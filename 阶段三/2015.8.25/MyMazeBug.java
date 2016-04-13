import info.gridworld.actor.Actor;
import info.gridworld.maze.MazeBug;
import info.gridworld.actor.Flower;  
import info.gridworld.actor.Rock; 
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.Stack;
import java.util.ArrayList;
import javax.swing.JOptionPane;
  
/** 
 * A <code>MazeBug</code> can find its way in a maze. <br /> 
 * The implementation of this class is testable on the AP CS A and AB exams. 
 */
public class MyMazeBug extends MazeBug {  
    public Location next;              //记录下一步要行走的位置
    public boolean isEnd = false;
    boolean hasShownTheSteps = false;      //final message has been shown
    public Integer stepCount = 0;          //the total number of steps
    public Stack<ArrayList<Location>> Tree = new Stack<ArrayList<Location>>();

    /** 
     * Constructs a box bug that traces a square of a given side length
     *  
     * @param length 
     *            the side length
     */  
    public MyMazeBug() {
        setColor(Color.BLUE);
    }
  
    /** 
     * Moves to the next location of the square. 
     */  
    public void act() {  
        //add the initial location to the first array list  
        if(stepCount==0){  
            Location loc = this.getLocation();    
            ArrayList<Location> first = new ArrayList<Location>();  
            first.add(loc);   
            Tree.add(first);  
        }  
         
        if (!isEnd) {
		    if (canMove()) {
		        stepCount++;
		        move();  
		        //increase step count when move</span>   
		        System.out.println(stepCount);
		    } else {  
		        //If can't move, return to last location</span>  
		        goBack();  
		    }
        }
    }
  
    /** 
     * Find all positions that can be move to. 
     *  
     * @param loc 
     *            the location to detect. 
     * @return List of positions. 
     */ 
    public ArrayList<Location> getValid(Location loc) {
        Grid<Actor> g = getGrid();
        if (g == null)
            return null;
        ArrayList<Location> nearEmptyLocations = new ArrayList<Location>();  
  
        //get the valid location in the only four direction  
        int[] dir = {Location.EAST, Location.SOUTH, Location.WEST, Location.NORTH};  
        for( int i = 0; i < 4; i++ ){  
            Location location = loc.getAdjacentLocation(dir[i]);  
            if(g.isValid(location)){  
                Actor actor = g.get(location);  
                /*if the goal is around, create a new arrayList and add the location of 
               * the goal to the arrayList,only return the location of the goal
               * then return the location of the goal
               */  
                if(( actor instanceof Rock) && actor.getColor().equals(Color.RED)){
                /*上面这个if语句如果写成if(( actor instanceof Rock) && actor.getColor().equals(Color.RED))
                  *if(actor.getColor().equals(Color.RED)&&( actor instanceof Rock))
                  *下面的else if语句就会报一个dead code的错误
                  *原因在于判断语句会去判断第一个条件，如果成立再判断第二个条件，如果第一个错误则第二个不会
                  *进行判断。当actor是null值的时候是没有getColor这一个方法的
                  */
                    next = location;  
                    ArrayList<Location> goal = new ArrayList<Location>();  
                    goal.add(next);  
                    return goal;  
                } else if(actor == null) {  
                	nearEmptyLocations.add(location);  
                }
            }  
        }  
        return nearEmptyLocations;  
    }   
  
    /** 
     * Tests whether this bug can move forward into a location that is empty or 
     * contains a flower. 
     *  
     * @return true if this bug can move. 
     */
    public boolean canMove() { 
    	//得到当前位置
        Location current = this.getLocation();
        //调用函数getValid来得到当前位置四周的空的位置链表
        ArrayList<Location> nearEmptyLocations = new ArrayList<Location>(); 
        nearEmptyLocations = getValid(current);
        //如果四周只要有一个空的位置就可以移动，否则没法移动
        if (nearEmptyLocations.size() > 0) {  
            return true;  
        }  
        return false;  
    }     
    
    /** 
     * Moves the bug forward, putting a flower into the location it previously 
     * occupied. 
     */  
    public void move() {  
        
    	//随机选择下一步的位置，如果链表只有一个值，那么只能选择它
        Location loc = this.getLocation();
        ArrayList<Location> nearEmptyLocation = getValid(loc);
        int ramd = (int)(10* Math.random())%nearEmptyLocation.size();
        next = nearEmptyLocation.get(ramd);
        
        
        Grid<Actor> g = getGrid(); 
        if (g == null)  
            return;  
        if (g.isValid(next)) {  
            Actor actor = g.get(next);
            if( actor instanceof Rock && actor.getColor().equals(Color.RED) ){  
                isEnd = true;
                //Show step count when reach the goal
            	//如果不使用hasShowTheSteps,那么就会不断地弹出窗口 
                if (!hasShownTheSteps) {  
                    String msg = stepCount.toString() + " steps";  
                    JOptionPane.showMessageDialog(null, msg);  
                    hasShownTheSteps = true;  
                }                
            }
            this.moveTo(next);
            
            int direc = loc.getDirectionToward(next);
            this.setDirection(direc);  
              
            ArrayList<Location> temp = Tree.pop();  
            temp.add(next);  
            Tree.push(temp);  
              
            ArrayList<Location> latest = new ArrayList<Location>();  
            latest.add(next);  
            Tree.push(latest);           
        } else {  
            this.removeSelfFromGrid();  
        }  
        Flower flower = new Flower(getColor());  
        flower.putSelfInGrid(g, loc);  
    }  
    //回溯
    public void goBack() {
        if (Tree.size() > 0) {  
            Tree.pop();
            if(Tree.size() > 0){  
                Grid g = getGrid();  
                if( g == null ) {
                    return;
                }
                Location currentLocation = this.getLocation();
                ArrayList<Location> back = Tree.peek();  
                Location returnLocation = back.get(0);

                if (g.isValid(returnLocation)) {
                    moveTo(returnLocation);
                    stepCount++;
                }else {  
                    removeSelfFromGrid();  
                }  
                Flower flower = new Flower(getColor());
                flower.putSelfInGrid(g, currentLocation);
            }  
        }  
    }
}  
