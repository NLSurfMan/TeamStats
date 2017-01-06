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
 // Spanish
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING="Cargando ";
  public static final String MAI_ERROR=          "Error: ";
  public static final String MAI_NOMATCHFILE=    "Archivo de resultados no especificado";
  public static final String MAI_NOFINDMATCHFILE="Archivo de resultados no encontrado";
  public static final String MAI_NOFINDLEAGUEFILE="Archivo de torneo no encontrado (Leaguefile)";
  public static final String MAI_NOMATCHES=      "Archivo de resultados vacio";
  public static final String MAI_TABLE=          "Tabla";
  public static final String MAI_MATCHES=        "Resultados";
  public static final String MAI_STATS=          "Estadisticas";
  public static final String MAI_COMPARE=        "Comparativa";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
   // Tablemode
  //
  public static final String TAB_MATCHES=  "Partidos jugados como:";
  public static final String TAB_ROUNDS=   "Numero de partidos:";
  public static final String TAB_ALL1=     "En Total";
  public static final String TAB_HOME=     "Local";
  public static final String TAB_AWAY=     "Visitante";
  public static final String TAB_ALL2=     "Todos";
  public static final String TAB_FIRST=    "Los primeros";
  public static final String TAB_LAST=     "Los ultimos";


  //
   // Matchmode
  //
  public static final String MAT_TEAM=     "Equipo:";
  public static final String MAT_MATCHES=  "Partidos:";
  public static final String MAT_RESULTS=  "Resultados:";
  public static final String MAT_ALL1=     "Total";
  public static final String MAT_ALL2=     "Total";
  public static final String MAT_HOME=     "De local";
  public static final String MAT_AWAY=     "De visitante";
  public static final String MAT_ALL3=     "Total";
  public static final String MAT_WON=      "Ganados";
  public static final String MAT_DRAWN=    "Empatados";
  public static final String MAT_LOST=     "Perdidos";
  public static final String MAT_HOMELET=  "L";
  public static final String MAT_AWAYLET=  "V";


  //
   // Statsmode
  //
  public static final int STA_X1=180;
  public static final int STA_X2=350;
  public static final String STA_PLAYED=   "Partidos jugados:";
  public static final String STA_HOMEWON=  "Ganados por local:";
  public static final String STA_DRAWN=    "Empatados:";
  public static final String STA_AWAYWON=  "Ganados por visitante:";
  public static final String STA_GOALS=    "Goles anotados:";
  public static final String STA_HOMEGOALS="Goles de local:";
  public static final String STA_AWAYGOALS="Goles de visitante:";
  public static final String STA_COMMONRES="Resultado mas frecuente:";
  public static final String STA_TIMES=    " veces";
  public static final String STA_BIGHOME=  "Max.goleada local:";
  public static final String STA_BIGAWAY=  "Max.goleada visitante:";
  public static final String STA_MOSTGOALS="Resultado con mas goles:";


  //
   // Comparemode
  //
  public static final int COM_X1=20;
  public static final int COM_X2=120;
  public static final String COM_STATS=    "Estadisticas";
  public static final String COM_HA_STATS= "Rendimiento Local/Visitante";
  public static final String COM_EARLIER=  "Partidos previos";
  public static final String COM_HOMETEAM= "Equipo Local:";
  public static final String COM_AWAYTEAM= "Equipo Visitante:";

  public static final String COM_TABLEPOS= "Posicion:";
  public static final String COM_PLAYED=   "Partidos jugados:";
  public static final String COM_WON=      "Ganados:";
  public static final String COM_DRAWN=    "Empatados:";
  public static final String COM_LOST=     "Perdidos:";
  public static final String COM_SCORED=   "Goles a favor:";
  public static final String COM_AGAINST=  "Goles en contra:";
  public static final String COM_RESCENT=  "5 ultimos partidos:";
  public static final String COM_SERIES=   "Record actual:";
  public static final String COM_COMMONRES="Resultado mas frecuente:";

  public static final String COM_UNBEATEN= "Invicto:               ";
  public static final String COM_NOWIN=    "Sin poder ganar por:   ";
  public static final String COM_SER_WON=  "Victorias consecutivas:";
  public static final String COM_SER_DRAWN="Empates consecutivos:  ";
  public static final String COM_SER_LOST= "Derrotas consecutivas: ";
  public static final String COM_NOAGA=    "Valla invicta en:      ";
  public static final String COM_NOSCORE=  "No anota goles en:     ";
  public static final String COM_MATCHES=  " partidos";

}