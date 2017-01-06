/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: MatchSeries.java
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

/**
 * Class: MatchSeries
 */
class MatchSeries {
    protected int unbeaten_ = 0, noWin_ = 0;
    protected int won_ = 0, drawn_ = 0, lost_ = 0;
    protected int noFor_ = 0, noAga_ = 0;
    protected boolean unbeatenS_ = true, noWinS_ = true;
    protected boolean wonS_ = true, drawnS_ = true, lostS_ = true;
    protected boolean noForS_ = true, noAgaS_ = true;
    protected int team_;


    // construct
    public MatchSeries(int team) {
        team_ = team;
    }

    // tries to add a match to the current matchseries
    public boolean addMatch(Match m) {
        int fwd, aga;
        boolean ret = false;

        if (team_ == m.getHomeId()) {
            fwd = m.getHGoals();
            aga = m.getAGoals();
        }
        else {
            fwd = m.getAGoals();
            aga = m.getHGoals();
        }

        if (fwd > aga) {
            noWinS_ = drawnS_ = lostS_ = false;
            if (unbeatenS_) {
                unbeaten_++;
                ret = true;
            }
            if (wonS_) {
                won_++;
                ret = true;
            }
        }
        else if (fwd == aga) {
            wonS_ = lostS_ = false;
            if (unbeatenS_) {
                unbeaten_++;
                ret = true;
            }
            if (noWinS_) {
                noWin_++;
                ret = true;
            }
            if (drawnS_) {
                drawn_++;
                ret = true;
            }
        }
        else if (fwd < aga) {
            unbeatenS_ = wonS_ = drawnS_ = false;
            if (noWinS_) {
                noWin_++;
                ret = true;
            }
            if (lostS_) {
                lost_++;
                ret = true;
            }
        }

        if (aga == 0 && noAgaS_) {
            noAga_++;
            ret = true;
        }
        else {
            noAgaS_ = false;
        }

        if (fwd == 0 && noForS_) {
            noFor_++;
            ret = true;
        }
        else {
            noForS_ = false;
        }

        return ret;
    }

    public int getDrawn() {
        return drawn_;
    }

    public int getLost() {
        return lost_;
    }

    public int getNoAga() {
        return noAga_;
    }

    public int getNoFwd() {
        return noFor_;
    }

    public int getNoWin() {
        return noWin_;
    }

    /**
     * Return member data
     */
    public int getUnbeaten() {
        return unbeaten_;
    }

    public int getWon() {
        return won_;
    }
}