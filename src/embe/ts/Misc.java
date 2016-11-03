/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: Misc.java
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
 * Collection of static helpfunctions
 */
class Misc {

    /**
     * Fixes strange ASCII-codes
     */
    public static String fixString(String s) {
        int len = s.length();
        char newString[] = new char[len];

        for (int a = 0; a < len; a++) {
            int c = (int) s.charAt(a);
            // MAC parering
            switch (c) {
                case 65420:
                    c = 229;
                    break; // �
                case 65418:
                    c = 228;
                    break; // �
                case 65434:
                    c = 246;
                    break; // �
                case 65409:
                    c = 197;
                    break; // �
                case 65408:
                    c = 196;
                    break; // �
                case 65413:
                    c = 214;
                    break; // �
            }
            newString[a] = (c > 65000) ? (char) (c - 65280) : (char) c;
        }

        return new String(newString);
    }

    /**
     * Converts a float to a String with specified number of decimals
     */
    public static String floatToString(float f, int dec) {
        String str = Float.toString(round(f, dec));
        if (dec == 0) {
            return str;
        }
        int decpos = str.lastIndexOf('.');
        if (decpos == -1) {
            str += ".";
            decpos = str.length() - 1;
        }
        int numdec = str.length() - decpos - 1;
        while (numdec++ < dec) {
            str += "0";
        }
        return str;
    }

    /**
     * Converts an int to a leftjustified string
     */
    public static String leftString(int i, int width, char fill) {
        String str = Integer.toString(i);
        while (str.length() < width) {
            str = str + fill;
        }

        return str;
    }

    /**
     * Pads s with blanks to be length (max 16) chars long
     * Does NOT truncate s if longer than length
     */
    public static String padString(String s, int length) {
        try {
            return s.concat("                ".substring(0, length - s.length()));
        }
        // string is longer than 16 chars, return it as it is
        catch (StringIndexOutOfBoundsException e) {
        }
        return s;
    }

    /**
     * Parses a String to a Color
     */
    public static Color parseColorString(String colorString) {
        int r, g, b;
        Color col = null;

        try {
            if (colorString.startsWith("#")) {
                colorString = colorString.substring(1);
            }
            r = Integer.valueOf(colorString.substring(0, 2), 16).intValue();
            g = Integer.valueOf(colorString.substring(2, 4), 16).intValue();
            b = Integer.valueOf(colorString.substring(4, 6), 16).intValue();
            col = new Color(r, g, b);
        }
        catch (NullPointerException e) {
        }
        catch (StringIndexOutOfBoundsException e) {
        }
        catch (NumberFormatException e) {
        }

        return col;
    }

    /**
     * Returns (x/y)*100
     */
    public static int procOf(int x, int y) {
        return (y == 0) ? 0 : Math.round(((float) x / (float) y) * 100);
    }

    /**
     * Converts an int to a rightjustified string
     */
    public static String rightString(int i, int width, char fill) {
        String str = Integer.toString(i);
        while (str.length() < width) {
            str = fill + str;
        }

        return str;
    }

    /**
     * Rounds to specified number of decimal points
     */
    public static float round(float f, int dec) {
        try {
            return (float) ((Math.round(f * Math.pow(10, dec))) / Math.pow(10, dec));
        }
        catch (ArithmeticException e) {
            return f;
        }
    }

    /**
     * Returns sign of i
     */
    public static int sign(int i) {
        if (i == 0) {
            return 0;
        }
        return (i > 0) ? 1 : -1;
    }
}