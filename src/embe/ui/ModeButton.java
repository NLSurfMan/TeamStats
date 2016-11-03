/*
 * UI-package
 * Copyright (c) 1998 Mats Bovin. All rights reserved.
 *
 * File: ModeButton.java
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

/**
 * This class is a button with an extra feature,
 * it draws a colored rectangel around the button
 * if it's selected. Note that this class inherits
 * from Panel and not from Button.
 * <p>
 * This class was primarily designed to be used together
 * with ModePanel but it's also possible to use on its own.
 *
 * @author Mats Bovin
 * @version 1.00 jan-98
 * @see embe.ui.ModePanel
 * @see java.awt.Button
 */
public class ModeButton extends java.awt.Panel {

    /**
     * The button
     */
    protected Button btn_;

    /**
     * Is the button selected?
     */
    protected boolean selected_ = false;

    /**
     * Color of the surrounding rectangle
     */
    protected Color selectedCol_;

    /**
     * The width of the surrounding rectangle
     */
    protected int rectWidth_ = 3;


    /**
     * Constructs a new ModeButton. The width of the rectangle
     * will be three pixels and the color red.
     *
     * @param label the label of the button
     */
    public ModeButton(String label) {
        this(label, Color.red, 3);
    }

    /**
     * Constructs a new ModeButton. The width of the rectangle
     * will be three pixels.
     *
     * @param label       the label of the button
     * @param selectedCol the color of the surrounding rectangle
     */
    public ModeButton(String label, Color selectedCol) {
        this(label, selectedCol, 3);
    }

    /**
     * Constructs a new ModeButton. The color of the rectangle
     * will be red.
     *
     * @param label     the label of the button
     * @param rectWidth the width of the surrounding rectangle
     */
    public ModeButton(String label, int rectWidth) {
        this(label, java.awt.Color.red, rectWidth);
    }

    /**
     * Constructs a new ModeButton.
     *
     * @param label       the label of the button
     * @param selectedCol the color of the surrounding rectangle
     * @param rectWidth   the width of the surrounding rectangle
     */
    public ModeButton(String label, Color selectedCol, int rectWidth) {
        super();
        selectedCol_ = selectedCol;
        rectWidth_ = rectWidth;

        btn_ = new Button(label);
        setLayout(new BorderLayout());
        add("Center", btn_);
    }


    /**
     * Sets the selected status of this button.
     * The button is then repainted to reflect the changes.
     *
     * @param selected true if the button should be selected, false otherwise
     */
    public void setSelected(boolean selected) {
        selected_ = selected;
        repaint();
    }

    /**
     * Selects the button.
     */
    public void select() {
        setSelected(true);
    }

    /**
     * Unselects the button.
     */
    public void unSelect() {
        setSelected(false);
    }

    /**
     * Toggles the selected status of the button.
     * If the button is selcted it will be unselected and
     * the other way around.
     */
    public void toggleSelected() {
        setSelected(!selected_);
    }

    /**
     * Sets the width of the surrounding rectangle.
     *
     * @param width the width in pixels
     */
    public void setRectWidth(int width) {
        rectWidth_ = width;
    }

    /**
     * Sets color of button.
     */
    public void setButtonColor(Color col) {
        btn_.setBackground(col);
    }

    /**
     * Sets color of buttontext.
     */
    public void setButtonTextColor(Color col) {
        btn_.setForeground(col);
    }

    /**
     * Sets the color of the surrounding rectangle.
     */
    public void setSelectedColor(Color col) {
        selectedCol_ = col;
    }

    /**
     * Returns the label of the button.
     */
    public String getLabel() {
        return btn_.getLabel();
    }

    /**
     * Sets the label of the button.
     *
     * @param label the new label for the button
     */
    public void setLabel(String label) {
        btn_.setLabel(label);
    }

    /**
     * Draws/clears the rectangle depending on the
     * selected status of the button.
     */
    public void paint(Graphics g) {
        if (selected_) {
            g.setColor(selectedCol_);
        }
        else {
            g.setColor(getBackground());
        }
        Dimension d = size();
        g.fillRoundRect(0, 0, d.width, d.height, 5, 5);
    }


    /**
     * Makes room for rectangle to be drawn.
     */
    public Insets insets() {
        return new Insets(rectWidth_, rectWidth_, rectWidth_, rectWidth_);
    }


}