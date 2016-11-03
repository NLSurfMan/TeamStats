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
 // Icelandic
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Hleður ";
  public static final String MAI_ERROR = "Villa: ";
  public static final String MAI_NOMATCHFILE = "Engin leikjaskrá uppgefin";
  public static final String MAI_NOFINDMATCHFILE = "Finn ekki leikjaskrána";
  public static final String MAI_NOFINDLEAGUEFILE = "Finn ekki deildarskrána";
  public static final String MAI_NOMATCHES = "Engir leikir í leikjaskránni";
  public static final String MAI_TABLE = "Tafla";
  public static final String MAI_MATCHES = "Leikir";
  public static final String MAI_STATS = "Tölfræði";
  public static final String MAI_COMPARE = "Bera saman lið";
  public static final String MAI_HOMEURL = "http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Leikir:";
  public static final String TAB_ROUNDS = "Umferðir:";
  public static final String TAB_ALL1 = "Allir";
  public static final String TAB_HOME = "Heima";
  public static final String TAB_AWAY = "Úti";
  public static final String TAB_ALL2 = "Allar";
  public static final String TAB_FIRST = "Fyrstu";
  public static final String TAB_LAST = "Síðustu";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Lið:";
  public static final String MAT_MATCHES = "Leikir:";
  public static final String MAT_RESULTS = "Úrslit:";
  public static final String MAT_ALL1 = "Öll";
  public static final String MAT_ALL2 = "Allir";
  public static final String MAT_HOME = "Heima";
  public static final String MAT_AWAY = "Úti";
  public static final String MAT_ALL3 = "Öll";
  public static final String MAT_WON = "Sigrar";
  public static final String MAT_DRAWN = "Jafntefli";
  public static final String MAT_LOST = "Ósigrar";
  public static final String MAT_HOMELET = "H";
  public static final String MAT_AWAYLET = "Ú";


  //
  // Statsmode
  //
  public static final int STA_X1 = 200;
  public static final int STA_X2 = 330;
  public static final String STA_PLAYED = "Leikir:";
  public static final String STA_HOMEWON = "Heimalið sigrar:";
  public static final String STA_DRAWN = "Jafntefli:";
  public static final String STA_AWAYWON = "Útilið sigrar:";
  public static final String STA_GOALS = "Skoruð mörk:";
  public static final String STA_HOMEGOALS = "Heimalið skorar:";
  public static final String STA_AWAYGOALS = "Útilið skorar:";
  public static final String STA_COMMONRES = "Algengustu úrslit:";
  public static final String STA_TIMES = " skipti";
  public static final String STA_BIGHOME = "Stærsti heimasigur:";
  public static final String STA_BIGAWAY = "Stærsti útisigur:";
  public static final String STA_MOSTGOALS = "Flest mörk í leik:";


  //
  // Comparemode
  //
  public static final int COM_X1 = 20;
  public static final int COM_X2 = 120;
  public static final String COM_STATS = "Tölfræði";
  public static final String COM_HA_STATS = "H/Ú tölfræði";
  public static final String COM_EARLIER = "Fyrri leikir";
  public static final String COM_HOMETEAM = "Heimalið:";
  public static final String COM_AWAYTEAM = "Útilið:";

  public static final String COM_TABLEPOS = "Sæti:";
  public static final String COM_PLAYED = "Leikir:";
  public static final String COM_WON = "Sigrað:";
  public static final String COM_DRAWN = "Jafntefli:";
  public static final String COM_LOST = "Tapað:";
  public static final String COM_SCORED = "Skorað:";
  public static final String COM_AGAINST = "Sleppt inn:";
  public static final String COM_RESCENT = "Fimm síðustu leikir:";
  public static final String COM_SERIES = "Núverandi lota:";
  public static final String COM_COMMONRES = "Algengustu úrslit:";

  public static final String COM_UNBEATEN =  "Ekki tapað:       ";
  public static final String COM_NOWIN =     "Án sigurs:        ";
  public static final String COM_SER_WON =   "Sigrað:           ";
  public static final String COM_SER_DRAWN = "Jafntefli:        ";
  public static final String COM_SER_LOST =  "Tapað:            ";
  public static final String COM_NOAGA =     "Ekki fengið mark: ";
  public static final String COM_NOSCORE =   "Ekki skorað:      ";
  public static final String COM_MATCHES = " leikir";

}

