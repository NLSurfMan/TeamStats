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
 // Norwegian
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Venter ";
  public static final String MAI_ERROR = "Feil: ";
  public static final String MAI_NOMATCHFILE = "Ingen kampfil er angitt";
  public static final String MAI_NOFINDMATCHFILE = "Finner ikke kampfilen";
  public static final String MAI_NOFINDLEAGUEFILE = "Finner ikke argumentfilen";
  public static final String MAI_NOMATCHES = "Kampfilen inneholder ingen kamper";
  public static final String MAI_TABLE = "Tabell";
  public static final String MAI_MATCHES = "Kamper";
  public static final String MAI_STATS = "Statistikk";
  public static final String MAI_COMPARE = "Velg lag";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Table mode
  //
  public static final String TAB_MATCHES = "Kamper:";
  public static final String TAB_ROUNDS = "Runder:";
  public static final String TAB_ALL1 = "Alle";
  public static final String TAB_HOME = "Hjemme";
  public static final String TAB_AWAY = "Borte";
  public static final String TAB_ALL2 = "Alle";
  public static final String TAB_FIRST = "Første";
  public static final String TAB_LAST = "Siste";


  //
  // Match mode
  //
  public static final String MAT_TEAM = "Lag:";
  public static final String MAT_MATCHES = "Kamper:";
  public static final String MAT_RESULTS = "Resultat:";
  public static final String MAT_ALL1 = "Alle";
  public static final String MAT_ALL2 = "Alle";
  public static final String MAT_HOME = "Hjemme";
  public static final String MAT_AWAY = "Borte";
  public static final String MAT_ALL3 = "Alle";
  public static final String MAT_WON = "Vunnet";
  public static final String MAT_DRAWN = "Uavgjort";
  public static final String MAT_LOST = "Tapt";
  public static final String MAT_HOMELET = "H";
  public static final String MAT_AWAYLET = "B";


  //
  // Stats mode
  //
  public static final int STA_X1=200;
  public static final int STA_X2=330;
  public static final String STA_PLAYED = "Spilte kamper:";
  public static final String STA_HOMEWON = "Hjemmeseirer:";
  public static final String STA_DRAWN = "Uavgjorte:";
  public static final String STA_AWAYWON = "Borteseirer:";
  public static final String STA_GOALS = "Scorede mål:";
  public static final String STA_HOMEGOALS = "Hjemmemål:";
  public static final String STA_AWAYGOALS = "Bortemål:";
  public static final String STA_COMMONRES = "Vanligste resultat:";
  public static final String STA_TIMES = " ganger";
  public static final String STA_BIGHOME = "Største hjemmeseier:";
  public static final String STA_BIGAWAY = "Største borteseier:";
  public static final String STA_MOSTGOALS = "Målrikeste kamp:";


  //
  // Compare mode
  //
  public static final int COM_X1=20;
  public static final int COM_X2=120;
  public static final String COM_STATS = "Statistikk";
  public static final String COM_HA_STATS = "Hjemme/borte statistikk";
  public static final String COM_EARLIER = "Tidligere møter";
  public static final String COM_HOMETEAM = "Hjemmelag:";
  public static final String COM_AWAYTEAM = "Bortelag:";

  public static final String COM_TABLEPOS = "Tabellplassering:";
  public static final String COM_PLAYED = "Spilte kamper:";
  public static final String COM_WON = "Vunnet:";
  public static final String COM_DRAWN = "Uavgjort:";
  public static final String COM_LOST = "Tapt:";
  public static final String COM_SCORED = "Scorede mål:";
  public static final String COM_AGAINST = "Innslupne mål:";
  public static final String COM_RESCENT = "Fem siste kamper:";
  public static final String COM_SERIES = "Aktuelle kampkurositeter:";
  public static final String COM_COMMONRES = "Vanligste resultat:";

  public static final String COM_UNBEATEN =  "Ubeseiret:       ";
  public static final String COM_NOWIN =     "Uten seier:      ";
  public static final String COM_SER_WON =   "Vunnet:          ";
  public static final String COM_SER_DRAWN = "Uavgjort:        ";
  public static final String COM_SER_LOST =  "Tap:             ";
  public static final String COM_NOAGA =     "Holdt nullen:    ";
  public static final String COM_NOSCORE =   "Ikke scoret mål: ";
  public static final String COM_MATCHES = " kamper";

}

