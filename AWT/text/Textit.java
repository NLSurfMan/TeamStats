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
 // Italian
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Caricamento dati ";
  public static final String MAI_ERROR = "Errore: ";
  public static final String MAI_NOMATCHFILE = "Non è stato specificato il file-partite";
  public static final String MAI_NOFINDMATCHFILE = "Impossibile trovare il file-partite";
  public static final String MAI_NOFINDLEAGUEFILE = "Impossibile trovare il file-parametri";
  public static final String MAI_NOMATCHES = "Il file-partite è vuoto";
  public static final String MAI_TABLE = "Classifica";
  public static final String MAI_MATCHES = "Partite";
  public static final String MAI_STATS = "Statistiche";
  public static final String MAI_COMPARE = "Confronti";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";

  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Partite:";
  public static final String TAB_ROUNDS = "Giornate:";
  public static final String TAB_ALL1 = "Tutte";
  public static final String TAB_HOME = "In casa";
  public static final String TAB_AWAY = "In trasf.";
  public static final String TAB_ALL2 = "Tutte";
  public static final String TAB_FIRST = "Prime";
  public static final String TAB_LAST = "Ultime";

  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Squadra:";
  public static final String MAT_MATCHES = "Partite:";
  public static final String MAT_RESULTS = "Risultati:";
  public static final String MAT_ALL1 = "Tutte";
  public static final String MAT_ALL2 = "Tutte";
  public static final String MAT_HOME = "In casa";
  public static final String MAT_AWAY = "In trasf.";
  public static final String MAT_ALL3 = "Tutti";
  public static final String MAT_WON = "Vittorie";
  public static final String MAT_DRAWN = "Pareggi";
  public static final String MAT_LOST = "Sconfitte";
  public static final String MAT_HOMELET = "C";
  public static final String MAT_AWAYLET = "T";

  //
  // Statsmode
  //
  public static final int STA_X1 = 200;
  public static final int STA_X2 = 330;
  public static final String STA_PLAYED = "Partite giocate:";
  public static final String STA_HOMEWON = "Vittorie interne:"; // "1:"
  public static final String STA_DRAWN = "Pareggi:"; // "X:"
  public static final String STA_AWAYWON = "Vittorie esterne:"; // "2:"
  public static final String STA_GOALS = "Reti segnate:";
  public static final String STA_HOMEGOALS = "Reti locali:";
  public static final String STA_AWAYGOALS = "Reti ospiti:";
  public static final String STA_COMMONRES = "Risultati più frequenti:";
  public static final String STA_TIMES = " volte";
  public static final String STA_BIGHOME = "Miglior vittoria interna:";
  public static final String STA_BIGAWAY = "Miglior vittoria esterna:";
  public static final String STA_MOSTGOALS = "Maggior numero di reti:";

  //
  // Comparemode
  //
  public static final int COM_X1 = 20;
  public static final int COM_X2 = 120;
  public static final String COM_STATS = "Statistiche";
  public static final String COM_HA_STATS = "Stat. casa/trasf.";
  public static final String COM_EARLIER = "Partite precedenti";
  public static final String COM_HOMETEAM = "Sq. locale:";
  public static final String COM_AWAYTEAM = "Sq. ospite:";

  public static final String COM_TABLEPOS = "In classifica:";
  public static final String COM_PLAYED = "Giocate:";
  public static final String COM_WON = "Vinte:";
  public static final String COM_DRAWN = "Pareggiate:";
  public static final String COM_LOST = "Perse:";
  public static final String COM_SCORED = "Reti segnate:";
  public static final String COM_AGAINST = "Reti subite:";
  public static final String COM_RESCENT = "Ultime 5 partite:";
  public static final String COM_SERIES = "Serie:";
  public static final String COM_COMMONRES = "Risultato più frequente:";

  public static final String COM_UNBEATEN =  "Imbattibilità:    ";
  public static final String COM_NOWIN =     "Senza vincere:    ";
  public static final String COM_SER_WON =   "Vittorie:         ";
  public static final String COM_SER_DRAWN = "Pareggi:          ";
  public static final String COM_SER_LOST =  "Sconfitte:        ";
  public static final String COM_NOAGA =     "Senza subire reti:";
  public static final String COM_NOSCORE =   "Senza segnare:    ";
  public static final String COM_MATCHES = " partite";

}
