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
  public static final String MAI_LOADING = "Hle�ur ";
  public static final String MAI_ERROR = "Villa: ";
  public static final String MAI_NOMATCHFILE = "Engin leikjaskr� uppgefin";
  public static final String MAI_NOFINDMATCHFILE = "Finn ekki leikjaskr�na";
  public static final String MAI_NOFINDLEAGUEFILE = "Finn ekki deildarskr�na";
  public static final String MAI_NOMATCHES = "Engir leikir � leikjaskr�nni";
  public static final String MAI_TABLE = "Tafla";
  public static final String MAI_MATCHES = "Leikir";
  public static final String MAI_STATS = "T�lfr��i";
  public static final String MAI_COMPARE = "Bera saman li�";
  public static final String MAI_HOMEURL = "http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Leikir:";
  public static final String TAB_ROUNDS = "Umfer�ir:";
  public static final String TAB_ALL1 = "Allir";
  public static final String TAB_HOME = "Heima";
  public static final String TAB_AWAY = "�ti";
  public static final String TAB_ALL2 = "Allar";
  public static final String TAB_FIRST = "Fyrstu";
  public static final String TAB_LAST = "S��ustu";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Li�:";
  public static final String MAT_MATCHES = "Leikir:";
  public static final String MAT_RESULTS = "�rslit:";
  public static final String MAT_ALL1 = "�ll";
  public static final String MAT_ALL2 = "Allir";
  public static final String MAT_HOME = "Heima";
  public static final String MAT_AWAY = "�ti";
  public static final String MAT_ALL3 = "�ll";
  public static final String MAT_WON = "Sigrar";
  public static final String MAT_DRAWN = "Jafntefli";
  public static final String MAT_LOST = "�sigrar";
  public static final String MAT_HOMELET = "H";
  public static final String MAT_AWAYLET = "�";


  //
  // Statsmode
  //
  public static final int STA_X1 = 200;
  public static final int STA_X2 = 330;
  public static final String STA_PLAYED = "Leikir:";
  public static final String STA_HOMEWON = "Heimali� sigrar:";
  public static final String STA_DRAWN = "Jafntefli:";
  public static final String STA_AWAYWON = "�tili� sigrar:";
  public static final String STA_GOALS = "Skoru� m�rk:";
  public static final String STA_HOMEGOALS = "Heimali� skorar:";
  public static final String STA_AWAYGOALS = "�tili� skorar:";
  public static final String STA_COMMONRES = "Algengustu �rslit:";
  public static final String STA_TIMES = " skipti";
  public static final String STA_BIGHOME = "St�rsti heimasigur:";
  public static final String STA_BIGAWAY = "St�rsti �tisigur:";
  public static final String STA_MOSTGOALS = "Flest m�rk � leik:";


  //
  // Comparemode
  //
  public static final int COM_X1 = 20;
  public static final int COM_X2 = 120;
  public static final String COM_STATS = "T�lfr��i";
  public static final String COM_HA_STATS = "H/� t�lfr��i";
  public static final String COM_EARLIER = "Fyrri leikir";
  public static final String COM_HOMETEAM = "Heimali�:";
  public static final String COM_AWAYTEAM = "�tili�:";

  public static final String COM_TABLEPOS = "S�ti:";
  public static final String COM_PLAYED = "Leikir:";
  public static final String COM_WON = "Sigra�:";
  public static final String COM_DRAWN = "Jafntefli:";
  public static final String COM_LOST = "Tapa�:";
  public static final String COM_SCORED = "Skora�:";
  public static final String COM_AGAINST = "Sleppt inn:";
  public static final String COM_RESCENT = "Fimm s��ustu leikir:";
  public static final String COM_SERIES = "N�verandi lota:";
  public static final String COM_COMMONRES = "Algengustu �rslit:";

  public static final String COM_UNBEATEN =  "Ekki tapa�:       ";
  public static final String COM_NOWIN =     "�n sigurs:        ";
  public static final String COM_SER_WON =   "Sigra�:           ";
  public static final String COM_SER_DRAWN = "Jafntefli:        ";
  public static final String COM_SER_LOST =  "Tapa�:            ";
  public static final String COM_NOAGA =     "Ekki fengi� mark: ";
  public static final String COM_NOSCORE =   "Ekki skora�:      ";
  public static final String COM_MATCHES = " leikir";

}

