/*
 * UI-package
 * Copyright (c) 1998 Mats Bovin. All rights reserved.
 *
 * File: ModePanel.java
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

package embe.ui;

import java.awt.*;
import java.util.Hashtable;


/**
 * This class, together with ModeButton, works like
 * a "tabbed notebook". This class uses a CardLayout to
 * display different Panels. Every Panel is represented by
 * a ModeButton. All the ModeButtons form a toolbar which
 * can be placed along any border. When a button is
 * clicked the corresponding Panel will be shown and the
 * button will be activated.
 *
 * @author Mats Bovin
 * @version 1.1 july-98
 * @see embe.ui.ModeButton
 * @see java.awt.CardLayout
 */
public class ModePanel extends java.awt.Panel {

    /**
     * Constant for placing the buttons along the top border
     */
    public static final int TOP = 0;
    /**
     * Constant for placing the buttons along the bottom border
     */
    public static final int BOTTOM = 1;
    /**
     * Constant for placing the buttons along the left border
     */
    public static final int LEFT = 2;
    /**
     * Constant for placing the buttons along the right border
     */
    public static final int RIGHT = 3;

    /**
     * Color of button
     */
    protected Color btnCol_ = Color.lightGray;
    /**
     * Color of buttontext
     */
    protected Color btnTxtCol_ = Color.black;
    /**
     * Color of selected button
     */
    protected Color selectedCol_ = Color.red;
    /**
     * Width of rectangle around selected btn
     */
    protected int rectWidth_;

    /**
     * The 'toolbar' with buttons
     */
    protected Panel btnBar_ = new Panel();
    /**
     * The selected button
     */
    protected ModeButton selectedBtn_ = null;
    /**
     * The panel containing the other panels
     */
    protected Panel mainPanel_ = new Panel();
    /**
     * A hashtable containing all the panels (or modes)
     */
    protected Hashtable modes_ = new Hashtable(4);


    /**
     * Constructs a new ModePanel.
     * The buttons will be placed along the top.
     */
    public ModePanel() {
        this(TOP, 3);
    }

    /**
     * Constructs a new ModePanel. The <TT>pos</TT> argument must be
     * either of <TT>ModePanel.TOP</TT>, <TT>ModePanel.BOTTOM</TT>,
     * <TT>ModePanel.LEFT</TT> or <TT>ModePanel.RIGHT</TT>.
     *
     * @param pos the position of the buttons.
     */
    public ModePanel(int pos) {
        this(pos, 3);
    }

    /**
     * Constructs a new ModePanel. The <TT>pos</TT> argument must be
     * either of <TT>ModePanel.TOP</TT>, <TT>ModePanel.BOTTOM</TT>,
     * <TT>ModePanel.LEFT</TT> or <TT>ModePanel.RIGHT</TT>.
     *
     * @param pos       the position of the buttons.
     * @param rectWidth width of rectangle around selected button.
     */
    public ModePanel(int pos, int rectWidth) {
        int rows = 0, cols = 0, hgap = 0, vgap = 0;
        String posStr;
        switch (pos) {
            case TOP:
                posStr = "North";
                rows = 1;
                hgap = 3;
                break;
            case BOTTOM:
                posStr = "South";
                rows = 1;
                hgap = 3;
                break;
            case RIGHT:
                posStr = "East";
                cols = 1;
                vgap = 3;
                break;
            case LEFT:
                posStr = "West";
                cols = 1;
                vgap = 3;
                break;
            default:
                posStr = "North";
                rows = 1;
                hgap = 3;
                break;
        }

        btnBar_.setLayout(new GridLayout(rows, cols, hgap, vgap));
        mainPanel_.setLayout(new CardLayout());

        setLayout(new BorderLayout());
        add(posStr, btnBar_);
        add("Center", mainPanel_);

        rectWidth_ = rectWidth;
    }


    /**
     * Adds a new mode to this panel.
     *
     * @param panel    the panel representing the new mode.
     * @param btnLabel the label of the button that is
     *                 to represent the new mode.
     */
    public void addMode(Panel panel, String btnLabel) {
        // add mode to Hashtable
        modes_.put(btnLabel, panel);
        // create a button for this new mode
        ModeButton btn = new ModeButton(btnLabel, selectedCol_, rectWidth_);
        btn.setButtonColor(btnCol_);
        btn.setButtonTextColor(btnTxtCol_);
        if (selectedBtn_ == null) {
            btn.select();
            selectedBtn_ = btn;
        }
        // add button and panel
        btnBar_.add(btn);
        mainPanel_.add(btnLabel, panel);
    }


    /**
     * Shows a given mode.
     *
     * @param modeStr a string representing this mode. Should
     *                be the same as the button label for the mode.
     */
    public void selectMode(String modeStr) {
        // find which ModeButton was clicked
        Component comps[] = btnBar_.getComponents();
        ModeButton newBtn = null;
        for (int a = 0; a < comps.length; a++) {
            newBtn = (ModeButton) comps[a];
            if (modeStr.equals(newBtn.getLabel())) {
                break;
            }
        }

        // repaint & exit if it's the button that already is selected
        if (newBtn == selectedBtn_) {
            getSelectedPanel().repaint();
            return;
        }

        // unselect old mode
        selectedBtn_.unSelect();
        // show new mode
        ((CardLayout) mainPanel_.getLayout()).show(mainPanel_, modeStr);

        // select the new button
        selectedBtn_ = newBtn;
        selectedBtn_.select();
    }


    /**
     * Returns the string for the selected mode.
     */
    public String getSelectedMode() {
        return selectedBtn_.getLabel();
    }

    /**
     * Returns the panel for the selected mode.
     */
    public Panel getSelectedPanel() {
        return getPanel(getSelectedMode());
    }


    /**
     * Returns the panel corresponding to modeStr.
     * Returns null if no panel exists that matches the string.
     */
    public Panel getPanel(String modeStr) {
        return (Panel) modes_.get(modeStr);
    }


    /**
     * Sets color of buttons.
     */
    public void setButtonColor(Color col) {
        btnCol_ = col;
    }

    /**
     * Sets color of buttontext.
     */
    public void setButtonTextColor(Color col) {
        btnTxtCol_ = col;
    }

    /**
     * Sets color of selected button.
     */
    public void setSelectedColor(Color col) {
        selectedCol_ = col;
    }


    /**
     * Handles clicks on the ModeButtons.
     * This method always returns false so that the
     * clicks are propagated further in the component
     * hierarchy thus allowing custom event handling.
     */
    public boolean action(Event evt, Object arg) {

        if (evt.target instanceof Button) {
            selectMode((String) arg);
        }
        return false;
    }


}