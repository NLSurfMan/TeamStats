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
 // Danish
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Indlæser ";
  public static final String MAI_ERROR = "Fejl: ";
  public static final String MAI_NOMATCHFILE = "Ingen kampfil er specificeret";
  public static final String MAI_NOFINDMATCHFILE = "Kan ikke finde kampfilen";
  public static final String MAI_NOFINDLEAGUEFILE = "Kan ikke finde parameterfilen (liga filen)";
  public static final String MAI_NOMATCHES = "Kampfilen indeholder ingen kampe";
  public static final String MAI_TABLE = "Tabel";
  public static final String MAI_MATCHES = "Kampe";
  public static final String MAI_STATS = "Statistikker";
  public static final String MAI_COMPARE = "Sammenlign hold";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Kampe:";
  public static final String TAB_ROUNDS = "Runder:";
  public static final String TAB_ALL1 = "Alle";
  public static final String TAB_HOME = "Hjemme";
  public static final String TAB_AWAY = "Ude";
  public static final String TAB_ALL2 = "Alle";
  public static final String TAB_FIRST = "Første";
  public static final String TAB_LAST = "Sidste";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Hold:";
  public static final String MAT_MATCHES = "Kampe:";
  public static final String MAT_RESULTS = "Resultater:";
  public static final String MAT_ALL1 = "Alle";
  public static final String MAT_ALL2 = "Alle";
  public static final String MAT_HOME = "Hjemme";
  public static final String MAT_AWAY = "Ude";
  public static final String MAT_ALL3 = "Alle";
  public static final String MAT_WON = "Vundet";
  public static final String MAT_DRAWN = "Uafgjorte";
  public static final String MAT_LOST = "Tabte";
  public static final String MAT_HOMELET = "H";
  public static final String MAT_AWAYLET = "U";


  //
  // Statsmode
  //
  public static final int STA_X1 = 185;
  public static final int STA_X2 = 345;
  public static final String STA_PLAYED = "Kampe spillet:";
  public static final String STA_HOMEWON = "Vundet af hjemmeholdet:";
  public static final String STA_DRAWN = "Uafgjorte:";
  public static final String STA_AWAYWON = "Vundet af udeholdet:";
  public static final String STA_GOALS = "Mål scoret:";
  public static final String STA_HOMEGOALS = "Mål af hjemmeholdet:";
  public static final String STA_AWAYGOALS = "Mål af udeholdet:";
  public static final String STA_COMMONRES = "Oftest spillede resultat:";
  public static final String STA_TIMES = " gange";
  public static final String STA_BIGHOME = "Største hjemmesejr:";
  public static final String STA_BIGAWAY = "Største udesejr:";
  public static final String STA_MOSTGOALS = "Målrigeste kamp:";


  //
  // Comparemode
  //
  public static final int COM_X1 = 20;
  public static final int COM_X2 = 120;
  public static final String COM_STATS = "Statistik";
  public static final String COM_HA_STATS = "Hjemme/ude Statistik";
  public static final String COM_EARLIER = "Tidligere kampe";
  public static final String COM_HOMETEAM = "Hjemmehold:";
  public static final String COM_AWAYTEAM = "Udehold:";

  public static final String COM_TABLEPOS = "Placering:";
  public static final String COM_PLAYED = "Kampe spillede:";
  public static final String COM_WON = "Vundet:";
  public static final String COM_DRAWN = "Uafgjort:";
  public static final String COM_LOST = "Tabt:";
  public static final String COM_SCORED = "Mål for:";
  public static final String COM_AGAINST = "Mål imod:";
  public static final String COM_RESCENT = "Fem sidste kampe:";
  public static final String COM_SERIES = "Aktuelle bedrifter:";
  public static final String COM_COMMONRES = "Mest spillede resultat:";

  public static final String COM_UNBEATEN =  "Ubesejret:         ";
  public static final String COM_NOWIN =     "Ingen kampe vundet:";
  public static final String COM_SER_WON =   "Vundet:            ";
  public static final String COM_SER_DRAWN = "Uafgjorte:         ";
  public static final String COM_SER_LOST =  "Tabte:             ";
  public static final String COM_NOAGA =     "Rent bur:          ";
  public static final String COM_NOSCORE =   "Ingen mål scoret i:";
  public static final String COM_MATCHES = " Kampe";

}
