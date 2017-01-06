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
  public static final String MAI_LOADING = "T�lt�dik ";
  public static final String MAI_ERROR = "Hiba: ";
  public static final String MAI_NOMATCHFILE = "Hi�nyzik a Matchfile";
  public static final String MAI_NOFINDMATCHFILE = "Nem tal�lom a Matchfile-t";
  public static final String MAI_NOFINDLEAGUEFILE = "Nem tal�lom a Leaguefile-t";
  public static final String MAI_NOMATCHES = "A Matchfile nem tartalmaz eredm�nyeket";
  public static final String MAI_TABLE = "Tabella";
  public static final String MAI_MATCHES = "M�rk�z�sek";
  public static final String MAI_STATS = "Statisztika";
  public static final String MAI_COMPARE = "Csapatok";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Table mode
  //
  public static final String TAB_MATCHES = "M�rk�z�sek:";
  public static final String TAB_ROUNDS = "Fordul�k:";
  public static final String TAB_ALL1 = "�sszes";
  public static final String TAB_HOME = "Hazai";
  public static final String TAB_AWAY = "Idegenbeli";
  public static final String TAB_ALL2 = "�sszes";
  public static final String TAB_FIRST = "Els�";
  public static final String TAB_LAST = "Utols�";


  //
  // Match mode
  //
  public static final String MAT_TEAM = "Csapat:";
  public static final String MAT_MATCHES = "M�rk�z�sek:";
  public static final String MAT_RESULTS = "Eredm�nyek:";
  public static final String MAT_ALL1 = "�sszes";
  public static final String MAT_ALL2 = "�sszes";
  public static final String MAT_HOME = "Hazai";
  public static final String MAT_AWAY = "Idegenbeli";
  public static final String MAT_ALL3 = "�sszes";
  public static final String MAT_WON = "Gy�zelem";
  public static final String MAT_DRAWN = "D�ntetlen";
  public static final String MAT_LOST = "Veres�g";
  public static final String MAT_HOMELET = "O";
  public static final String MAT_AWAYLET = "I";


  //
  // Stats mode
  //
  public static final int STA_X1=200;
  public static final int STA_X2=330;
  public static final String STA_PLAYED = "M�rk�z�sek sz�ma:";
  public static final String STA_HOMEWON = "Hazai gy�zelem:";
  public static final String STA_DRAWN = "D�ntetlen:";
  public static final String STA_AWAYWON = "Vend�g gy�zelem:";
  public static final String STA_GOALS = "�sszes g�l:";
  public static final String STA_HOMEGOALS = "Hazai g�lok:";
  public static final String STA_AWAYGOALS = "Vend�g g�lok:";
  public static final String STA_COMMONRES = "Leggyakoribb eredm�ny:";
  public static final String STA_TIMES = " alkalommal";
  public static final String STA_BIGHOME = "Legnagyobb hazai gy�zelem:";
  public static final String STA_BIGAWAY = "Legnagyobb vend�g gy�zelem:";
  public static final String STA_MOSTGOALS = "Legt�bb g�l:";


  //
  // Compare mode
  //
  public static final int COM_X1=20;
  public static final int COM_X2=120;
  public static final String COM_STATS = "Statisztika";
  public static final String COM_HA_STATS = "Hazai/vend�g";
  public static final String COM_EARLIER = "El�z� m�rk�z�sek";
  public static final String COM_HOMETEAM = "Hazai csapat:";
  public static final String COM_AWAYTEAM = "Vend�g csapat:";

  public static final String COM_TABLEPOS = "Helyez�s:";
  public static final String COM_PLAYED = "M�rk�z�sek sz�ma:";
  public static final String COM_WON = "Gy�zelem:";
  public static final String COM_DRAWN = "D�ntetlen:";
  public static final String COM_LOST = "Veres�g:";
  public static final String COM_SCORED = "L�tt g�lok:";
  public static final String COM_AGAINST = "Kapott g�lok:";
  public static final String COM_RESCENT = "Utols� m�rk�z�sek:";
  public static final String COM_SERIES = "Aktu�lis forma:";
  public static final String COM_COMMONRES = "Leggyakoribb eredm�ny";

  public static final String COM_UNBEATEN =  "Veretlen:         ";
  public static final String COM_NOWIN =     "Nyeretlen:        ";
  public static final String COM_SER_WON =   "Gy�zelem:         ";
  public static final String COM_SER_DRAWN = "D�ntetlen:        ";
  public static final String COM_SER_LOST =  "Veres�g:          ";
  public static final String COM_NOAGA =     "Kapott g�l n�lk�l:";
  public static final String COM_NOSCORE =   "R�gott g�l n�lk�l:";
  public static final String COM_MATCHES = " m�rk�z�s";

}
