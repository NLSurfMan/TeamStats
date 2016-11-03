/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: TeamStats.java
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

import embe.ui.HyperLink;
import embe.ui.ModePanel;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.DataInputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;


/**
 * The main class.
 *
 * @author Mats Bovin
 */
public class TeamStats extends java.applet.Applet implements Runnable {
    public final static Font MAINFONT = new Font("Courier", Font.PLAIN, 12);
    private final static String VERSION = "TeamStats v1.2";
    private final static String COPYRIGHT = "Copyright (c) 1996-99 Mats Bovin.";
    protected boolean hideBorder_ = false;

    protected Hashtable leagueNames_ = new Hashtable();
    protected Hashtable activeLeague_ = null;
    protected Vector leagues_ = new Vector();

    protected Thread jsThread_ = null;
    protected Vector jsQueue_ = new Vector();

    protected ModePanel mainPanel_;
    protected TablePanel tablePanel_;
    protected MatchPanel matchPanel_;
    protected StatPanel statsPanel_;
    protected ComparePanel comparePanel_;
    protected boolean guiBuilt_ = false;

    protected String errorStr_ = null;
    protected Label errorLabel_;
    protected boolean error_ = false;


    /** Returns info about parameters */
/*  public String[][] getParameterInfo() {
    String[][] pinfo = {
		  {"Leaguefile",  "url",    "URL to file with parameters"},
		  {"LeagueName",  "string", "Name of league"},
		  {"Season",      "string", "Season of league"},
		  {"Matchfile",   "url",    "URL to file with matches"},
		  {"WinPoints",   "int",    "Points for winning a game"},
		  {"DrawPoints",  "int",    "Points for a draw"},
		  {"LossPoints",  "int",    "Points for loosing a game"},
		  {"SDWinPoints", "int",    "Points for winning a game in SD"},
		  {"SDLossPoints","int",    "Points for loosing a game in SD"},
		  {"SuddenDeath", "boolean","League uses Sudden Death"},
		  {"ShowSDInTable","boolean","Should SD-columns be showed in the table"},
		  {"GDiffSort",   "boolean","Use goaldiff to separate teams with equal points"},
		  {"LineX",       "int",    "Place a qualifying line at this position in the table"},
		  {"HideX",       "string", "Hide a team"},
		  {"PointsX",     "string", "Give extra points to a team"},
		  {"MarkX",       "string", "Marks a team in the table"},
		  {"NoPrevSeason","boolean","Don't look for previous meetings"},
		  {"HideBorder",  "boolean","Hides border around applet"},
		  {"ForeCol",     "string", "Sets foreground color"},
		  {"BackCol",     "string", "Sets background color"},
		  {"PrimCol",     "string", "Sets primary drawing color"},
		  {"SecCol",      "string", "Sets secondary drawing color"},
		  {"ButtonCol",   "string", "Sets button color"},
		  {"ButtonTextCol", "string", "Sets button text color"},
		  {"ButtonSelectCol", "string", "Color of selected button"},
		  {"DateChar",    "character", "Sets date separator"},
	};

	return pinfo;
  }
*/

    /**
     * Build the GUI, executed once
     */
    protected void buildGUI() {
        Color foreCol = Color.black;
        Color backCol = Color.white;
        Color primCol = Color.blue;
        Color secCol = Color.black;
        Color buttonCol = Color.lightGray;
        Color buttonTextCol = Color.black;
        Color buttonSelectCol = Color.blue;
        boolean noPrev = false;
        String imageName = null;
        String arg;
        Color col;

        // check applet parameters
        try {

            // colors
            arg = getParameter("Primcol");
            if ((col = Misc.parseColorString(arg)) != null) {
                primCol = col;
            }
            arg = getParameter("Seccol");
            if ((col = Misc.parseColorString(arg)) != null) {
                secCol = col;
            }
            arg = getParameter("Forecol");
            if ((col = Misc.parseColorString(arg)) != null) {
                foreCol = col;
            }
            arg = getParameter("Backcol");
            if ((col = Misc.parseColorString(arg)) != null) {
                backCol = col;
            }
            arg = getParameter("ButtonCol");
            if ((col = Misc.parseColorString(arg)) != null) {
                buttonCol = col;
            }
            arg = getParameter("ButtonTextCol");
            if ((col = Misc.parseColorString(arg)) != null) {
                buttonTextCol = col;
            }
            arg = getParameter("ButtonSelectCol");
            if ((col = Misc.parseColorString(arg)) != null) {
                buttonSelectCol = col;
            }

            // name of backgroundimage
            imageName = getParameter("Image");

            // draw border?
            arg = getParameter("HideBorder");
            if (arg != null && arg.toUpperCase().equals("TRUE")) {
                hideBorder_ = true;
            }

            // look for previous meetings?
            arg = getParameter("NoPrevSeason");
            if (arg != null && arg.toUpperCase().equals("TRUE")) {
                noPrev = true;
            }

        }
        catch (NullPointerException e) {
        } // if not in applet

        // background colors and layout
        setBackground(backCol);
        setForeground(foreCol);
        setLayout(new BorderLayout());

        // create the panels
        tablePanel_ = new TablePanel(primCol, secCol, foreCol, backCol);
        matchPanel_ = new MatchPanel(primCol, secCol, foreCol, backCol, size().width);
        statsPanel_ = new StatPanel(primCol, secCol, foreCol, backCol);
        comparePanel_ = new ComparePanel(primCol, secCol, foreCol, backCol, noPrev);

        // load the backgroundimage
        Image image = getImage(getDocumentBase(), imageName);
        if (image != null) {
            if (prepareImage(image, this)) { // the image is already loaded
                // give image to panels
                tablePanel_.setImage(image);
                matchPanel_.setImage(image);
                statsPanel_.setImage(image);
                comparePanel_.setImage(image);
            }
        }

        // create and set up ModePanel and menu system
        mainPanel_ = new ModePanel(ModePanel.TOP, 2);
        mainPanel_.setButtonColor(buttonCol);
        mainPanel_.setButtonTextColor(buttonTextCol);
        mainPanel_.setSelectedColor(buttonSelectCol);
        mainPanel_.addMode(tablePanel_, Text.MAI_TABLE);
        mainPanel_.addMode(matchPanel_, Text.MAI_MATCHES);
        mainPanel_.addMode(statsPanel_, Text.MAI_STATS);
        mainPanel_.addMode(comparePanel_, Text.MAI_COMPARE);

        // a copyright-msg and link to homepage at the bottom
        URL homeURL = null;
        try {
            homeURL = new URL(Text.MAI_HOMEURL);
        }
        catch (java.net.MalformedURLException e) {
        }
        HyperLink link = new HyperLink(homeURL, getAppletContext(), VERSION);
        link.setForeground(primCol);
        Label copyLab = new Label(COPYRIGHT);
        copyLab.setForeground(foreCol);
        Panel southbar = new Panel();
        southbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        southbar.add(link);
        southbar.add(copyLab);

        // add stuff to applet
        add("Center", mainPanel_);
        add("South", southbar);

        // ok, we're done
        guiBuilt_ = true;
    }

    /**
     * Queues a JavaScript request and starts js-thread
     */
    protected synchronized void execJS(String[] args) {
        jsQueue_.addElement(args);
        if (jsThread_ == null) {
            jsThread_ = new Thread(this);
            jsThread_.start();
        }
    }

    /**
     * Returns info about the applet
     */
    public String getAppletInfo() {
        return VERSION + " " + COPYRIGHT;
    }

    /**
     * Informs Panels when background image has been loaded
     */
    public boolean imageUpdate(Image image, int flags, int x, int y, int w, int h) {
        // check that the whole image is loaded
        if ((flags & ImageObserver.ALLBITS) != 0) {
            // give image to panels
            tablePanel_.setImage(image);
            matchPanel_.setImage(image);
            statsPanel_.setImage(image);
            comparePanel_.setImage(image);
        }

        return (flags & (ALLBITS | ABORT)) == 0;
    }

    /**
     * Check Leaguefile param, then read other params
     */
    public void init() {
        Properties props;

        String leaguefile = getParameter("Leaguefile");
        if (leaguefile != null) {
            props = readLeaguefile(leaguefile); // read from options file
        }
        else {
            props = readParams(); // read Applet params
            leaguefile = "param";
        }

        setup(leaguefile, props);

        // if no GUI -> build it now
        if (!guiBuilt_) {
            buildGUI();
        }

        showLeague(leaguefile);
    }

    /**
     * Make room for border
     */
    public Insets insets() {
        if (!hideBorder_) {
            return new Insets(1, 1, 1, 1);
        }
        else {
            return new Insets(0, 0, 0, 0);
        }
    }

    /**
     * Loads another league
     */
    public synchronized void loadLeaguefile(String filename) {
        errorStr_ = null;
        // check if league is loaded first
        if (!leagueNames_.containsKey(filename)) {
            String args[] = {"loadfile", filename};
            execJS(args); // send JS-request to JS-thread
        }
    }

    /**
     * Opens a DataInputStream to the Matchfile
     */
    protected DataInputStream openMatchfile(String name)
            throws java.net.MalformedURLException, java.io.IOException {

        URL url;
        DataInputStream inStm;

        try {
            url = new URL(getDocumentBase(), name);
        }
        catch (java.net.MalformedURLException e) {
            throw e;
        }
        try {
            inStm = new DataInputStream(url.openStream());
        }
        catch (java.io.IOException e) {
            throw e;
        }

        return inStm;
    }

    /**
     * Draws a frame around the applet
     */
    public void paint(Graphics g) {
        if (!hideBorder_) {
            Dimension d = size();
            g.drawRect(0, 0, d.width - 1, d.height - 1);
        }
    }

    /**
     * Reads League properties from a file
     */
    protected Properties readLeaguefile(String filename) {
        Properties props = new Properties();
        URL url = null;

        try {
            url = new URL(getDocumentBase(), filename);
        }
        catch (java.net.MalformedURLException e) {
            errorStr_ = Text.MAI_NOFINDLEAGUEFILE;
        }
        try {
            props.load(url.openStream());
        }
        catch (java.io.IOException e) {
            errorStr_ = Text.MAI_NOFINDLEAGUEFILE;
        }

        return props;
    }

    /**
     * Read League properties from applet params
     */
    protected Properties readParams() {
        int n, a;
        Properties props = new Properties();
        String paramValue = null;
        String validParams[] = {
                "Matchfile",
                "Winpoints",
                "Drawpoints",
                "Losspoints",
                "SDWinpoints",
                "SDLosspoints",
                "SuddenDeath",
                "ShowSDInTable",
                "GDiffSort",
                "LeagueName",
                "Season",
                "DateChar",
                "HideDraws"
        };
        String multiParams[] = {
                "Line",
                "Hide",
                "Points",
                "Mark"
        };

        for (a = 0; a < validParams.length; a++) {
            paramValue = getParameter(validParams[a]);
            if (paramValue != null) {
                props.put(validParams[a], paramValue);
            }
        }

        for (a = 0; a < multiParams.length; a++) {
            n = 1;
            while (true) {
                paramValue = getParameter(multiParams[a] + n);
                if (paramValue == null) {
                    break;
                }
                props.put(multiParams[a] + n, paramValue);
                n++;
            }
        }

        return props;
    }

    /**
     * Executes JS-requests
     */
    public void run() {

        while (!jsQueue_.isEmpty()) {
            String args[] = (String[]) jsQueue_.firstElement();
            jsQueue_.removeElementAt(0);

            if (args[0].endsWith("file")) {
                // load league if it's not loaded
                if (!(leagueNames_.containsKey(args[1]))) {
                    Properties props;
                    props = readLeaguefile(args[1]);
                    setup(args[1], props);
                }

                if (args[0].startsWith("show")) {
                    showLeague(args[1]);
                }
                showInfo("");
            }

            if (args[0].equals("table")) {
                activeLeague_.put("tab_place", new Integer(args[1]));
                activeLeague_.put("tab_match", new Integer(args[2]));
                activeLeague_.put("tab_num", new Integer(args[3]));
                tablePanel_.setOptions(activeLeague_);
                showMode(Text.MAI_TABLE);
            }

            if (args[0].equals("match")) {
                activeLeague_.put("mat_team", args[1]);
                activeLeague_.put("mat_place", new Integer(args[2]));
                activeLeague_.put("mat_res", new Integer(args[3]));
                matchPanel_.setOptions(activeLeague_, false);
                showMode(Text.MAI_MATCHES);
            }

            if (args[0].equals("stats")) {
                showMode(Text.MAI_STATS);
                statsPanel_.setOptions(activeLeague_);
            }

            if (args[0].equals("compare")) {
                activeLeague_.put("com_mode", new Integer(args[1]));
                activeLeague_.put("com_home", args[2]);
                activeLeague_.put("com_away", args[3]);
                comparePanel_.setOptions(activeLeague_);
                showMode(Text.MAI_COMPARE);
            }

        }

        jsThread_ = null;
    }

    /**
     * Shows another league
     */
    public synchronized void setLeaguefile(String filename) {
        errorStr_ = null;

        String args[] = {"showfile", filename};
        execJS(args); // send JS-request to JS-thread
    }

    /**
     * Setup a new league, executed once per new league
     */
    protected void setup(String name, Properties props) {
        URL url = null;
        String arg;
        Thread loadThread = null;
        DataInputStream instm = null;
        Hashtable set;

        // create settings for this league
        set = new Hashtable();
        set.put("mode", "ERROR"); // assume error
        leagueNames_.put(name, set);

        // exit if already error
        if (errorStr_ != null) {
            set.put("error", errorStr_);
            return;
        }

        // connect to Matchfile
        arg = props.getProperty("Matchfile");
        if (arg == null) {
            set.put("error", Text.MAI_NOMATCHFILE);
            return;
        }
        try {
            instm = openMatchfile(arg);
        }
        catch (java.net.MalformedURLException e) {
            set.put("error", Text.MAI_NOFINDMATCHFILE);
            return;
        }
        catch (java.io.IOException e) {
            set.put("error", Text.MAI_NOFINDMATCHFILE);
            return;
        }

        // create new league and start thread
        // for loading and parsing the matchfile
        League league = new League(leagues_, instm);
        // DateChar and SuddenDeath are use by the load thread so
        // they have to be set before loading begins
        arg = props.getProperty("DateChar");
        if (arg != null) {
            league.setDateChar(arg.charAt(0));
        }
        arg = props.getProperty("SuddenDeath");
        if (arg != null && arg.toLowerCase().equals("true")) {
            league.setSuddenDeath(true);
        }
        loadThread = new Thread(league, "LoadFile");
        loadThread.start();

        // set league props
        league.setProps(props);

        showInfo("TeamStats: " + Text.MAI_LOADING + league.getTitle() + "...");

        // if this is first league -> build GUI
        if (activeLeague_ == null) {
            buildGUI();
        }

        // wait for loadThread to finish
        while (loadThread.isAlive()) {
            try {
                loadThread.join(100);
            }
            catch (InterruptedException e) {
            }
        }

        // check that any matches where read
        if (league.getNumMatches() == 0) {
            set.put("error", Text.MAI_NOMATCHES);
            return;
        }

        // if reached -> league is OK, no more error exits

        // add league to leagues-vector
        int a = 0;
        while (a < leagues_.size()) {
            League l = (League) leagues_.elementAt(a);
            if (league.getSeason().compareTo(l.getSeason()) >= 0) {
                break;
            }
            else {
                a++;
            }
        }
        leagues_.insertElementAt(league, a);

        // set standard settings
        set.put("mode", Text.MAI_TABLE);
        set.put("league", league);
        set.put("tab_place", new Integer(0));
        set.put("tab_match", new Integer(0));
        set.put("tab_num", new Integer(5));

        set.put("mat_team", "ALL");
        set.put("mat_place", new Integer(0));
        set.put("mat_res", new Integer(0));

        set.put("com_mode", new Integer(0));
        set.put("com_home", "");
        set.put("com_away", "");
    }

    public synchronized void showCompare(int mode, String home, String away) {
        // no mode change if error
        if (error_) {
            return;
        }

        // fixes special chars (�,�,� etc)
        // start bugfix NN3.0
        home = Misc.fixString(home);
        away = Misc.fixString(away);
        // end bugfix

        String[] args = {"compare", Integer.toString(mode), home, away};
        execJS(args);
    }

    /**
     * Outputs info
     */
    protected void showInfo(String info) {
        showStatus(info);
    }

    /**
     * Shows a league
     */
    protected synchronized void showLeague(String name) {
        boolean startup = (activeLeague_ == null);

        // save old league settings
        if (activeLeague_ != null && !error_) {
            activeLeague_.put("mode", mainPanel_.getSelectedMode());
            tablePanel_.getOptions(activeLeague_);
            matchPanel_.getOptions(activeLeague_);
            statsPanel_.getOptions(activeLeague_);
            comparePanel_.getOptions(activeLeague_);
        }

        activeLeague_ = (Hashtable) leagueNames_.get(name);
        String mode = (String) activeLeague_.get("mode");

/*
  tablePanel_.setOptions(activeLeague_);
	comparePanel_.setOptions(activeLeague_);
	matchPanel_.setOptions(activeLeague_);
	statsPanel_.setOptions(activeLeague_);
	showMode(mode);
*/
        if (mode.equals(Text.MAI_TABLE)) {
            tablePanel_.setOptions(activeLeague_);
            showMode(mode);
            matchPanel_.setOptions(activeLeague_, startup);
            statsPanel_.setOptions(activeLeague_);
            comparePanel_.setOptions(activeLeague_);
        }
        else if (mode.equals(Text.MAI_MATCHES)) {
            matchPanel_.setOptions(activeLeague_, startup);
            showMode(mode);
            tablePanel_.setOptions(activeLeague_);
            statsPanel_.setOptions(activeLeague_);
            comparePanel_.setOptions(activeLeague_);
        }
        else if (mode.equals(Text.MAI_STATS)) {
            statsPanel_.setOptions(activeLeague_);
            showMode(mode);
            tablePanel_.setOptions(activeLeague_);
            matchPanel_.setOptions(activeLeague_, startup);
            comparePanel_.setOptions(activeLeague_);
        }
        else if (mode.equals(Text.MAI_COMPARE)) {
            comparePanel_.setOptions(activeLeague_);
            showMode(mode);
            tablePanel_.setOptions(activeLeague_);
            matchPanel_.setOptions(activeLeague_, startup);
            statsPanel_.setOptions(activeLeague_);
        }
        else if (mode.equals("ERROR")) {
            String error = (String) activeLeague_.get("error");
            // remove main panel and add errorlabel
            remove(mainPanel_);
            errorLabel_ = new Label("Guru Meditation: " + error, Label.CENTER);
            add("Center", errorLabel_);
            validate();
            // applet in error mode
            error_ = true;
        }

    }

    public synchronized void showMatches(String team, int place, int res) {
        // no mode change if error
        if (error_) {
            return;
        }

        // fixes special chars (�,�,� etc)
        // start bugfix NN3.0
        team = Misc.fixString(team);
        // end bugfix

        String[] args = {"match", team, Integer.toString(place), Integer.toString(res)};
        execJS(args);
    }

    /**
     * Shows a new mode
     */
    protected synchronized void showMode(String newMode) {
        // check if applet is in error mode
        if (error_) {
            // remove errorlabel and add main panel
            remove(errorLabel_);
            add("Center", mainPanel_);
            validate();
            // no longer in error
            error_ = false;
        }

        // show new mode
        mainPanel_.selectMode(newMode);
    }

    public synchronized void showStats() {
        // no mode change if error
        if (error_) {
            return;
        }
        String[] args = {"stats"};
        execJS(args);
    }

    /* Shows a mode with specified options */
    public synchronized void showTable(int place, int match, int num) {
        // no mode change if error
        if (error_) {
            return;
        }
        String[] args = {"table", Integer.toString(place), Integer.toString(match), Integer.toString(num)};
        execJS(args);
    }

    /**
     * Clears the StatusBar
     */
    public void start() {
        showInfo("");
    }
}