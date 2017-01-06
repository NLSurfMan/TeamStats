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
 // Portugese
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING="Carregando ";
  public static final String MAI_ERROR="Erro:";
  public static final String MAI_NOMATCHFILE="Arquivo de jogo nao especificado";
  public static final String MAI_NOFINDMATCHFILE="Arquivo de jogos nao encontrado";
  public static final String MAI_NOFINDLEAGUEFILE="Arquivo da liga nao achado (Leaguefile)";
  public static final String MAI_NOMATCHES="Arq.de jogos nao contem partidas";
  public static final String MAI_TABLE="Tabela";
  public static final String MAI_MATCHES="Jogos";
  public static final String MAI_STATS="Statisticas";
  public static final String MAI_COMPARE="Compare Times";
  public static final String MAI_HOMEURL="http://www.mbovin.com/ts/";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES="Jogos:";
  public static final String TAB_ROUNDS="Rodada:";
  public static final String TAB_ALL1="Todos";
  public static final String TAB_HOME="Casa";
  public static final String TAB_AWAY="Fora";
  public static final String TAB_ALL2="Todos";
  public static final String TAB_FIRST="Primeiro";
  public static final String TAB_LAST="Ultimo";


  //
  // Matchmode
  //
  public static final String MAT_TEAM="Times:";
  public static final String MAT_MATCHES="Jogos:";
  public static final String MAT_RESULTS="Resultados:";
  public static final String MAT_ALL1="Todos";
  public static final String MAT_ALL2="Todos";
  public static final String MAT_HOME="Casa";
  public static final String MAT_AWAY="Fora";
  public static final String MAT_ALL3="Todos";
  public static final String MAT_WON="Vitoria";
  public static final String MAT_DRAWN="Empate";
  public static final String MAT_LOST="Derrota";
  public static final String MAT_HOMELET="C";
  public static final String MAT_AWAYLET="F";


  //
  // Statsmode
  //
  public static final int STA_X1=180;
  public static final int STA_X2=350;
  public static final String STA_PLAYED="Jogos disputados:";
  public static final String STA_HOMEWON="Vitorias da casa:";
  public static final String STA_DRAWN="Empates:";
  public static final String STA_AWAYWON="Vitoria dos visitantes:";
  public static final String STA_GOALS="Gols Marcados:";
  public static final String STA_HOMEGOALS="Gols de Casa:";
  public static final String STA_AWAYGOALS="Gols do Visitante:";
  public static final String STA_COMMONRES="Resultados mais frequentes:";
  public static final String STA_TIMES=" Vezes";
  public static final String STA_BIGHOME="Maiores Goleadas em Casa:";
  public static final String STA_BIGAWAY="Maiores Goleadas fora de Casa:";
  public static final String STA_MOSTGOALS="Mais gols:";


  //
  // Comparemode
  //
  public static final int COM_X1=15;
  public static final int COM_X2=130;
  public static final String COM_STATS="Statisticas";
  public static final String COM_HA_STATS="Casa/Fora Stats.";
  public static final String COM_EARLIER="Jogos anteriores";
  public static final String COM_HOMETEAM="Dono da Casa:";
  public static final String COM_AWAYTEAM="Visitantes:";

  public static final String COM_TABLEPOS="Posiçao na tabela:";
  public static final String COM_PLAYED="Jogos Disputados:";
  public static final String COM_WON="Vitorias:";
  public static final String COM_DRAWN="Empates:";
  public static final String COM_LOST="Derrotas:";
  public static final String COM_SCORED="Gols Marcados:";
  public static final String COM_AGAINST="Gols Sofridos:";
  public static final String COM_RESCENT="Ultimos cinco Jogos:";
  public static final String COM_SERIES="Recorde Atual:";
  public static final String COM_COMMONRES="Resultado mais frequente:";

  public static final String COM_UNBEATEN= "Invencibilidade:";
  public static final String COM_NOWIN=    "Sem vencer:     ";
  public static final String COM_SER_WON=  "Vitorias:       ";
  public static final String COM_SER_DRAWN="Empates:        ";
  public static final String COM_SER_LOST= "Derrotas:       ";
  public static final String COM_NOAGA=    "Sem tomar gols: ";
  public static final String COM_NOSCORE=  "Sem marcar gols:";
  public static final String COM_MATCHES=" Jogos";

}