/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: TableTeam.java
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
 * Class: TableTeam
 */
public class TableTeam {
    protected static int forWidth__ = 1;
    protected static int agaWidth__ = 1;
    protected static int pointsWidth__ = 1;
    protected static int gdiffWidth__ = 1;
    protected static int sdWonWidth__ = 1;
    protected static int sdLostWidth__ = 1;
    protected String team_;
    protected int teamId_;
    protected int played_, won_, drawn_, lost_;
    protected int sdWon_, sdLost_;
    protected int for_, against_, gDiff_;
    protected int points_, pos_;
    protected boolean hidden_;


    /**
     * Constructor
     */
    public TableTeam(String t, int id, boolean hide) {
        team_ = t;
        teamId_ = id;
        played_ = won_ = drawn_ = lost_ = sdWon_ = sdLost_ = for_ = against_ = gDiff_ = points_ = 0;
        pos_ = 1;
        hidden_ = hide;
    }

    /**
     * Resets the static widths
     */
    public static void resetWidths() {
        forWidth__ = agaWidth__ = pointsWidth__ =
                gdiffWidth__ = sdWonWidth__ = sdLostWidth__ = 1;
    }

    /**
     * Adds a match to the table
     */
    public void addMatch(Match m, int stopAt) {
        if (stopAt > -1 && played_ >= stopAt) {
            return;
        }

        int foor, aga;

        if (m.getHomeId() == teamId_) {
            foor = m.getHGoals();
            aga = m.getAGoals();
        }
        else {
            foor = m.getAGoals();
            aga = m.getHGoals();
        }

        played_++;
        if (foor > aga) {
            won_++;
            if (m.isSuddenDeath()) {
                sdWon_++;
            }
        }
        else if (aga > foor) {
            lost_++;
            if (m.isSuddenDeath()) {
                sdLost_++;
            }
        }
        else {
            drawn_++;
        }

        for_ += foor;
        against_ += aga;
    }

    /**
     * Calculates width for this team
     */
    public void calcWidths() {
        int w;
        if ((w = Integer.toString(for_).length()) > forWidth__) {
            forWidth__ = w;
        }
        if ((w = Integer.toString(against_).length()) > agaWidth__) {
            agaWidth__ = w;
        }
        if ((w = Integer.toString(points_).length()) > pointsWidth__) {
            pointsWidth__ = w;
        }
        if ((w = Integer.toString(Math.abs(gDiff_)).length()) > gdiffWidth__) {
            gdiffWidth__ = w;
        }
        if ((w = Integer.toString(sdWon_).length()) > sdWonWidth__) {
            sdWonWidth__ = w;
        }
        if ((w = Integer.toString(sdLost_).length()) > sdLostWidth__) {
            sdLostWidth__ = w;
        }
    }

    /**
     * Compare this team aganist an enemy.
     * If this team is worse its position is increased.
     */
    public void compareTo(TableTeam enemy, boolean gDiffSort) {
        if (hidden_ || enemy.hidden_) {
            return;
        }

        if (points_ < enemy.points_) {
            pos_++;
        }
        else if (points_ == enemy.points_) {
            int primary, secondary;
            if (gDiffSort) {
                primary = gDiff_ - enemy.gDiff_;
                secondary = for_ - enemy.for_;
            }
            else {
                primary = for_ - enemy.for_;
                secondary = gDiff_ - enemy.gDiff_;
            }
            if (primary < 0) {
                pos_++;
            }
            else if (primary == 0) {
                if (secondary < 0) {
                    pos_++;
                }
                else if (secondary == 0 && teamId_ > enemy.teamId_) {
                    pos_++;
                }
            }
        }

    }

    public float getAgaAvg() {
        return (played_ == 0) ?
                (float) 0 : (float) against_ / (float) played_;
    }

    public int getAgainst() {
        return against_;
    }

    public int getDrawn() {
        return drawn_;
    }

    public int getDrawnProc() {
        return Misc.procOf(drawn_, played_);
    }

    public int getFor() {
        return for_;
    }

    public float getForAvg() {
        return (played_ == 0) ?
                (float) 0 : (float) for_ / (float) played_;
    }

    public int getGDiff() {
        return gDiff_;
    }

    public int getLost() {
        return lost_;
    }

    public int getLostProc() {
        return Misc.procOf(lost_, played_);
    }

    public int getPlayed() {
        return played_;
    }

    public int getPoints() {
        return points_;
    }

    /* Return member data */
    public int getPos() {
        return pos_;
    }

    /**
     * Returns a string to use in the table
     */
    public String getString(boolean sudden, boolean hideDraws) {

        String diffstr = (gDiff_ > -1) ?
                "+" + Misc.rightString(gDiff_, gdiffWidth__, ' ') :
                "-" + Misc.rightString(Math.abs(gDiff_), gdiffWidth__, ' ');
        // prepare Sudden Death-strings
        String sdWon = " ", sdLost = "  ";
        if (sudden) {
            sdWon = "(" + Misc.rightString(sdWon_, sdWonWidth__, ' ') + ") ";
            sdLost = "(" + Misc.rightString(sdLost_, sdLostWidth__, ' ') + ")  ";
        }
        String drawStr = (hideDraws) ? "" : Misc.rightString(drawn_, 2, ' ') + " ";

        return Misc.rightString(pos_, 2, ' ') + ". " + team_ + " " +
                Misc.rightString(played_, 2, ' ') + "  " +
                Misc.rightString(won_, 2, ' ') + "" +
                sdWon +
                //	   Misc.rightString(drawn_, 2, ' ')+" "+
                drawStr +
                Misc.rightString(lost_, 2, ' ') + "" +
                sdLost +
                Misc.rightString(for_, forWidth__, ' ') + "-" +
                Misc.leftString(against_, agaWidth__, ' ') + "  " +
                Misc.rightString(points_, pointsWidth__, ' ') + " (" +
                diffstr + ")";
    }

    public int getSuddenDeathLost() {
        return sdLost_;
    }

    public int getSuddenDeathWon() {
        return sdWon_;
    }

    public int getWon() {
        return won_;
    }

    public int getWonProc() {
        return Misc.procOf(won_, played_);
    }

    /**
     * Calculates points and goaldifference
     */
    public void sumUp(int winPts, int drawPts, int lossPts, int sdWinPts, int sdLossPts, int bonus) {
        points_ =
                (won_ - sdWon_) * winPts +
                        sdWon_ * sdWinPts +
                        drawn_ * drawPts +
                        sdLost_ * sdLossPts +
                        (lost_ - sdLost_) * lossPts +
                        bonus;
        gDiff_ = for_ - against_;
    }
}