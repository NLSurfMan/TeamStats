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
 // Catalan
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Carregant ";
  public static final String MAI_ERROR = "Error: ";
  public static final String MAI_NOMATCHFILE = "Arxiu de dades no especificat";
  public static final String MAI_NOFINDMATCHFILE = "Arxiu de resultats no trobat";
  public static final String MAI_NOFINDLEAGUEFILE = "Arxiu de torneig no trobat(Leaguefile)";
  public static final String MAI_NOMATCHES = "Arxiu de resultats buit";
  public static final String MAI_TABLE = "Taula";
  public static final String MAI_MATCHES = "Resultats";
  public static final String MAI_STATS = "Estadístiques";
  public static final String MAI_COMPARE = "Comparatives";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Partits jugats com a:";
  public static final String TAB_ROUNDS = "Numero de partits:";
  public static final String TAB_ALL1 = "En total";
  public static final String TAB_HOME = "Local";
  public static final String TAB_AWAY = "Visitant";
  public static final String TAB_ALL2 = "Tots";
  public static final String TAB_FIRST = "Els primers";
  public static final String TAB_LAST = "Els ultims";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Equip:";
  public static final String MAT_MATCHES = "Partits:";
  public static final String MAT_RESULTS = "Resultats:";
  public static final String MAT_ALL1 = "Total";
  public static final String MAT_ALL2 = "Total";
  public static final String MAT_HOME = "Com a Local";
  public static final String MAT_AWAY = "Com a Visitant";
  public static final String MAT_ALL3 = "Total";
  public static final String MAT_WON = "Guanyats";
  public static final String MAT_DRAWN = "Empatats";
  public static final String MAT_LOST = "Perduts";
  public static final String MAT_HOMELET = "L";
  public static final String MAT_AWAYLET = "V";


  //
  // Statsmode
  //
  public static final int STA_X1=180;
  public static final int STA_X2=350;
  public static final String STA_PLAYED = "Partits jugats:";
  public static final String STA_HOMEWON = "Guanyats pel Local:";
  public static final String STA_DRAWN = "Empatats:";
  public static final String STA_AWAYWON = "Guanyats pel Visitant:";
  public static final String STA_GOALS = "Gols Marcats:";
  public static final String STA_HOMEGOALS = "Gols com a Local:";
  public static final String STA_AWAYGOALS = "Gols com a Visitant:";
  public static final String STA_COMMONRES = "Resultat més frequent:";
  public static final String STA_TIMES = " vegades";
  public static final String STA_BIGHOME = "Màxima golejada local:";
  public static final String STA_BIGAWAY = "Màxima golejada visitant:";
  public static final String STA_MOSTGOALS = "Resultat amb més gols:";


  //
  // Comparemode
  //
  public static final int COM_X1=20;
  public static final int COM_X2=120;
  public static final String COM_STATS = "Estadístiques";
  public static final String COM_HA_STATS = "Rendiment Local/Visitant";
  public static final String COM_EARLIER = "Partits previs";
  public static final String COM_HOMETEAM = "Equip Local:";
  public static final String COM_AWAYTEAM = "Equip Visitant:";

  public static final String COM_TABLEPOS = "Posició:";
  public static final String COM_PLAYED = "Partits Jugats:";
  public static final String COM_WON = "Guanyats:";
  public static final String COM_DRAWN = "Empatats:";
  public static final String COM_LOST = "Perduts:";
  public static final String COM_SCORED = "Gols a Favor:";
  public static final String COM_AGAINST = "Gols en Contra:";
  public static final String COM_RESCENT = "Ultims 5 partits:";
  public static final String COM_SERIES = "Record actual:";
  public static final String COM_COMMONRES = "Resultats més frequents:";

  public static final String COM_UNBEATEN =  "Invicte:                ";
  public static final String COM_NOWIN =     "Sense guanyar durant:   ";
  public static final String COM_SER_WON =   "Victories consecutives: ";
  public static final String COM_SER_DRAWN = "Empats consecutius:     ";
  public static final String COM_SER_LOST =  "Derrotes consecutives:  ";
  public static final String COM_NOAGA =     "Sense encaixar gols en: ";
  public static final String COM_NOSCORE =   "Sense marcar gols en:   ";
  public static final String COM_MATCHES = " partits";

}
