/*
 * TeamStats by Mats Bovin (mats@mbovin.com)
 * Version 1.2 - September 1999
 * Copyright (c) 1996-99. All rights reserved.
 *
 * File: Results.java
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

import java.util.Vector;


/**
 * Picks out the most common results for a specified team.
 */
class Results {
    protected League league_;
    protected Vector res_ = new Vector(20);
    protected int team_;


    // construct
    public Results(League l) {
        this(l, -1); // -1 = all teams
    }

    // construct
    public Results(League l, int team) {
        league_ = l;
        team_ = team;
    }

    // adds a match to the list of results
    public void addMatch(Match m) {
        int a;
        int goal1, goal2;

        if (team_ < 0 || team_ == m.getHomeId()) {
            goal1 = m.getHGoals();
            goal2 = m.getAGoals();
        }
        else {
            goal1 = m.getAGoals();
            goal2 = m.getHGoals();
        }

        for (a = 0; a < res_.size(); a++) {
            ResObj obj = (ResObj) res_.elementAt(a);
            if (obj.add(goal1, goal2)) {
                break;
            }
        }

        if (a == res_.size()) {
            res_.addElement(new ResObj(goal1, goal2));
        }

        while (a > 0) {
            ResObj obj = (ResObj) res_.elementAt(a);
            ResObj prev = (ResObj) res_.elementAt(a - 1);
            if (obj.getCount() > prev.getCount()) {
                res_.removeElementAt(a);
                res_.insertElementAt(obj, a - 1);
                a--;
            }
            else {
                break;
            }
        }


    }

    // returns a ResObj
    public ResObj getResult(int n) throws ArrayIndexOutOfBoundsException, NullPointerException {
        try {
            return (ResObj) res_.elementAt(n);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
        catch (NullPointerException e) {
            throw e;
        }
    }
}