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
 * Constant textstrings in different languages
 */
class Text {

  private Text() {}

 ///////////
 // Greek
 ///////////

  //
  // Main
  //
  public static final String MAI_LOADING = "������� ";
  public static final String MAI_ERROR = "�����: ";
  public static final String MAI_NOMATCHFILE = "��� ������� ������ ������";
  public static final String MAI_NOFINDMATCHFILE = "��� ��������� ������ ������";
  public static final String MAI_NOFINDLEAGUEFILE = "��� ����� �� ��� �� ������ ���������� ";
  public static final String MAI_NOMATCHES = "�� ������ ��� �������� ������ ";
  public static final String MAI_TABLE = "�������";
  public static final String MAI_MATCHES = "������";
  public static final String MAI_STATS = "����������";
  public static final String MAI_COMPARE = "�������� ������";
  public static final String MAI_HOMEURL = "http://www.dsv.su.se/~mats-bov/ts";


  //
  // Tablemode
  //
  public static final String TAB_MATCHES = "������:";
  public static final String TAB_ROUNDS = "�����:";
  public static final String TAB_ALL1 = "���";
  public static final String TAB_HOME = "����� �����"; /* (if not enough space "�����") */
  public static final String TAB_AWAY = "����� �����"; /* (if not enough space "�����") */
  public static final String TAB_ALL2 = "���";
  public static final String TAB_FIRST = "������";
  public static final String TAB_LAST = "����������";


  //
  // Matchmode
  //
  public static final String MAT_TEAM = "�����:";
  public static final String MAT_MATCHES = "������:";
  public static final String MAT_RESULTS = "������������:";
  public static final String MAT_ALL1 = "���";
  public static final String MAT_ALL2 = "���";
  public static final String MAT_HOME = "����� �����"; /* ("�����") */
  public static final String MAT_AWAY = "����� �����"; /* ("�����") */
  public static final String MAT_ALL3 = "���";
  public static final String MAT_WON = "�����";
  public static final String MAT_DRAWN = "���������";
  public static final String MAT_LOST = "�����";
  public static final String MAT_HOMELET = "�"; /* ("��") */
  public static final String MAT_AWAYLET = "�"; /* ("��") */


  //
  // Statsmode
  //
  public static final int STA_X1 = 180;
  public static final int STA_X2 = 360;
  public static final String STA_PLAYED = "������ ��� ����� �������:";
  public static final String STA_HOMEWON = "����� ����������:";
  public static final String STA_DRAWN = "���������:";
  public static final String STA_AWAYWON = "����� ��������������:";
  public static final String STA_GOALS = "����:";
  public static final String STA_HOMEGOALS = "���� ����������:";
  public static final String STA_AWAYGOALS = "���� ��������������:";
  public static final String STA_COMMONRES = "��� ����� ����������:";
  public static final String STA_TIMES = " �����";
  public static final String STA_BIGHOME = "���������� ����� ����� ����:";
  public static final String STA_BIGAWAY = "���������� ����� ����� ����:";
  public static final String STA_MOSTGOALS = "����������� ����:";


  //
  // Comparemode
  //
  public static final int COM_X1 = 15;
  public static final int COM_X2 = 150;
  public static final String COM_STATS = "����������";
  public static final String COM_HA_STATS = "�����/����� ����������";
  public static final String COM_EARLIER = "����������� ���������";
  public static final String COM_HOMETEAM = "����������:";
  public static final String COM_AWAYTEAM = "��������������:";

  public static final String COM_TABLEPOS = "����:";
  public static final String COM_PLAYED = "������ ��� ���������:";
  public static final String COM_WON = "�����:";
  public static final String COM_DRAWN = "���������:";
  public static final String COM_LOST = "�����:";
  public static final String COM_SCORED = "���� ����:";
  public static final String COM_AGAINST = "���� ����:";
  public static final String COM_RESCENT = "5 ��������� ���������:";
  public static final String COM_SERIES = "���� ���������:";
  public static final String COM_COMMONRES = "��� ����� ����������:";

  public static final String COM_UNBEATEN =  "����� ����:        ";
  public static final String COM_NOWIN =     "����� ����:        ";
  public static final String COM_SER_WON =   "�����:             ";
  public static final String COM_SER_DRAWN = "���������:         ";
  public static final String COM_SER_LOST =  "�����:             ";
  public static final String COM_NOAGA =     "����������� �����: ";
  public static final String COM_NOSCORE =   "����� ���� ����:   ";
  public static final String COM_MATCHES = " ������";


}

