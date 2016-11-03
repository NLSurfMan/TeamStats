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

  private Text() {}

 ///////////
 // Swedish
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Laddar ";
  public static final String MAI_ERROR = "Fel: ";
  public static final String MAI_NOMATCHFILE = "Ingen matchfil är angiven";
  public static final String MAI_NOFINDMATCHFILE = "Hittar ej matchfilen";
  public static final String MAI_NOFINDLEAGUEFILE = "Hittar ej argumentfilen (Leaguefile)";
  public static final String MAI_NOMATCHES = "Matchfilen innehåller inga matcher";
  public static final String MAI_TABLE = "Tabell";
  public static final String MAI_MATCHES = "Matcher";
  public static final String MAI_STATS = "Statistik";
  public static final String MAI_COMPARE = "Jämför lag";
  public static final String MAI_HOMEURL = "http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Matcher:";
  public static final String TAB_ROUNDS = "Omgångar:";
  public static final String TAB_ALL1 = "Alla";
  public static final String TAB_HOME = "Hemma";
  public static final String TAB_AWAY = "Borta";
  public static final String TAB_ALL2 = "Alla";
  public static final String TAB_FIRST = "Första";
  public static final String TAB_LAST = "Senaste";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Lag:";
  public static final String MAT_MATCHES = "Matcher:";
  public static final String MAT_RESULTS = "Resultat:";
  public static final String MAT_ALL1 = "Alla";
  public static final String MAT_ALL2 = "Alla";
  public static final String MAT_HOME = "Hemma";
  public static final String MAT_AWAY = "Borta";
  public static final String MAT_ALL3 = "Alla";
  public static final String MAT_WON = "Vunna";
  public static final String MAT_DRAWN = "Oavgjorda";
  public static final String MAT_LOST = "Förluster";
  public static final String MAT_HOMELET = "H";
  public static final String MAT_AWAYLET = "B";


  //
  // Statsmode
  //
  public static final int STA_X1 = 200;
  public static final int STA_X2 = 330;
  public static final String STA_PLAYED = "Spelade matcher:";
  public static final String STA_HOMEWON = "Hemmasegrar:";
  public static final String STA_DRAWN = "Oavgjorda:";
  public static final String STA_AWAYWON = "Bortasegrar:";
  public static final String STA_GOALS = "Gjorda mål:";
  public static final String STA_HOMEGOALS = "Hemmamål:";
  public static final String STA_AWAYGOALS = "Bortamål:";
  public static final String STA_COMMONRES = "Vanligaste resultat:";
  public static final String STA_TIMES = " gånger";
  public static final String STA_BIGHOME = "Största hemmaseger:";
  public static final String STA_BIGAWAY = "Största bortaseger:";
  public static final String STA_MOSTGOALS = "Målrikaste match:";


  //
  // Comparemode
  //
  public static final int COM_X1 = 20;
  public static final int COM_X2 = 120;
  public static final String COM_STATS = "Statistik";
  public static final String COM_HA_STATS = "Hemma/borta statistik";
  public static final String COM_EARLIER = "Tidigare möten";
  public static final String COM_HOMETEAM = "Hemmalag:";
  public static final String COM_AWAYTEAM = "Bortalag:";

  public static final String COM_TABLEPOS = "Tabellplacering:";
  public static final String COM_PLAYED = "Spelade matcher:";
  public static final String COM_WON = "Vunna:";
  public static final String COM_DRAWN = "Oavgjorda:";
  public static final String COM_LOST = "Förluster:";
  public static final String COM_SCORED = "Gjorda mål:";
  public static final String COM_AGAINST = "Insläppta mål:";
  public static final String COM_RESCENT = "Fem senaste matcher:";
  public static final String COM_SERIES = "Aktuella matchsviter:";
  public static final String COM_COMMONRES = "Vanligaste resultat:";

  public static final String COM_UNBEATEN = "Obesegrade:     ";
  public static final String COM_NOWIN =    "Utan seger:     ";
  public static final String COM_SER_WON =  "Vunna:          ";
  public static final String COM_SER_DRAWN ="Oavgjorda:      ";
  public static final String COM_SER_LOST = "Förluster:      ";
  public static final String COM_NOAGA =    "Hållit nollan:  ";
  public static final String COM_NOSCORE =  "Inte gjort mål: ";
  public static final String COM_MATCHES = " matcher";

}
