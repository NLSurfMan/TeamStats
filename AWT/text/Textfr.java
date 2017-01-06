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
 // French
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Chargement ";
  public static final String MAI_ERROR = "Erreur: ";
  public static final String MAI_NOMATCHFILE = "Aucuns fichiers rencontres sp�cifi�s";
  public static final String MAI_NOFINDMATCHFILE = "Fichier rencontres introuvable";
  public static final String MAI_NOFINDLEAGUEFILE = "Fichier param�tres introuvable";
  public static final String MAI_NOMATCHES = "Fichier rencontres ne contient pas de matchs";
  public static final String MAI_TABLE = "Classement";
  public static final String MAI_MATCHES = "Rencontres";
  public static final String MAI_STATS =  "Statistiques";
  public static final String MAI_COMPARE = "Comparaisons";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";

  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Rencontres:";
  public static final String TAB_ROUNDS = "Journ�es:";
  public static final String TAB_ALL1 = "Toutes";
  public static final String TAB_HOME = "Domicile";
  public static final String TAB_AWAY = "Ext�rieur";
  public static final String TAB_ALL2 = "Toutes";
  public static final String TAB_FIRST = "Premi�re";
  public static final String TAB_LAST = "Derni�re";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "�quipes:";
  public static final String MAT_MATCHES = "Rencontres:";
  public static final String MAT_RESULTS = "R�sultats:";
  public static final String MAT_ALL1 = "Toutes";
  public static final String MAT_ALL2 = "Toutes";
  public static final String MAT_HOME = "Domicile";
  public static final String MAT_AWAY = "Ext�rieur";
  public static final String MAT_ALL3 = "Tous";
  public static final String MAT_WON = "Victoires";
  public static final String MAT_DRAWN = "Matchs nuls";
  public static final String MAT_LOST = "D�faites";
  public static final String MAT_HOMELET = "D";
  public static final String MAT_AWAYLET = "E";


  //
  // Statsmode
  //
  public static final int STA_X1=175;
  public static final int STA_X2=355;
  public static final String STA_PLAYED = "Rencontres disput�es:";
  public static final String STA_HOMEWON = "Victoires � domicile:";
  public static final String STA_DRAWN = "Matchs nuls:";
  public static final String STA_AWAYWON = "Victoires � l'ext�rieure:";
  public static final String STA_GOALS = "Buts marqu�s:";
  public static final String STA_HOMEGOALS = "Buts � l'ext�rieur:";
  public static final String STA_AWAYGOALS = "Buts � domicile:";
  public static final String STA_COMMONRES = "R�sultat les plus fr�quents:";
  public static final String STA_TIMES = " fois";
  public static final String STA_BIGHOME = "La plus belle victoire � domicile:";
  public static final String STA_BIGAWAY = "La plus belle victoire � l'ext�rieure:";
  public static final String STA_MOSTGOALS = "La rencontre la plus riche en but:";


  //
  // Comparemode
  //
  public static final int COM_X1=15;
  public static final int COM_X2=150;
  public static final String COM_STATS = "Statistiques";
  public static final String COM_HA_STATS = "Statistiques domicile/ext�rieur";
  public static final String COM_EARLIER = "Pr�c�dentes rencontres";
  public static final String COM_HOMETEAM = "�quipe locale:";
  public static final String COM_AWAYTEAM = "Visiteur:";

  public static final String COM_TABLEPOS = "Classement:";
  public static final String COM_PLAYED = "Rencontres disput�es:";
  public static final String COM_WON = "Victoires:";
  public static final String COM_DRAWN = "Matchs nuls:";
  public static final String COM_LOST = "D�faites:";
  public static final String COM_SCORED = "Buts marqu�s:";
  public static final String COM_AGAINST = "Buts encaiss�s:";
  public static final String COM_RESCENT = "Cinq derni�res rencontres:";
  public static final String COM_SERIES = "S�ries de rencontres:";
  public static final String COM_COMMONRES = "R�sultat le plus fr�quent:";

  public static final String COM_UNBEATEN= "Invaincu:         ";
  public static final String COM_NOWIN=    "Sans victoire:    ";
  public static final String COM_SER_WON=  "Gagn�es:          ";
  public static final String COM_SER_DRAWN="Matchs nuls:      ";
  public static final String COM_SER_LOST= "Perdues:          ";
  public static final String COM_NOAGA=    "Sans buts marqu�s:";
  public static final String COM_NOSCORE=  "Sans buts marqu�s:";
  public static final String COM_MATCHES=" Rencontres";


}