/*
 * UI-package
 * Copyright (c) 1998 Mats Bovin. All rights reserved.
 *
 * File: HyperLink.java
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

import java.applet.AppletContext;
import java.awt.*;
import java.net.URL;


/**
 * This class implements a clickable hyperlink. It works like an
 * ordinary link in an HTML-document. It displays an underlined
 * string or short text and when clicked upon loads a specfied URL
 * in the browser. Since this class needs an AppletContext to work
 * it will only make sense using it in applets.
 * <p>
 * The class needs an URL to the document that is to be shown.
 * It also needs two strings. One is the text to be shown in
 * the link itself. The other is a string that is shown, using
 * the <TT>showStatus()</TT>-method, every time the mouse is moved over
 * the link.
 * <p>
 * When the mouse is clicked somewhere over the link the specified
 * URL is loaded. The target of the new document can be specified
 * in the constructor. The target-string is passed on to <TT>showDocument()</TT>
 * and should therefore be one of the strings supported by that
 * method. Possible strings are:
 * "_self" = show in current frame,
 * "_parent" = show in parent frame,
 * "_top" = show in top-most frame,
 * "_blank" = show in new unnamed top-level window,
 * name = show in new top-level window named <I>name</I>.
 * If no target is given in the constructor the default is "_blank".
 *
 * @author Mats Bovin
 * @version 1.00 jan-98
 * @see java.net.URL
 * @see java.applet.AppletContext
 */
public class HyperLink extends java.awt.Canvas {

    /**
     * The URL to load
     */
    protected URL url_ = null;

    /**
     * The clickable text (the link itself)
     */
    protected String text_;

    /**
     * The string to show (showStatus()) when the mouse is over the link
     */
    protected String mouseOver_;

    /**
     * Where shall we view the page
     */
    protected String target_;

    /**
     * We need an AppletContext to be able to surf
     */
    protected AppletContext appletContext_ = null;


    /**
     * Constructs a new HyperLink. URL.toString() will
     * be used for the clickable text and the text
     * shown when the mouse is over the link. The URL
     * will be displayed in a new blank window.
     *
     * @param url the URL to load
     * @param ac  an AppletContext
     */
    public HyperLink(URL url, AppletContext ac) {
        this(url, ac, url.toString(), url.toString(), "_blank");
    }

    /**
     * Constructs a new HyperLink. URL.toString() will
     * be used for the text shown when the mouse is
     * over the link. The URL will be displayed in a
     * new blank window.
     *
     * @param url  the URL to load
     * @param ac   an AppletContext
     * @param text the clickable text
     */
    public HyperLink(URL url, AppletContext ac, String text) {
        this(url, ac, text, url.toString(), "_blank");
    }

    /**
     * Constructs a new HyperLink. The new document
     * will be displayed in a new blank window.
     *
     * @param url       the URL to load
     * @param ac        an AppletContext
     * @param text      the clickable text
     * @param mouseOver the string to show when the mouse is over the link
     */
    public HyperLink(URL url, AppletContext ac, String text, String mouseOver) {
        this(url, ac, text, mouseOver, "_blank");
    }

    /**
     * Constructs a new HyperLink.
     *
     * @param url       the URL to load
     * @param ac        an AppletContext
     * @param text      the clickable text
     * @param mouseOver the string to show when the mouse is over the link
     * @param target    a String indicating where to display the page.
     *                  Possible strings are:
     *                  "_self" = show in current frame,
     *                  "_parent" = show in parent frame,
     *                  "_top" = show in top-most frame,
     *                  "_blank" = show in new unnamed top-level window,
     *                  name = show in new top-level window named name
     */
    public HyperLink(URL url, AppletContext ac, String text, String mouseOver, String target) {
        url_ = url;
        appletContext_ = ac;
        text_ = text;
        mouseOver_ = mouseOver;
        target_ = target;
        setForeground(java.awt.Color.blue);
    }


    /**
     * Prints and underlines the text.
     */
    public void paint(java.awt.Graphics g) {
        Dimension d = getSize();
        g.drawString(text_, 0, d.height - 4);
        g.drawLine(0, d.height - 3, d.width, d.height - 3);
    }


    /**
     * Shows a text when the mouse is over the link.
     */
    public boolean mouseEnter(Event evt, int x, int y) {
        if (appletContext_ != null) {
            appletContext_.showStatus(mouseOver_);
        }
        return true;
    }


    /**
     * Clears the text when the mouse leaves the link.
     */
    public boolean mouseExit(Event evt, int x, int y) {
        if (appletContext_ != null) {
            appletContext_.showStatus("");
        }
        return true;
    }


    /**
     * Loads the URL in the specified target.
     */
    public boolean mouseUp(Event evt, int x, int y) {
        if (appletContext_ != null) {
            appletContext_.showDocument(url_, target_);
        }
        return true;
    }


    /* Returns size of component */
    public java.awt.Rectangle getBounds() {
        FontMetrics fm = getFontMetrics(getFont());
        Dimension d = new Dimension(fm.stringWidth(text_), fm.getHeight()); //14
        return new java.awt.Rectangle(d);
    }

    public Dimension getMinimumSize() {
        FontMetrics fm = getFontMetrics(getFont());
        return new Dimension(fm.stringWidth(text_), fm.getHeight()); //14
    }

    public Dimension getPreferredSize() {
        FontMetrics fm = getFontMetrics(getFont());
        return new Dimension(fm.stringWidth(text_), fm.getHeight()); //14
    }


}