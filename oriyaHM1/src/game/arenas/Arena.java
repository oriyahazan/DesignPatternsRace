/**
 * Oriya Hazan. id:211987102
 * An abstract class that all the other classes of the arenas extend
 */

package game.arenas;

import game.racers.Racer;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import utilities.Point;

import java.util.ArrayList;

public abstract class Arena {
    protected ArrayList<Racer> activeRacers;
    protected ArrayList<Racer> completedRacers;
    protected final double FRICTION;
    protected final int MAX_RACERS;
    protected static final int MIN_Y_GAP = 10;
    protected double length;

    /**
     * constructor
     * @param length-the length of the arena
     * @param maxRacers-The maximum number of participants in the arena
     * @param friction-The friction of the arena
     */
    public Arena(double length, int maxRacers, double friction) {
        this.length = length;
        this.MAX_RACERS = maxRacers;
        this.FRICTION = friction;
        this.activeRacers = new ArrayList<Racer>();
        this.completedRacers = new ArrayList<Racer>();
    }

    /**
     * An abstract function that will be implemented in the successor classes
     * @param newRacer-input
     * @throws RacerTypeException-Exceptions Department
     * @throws RacerLimitException-Exceptions Department
     */
    public abstract void addRacer(Racer newRacer) throws  RacerTypeException, RacerLimitException;


    /**
     * Entering a competitor into the ring. Initializes the start and end point of each participant
     */
    public void initRace(){
        for(int i=0;i<this.activeRacers.size();i++){
            Point start=new Point(0,i*MIN_Y_GAP);
            Point finish=new Point(this.length,i*MIN_Y_GAP);
            this.activeRacers.get(i).initRace(this,start,finish);
        }
    }

    /**
     * A function that checks whether there are active participants in the arena
     */
    public boolean hasActiveRacers() {
        if(this.activeRacers.isEmpty())
            return false;
        return true;
    }

    /**
     * Activates the "move" function for each participant and checks whether any participants have crossed the finish line.
     */
    public void playTurn() {
        for(int i=0;i<getActiveRacers().size();i++){
            activeRacers.get(i).move(getFRICTION());
            if(activeRacers.get(i).getCurrentLocation().getX()>=length)
                crossFinishLine(getActiveRacers().get(i));
        }
    }

    /**
     * Checks whether there are participants who have crossed the finish line.
     * @param racer
     */
    public void crossFinishLine(Racer racer) {
        this.activeRacers.remove(racer);
        this.completedRacers.add(racer);
    }

    /**
     * Prints the race results
     */
    public void showResults() {
        //System.out.println("Completed Racers:");
        for (int i=0;i<this.completedRacers.size();i++)
            System.out.println("#"+i+" -> " +this.completedRacers.get(i).describeRacer());

        //System.out.println("Active Racers:");
        for (int i=0;i<this.activeRacers.size();i++)
            System.out.println(this.activeRacers.get(i));
    }

    /**
     * getters and setters
     */
    public ArrayList<Racer> getActiveRacers() {
        return activeRacers;
    }

    public int getMAX_RACERS() {
        return MAX_RACERS;
    }

    public double getFRICTION() {
        return FRICTION;
    }

    public ArrayList<Racer> getCompletedRacers() {
        return completedRacers;
    }

    public double getLength() {
        return length;
    }

}


