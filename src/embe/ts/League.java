/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: League.java
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

import java.io.DataInputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;


/**
 * Implements a League-object
 *
 * @author Mats Bovin
 */
public class League implements Runnable {
    protected String name_ = new String();
    protected String season_ = new String();
    protected int winPoints_ = 3;
    protected int drawPoints_ = 1;
    protected int lossPoints_ = 0;
    protected int sdWinPoints_ = 3;
    protected int sdLossPoints_ = 0;
    protected boolean suddenDeath_ = false;
    protected boolean showSDInTable_ = true;
    protected boolean gDiffSort_ = true;
    protected boolean hideDraws_ = false;
    protected Vector teams_ = new Vector(20, 2);
    protected Vector matches_ = new Vector(400, 10);
    protected Vector lines_ = new Vector();
    protected Vector teamOrder_ = new Vector(20, 2);
    protected Vector hide_ = new Vector();
    protected Vector mark_ = new Vector();
    protected Hashtable bonus_ = new Hashtable();
    protected DataInputStream inStm_ = null;
    protected int matchWidth_ = 0;
    protected Vector leagues_;
    protected String currentDate_ = "";
    protected char dateChar_ = 0;


    /**
     * Constructor
     */
    public League() {
    }

    public League(Vector leagues, DataInputStream instm) {
        inStm_ = instm;
        leagues_ = leagues;
    }

    /**
     * Returns penalty points for team n
     */
    public int getBonus(String team) {
        Integer i = (Integer) bonus_.get(team);
        return (i == null) ? 0 : i.intValue();
    }

    /**
     * Returns points for draw
     */
    public int getDrawPoints() {
        return drawPoints_;
    }

    /**
     * Gets leagues
     */
    public Vector getLeagues() {
        return leagues_;
    }

    /**
     * Returns points for loss
     */
    public int getLossPoints() {
        return lossPoints_;
    }

    /**
     * Returns match number n
     */
    public Match getMatch(int n) throws ArrayIndexOutOfBoundsException, NullPointerException {
        try {
            return (Match) matches_.elementAt(n);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
        catch (NullPointerException e) {
            throw e;
        }
    }

    /**
     * Returns width of goals
     */
    public int getMatchWidth() {
        return matchWidth_;
    }

    /**
     * Gets name
     */
    public String getName() {
        return name_;
    }

    /**
     * Returns number of matches played
     */
    public int getNumMatches() {
        return matches_.size();
    }

    /**
     * Returns number of teams in the league
     */
    public int getNumTeams() {
        return teams_.size();
    }

    /**
     * Returns points for sudden death loss
     */
    public int getSDLossPoints() {
        return sdLossPoints_;
    }

    /**
     * Returns points for sudden death victory
     */
    public int getSDWinPoints() {
        return sdWinPoints_;
    }

    /**
     * Gets season
     */
    public String getSeason() {
        return season_;
    }

    /**
     * Returns team number n
     */
    public String getTeam(int n) throws ArrayIndexOutOfBoundsException, NullPointerException {
        try {
            return (String) teams_.elementAt(n);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
        catch (NullPointerException e) {
            throw e;
        }
    }

    /**
     * Returns team number n in alphabetical order
     */
    public String getTeamAlpha(int n) throws ArrayIndexOutOfBoundsException, NullPointerException {
        try {
            return (String) teams_.elementAt(
                    ((Integer) teamOrder_.elementAt(n)).intValue());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
        catch (NullPointerException e) {
            throw e;
        }
    }

    /**
     * Returns teamId for team
     */
    public int getTeamId(String team) {
        return teams_.indexOf(team);
    }

    /**
     * Returns title
     */
    public String getTitle() {
        return name_ + " " + season_;
    }

    /**
     * Returns points for victory
     */
    public int getWinPoints() {
        return winPoints_;
    }

    /**
     * Return gDiffSort
     */
    public boolean isGDiffSort() {
        return gDiffSort_;
    }

    /**
     * Checks if team should be hidden
     */
    public boolean isHidden(String team) {
        return hide_.contains(team);
    }

    /**
     * Checks if draws should be hidden
     */
    public boolean isHideDraws() {
        return hideDraws_;
    }

    /**
     * Check if there is a line after team n
     */
    public boolean isLine(int n) {
        return lines_.contains(new Integer(n));
    }

    /**
     * Checks if team should be marked
     */
    public boolean isMarked(String team) {
        return mark_.contains(team);
    }

    /**
     * Checks if league uses SuddenDeath
     */
    public boolean isSuddenDeath() {
        return suddenDeath_;
    }

    /**
     * Sets SuddenDeath-property
     */
    public void setSuddenDeath(boolean sd) {
        suddenDeath_ = sd;
    }

    /**
     * Parses a string to a date
     * Returns: true if date, false otherwise
     */
    private boolean parseDate(String str) {
        int index;
        String leftStr, rightStr;
        int left, right;

        try {
            index = str.indexOf(dateChar_);
            leftStr = str.substring(0, index).trim();
            rightStr = str.substring(index + 1).trim();

            if ((index = leftStr.lastIndexOf(' ')) > -1) // space
            {
                leftStr = leftStr.substring(index + 1);
            }
            if ((index = leftStr.lastIndexOf(9)) > -1) // tab
            {
                leftStr = leftStr.substring(index + 1);
            }
            if ((index = rightStr.indexOf(' ')) > -1) // space
            {
                rightStr = rightStr.substring(0, index);
            }
            if ((index = rightStr.indexOf(9)) > -1) // tab
            {
                rightStr = rightStr.substring(0, index);
            }

            left = Integer.parseInt(leftStr);
            right = Integer.parseInt(rightStr);

            // build a string with the date
            currentDate_ = Misc.rightString(left, 2, ' ') + dateChar_ + Misc.leftString(right, 2, ' ') + " ";
        }
        catch (NumberFormatException e) {
            return false;
        }
        catch (StringIndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    /**
     * Parses a string into a Match object
     * Returns: true if match, false otherwise
     */
    private boolean parseLine(String rad) {
        int first = rad.indexOf('-');
        if (first < 0) {
            return false;
        }
        int second = (rad.substring(first + 1)).indexOf('-') + first + 1;
        if (second < 0) {
            return false;
        }

        String home, away, temp;
        int hgoals, agoals, a, index, index2;
        boolean sudden = false;

        try {
            // hometeam
            home = (rad.substring(0, first)).trim();
            // remove junk to the left
            if ((index = home.lastIndexOf("  ")) > -1) {
                home = home.substring(index + 2);
            }
            if ((index = home.lastIndexOf(9)) > -1) // Tab
            {
                home = home.substring(index + 1);
            }

            // awayteam
            temp = (rad.substring(first + 1, second)).trim();
            index = temp.lastIndexOf(' ');
            index2 = temp.lastIndexOf(9); // Tab
            index = (index > index2) ? index : index2;
            away = (temp.substring(0, index)).trim();

            // homegoals
            hgoals = Integer.parseInt((temp.substring(index + 1)).trim());

            // awaygoals
            temp = (rad.substring(second + 1)).trim();
            // remove junk to the right
            String junk = null;
            if ((index = temp.indexOf(' ')) > -1) {
                junk = temp.substring(index).trim();
                temp = (temp.substring(0, index)).trim();
            }
            else if ((index = temp.indexOf(9)) > -1) { //Tab
                junk = temp.substring(index).trim();
                temp = (temp.substring(0, index)).trim();
            }
            agoals = Integer.parseInt(temp);

            // check if junk contains Sudden Death (sd)
            if (suddenDeath_ && junk != null) {
                sudden = junk.toLowerCase().startsWith("sd");
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
        catch (StringIndexOutOfBoundsException e) {
            return false;
        }

        // check if team already exists in league
        int homeid = -1, awayid = -1;
        a = 0;
        java.util.Enumeration enumeration = teams_.elements();
        while (enumeration.hasMoreElements() && (homeid < 0 || awayid < 0)) {
            String team = ((String) enumeration.nextElement()).trim();
            if (team.equals(home)) {
                homeid = a;
            }
            if (team.equals(away)) {
                awayid = a;
            }
            a++;
        }

        try {
            // add teams to league if they are new
            if (homeid == -1) {
                teams_.addElement(Misc.padString(home, 16));
                homeid = teams_.size() - 1;
            }
            if (awayid == -1) {
                teams_.addElement(Misc.padString(away, 16));
                awayid = teams_.size() - 1;
            }

            // add the match
            matches_.addElement(new Match(this, matches_.size(), homeid, awayid, hgoals, agoals, sudden, currentDate_));
            int w;
            if ((w = Integer.toString(hgoals).length()) > matchWidth_) {
                matchWidth_ = w;
            }
            if ((w = Integer.toString(agoals).length()) > matchWidth_) {
                matchWidth_ = w;
            }
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    /**
     * Reads and parses lines from the stream
     */
    public void run() {
        int a, b, plac;

        try {
            String rad;
            while ((rad = inStm_.readLine()) != null) {
                if (!parseLine(rad)) {  // no matchline
                    parseDate(rad);
                }
            }
            inStm_.close();
            inStm_ = null;
        }
        catch (java.io.IOException e) {
            System.out.println("League: IO Error");
            return;
        }

        // sort the teams alphabetically
        int numTeams = teams_.size();
        teamOrder_.setSize(numTeams);

        for (a = 0; a < numTeams; a++) {
            // max 16 characters per team-string
            try {
                teams_.setElementAt(((String) teams_.elementAt(a)).substring(0, 16), a);
            }
            catch (StringIndexOutOfBoundsException e) {
            }
            plac = 0;
            for (b = 0; b < numTeams; b++) {
                if ((((String) teams_.elementAt(a)).compareTo(((String) teams_.elementAt(b)))) > 0) {
                    plac++;
                }
            }
            teamOrder_.setElementAt(new Integer(a), plac);
        }

        matches_.trimToSize();
        teams_.trimToSize();

    }

    /**
     * Sets DateChar-property
     */
    public void setDateChar(char c) {
        dateChar_ = c;
    }

    /**
     * Sets all League-properties (except DateChar)
     */
    public void setProps(Properties props) {
        String arg;

        // check Name and Season parameters
        arg = props.getProperty("LeagueName");
        if (arg != null) {
            name_ = arg;
        }
        arg = props.getProperty("Season");
        if (arg != null) {
            season_ = arg;
        }

        // check the Winpoints parameter
        arg = props.getProperty("Winpoints");
        try {
            winPoints_ = Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
        }

        // check the Drawpoints parameter
        arg = props.getProperty("Drawpoints");
        try {
            drawPoints_ = Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
        }

        // check the Losspoints parameter
        arg = props.getProperty("Losspoints");
        try {
            lossPoints_ = Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
        }

        // check the SDWinpoints parameter
        arg = props.getProperty("SDWinpoints");
        try {
            sdWinPoints_ = Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
        }

        // check the SDLosspoints parameter
        arg = props.getProperty("SDLosspoints");
        try {
            sdLossPoints_ = Integer.parseInt(arg);
        }
        catch (NumberFormatException e) {
        }

        // check the ShowSDInTable parameter
        arg = props.getProperty("ShowSDInTable");
        if (arg != null && arg.toLowerCase().equals("false")) {
            showSDInTable_ = false;
        }

        // check the GDiffSort parameter
        arg = props.getProperty("GDiffSort");
        if (arg != null && arg.toLowerCase().equals("false")) {
            gDiffSort_ = false;
        }

        // check the HideDraws parameter
        arg = props.getProperty("HideDraws");
        if (arg != null && arg.toLowerCase().equals("true")) {
            hideDraws_ = true;
        }

        // check the LineX parameter
        int n = 1;
        int i;
        while (true) {
            arg = props.getProperty("Line" + n);
            try {
                i = Integer.parseInt(arg);
                lines_.addElement(new Integer(i - 1));
            }
            catch (NumberFormatException e) {
                break;
            }
            n++;
        }

        // check the HideX parameter
        n = 1;
        while (true) {
            arg = props.getProperty("Hide" + n);
            if (arg == null) {
                break;
            }
            hide_.addElement(Misc.padString(arg, 16));
            n++;
        }

        // check the MarkX parameter
        n = 1;
        while (true) {
            arg = props.getProperty("Mark" + n);
            if (arg == null) {
                break;
            }
            mark_.addElement(Misc.padString(arg, 16));
            n++;
        }

        // check the PointsX parameter
        // example: Arsenal (-2)
        n = 1;
        while (true) {
            arg = props.getProperty("Points" + n);
            if (arg == null) {
                break;
            }
            try {
                int open = arg.indexOf('(');
                int close = arg.indexOf(')');
                String team = arg.substring(0, open).trim();
                int points = Integer.parseInt(arg.substring(open + 1, close).trim());
                bonus_.put(Misc.padString(team, 16), new Integer(points));
            }
            catch (NumberFormatException e) {
            }
            catch (StringIndexOutOfBoundsException e) {
            }
            n++;
        }

    }

    /**
     * Checks if we should show SD-columns in the table
     */
    public boolean showSDInTable() {
        return showSDInTable_;
    }
}