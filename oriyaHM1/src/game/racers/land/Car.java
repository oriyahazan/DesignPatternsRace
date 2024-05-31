/**
 * Oriya Hazan. id:211987102
 * A class that extends the "Racer" class and implements the "LandRacer" interface - the class represents a car
 */

package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class Car extends Racer implements  LandRacer{
    private static final String CLASS_NAME="Car";
    private static final int DEFAULT_WHEELS=4;
    private static final double DEFAULT_MAX_SPEED=400;
    private static final double DEFAULT_ACCELERATION=20;
    private static final EnumContainer.Color DEFAULT_color= EnumContainer.Color.RED;
    private Wheeled wheeled;
    private EnumContainer.Engine engine=EnumContainer.Engine.FOURSTROKE;

    /**
     * constructor
     * @param name-Name of the car
     * @param maxSpeed-the maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     * @param numOfWheeled-the number of the wheeled
     */
    public Car(String name,double maxSpeed,double acceleration,EnumContainer.Color color,int numOfWheeled){
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheeled);
    }
    public Car(){
        super(" " , DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION , DEFAULT_color);
        this.wheeled=new Wheeled(DEFAULT_WHEELS);
        setName(CLASS_NAME+" #"+getSerialNumber());
    }

    public EnumContainer.Engine getEngine() {
        return engine;
    }
    public boolean setEngine(EnumContainer.Engine engine) {
        this.engine = engine;
        return true;
    }
    /**
     * describes the unique details
     */
    public String describeSpecific(){
        return ", number of Wheeled: "+this.wheeled.getNumOfWheels()+", Engine: "+this.engine;
    }

    /**
     * describes the Racer
     */
    public String describeRacer(){
        return super.describeRacer()+describeSpecific();
    }

    /**
     * return the class name
     */
    public String className(){
        return "Car";
    }
}
