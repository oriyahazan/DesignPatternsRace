/**
 * Oriya Hazan. id:211987102
 * An abstract class that other classes extend.
 */

package game.racers;

import game.arenas.Arena;
import utilities.EnumContainer;
import utilities.Fate;
import utilities.Mishap;
import utilities.Point;

public abstract class Racer {
    private int serialNumber;
    private static int id=1;
    private String name;
    private Point currentLocation;
    private Point finish;
    private Arena arena;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private double failureProbability;
    private EnumContainer.Color color;
    private Mishap mishap;

    /**
     * constructor
     * @param name-Name of the racer
     * @param maxSpeed-the maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     */
    public Racer(String name,double maxSpeed,double acceleration, EnumContainer.Color color){
        this.name=name;
        this.maxSpeed=maxSpeed;
        this.acceleration=acceleration;
        this.color=color;
        this.serialNumber=id++;
    }

    /**
     * Entering a racer into the arena
     * @param arena-the arena
     * @param start-start point
     * @param finish-finish point
     */
    public void initRace(Arena arena,Point start,Point finish){
        setCurrentLocation(start);
        setFinish(finish);
        setArena(arena);
    }

    /**
     * The function moves the player according to the conditions of the game and the arena.
     * Checks if there is a fault, and thus determines the next position of the player
     * @param friction-the friction input
     * @return-The current location of the participant after the move
     */
    public Point move(double friction){
        if(hasMishap()){      //check if there is a Mishap
            if(mishap.getFixAble() && mishap.getTurnsToFix()==0)
                setMishap(null);
        }
        if(!hasMishap()){     //check if there is no mishap : if(mishap==null)
            if(Fate.breakDown()) {       //A mishap was random
                setMishap(Fate.generateMishap());     //create new mishap
                System.out.println(this.name + " Has a new mishap!: " + mishap.toString());
            }
        }
        if(hasMishap()){
            this.setCurrentSpeed(Math.min(this.currentSpeed+this.mishap.getReductionFactor() * this.acceleration * friction,this.maxSpeed));
            mishap.nextTurn();
        }
        else
            setCurrentSpeed(Math.min(this.currentSpeed+this.acceleration * friction,this.maxSpeed));
        getCurrentLocation().setX(getCurrentLocation().getX()+getCurrentSpeed());
        return getCurrentLocation();
    }
    
    /**
     * An abstract function that describes the unique things of each participant
     */
    public abstract String describeSpecific();

    /**
     * A function describing the participant
     */
    public String describeRacer(){
        return "name: "+this.name+" ,"+" SerialNumber: "+this.serialNumber+", max speed: "+ this.maxSpeed+", acceleration: "+this.acceleration+", color: "+this.color;
    }

    /**
     * Abstract function
     */
    public abstract String className();

    /**
     * Prints all the details of the racer
     */
    public void introduce(){
        System.out.println("["+className()+"] "+describeRacer());
    }

    /**
     * Checking whether it exists mishap
     */
    public boolean hasMishap(){
        return (!(this.mishap==null));
    }

    /**
     * getters and setters
     */
    public int getSerialNumber() {
        return serialNumber;
    }
    public boolean setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
        return true;
    }
    public String getName(){
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public boolean setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
        return true;
    }

    public Point getFinish() {
        return finish;
    }

    public boolean setFinish(Point finish) {
        this.finish = finish;
        return true;
    }

    public Arena getArena() {
        return arena;
    }

    public boolean setArena(Arena arena) {
        this.arena = arena;
        return true;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean setMaxSpeed(double maxSpeed) {
        if(maxSpeed>=0){
            this.maxSpeed = maxSpeed;
            return true;
        }
        return false;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public boolean setAcceleration(double acceleration) {
        this.acceleration = acceleration;
        return true;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean setCurrentSpeed(double currentSpeed) {
        if(currentSpeed>=0){
            this.currentSpeed = currentSpeed;
            return true;
        }
        return false;
    }

    public double getFailureProbability() {
        return failureProbability;
    }

    public boolean setFailureProbability(double failureProbability) {
        this.failureProbability = failureProbability;
        return true;
    }

    public EnumContainer.Color getColor() {
        return color;
    }

    public boolean setColor(EnumContainer.Color color) {
        this.color = color;
        return true;
    }

    public Mishap getMishap() {
        return mishap;
    }

    public boolean setMishap(Mishap mishap) {
        this.mishap = mishap;
        return true;
    }
}
