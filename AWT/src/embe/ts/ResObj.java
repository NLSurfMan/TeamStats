/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: ResObj.java
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
 * Class: ResObj
 */
class ResObj {
    protected int count_;
    protected int hGoals_, aGoals_;

    // construct
    public ResObj(int hg, int ag) {
        hGoals_ = hg;
        aGoals_ = ag;
        count_ = 1;
    }

    /**
     * Tries to add a result. Returns true if this is
     * is the ResObj for the given result and false otherwise.
     */
    public boolean add(int hgoals, int agoals) {
        if (hGoals_ == hgoals && aGoals_ == agoals) {
            count_++;
            return true;
        }

        return false;
    }

    /**
     * Returns count_
     */
    public int getCount() {
        return count_;
    }

    /**
     * Returns a string-representation of this object
     */
    public String getString() {
        if (count_ < 2) {
            return "";
        }
        else {
            return Misc.rightString(hGoals_, 2, ' ') + "-" +
                    Misc.leftString(aGoals_, 2, ' ') + "  " +
                    Misc.rightString(count_, 3, ' ') + Text.STA_TIMES;
        }
    }
}