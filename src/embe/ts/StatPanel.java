/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: StatPanel.java
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
 * Class: StatPanel
 */
public class StatPanel extends TSPanel {
    protected int played_ = 0;
    protected int homeWon_ = 0;
    protected int awayWon_ = 0;
    protected int drawn_ = 0;
    protected int scored_ = 0;
    protected int homeScore_ = 0;
    protected int awayScore_ = 0;
    protected int bigHomeWin_ = -1, bigAwayWin_ = -1, mostGoals_ = -1;
    protected Results res_;


    /**
     * Constructor
     */
    public StatPanel(Color prim, Color sec, Color fore, Color back) {
        super(prim, sec, fore, back);
    }

    /**
     * Gets options
     */
    public void getOptions(java.util.Hashtable opt) {
    }

    /**
     * Paints the stats
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(TeamStats.MAINFONT);
        FontMetrics fm = g.getFontMetrics();
        int height = 15 + 1; //fm.getAscent()+fm.getDescent()+1;
        int x1 = Text.STA_X1, x2 = Text.STA_X2, gap = height - 5, y;
        int ys = 20;

        g.setColor(secCol_);
        String s = league_.getTitle();
        if (!s.equals(" ")) { // check that league has a title
            ys = 35;
            g.drawString(s, (size().width - fm.stringWidth(s)) / 2, ys - 15);
        }
        y = ys;
        g.drawString(Text.STA_PLAYED, x1, y += height);
        g.drawString(Text.STA_HOMEWON, x1, y += (height + gap));
        if (!league_.isHideDraws()) {
            g.drawString(Text.STA_DRAWN, x1, y += height);
        }
        g.drawString(Text.STA_AWAYWON, x1, y += height);
        g.drawString(Text.STA_GOALS, x1, y += (height + gap));
        g.drawString(Text.STA_HOMEGOALS, x1, y += height);
        g.drawString(Text.STA_AWAYGOALS, x1, y += height);

        g.setColor(primCol_);
        y = ys;
        int w = Integer.toString(scored_).length();
        g.drawString(Misc.rightString(played_, w, ' '), x2, y += height);

        g.drawString(Misc.rightString(homeWon_, w, ' ') + " (" +
                             Misc.rightString(Math.round(((float) homeWon_ / (float) played_) * 100), 3, ' ') + "%)",
                     x2, y += (height + gap));
        if (!league_.isHideDraws()) {
            g.drawString(Misc.rightString(drawn_, w, ' ') + " (" +
                                 Misc.rightString(Math.round(((float) drawn_ / (float) played_) * 100), 3, ' ') + "%)",
                         x2, y += height);
        }
        g.drawString(Misc.rightString(awayWon_, w, ' ') + " (" +
                             Misc.rightString(Math.round(((float) awayWon_ / (float) played_) * 100), 3, ' ') + "%)",
                     x2, y += height);

        float avg = (float) awayScore_ / (float) played_;
        int dec = 2;
        if (avg >= 10) {
            dec = 1;
        }
        if (avg >= 100) {
            dec = 0;
        }
        g.drawString(Misc.rightString(scored_, w, ' ') + " (" +
                             Misc.floatToString((float) scored_ / (float) played_, dec) + ")", x2, y += (height + gap));
        g.drawString(Misc.rightString(homeScore_, w, ' ') + " (" +
                             Misc.floatToString((float) homeScore_ / (float) played_, dec) + ")", x2, y += height);
        g.drawString(Misc.rightString(awayScore_, w, ' ') + " (" +
                             Misc.floatToString((float) awayScore_ / (float) played_, dec) + ")", x2, y += height);

        g.setColor(secCol_);
        g.drawString(Text.STA_COMMONRES, x1, y += (height + gap));
        g.setColor(primCol_);
        for (int a = 0; a < 5; a++) {
            try {
                g.drawString(res_.getResult(a).getString(), x1, y += height);
            }
            catch (RuntimeException e) {
                continue;
            }
        }

        int xmatch = (size().width - fm.stringWidth(league_.getMatch(0).matchString())) / 2;
        g.setColor(secCol_);
        g.drawString(Text.STA_BIGHOME, (size().width - fm.stringWidth(Text.STA_BIGHOME)) / 2, y += (height + gap));
        g.setColor(primCol_);
        try {
            g.drawString(league_.getMatch(bigHomeWin_).matchString(), xmatch, y += height);
        }
        catch (RuntimeException e) {
        }

        g.setColor(secCol_);
        g.drawString(Text.STA_BIGAWAY, (size().width - fm.stringWidth(Text.STA_BIGAWAY)) / 2, y += (height + gap));
        g.setColor(primCol_);
        try {
            g.drawString(league_.getMatch(bigAwayWin_).matchString(), xmatch, y += height);
        }
        catch (RuntimeException e) {
        }

        g.setColor(secCol_);
        g.drawString(Text.STA_MOSTGOALS, (size().width - fm.stringWidth(Text.STA_MOSTGOALS)) / 2, y += (height + gap));
        g.setColor(primCol_);
        try {
            g.drawString(league_.getMatch(mostGoals_).matchString(), xmatch, y += height);
        }
        catch (RuntimeException e) {
        }

    }

    /**
     * Sets options
     */
    public void setOptions(java.util.Hashtable opt) {
        League newL = (League) opt.get("league");

        if (newL != league_) {
            league_ = newL;
            Match m;
            int homewin = 0, awaywin = 0, manygoals = 0;

            played_ = homeWon_ = awayWon_ = drawn_ = 0;
            scored_ = homeScore_ = awayScore_ = 0;
            bigHomeWin_ = bigAwayWin_ = mostGoals_ = -1;
            res_ = new Results(league_);

            int homeg;
            int awayg;
            for (int a = 0; a < league_.getNumMatches(); a++) {
                try {
                    m = league_.getMatch(a);
                }
                catch (RuntimeException e) {
                    continue;
                }
                homeg = m.getHGoals();
                awayg = m.getAGoals();

                if (homeg > awayg) {
                    homeWon_++;
                    if (homeg - awayg >= homewin) {
                        bigHomeWin_ = a;
                        homewin = homeg - awayg;
                    }
                }
                else if (homeg == awayg) {
                    drawn_++;
                }
                else {
                    awayWon_++;
                    if (awayg - homeg >= awaywin) {
                        bigAwayWin_ = a;
                        awaywin = awayg - homeg;
                    }
                }

                homeScore_ += homeg;
                awayScore_ += awayg;

                if (homeg + awayg >= manygoals) {
                    mostGoals_ = a;
                    manygoals = homeg + awayg;
                }

                res_.addMatch(m);
            }

            played_ = homeWon_ + drawn_ + awayWon_;
            scored_ = homeScore_ + awayScore_;
        }

    }
}