/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: CompareStats.java
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

import java.awt.*;


/**
 * Class: CompareStats
 */
class CompareStats {
    protected League league_;
    protected Table table_;
    protected Results res_;
    protected MatchSeries series_;
    protected int team_;
    protected boolean home_, away_;
    protected int latest_[];


    // construct
    public CompareStats(League l, int team, boolean home, boolean away) {
        league_ = l;
        team_ = team;
        home_ = home;
        away_ = away;
        latest_ = new int[5];
        for (int a = 0; a < 5; a++) {
            latest_[a] = -1;
        }
        table_ = new Table(league_, home_, away_, true, -1);
        res_ = new Results(league_, team_);
        series_ = new MatchSeries(team_);
    }

    // computes the statistics
    public void build() {
        table_.build();
        int count = 0;
        boolean cont = true;
        for (int a = league_.getNumMatches() - 1; a >= 0; a--) {
            Match m;
            try {
                m = league_.getMatch(a);
            }
            catch (RuntimeException e) {
                continue;
            }
            if ((home_ && m.getHomeId() == team_) || (away_ && m.getAwayId() == team_)) {
                if (count < 5) {
                    latest_[count++] = a;
                }
                if (cont) {
                    cont = series_.addMatch(m);
                }
                res_.addMatch(m);
            }
        }
    }

    // shows the statistics
    public void show(Graphics g, Color primCol, Color secCol, int x, int ys) {
        java.awt.FontMetrics fm = g.getFontMetrics();
        int height = 15 - 1; //fm.getAscent()+fm.getDescent()-1;
        int x1 = x + Text.COM_X1;
        int x2 = x1 + Text.COM_X2;
        int gap = (height / 2) - 2;
        int y;
        TableTeam t = table_.getTableTeam(team_);
        //int played=t.Played;

        g.setColor(secCol);
        y = ys;
        g.drawString(Text.COM_TABLEPOS, x1, y += height);
        g.drawString(Text.COM_PLAYED, x1, y += (height + gap));
        g.drawString(Text.COM_WON, x1, y += height);
        if (!league_.isHideDraws()) {
            g.drawString(Text.COM_DRAWN, x1, y += height);
        }
        g.drawString(Text.COM_LOST, x1, y += height);
        g.drawString(Text.COM_SCORED, x1, y += (height + gap));
        g.drawString(Text.COM_AGAINST, x1, y += height);

        g.drawString(Text.COM_RESCENT, x1, y += (height + gap));
        g.drawString(Text.COM_SERIES, x1, y += (6 * height + gap));
        g.drawString(Text.COM_COMMONRES, x1, y += (6 * height + gap));

        g.setColor(primCol);
        y = ys;
        int w1 = Integer.toString(t.getFor()).length();
        int w2 = Integer.toString(t.getAgainst()).length();
        int w = (w1 > w2) ? w1 : w2;
        if (w < 3) {
            w = 3;
        }

        g.drawString(Misc.rightString(t.getPos(), w, ' '), x2, y += height);
        g.drawString(Misc.rightString(t.getPlayed(), w, ' '), x2, y += height + gap);
        g.drawString(Misc.rightString(t.getWon(), w, ' ') + " (" +
                             Misc.rightString(t.getWonProc(), 3, ' ') + "%)", x2, y += height);
        if (!league_.isHideDraws()) {
            g.drawString(Misc.rightString(t.getDrawn(), w, ' ') + " (" +
                                 Misc.rightString(t.getDrawnProc(), 3, ' ') + "%)", x2, y += height);
        }
        g.drawString(Misc.rightString(t.getLost(), w, ' ') + " (" +
                             Misc.rightString(t.getLostProc(), 3, ' ') + "%)", x2, y += height);

        float avg = t.getAgaAvg();
        int dec = 2;
        if (avg >= 10) {
            dec = 1;
        }
        if (avg >= 100) {
            dec = 0;
        }
        g.drawString(Misc.rightString(t.getFor(), w, ' ') + " (" +
                             Misc.floatToString(t.getForAvg(), dec) + ")", x2, y += height + gap);
        g.drawString(Misc.rightString(t.getAgainst(), w, ' ') + " (" +
                             Misc.floatToString(t.getAgaAvg(), dec) + ")", x2, y += height);

        y += height + gap;
        for (int a = 0; a < 5; a++) {
            try {
                g.drawString(league_.getMatch(latest_[a]).shortString(team_), x1, y += height);
            }
            catch (RuntimeException e) {
                y += height;
            }
        }

        y += height + gap;
        int yt = y;
        int tmp;
        int unbeat = series_.getUnbeaten(), nowin = series_.getNoWin(),
                won = series_.getWon(), drawn = series_.getDrawn(), lost = series_.getLost();
        if (unbeat > 2 && unbeat != won && unbeat != drawn) {
            g.drawString(Text.COM_UNBEATEN + unbeat + Text.COM_MATCHES, x1, yt += height);
        }
        if (nowin > 2 && nowin != lost && nowin != drawn) {
            g.drawString(Text.COM_NOWIN + nowin + Text.COM_MATCHES, x1, yt += height);
        }
        if (won > 2) {
            g.drawString(Text.COM_SER_WON + won + Text.COM_MATCHES, x1, yt += height);
        }
        if (drawn > 2) {
            g.drawString(Text.COM_SER_DRAWN + drawn + Text.COM_MATCHES, x1, yt += height);
        }
        if (lost > 2) {
            g.drawString(Text.COM_SER_LOST + lost + Text.COM_MATCHES, x1, yt += height);
        }
        if ((tmp = series_.getNoAga()) > 2) {
            g.drawString(Text.COM_NOAGA + tmp + Text.COM_MATCHES, x1, yt += height);
        }
        if ((tmp = series_.getNoFwd()) > 2) {
            g.drawString(Text.COM_NOSCORE + tmp + Text.COM_MATCHES, x1, yt += height);
        }

        y += 6 * height + gap;
        //    y+=height+gap;
        for (int a = 0; a < 3; a++) {
            try {
                g.drawString(res_.getResult(a).getString(), x1, y += height);
            }
            catch (RuntimeException e) {
            }
        }
    }
}