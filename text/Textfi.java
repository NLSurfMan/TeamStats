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
 // Finnish
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "Ladataan ";
  public static final String MAI_ERROR = "Virhe: ";
  public static final String MAI_NOMATCHFILE = "Ottelutiedostoa ei ole määritelty";
  public static final String MAI_NOFINDMATCHFILE = "Ottelutiedostoa ei löydy";
  public static final String MAI_NOFINDLEAGUEFILE = "Parametritiedostoa ei löydy";
  public static final String MAI_NOMATCHES = "Ottelutiedosto ei sisällä yhtään ottelua";
  public static final String MAI_TABLE = "Taulukko";
  public static final String MAI_MATCHES = "Ottelut";
  public static final String MAI_STATS = "Tilastot";
  public static final String MAI_COMPARE = "Vertaa joukkueita";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "Ottelut:";
  public static final String TAB_ROUNDS = "Kierrokset:";
  public static final String TAB_ALL1 = "Kaikki";
  public static final String TAB_HOME = "Koti";
  public static final String TAB_AWAY = "Vieras";
  public static final String TAB_ALL2 = "Kaikki";
  public static final String TAB_FIRST = "Ensimmäiset";
  public static final String TAB_LAST = "Viimeiset";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "Joukkue:";
  public static final String MAT_MATCHES = "Ottelut:";
  public static final String MAT_RESULTS = "Tulokset:";
  public static final String MAT_ALL1 = "Kaikki";
  public static final String MAT_ALL2 = "Kaikki";
  public static final String MAT_HOME = "Koti";
  public static final String MAT_AWAY = "Vieras";
  public static final String MAT_ALL3 = "Kaikki";
  public static final String MAT_WON = "Voitot";
  public static final String MAT_DRAWN = "Tasapelit";
  public static final String MAT_LOST = "Häviöt";
  public static final String MAT_HOMELET = "K";
  public static final String MAT_AWAYLET = "V";


  //
  // Statsmode
  //
  public static final int STA_X1=170;
  public static final int STA_X2=360;
  public static final String STA_PLAYED = "Otteluita pelattu:";
  public static final String STA_HOMEWON = "Kotijoukkueiden voittoja:";
  public static final String STA_DRAWN = "Tasapelejä:";
  public static final String STA_AWAYWON = "Vierasjoukkueiden voittoja:";
  public static final String STA_GOALS = "Maaleja tehty:";
  public static final String STA_HOMEGOALS = "Kotijoukkueiden maalit:";
  public static final String STA_AWAYGOALS = "Vierasjoukkueiden maalit:";
  public static final String STA_COMMONRES = "Yleisin tulos:";
  public static final String STA_TIMES = " kertaa";
  public static final String STA_BIGHOME = "Suurin kotivoitto:";
  public static final String STA_BIGAWAY = "Suurin vierasvoitto:";
  public static final String STA_MOSTGOALS = "Eniten maaleja:";


  //
  // Comparemode
  //
  public static final int COM_X1=20;
  public static final int COM_X2=130;
  public static final String COM_STATS = "Tilastot";
  public static final String COM_HA_STATS = "Koti/vieras tilastot";
  public static final String COM_EARLIER = "Edelliset kohtaamiset";
  public static final String COM_HOMETEAM = "Kotijoukkue:";
  public static final String COM_AWAYTEAM = "Vierasjoukkue:";

  public static final String COM_TABLEPOS = "Sarjasijoitus:";
  public static final String COM_PLAYED = "Pelatut ottelut:";
  public static final String COM_WON = "Voitot:";
  public static final String COM_DRAWN = "Tasapelit:";
  public static final String COM_LOST = "Häviöt:";
  public static final String COM_SCORED = "Tehdyt maalit:";
  public static final String COM_AGAINST = "Päästetyt maalit:";
  public static final String COM_RESCENT = "Viisi viimeistä ottelua:";
  public static final String COM_SERIES = "Putket:";
  public static final String COM_COMMONRES = "Yleisin tulos:";

  public static final String COM_UNBEATEN = "Tappioitta:     ";
  public static final String COM_NOWIN =    "Ei voittoa:     ";
  public static final String COM_SER_WON =  "Voitot:         ";
  public static final String COM_SER_DRAWN ="Tasapelit:      ";
  public static final String COM_SER_LOST = "Tappiot:        ";
  public static final String COM_NOAGA =    "Ei päästettyjä: ";
  public static final String COM_NOSCORE =  "Ei tehtyjä:     ";
  public static final String COM_MATCHES = " ottelua";

}