/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: TablePanel.java
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
 * Class: TablePanel
 */
public class TablePanel extends TSPanel {
    protected Table table_;

    protected Panel toolBar_ = new Panel();
    protected Choice placeCh_ = new Choice();
    protected Choice matchCh_ = new Choice();
    protected TextField numEd_ = new TextField("5", 3);


    /**
     * Construct
     */
    public TablePanel(Color prim, Color sec, Color fore, Color back) {
        super(prim, sec, fore, back);

        placeCh_.addItem(Text.TAB_ALL1);
        placeCh_.addItem(Text.TAB_HOME);
        placeCh_.addItem(Text.TAB_AWAY);
        placeCh_.setForeground(foreCol_);
        placeCh_.setBackground(backCol_);

        matchCh_.addItem(Text.TAB_ALL2);
        matchCh_.addItem(Text.TAB_FIRST);
        matchCh_.addItem(Text.TAB_LAST);
        matchCh_.setForeground(foreCol_);
        matchCh_.setBackground(backCol_);

        numEd_.disable();
        numEd_.setForeground(foreCol_);
        numEd_.setBackground(backCol_);

        Label tempLab;
        tempLab = new Label(Text.TAB_MATCHES, Label.LEFT);
        tempLab.setForeground(foreCol_);
        toolBar_.add(tempLab);
        toolBar_.add(placeCh_);
        tempLab = new Label(Text.TAB_ROUNDS, Label.LEFT);
        tempLab.setForeground(foreCol_);
        toolBar_.add(tempLab);
        toolBar_.add(matchCh_);
        toolBar_.add(numEd_);

        setLayout(new BorderLayout());
        add("North", toolBar_);
    }

    /**
     * Eventhandler
     */
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice || evt.target instanceof TextField) {
            handleOptions();
            repaint();
            return true;
        }
        return false;
    }

    /**
     * Gets options
     */
    public void getOptions(java.util.Hashtable opt) {
        opt.put("tab_place", new Integer(placeCh_.getSelectedIndex()));
        opt.put("tab_match", new Integer(matchCh_.getSelectedIndex()));
        int st;
        try {
            st = Integer.parseInt(numEd_.getText());
        }
        catch (NumberFormatException e) {
            st = -1;
        }
        opt.put("tab_num", new Integer(st));
    }

    /**
     * Handles options
     */
    protected void handleOptions() {
        boolean ho = true, aw = true, fi = true;
        int st = -1;
        if (Text.TAB_HOME.equals(placeCh_.getSelectedItem())) {
            aw = false;
        }
        if (Text.TAB_AWAY.equals(placeCh_.getSelectedItem())) {
            ho = false;
        }
        if (Text.TAB_ALL1.equals(matchCh_.getSelectedItem())) {
            numEd_.disable();
        }
        if (Text.TAB_FIRST.equals(matchCh_.getSelectedItem())) {
            numEd_.enable();
            try {
                st = Integer.parseInt(numEd_.getText());
            }
            catch (NumberFormatException e) {
                st = -1;
            }
        }
        if (Text.TAB_LAST.equals(matchCh_.getSelectedItem())) {
            numEd_.enable();
            fi = false;
            try {
                st = Integer.parseInt(numEd_.getText());
            }
            catch (NumberFormatException e) {
                st = -1;
            }
        }

        table_ = new Table(league_, ho, aw, fi, st);
        table_.build();
    }

    /**
     * Paints the table
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(TeamStats.MAINFONT);
        int h = toolBar_.size().height;
        if (h < 25) {
            h = 34; // Netscape bugfix?
        }
        table_.show(g, primCol_, secCol_, size().width, h);
    }

    /**
     * Sets options
     */
    public void setOptions(java.util.Hashtable opt) {
        League newL = (League) opt.get("league");

        if (newL != league_) {
            league_ = newL;
        }

        int place = ((Integer) opt.get("tab_place")).intValue();
        int match = ((Integer) opt.get("tab_match")).intValue();
        int num = ((Integer) opt.get("tab_num")).intValue();
        try {
            placeCh_.select(place);
        }
        catch (IllegalArgumentException e) {
        }
        try {
            matchCh_.select(match);
        }
        catch (IllegalArgumentException e) {
        }
        if (num > -1) {
            numEd_.setText(Integer.toString(num));
        }

        // NN 3 for UNIX bugfix start here
        placeCh_.resize(placeCh_.size().width + 1, placeCh_.size().height);
        placeCh_.resize(placeCh_.size().width - 1, placeCh_.size().height);
        matchCh_.resize(matchCh_.size().width + 1, matchCh_.size().height);
        matchCh_.resize(matchCh_.size().width - 1, matchCh_.size().height);
        // end bugfix

        handleOptions();
    }
}