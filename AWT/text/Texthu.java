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
 // Hungarian
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Töltödik ";
  public static final String MAI_ERROR = "Hiba: ";
  public static final String MAI_NOMATCHFILE = "Hiányzik a Matchfile";
  public static final String MAI_NOFINDMATCHFILE = "Nem találom a Matchfile-t";
  public static final String MAI_NOFINDLEAGUEFILE = "Nem találom a Leaguefile-t";
  public static final String MAI_NOMATCHES = "A Matchfile nem tartalmaz eredményeket";
  public static final String MAI_TABLE = "Tabella";
  public static final String MAI_MATCHES = "Mérkõzések";
  public static final String MAI_STATS = "Statisztika";
  public static final String MAI_COMPARE = "Csapatok";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Table mode
  //
  public static final String TAB_MATCHES = "Mérkõzések:";
  public static final String TAB_ROUNDS = "Fordulók:";
  public static final String TAB_ALL1 = "Összes";
  public static final String TAB_HOME = "Hazai";
  public static final String TAB_AWAY = "Idegenbeli";
  public static final String TAB_ALL2 = "Összes";
  public static final String TAB_FIRST = "Elsõ";
  public static final String TAB_LAST = "Utolsó";


  //
  // Match mode
  //
  public static final String MAT_TEAM = "Csapat:";
  public static final String MAT_MATCHES = "Mérkõzések:";
  public static final String MAT_RESULTS = "Eredmények:";
  public static final String MAT_ALL1 = "Összes";
  public static final String MAT_ALL2 = "Összes";
  public static final String MAT_HOME = "Hazai";
  public static final String MAT_AWAY = "Idegenbeli";
  public static final String MAT_ALL3 = "Összes";
  public static final String MAT_WON = "Gyõzelem";
  public static final String MAT_DRAWN = "Döntetlen";
  public static final String MAT_LOST = "Vereség";
  public static final String MAT_HOMELET = "O";
  public static final String MAT_AWAYLET = "I";


  //
  // Stats mode
  //
  public static final int STA_X1=200;
  public static final int STA_X2=330;
  public static final String STA_PLAYED = "Mérkõzések száma:";
  public static final String STA_HOMEWON = "Hazai gyõzelem:";
  public static final String STA_DRAWN = "Döntetlen:";
  public static final String STA_AWAYWON = "Vendég gyõzelem:";
  public static final String STA_GOALS = "Összes gól:";
  public static final String STA_HOMEGOALS = "Hazai gólok:";
  public static final String STA_AWAYGOALS = "Vendég gólok:";
  public static final String STA_COMMONRES = "Leggyakoribb eredmény:";
  public static final String STA_TIMES = " alkalommal";
  public static final String STA_BIGHOME = "Legnagyobb hazai gyõzelem:";
  public static final String STA_BIGAWAY = "Legnagyobb vendég gyõzelem:";
  public static final String STA_MOSTGOALS = "Legtöbb gól:";


  //
  // Compare mode
  //
  public static final int COM_X1=20;
  public static final int COM_X2=120;
  public static final String COM_STATS = "Statisztika";
  public static final String COM_HA_STATS = "Hazai/vendég";
  public static final String COM_EARLIER = "Elõzõ mérkõzések";
  public static final String COM_HOMETEAM = "Hazai csapat:";
  public static final String COM_AWAYTEAM = "Vendég csapat:";

  public static final String COM_TABLEPOS = "Helyezés:";
  public static final String COM_PLAYED = "Mérkõzések száma:";
  public static final String COM_WON = "Gyõzelem:";
  public static final String COM_DRAWN = "Döntetlen:";
  public static final String COM_LOST = "Vereség:";
  public static final String COM_SCORED = "Lõtt gólok:";
  public static final String COM_AGAINST = "Kapott gólok:";
  public static final String COM_RESCENT = "Utolsó mérkõzések:";
  public static final String COM_SERIES = "Aktuális forma:";
  public static final String COM_COMMONRES = "Leggyakoribb eredmény";

  public static final String COM_UNBEATEN =  "Veretlen:         ";
  public static final String COM_NOWIN =     "Nyeretlen:        ";
  public static final String COM_SER_WON =   "Gyõzelem:         ";
  public static final String COM_SER_DRAWN = "Döntetlen:        ";
  public static final String COM_SER_LOST =  "Vereség:          ";
  public static final String COM_NOAGA =     "Kapott gól nélkül:";
  public static final String COM_NOSCORE =   "Rúgott gól nélkül:";
  public static final String COM_MATCHES = " mérkõzés";

}
