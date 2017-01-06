/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: Table.java
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
 * Class: Table
 */
public class Table {
    protected League league_;
    protected TableTeam teams_[];
    protected boolean home_ = true;
    protected boolean away_ = true;
    protected boolean first_ = true;
    protected int stopAt_ = -1;


    /**
     * Constructor
     */
    public Table(League l, boolean home, boolean away, boolean first, int stopat) {
        league_ = l;
        home_ = home;
        away_ = away;
        first_ = first;
        stopAt_ = stopat;

        int n = league_.getNumTeams();
        teams_ = new TableTeam[n];
        for (int a = 0; a < n; a++) {
            try {
                teams_[a] = new TableTeam(league_.getTeam(a), a, league_.isHidden(league_.getTeam(a)));
            }
            catch (RuntimeException e) {
            }
        }

    }

    /**
     * Builds the table
     */
    public void build() {
        int a, start, stop, step;

        if (first_) {
            start = 0;
            stop = league_.getNumMatches();
            step = 1;
        }
        else {
            start = league_.getNumMatches() - 1;
            stop = -1;
            step = -1;
        }

        Match m;
        for (a = start; a != stop; a += step) {
            try {
                m = league_.getMatch(a);
                if (home_) {
                    teams_[m.getHomeId()].addMatch(m, stopAt_);
                }
                if (away_) {
                    teams_[m.getAwayId()].addMatch(m, stopAt_);
                }
            }
            catch (RuntimeException e) {
            }
        }

        sort();
    }

    /**
     * Returns a TableTeam
     */
    public TableTeam getTableTeam(int n) throws ArrayIndexOutOfBoundsException, NullPointerException {
        try {
            return teams_[n];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
        catch (NullPointerException e) {
            throw e;
        }
    }

    /**
     * Shows the table
     */
    public void show(Graphics g, Color primCol, Color secCol, int cwidth, int y) {
        FontMetrics fm = g.getFontMetrics();
        int height = 15; //fm.getAscent()+fm.getDescent();
        int a;

        // calc table-comlumn width
        TableTeam.resetWidths();
        for (a = 0; a < league_.getNumTeams(); a++) {
            teams_[a].calcWidths();
        }

        boolean sudden = (league_.isSuddenDeath() && league_.showSDInTable());
        int w = fm.stringWidth(teams_[0].getString(sudden, league_.isHideDraws()));
        int x = (cwidth - w) / 2;

        g.setColor(primCol);
        for (a = 0; a < league_.getNumTeams(); a++) {
            if (!league_.isHidden(league_.getTeam(a))) {
                if (league_.isMarked(league_.getTeam(a))) {
                    // pseudo-bold, draw the string twice
                    g.drawString(teams_[a].getString(sudden, league_.isHideDraws()), x + 1,
                                 y + height * teams_[a].getPos());
                }
                g.drawString(teams_[a].getString(sudden, league_.isHideDraws()), x, y + height * teams_[a].getPos());
            }
            if (league_.isLine(a)) {
                g.setColor(secCol);
                g.drawLine(x, y + 2 + height * a + height, x + w, y + 2 + height * a + height);
                g.setColor(primCol);
            }
        }
    }

    /**
     * Sorts the table
     */
    protected void sort() {
        int a, b;
        int numteams = league_.getNumTeams();
        boolean gdiffsort = league_.isGDiffSort();
        int winPts = league_.getWinPoints();
        int drawPts = league_.getDrawPoints();
        int lossPts = league_.getLossPoints();
        int sdWinPts = league_.getSDWinPoints();
        int sdLossPts = league_.getSDLossPoints();
        int bonus;

        for (a = 0; a < numteams; a++) {
            bonus = 0;
            if (stopAt_ == -1 && home_ && away_) // extrapoints only in current table
            {
                bonus = league_.getBonus(league_.getTeam(a));
            }
            teams_[a].sumUp(winPts, drawPts, lossPts, sdWinPts, sdLossPts, bonus);
        }

        for (a = 0; a < numteams; a++) {
            for (b = 0; b < numteams; b++) {
                teams_[a].compareTo(teams_[b], gdiffsort);
            }
        }
    }
}