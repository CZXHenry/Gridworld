/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
    private static final int Courage = 4;
    private static final double DARKENING_FACTOR = 0.05;

    public ArrayList<Actor> getActors() {

        ArrayList<Actor> actors = new ArrayList<Actor>();

        Location loca = getLocation();
        Grid gr = getGrid();

        for (int i = loca.getRow() - 2; i <= loca.getRow()+2; i++) {
            for (int j = loca.getCol() - 2; j <= loca.getCol() + 2;j++) {
                Location l = new Location(i,j);

                if(gr.isValid(l)) {
                    Actor actor = getGrid().get(l);
                    if (actor != null) {
                        actors.add(actor);
                    }
                }
            }
        }
        return actors;
    }


    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        Color c = getColor();
        int red, green, blue;

        if (n < Courage) {
            if (c.getRed() * (1 + DARKENING_FACTOR) >= 255) {
                red = 255;
            } else {
                red = (int) (c.getRed() * (1 + DARKENING_FACTOR));   
            }
            if (c.getGreen() * (1 + DARKENING_FACTOR) >= 255) {
                green = 255;
            } else {
                green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
            }
            if (c.getBlue() * (1 + DARKENING_FACTOR) >= 255) {
                blue = 255;
            } else {
                blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
            }                
        } else {
                red = (int) (c.getRed() * (1 - DARKENING_FACTOR));   
                green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
                blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));  
        }
        setColor(new Color(red, green, blue));
    }

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
