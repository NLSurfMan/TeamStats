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
 // German
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Laden ";
  public static final String MAI_ERROR = "Fehler: ";
  public static final String MAI_NOMATCHFILE = "kein Matchfile angegeben";
  public static final String MAI_NOFINDMATCHFILE = "Kann Matchfile nicht finden";
  public static final String MAI_NOFINDLEAGUEFILE = "Kann Parameterfile nicht finden";
  public static final String MAI_NOMATCHES = "Das Matchfile ist leer";
  public static final String MAI_TABLE = "Tabelle";
  public static final String MAI_MATCHES = "Spiele";
  public static final String MAI_STATS = "Statistik";
  public static final String MAI_COMPARE = "Teamvergleich"; //"Mannschaftsvergleich";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Spiele:";
  public static final String TAB_ROUNDS = "Spieltag:";
  public static final String TAB_ALL1 = "Alle";
  public static final String TAB_HOME = "Heim";
  public static final String TAB_AWAY = "Auswärts";
  public static final String TAB_ALL2 = "Alle";
  public static final String TAB_FIRST = "Ersten";
  public static final String TAB_LAST = "Letzten";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Mannschaft:";
  public static final String MAT_MATCHES = "Spiele:";
  public static final String MAT_RESULTS = "Ergebnisse:";
  public static final String MAT_ALL1 = "Alle";
  public static final String MAT_ALL2 = "Alle";
  public static final String MAT_HOME = "Heim";
  public static final String MAT_AWAY = "Auswärts";
  public static final String MAT_ALL3 = "Alle";
  public static final String MAT_WON = "gewonnen";
  public static final String MAT_DRAWN = "unent."; //"unentschieden"
  public static final String MAT_LOST = "verloren";
  public static final String MAT_HOMELET = "H";
  public static final String MAT_AWAYLET = "A";


  //
  // Statsmode
  //
  public static final int STA_X1=156;
  public static final int STA_X2=374;
  public static final String STA_PLAYED = "Gespielte Begegnungen:";
  public static final String STA_HOMEWON = "Heimsieg:";
  public static final String STA_DRAWN = "Unentschieden:";
  public static final String STA_AWAYWON = "Auswärtssieg:";
  public static final String STA_GOALS = "Tore:";
  public static final String STA_HOMEGOALS = "Tore durch Heimmannschaft:";
  public static final String STA_AWAYGOALS = "Tore durch Auswärtsmannschaft:";
  public static final String STA_COMMONRES = "Häufigstes Ergebnis:";
  public static final String STA_TIMES = " mal";
  public static final String STA_BIGHOME = "Höchster Heimsieg:";
  public static final String STA_BIGAWAY = "Höchster Auswärtssieg:";
  public static final String STA_MOSTGOALS = "Meiste Tore:";


  //
  // Comparemode
  //
  public static final int COM_X1=15;
  public static final int COM_X2=130;
  public static final String COM_STATS = "Statistik";
  public static final String COM_HA_STATS = "Heim/Auswärts Statistik";
  public static final String COM_EARLIER = "Vorherige Spiele";
  public static final String COM_HOMETEAM = "Heimteam:"; //"Heimmannschaft:";
  public static final String COM_AWAYTEAM = "Auswärtsteam:"; //"Auswärtsmannschaft:";

  public static final String COM_TABLEPOS = "Tabellenplatz:";
  public static final String COM_PLAYED = "Spiele absolviert:";
  public static final String COM_WON = "Gewonnen:";
  public static final String COM_DRAWN = "Unentschieden:";
  public static final String COM_LOST = "Verloren:";
  public static final String COM_SCORED = "geschossene Tore:";
  public static final String COM_AGAINST = "Gegentore:";
  public static final String COM_RESCENT = "Letzte 5 Spiele:";
  public static final String COM_SERIES = "Aktuelle Serien:";
  public static final String COM_COMMONRES = "Häufigstes Ergebnis:";

  public static final String COM_UNBEATEN = "Ungeschlagen:           ";
  public static final String COM_NOWIN =    "Kein Sieg:              ";
  public static final String COM_SER_WON =  "Siege:                  ";
  public static final String COM_SER_DRAWN ="Unentschieden:          ";
  public static final String COM_SER_LOST = "Niederlagen:            ";
  public static final String COM_NOAGA =    "Keine Gegentore:        ";
  public static final String COM_NOSCORE =  "Keine geschossenen Tore:";
  public static final String COM_MATCHES = " Spiele";

}