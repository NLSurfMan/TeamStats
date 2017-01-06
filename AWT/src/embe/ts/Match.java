/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: Match.java
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
 * class Match
 */
public class Match {
    protected League league_;
    protected int id_;
    protected int homeId_;
    protected int awayId_;
    protected int hGoals_;
    protected int aGoals_;
    protected boolean suddenDeath_;
    protected String date_;


    /* Constructors */
    public Match() {
        this(null, -1, -1, -1, -1, -1, false, "");
    }

    public Match(League league, int id, int homeid, int awayid, int hg, int ag, boolean sudden, String date) {
        league_ = league;
        id_ = id;
        homeId_ = homeid;
        awayId_ = awayid;
        hGoals_ = hg;
        aGoals_ = ag;
        suddenDeath_ = sudden;
        date_ = date;
    }

    public int getAGoals() {
        return aGoals_;
    }

    public int getAwayId() {
        return awayId_;
    }

    public int getHGoals() {
        return hGoals_;
    }

    /* Returns memberdata */
    public int getHomeId() {
        return homeId_;
    }

    public boolean isSuddenDeath() {
        return suddenDeath_;
    }

    /**
     * Returns the match as a string
     */
    public String matchString() {
        String sd = suddenDeath_ ? " SD" : "";
        return date_ + league_.getTeam(homeId_) + "-" + league_.getTeam(awayId_) + " " +
                Misc.rightString(hGoals_, league_.getMatchWidth(), ' ') + "-" +
                Misc.leftString(aGoals_, league_.getMatchWidth(), ' ') + sd;
    }

    /**
     * Returns the match as a string
     * If the match's date (date_) equals curDate return
     * empty space instead of date
     */
    public String matchString(String curDate) {
        String sd = suddenDeath_ ? " SD" : "";
        if (curDate.equals(date_)) {
            return "      " + league_.getTeam(homeId_) + "-" + league_.getTeam(awayId_) + " " +
                    Misc.rightString(hGoals_, league_.getMatchWidth(), ' ') + "-" +
                    Misc.leftString(aGoals_, league_.getMatchWidth(), ' ') + sd;
        }
        return matchString();
    }

    /**
     * Returns the match as a short-string
     */
    public String shortString(int TeamId) {
        String team;
        int forward, against;
        String sd = suddenDeath_ ? " SD" : "";

        if (TeamId == homeId_) {
            team = league_.getTeam(awayId_) + "(" + Text.MAT_HOMELET + ")";
            forward = hGoals_;
            against = aGoals_;
        }
        else {
            team = league_.getTeam(homeId_) + "(" + Text.MAT_AWAYLET + ")";
            forward = aGoals_;
            against = hGoals_;
        }
        return date_ + team + " " +
                Misc.rightString(forward, league_.getMatchWidth(), ' ') + "-" +
                Misc.leftString(against, league_.getMatchWidth(), ' ') + sd;
    }
}