/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: MatchPanel.java
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


/**
 * class MatchPanel
 */
public class MatchPanel extends TSPanel implements Runnable {
    protected int team_ = -1;
    protected int result_ = 0;
    protected boolean home_ = true;
    protected boolean away_ = true;
    protected Thread fillListThread_ = null;

    protected Panel toolBar_ = new Panel();
    protected Choice teamCh_ = new Choice();
    protected Choice matchCh_ = new Choice();
    protected Choice resCh_ = new Choice();
    protected List matchLi_ = new List();


    /**
     * Construct
     */
    public MatchPanel(Color prim, Color sec, Color fore, Color back, int appletWidth) {
        super(prim, sec, fore, back);

        teamCh_.add(Text.MAT_ALL1);

        matchCh_.add(Text.MAT_ALL2);
        matchCh_.add(Text.MAT_HOME);
        matchCh_.add(Text.MAT_AWAY);
        matchCh_.setForeground(foreCol_);
        matchCh_.setBackground(backCol_);
        matchCh_.setEnabled(false);

        resCh_.add(Text.MAT_ALL3);
        resCh_.add(Text.MAT_WON);
        resCh_.add(Text.MAT_DRAWN);
        resCh_.add(Text.MAT_LOST);
        resCh_.setForeground(foreCol_);
        resCh_.setBackground(backCol_);
        resCh_.setEnabled(false);

        Label tempLab;
        tempLab = new Label(Text.MAT_TEAM, Label.LEFT);
        tempLab.setForeground(foreCol_);
        toolBar_.add(tempLab);
        toolBar_.add(teamCh_);
        tempLab = new Label(Text.MAT_MATCHES, Label.LEFT);
        tempLab.setForeground(foreCol_);
        toolBar_.add(tempLab);
        toolBar_.add(matchCh_);
        tempLab = new Label(Text.MAT_RESULTS, Label.LEFT);
        tempLab.setForeground(foreCol_);
        toolBar_.add(tempLab);
        toolBar_.add(resCh_);

        matchLi_.setFont(TeamStats.MAINFONT);
        matchLi_.setForeground(primCol_);
        matchLi_.setBackground(backCol_);

        if (appletWidth == 0) {
            appletWidth = 560; // just a precaution
        }
        int hgap = (appletWidth - 370) / 2;
        setLayout(new BorderLayout(hgap, 0));
        add("North", toolBar_);
        add("Center", matchLi_);
        // add dummy-canvas to stop List from being to wide
        add("West", new Canvas());
        add("East", new Canvas());
    }

    /**
     * Eventhandler
     */
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice) {
            handleOptions(false);
            return true;
        }
        return false;
    }

    /**
     * Gets options
     */
    public void getOptions(java.util.Hashtable opt) {
        String team = null;
        if (teamCh_.getSelectedIndex() == 0) {
            team = "ALL";
        }
        else {
            team = teamCh_.getSelectedItem();
        }
        opt.put("mat_team", team);
        opt.put("mat_place", matchCh_.getSelectedIndex());
        opt.put("mat_res", resCh_.getSelectedIndex());
    }

    /**
     * Handles options
     */
    protected void handleOptions(boolean skipThread) {
        team_ = teamCh_.getSelectedIndex() - 1;
        if (team_ > -1) // a team is selected
        {
            team_ = league_.getTeamId(teamCh_.getSelectedItem());
        }

        matchCh_.setEnabled(team_ > -1);
        resCh_.setEnabled(team_ > -1);

        if (matchCh_.getSelectedItem().equals(Text.MAT_AWAY)) {
            home_ = false;
        }
        else {
            home_ = true;
        }
        if (matchCh_.getSelectedItem().equals(Text.MAT_HOME)) {
            away_ = false;
        }
        else {
            away_ = true;
        }

        switch (resCh_.getSelectedIndex()) {
            case 0:
                result_ = 2;
                break;
            case 1:
                result_ = 1;
                break;
            case 2:
                result_ = 0;
                break;
            case 3:
                result_ = -1;
                break;
        }

        // skipThread option due to IE5 having problem
        // running fillListThred during applet initialization
        if (!skipThread) {
            //System.out.println("Thread");
            if (fillListThread_ != null) {
                fillListThread_.stop();
            }
            fillListThread_ = new Thread(this, "MatchThread");
            fillListThread_.start();
        }
        else {
            //System.out.println("No Thread");
            run();
        }
    }

    /**
     * Fills the listbox with matches
     */
    public void run() {
        // clear list first
        if (matchLi_.getItemCount() > 0) {
            matchLi_.removeAll();
        }

        if (team_ == -1) {  // all matches
            String prevDate = "------"; // dummy init value
            String mStr;
            Match m;

            //      for(int a = 0; a < league_.getNumMatches(); a++) {
            for (int a = league_.getNumMatches() - 1; a > -1; a--) {
                try {
                    m = league_.getMatch(a);
                    mStr = m.matchString(prevDate);
                    // check if string has a date (otherwise
                    // the '-' will be at pos 16)
                    if ((mStr.charAt(22) == '-') && (!mStr.startsWith("     "))) {
                        prevDate = mStr.substring(0, 6); // remember date
                        matchLi_.add(" "); // a little more space
                    }
                    matchLi_.add(mStr);
                }
                catch (Exception e) {
                }
            }
        }

        else { // a team is selected
            //      for(int a = 0; a < league_.getNumMatches(); a++) {
            for (int a = league_.getNumMatches() - 1; a > -1; a--) {
                try {
                    Match m = league_.getMatch(a);
                    boolean thishome = (team_ == m.getHomeId());
                    boolean thisaway = (team_ == m.getAwayId());
                    if ((home_ && thishome) || (away_ && thisaway)) {
                        int result = 0;
                        if (thishome) {
                            result = Misc.sign(m.getHGoals() - m.getAGoals());
                        }
                        if (thisaway) {
                            result = Misc.sign(m.getAGoals() - m.getHGoals());
                        }

                        if (result_ > 1 || result_ == result) {
                            matchLi_.add(m.shortString(team_));
                        }
                    }
                }
                catch (Exception e) {
                }
            }
        }

    }

    /**
     * Sets options
     */
    public void setOptions(java.util.Hashtable opt, boolean skipThread) {
        League newL = (League) opt.get("league");

        if (newL != league_) {
            league_ = newL;

            toolBar_.remove(teamCh_);
            teamCh_ = new Choice();
            teamCh_.setForeground(foreCol_);
            teamCh_.setBackground(backCol_);
            teamCh_.add(Text.MAT_ALL1);
            for (int a = 0; a < league_.getNumTeams(); a++) {
                try {
                    if (!league_.isHidden(league_.getTeamAlpha(a))) {
                        teamCh_.add(league_.getTeamAlpha(a));
                    }
                }
                catch (RuntimeException e) {
                }
            }
            toolBar_.add(teamCh_, 1);
            toolBar_.validate();
        }

        String team = (String) opt.get("mat_team");
        int place = ((Integer) opt.get("mat_place")).intValue();
        int res = ((Integer) opt.get("mat_res")).intValue();

        if (team.toUpperCase().equals("ALL")) {
            teamCh_.select(0);
        }
        else {
            teamCh_.select(Misc.padString(team, 16));
        }

        try {
            matchCh_.select(place);
        }
        catch (IllegalArgumentException e) {
        }
        try {
            resCh_.select(res);
        }
        catch (IllegalArgumentException e) {
        }

        // NN 3 for UNIX bugfix start here
        teamCh_.setSize(teamCh_.getSize().width + 1, teamCh_.getSize().height);
        teamCh_.setSize(teamCh_.getSize().width - 1, teamCh_.getSize().height);
        matchCh_.setSize(matchCh_.getSize().width + 1, matchCh_.getSize().height);
        matchCh_.setSize(matchCh_.getSize().width - 1, matchCh_.getSize().height);
        resCh_.setSize(resCh_.getSize().width + 1, resCh_.getSize().height);
        resCh_.setSize(resCh_.getSize().width - 1, resCh_.getSize().height);
        // end bugfix

        handleOptions(skipThread);
    }
}