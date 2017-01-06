/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: Text.java
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
 * Constant text strings
 */
class Text {

    //
    // Main
    //
    public static final String MAI_LOADING = "Loading ";

    ///////////
    // English
    ///////////
    public static final String MAI_ERROR = "Error: ";
    public static final String MAI_NOMATCHFILE = "No matchfile is specified";
    public static final String MAI_NOFINDMATCHFILE = "Can't find the matchfile";
    public static final String MAI_NOFINDLEAGUEFILE = "Can't find the parameterfile (Leaguefile)";
    public static final String MAI_NOMATCHES = "The matchfile doesn't contain any matches";
    public static final String MAI_TABLE = "Table";
    public static final String MAI_MATCHES = "Matches";
    public static final String MAI_STATS = "Statistics";
    public static final String MAI_COMPARE = "Compare teams";
    public static final String MAI_HOMEURL = "http://www.mbovin.com/ts/";
    //
    // Tablemode
    //
    public static final String TAB_MATCHES = "Matches:";
    public static final String TAB_ROUNDS = "Rounds:";
    public static final String TAB_ALL1 = "All";
    public static final String TAB_HOME = "Home";
    public static final String TAB_AWAY = "Away";
    public static final String TAB_ALL2 = "All";
    public static final String TAB_FIRST = "First";
    public static final String TAB_LAST = "Last";
    //
    // Matchmode
    //
    public static final String MAT_TEAM = "Team:";
    public static final String MAT_MATCHES = "Matches:";
    public static final String MAT_RESULTS = "Results:";
    public static final String MAT_ALL1 = "All";
    public static final String MAT_ALL2 = "All";
    public static final String MAT_HOME = "Home";
    public static final String MAT_AWAY = "Away";
    public static final String MAT_ALL3 = "All";
    public static final String MAT_WON = "Won";
    public static final String MAT_DRAWN = "Drawn";
    public static final String MAT_LOST = "Lost";
    public static final String MAT_HOMELET = "H";
    public static final String MAT_AWAYLET = "A";
    //
    // Statsmode
    //
    public static final int STA_X1 = 200;
    public static final int STA_X2 = 330;
    public static final String STA_PLAYED = "Matches played:";
    public static final String STA_HOMEWON = "Won by hometeam:";
    public static final String STA_DRAWN = "Drawn:";
    public static final String STA_AWAYWON = "Won by awayteam:";
    public static final String STA_GOALS = "Goals scored:";
    public static final String STA_HOMEGOALS = "Goals by hometeam:";
    public static final String STA_AWAYGOALS = "Goals by awayteam:";
    public static final String STA_COMMONRES = "Most frequent result:";
    public static final String STA_TIMES = " times";
    public static final String STA_BIGHOME = "Largest homewin:";
    public static final String STA_BIGAWAY = "Largest awaywin:";
    public static final String STA_MOSTGOALS = "Most goals:";
    //
    // Comparemode
    //
    public static final int COM_X1 = 20;
    public static final int COM_X2 = 120;
    public static final String COM_STATS = "Statistics";
    public static final String COM_HA_STATS = "Home/away stats";
    public static final String COM_EARLIER = "Previous matches";
    public static final String COM_HOMETEAM = "Hometeam:";
    public static final String COM_AWAYTEAM = "Awayteam:";
    public static final String COM_TABLEPOS = "Tableposition:";
    public static final String COM_PLAYED = "Matches played:";
    public static final String COM_WON = "Won:";
    public static final String COM_DRAWN = "Drawn:";
    public static final String COM_LOST = "Lost:";
    public static final String COM_SCORED = "Goals for:";
    public static final String COM_AGAINST = "Goals against:";
    public static final String COM_RESCENT = "Five last matches:";
    public static final String COM_SERIES = "Current streaks:";
    public static final String COM_COMMONRES = "Most frequent result:";
    public static final String COM_UNBEATEN = "Undefeated:     ";
    public static final String COM_NOWIN = "No win:         ";
    public static final String COM_SER_WON = "Wins:           ";
    public static final String COM_SER_DRAWN = "Draws:          ";
    public static final String COM_SER_LOST = "Losses:         ";
    public static final String COM_NOAGA = "No goal against:";
    public static final String COM_NOSCORE = "No goal for:    ";
    public static final String COM_MATCHES = " matches";

    private Text() {
    }

}
