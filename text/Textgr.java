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
 * Constant textstrings in different languages
 */
class Text {

  private Text() {}

 ///////////
 // Greek
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Φορτωμα ";
  public static final String MAI_ERROR = "Λαθος: ";
  public static final String MAI_NOMATCHFILE = "Δεν υπαρχει αρχειο αγωνων";
  public static final String MAI_NOFINDMATCHFILE = "Δεν βρισκεται αρχειο αγωνων";
  public static final String MAI_NOFINDLEAGUEFILE = "Δεν μπορω να βρω το αρχειο παραμετρων ";
  public static final String MAI_NOMATCHES = "Το αρχειο δεν περιεχει αγωνες ";
  public static final String MAI_TABLE = "Πινακας";
  public static final String MAI_MATCHES = "Αγωνες";
  public static final String MAI_STATS = "Στατιστικα";
  public static final String MAI_COMPARE = "Συγκριση ομαδων";
  public static final String MAI_HOMEURL = "http://www.dsv.su.se/~mats-bov/ts";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Αγωνες:";
  public static final String TAB_ROUNDS = "Γυροι:";
  public static final String TAB_ALL1 = "Ολα";
  public static final String TAB_HOME = "Εντος εδρας"; /* (if not enough space "Εντος") */
  public static final String TAB_AWAY = "Εκτος εδρας"; /* (if not enough space "Εκτος") */
  public static final String TAB_ALL2 = "Ολα";
  public static final String TAB_FIRST = "Πρωτος";
  public static final String TAB_LAST = "Τελευταιος";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Ομαδα:";
  public static final String MAT_MATCHES = "Αγωνες:";
  public static final String MAT_RESULTS = "Αποτελεσματα:";
  public static final String MAT_ALL1 = "Ολα";
  public static final String MAT_ALL2 = "Ολα";
  public static final String MAT_HOME = "Εντος εδρας"; /* ("Εντος") */
  public static final String MAT_AWAY = "Εκτος εδρας"; /* ("Εκτος") */
  public static final String MAT_ALL3 = "Ολα";
  public static final String MAT_WON = "Νικες";
  public static final String MAT_DRAWN = "Ισοπαλιες";
  public static final String MAT_LOST = "Ηττες";
  public static final String MAT_HOMELET = "Ν"; /* ("Εν¨") */
  public static final String MAT_AWAYLET = "Κ"; /* ("Εκ") */


  //
  // Statsmode
  //
  public static final int STA_X1 = 180;
  public static final int STA_X2 = 360;
  public static final String STA_PLAYED = "Αγωνες που εχουν παιχτεί:";
  public static final String STA_HOMEWON = "Νικες γηπεδουχου:";
  public static final String STA_DRAWN = "Ισοπαλιες:";
  public static final String STA_AWAYWON = "Νικες φιλοξενουμενου:";
  public static final String STA_GOALS = "Γκολ:";
  public static final String STA_HOMEGOALS = "Γκολ γηπεδουχου:";
  public static final String STA_AWAYGOALS = "Γκολ φιλοξενουμενου:";
  public static final String STA_COMMONRES = "Πιο συχνο αποτελεσμα:";
  public static final String STA_TIMES = " Φορες";
  public static final String STA_BIGHOME = "Μεγαλυτερη εντος εδρας νικη:";
  public static final String STA_BIGAWAY = "Μεγαλυτερη εκτος εδρας νικη:";
  public static final String STA_MOSTGOALS = "Περισσοτερα γκολ:";


  //
  // Comparemode
  //
  public static final int COM_X1 = 15;
  public static final int COM_X2 = 150;
  public static final String COM_STATS = "Στατιστικα";
  public static final String COM_HA_STATS = "Εντος/Εκτος Στατιστικα";
  public static final String COM_EARLIER = "Προηγουμενα παιχνιδια";
  public static final String COM_HOMETEAM = "Γηπεδουχος:";
  public static final String COM_AWAYTEAM = "Φιλοξενουμενος:";

  public static final String COM_TABLEPOS = "Θεση:";
  public static final String COM_PLAYED = "Αγωνες που παιχτηκαν:";
  public static final String COM_WON = "Νικες:";
  public static final String COM_DRAWN = "Ισοπαλιες:";
  public static final String COM_LOST = "Ηττες:";
  public static final String COM_SCORED = "Γκολ υπερ:";
  public static final String COM_AGAINST = "Γκολ κατα:";
  public static final String COM_RESCENT = "5 τελευταια παιχνιδια:";
  public static final String COM_SERIES = "Σερι επιτυχιων:";
  public static final String COM_COMMONRES = "Πιο συχνο αποτελεσμα:";

  public static final String COM_UNBEATEN =  "Χωρις ηττα:        ";
  public static final String COM_NOWIN =     "Χωρις νικη:        ";
  public static final String COM_SER_WON =   "Νικες:             ";
  public static final String COM_SER_DRAWN = "Ισοπαλιες:         ";
  public static final String COM_SER_LOST =  "Ηττες:             ";
  public static final String COM_NOAGA =     "Απαραβίαστη Εστια: ";
  public static final String COM_NOSCORE =   "Χωρις γκολ υπερ:   ";
  public static final String COM_MATCHES = " Αγωνες";


}

