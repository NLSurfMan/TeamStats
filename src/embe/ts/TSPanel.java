/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: TSPanel.java
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
 * Parent of all Panels. Draws a background image
 * and hosts color parameters.
 */
public abstract class TSPanel extends java.awt.Panel {

    // colors
    protected Color primCol_;
    protected Color secCol_;
    protected Color foreCol_;
    protected Color backCol_;

    // the background image
    protected Image image_ = null;

    // the league object
    protected League league_ = null;


    /**
     * Constructor
     */
    public TSPanel(Color prim, Color sec, Color fore, Color back) {
        primCol_ = prim;
        secCol_ = sec;
        foreCol_ = fore;
        backCol_ = back;
    }

    /**
     * Clears screen and paints background image
     */
    public void paint(Graphics g) {
        // clears the screen (because of bug in Java for Unix)
        g.setColor(getBackground());
        java.awt.Dimension d = size();
        g.fillRect(0, 0, d.width, d.height);

        // draw the background image
        if (image_ != null) {
            int iw = image_.getWidth(this);
            int ih = image_.getHeight(this);
            int x = (d.width - iw) / 2;
            int y = ((d.height - ih) / 2) + 40; //+40 -> room for toolbar
            g.drawImage(image_, x, y, this);
        }
    }

    /**
     * Sets the image to use as background
     */
    public void setImage(Image img) {
        image_ = img;
        repaint();
    }
}