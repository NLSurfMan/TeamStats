/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: ComparePanel.java
 *
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package embe.ts;

import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;


/**
 * Class: ComparePanel
 */
public class ComparePanel extends TSPanel {
    protected CompareStats home_;
    protected CompareStats away_;
    protected int mode_ = 0;
    protected Vector earlier_ = new Vector(4, 2);
    protected boolean noPrev_;

    protected Panel toolBar_ = new Panel();
    protected Panel teamBar_ = new Panel();
    protected Panel homeBar_ = new Panel();
    protected Panel awayBar_ = new Panel();
    protected Checkbox statsCb_ = new Checkbox(Text.COM_STATS);
    protected Checkbox haStatsCb_ = new Checkbox(Text.COM_HA_STATS);
    protected Checkbox earlierCb_ = new Checkbox(Text.COM_EARLIER);
    protected Choice homeCh_ = new Choice();
    protected Choice awayCh_ = new Choice();


    /**
     * Construct
     */
    public ComparePanel(Color prim, Color sec, Color fore, Color back, boolean noPrev) {
        super(prim, sec, fore, back);
        this.noPrev_ = noPrev;

        CheckboxGroup modeGrp = new CheckboxGroup();
        statsCb_.setCheckboxGroup(modeGrp);
        statsCb_.setForeground(foreCol_);
        statsCb_.setBackground(backCol_);
        haStatsCb_.setCheckboxGroup(modeGrp);
        haStatsCb_.setForeground(foreCol_);
        haStatsCb_.setBackground(backCol_);
        earlierCb_.setCheckboxGroup(modeGrp);
        earlierCb_.setForeground(foreCol_);
        earlierCb_.setBackground(backCol_);
        modeGrp.setCurrent(statsCb_);
        toolBar_.add(statsCb_);
        toolBar_.add(haStatsCb_);
        toolBar_.add(earlierCb_);

        Label tempLab;
        homeBar_.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempLab = new Label(Text.COM_HOMETEAM, Label.LEFT);
        tempLab.setForeground(foreCol_);
        homeBar_.add(tempLab);
        homeBar_.add(homeCh_);
        awayBar_.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempLab = new Label(Text.COM_AWAYTEAM, Label.LEFT);
        tempLab.setForeground(foreCol_);
        awayBar_.add(tempLab);
        awayBar_.add(awayCh_);

        teamBar_.setLayout(new GridLayout(1, 2));
        teamBar_.add(homeBar_);
        teamBar_.add(awayBar_);

        Panel bars = new Panel();
        bars.setLayout(new BorderLayout());
        bars.add("North", toolBar_);
        bars.add("South", teamBar_);

        setLayout(new BorderLayout());
        add("North", bars);
    }

    /**
     * Eventhandler
     */
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice || evt.target instanceof Checkbox) {
            handleOptions();
            repaint();
            return true;
        }
        return false;
    }

    /**
     * Finds eariler macthes between the teams
     */
    protected void findEarlier() {
        Enumeration enumeration;
        if (noPrev_) {
            Vector v = new Vector();
            v.addElement(league_);
            enumeration = v.elements();
        }
        else {
            enumeration = league_.getLeagues().elements();
        }

        earlier_.removeAllElements();

        while (enumeration.hasMoreElements()) {
            League l = (League) enumeration.nextElement();
            // don't include newer leagues
            if (league_.getSeason().compareTo(l.getSeason()) < 0) {
                continue;
            }

            int hteam = l.getTeamId(homeCh_.getSelectedItem());
            int ateam = l.getTeamId(awayCh_.getSelectedItem());
            // at least one team not found or same team
            if (hteam == -1 || ateam == -1 || hteam == ateam) {
                continue;
            }

            earlier_.addElement("head" + l.getTitle());
            int before = earlier_.size();

            Match m;
            for (int a = l.getNumMatches() - 1; a > -1; a--) {
                try {
                    m = l.getMatch(a);
                }
                catch (RuntimeException e) {
                    continue;
                }
                int team1 = m.getHomeId();
                int team2 = m.getAwayId();
                if ((team1 == hteam && team2 == ateam) ||
                        (team2 == hteam && team1 == ateam)) {
                    earlier_.addElement(m.matchString());
                }
            }

            // if no matches were added remove the header
            if (earlier_.size() == before) {
                earlier_.removeElement(earlier_.lastElement());
            }
        }

    }

    /**
     * Gets options
     */
    public void getOptions(java.util.Hashtable opt) {
        String home = homeCh_.getSelectedItem();
        String away = awayCh_.getSelectedItem();
        opt.put("com_mode", new Integer(mode_));
        opt.put("com_home", home);
        opt.put("com_away", away);
    }

    /**
     * Handles options
     */
    protected void handleOptions() {

        if (statsCb_.getState()) {
            mode_ = 0;
        }
        if (haStatsCb_.getState()) {
            mode_ = 1;
        }
        if (earlierCb_.getState()) {
            mode_ = 2;
        }

        switch (mode_) {
            case 0:
                try {
                    home_ = new CompareStats(league_, league_.getTeamId(homeCh_.getSelectedItem()), true, true);
                    home_.build();
                }
                catch (RuntimeException e) {
                }
                try {
                    away_ = new CompareStats(league_, league_.getTeamId(awayCh_.getSelectedItem()), true, true);
                    away_.build();
                }
                catch (RuntimeException e) {
                }
                break;
            case 1:
                try {
                    home_ = new CompareStats(league_, league_.getTeamId(homeCh_.getSelectedItem()), true, false);
                    home_.build();
                }
                catch (RuntimeException e) {
                }
                try {
                    away_ = new CompareStats(league_, league_.getTeamId(awayCh_.getSelectedItem()), false, true);
                    away_.build();
                }
                catch (RuntimeException e) {
                }
                break;
            case 2:
                findEarlier();
                break;
        }
    }

    /**
     * Paints the stats
     */
    public void paint(Graphics g) {
        super.paint(g);
        Dimension dim = getSize();
        g.setFont(TeamStats.MAINFONT);
        int y = toolBar_.getSize().height + teamBar_.getSize().height;

        // stats
        if (mode_ < 2) {
            home_.show(g, primCol_, secCol_, 0, y);
            away_.show(g, primCol_, secCol_, (dim.width / 2), y);
        }

        // earlier matches
        else {
            java.util.Enumeration enumeration = earlier_.elements();
            int x, yoff = 0;
            while (enumeration.hasMoreElements()) {
                String s = (String) enumeration.nextElement();
                if (s.startsWith("head")) {
                    g.setColor(secCol_);
                    s = s.substring(4);
                    yoff += 18;
                }
                else {
                    g.setColor(primCol_);
                    yoff += 12;
                }

                int stringWidth = g.getFontMetrics().stringWidth(s);
                // make sure sudden-Strings don't stick out
                if (s.endsWith(" SD")) {
                    stringWidth -= g.getFontMetrics().stringWidth(" SD");
                }
                x = (dim.width - stringWidth) / 2;
                g.drawString(s, x, y + yoff);

                // check if end of screen is reached
                if (y + yoff > dim.height - 20) {
                    break;
                }
            }
        }

    }

    /**
     * Sets options
     */
    public void setOptions(java.util.Hashtable opt) {
        League newL = (League) opt.get("league");

        if (newL != league_) {
            league_ = newL;
            // add the teams to choice-components
            homeBar_.remove(homeCh_);
            awayBar_.remove(awayCh_);
            homeCh_ = new Choice();
            homeCh_.setForeground(foreCol_);
            homeCh_.setBackground(backCol_);
            awayCh_ = new Choice();
            awayCh_.setForeground(foreCol_);
            awayCh_.setBackground(backCol_);
            for (int a = 0; a < league_.getNumTeams(); a++) {
                try {
                    if (!league_.isHidden(league_.getTeamAlpha(a))) {
                        homeCh_.add(league_.getTeamAlpha(a));
                        awayCh_.add(league_.getTeamAlpha(a));
                    }
                }
                catch (RuntimeException e) {
                }
            }
            awayCh_.select(1);
            homeBar_.add(homeCh_, 1);
            awayBar_.add(awayCh_, 1);
            homeBar_.validate();
            awayBar_.validate();

        }

        mode_ = (Integer) opt.get("com_mode");
        String home = (String) opt.get("com_home");
        String away = (String) opt.get("com_away");
        switch (mode_) {
            case 0:
                statsCb_.setState(true);
                break;
            case 1:
                haStatsCb_.setState(true);
                break;
            case 2:
                earlierCb_.setState(true);
                break;
        }

        while (home.length() < 16) {
            home += ' ';
        }
        homeCh_.select(home);
        while (away.length() < 16) {
            away += ' ';
        }
        awayCh_.select(away);

        // NN 3 for UNIX bugfix start here
        homeCh_.setSize(homeCh_.getSize().width + 1, homeCh_.getSize().height);
        homeCh_.setSize(homeCh_.getSize().width - 1, homeCh_.getSize().height);
        awayCh_.setSize(awayCh_.getSize().width + 1, awayCh_.getSize().height);
        awayCh_.setSize(awayCh_.getSize().width - 1, awayCh_.getSize().height);
        // end bugfix

        handleOptions();
    }
}