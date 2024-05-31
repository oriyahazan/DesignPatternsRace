/**
 * Oriya Hazan. id:211987102
 * A class that extends the "Racer" class and implements the "LandRacer" interface - the class represents a bicycle
 */

package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class Bicycle extends Racer implements LandRacer {
    private static final String CLASS_NAME="Bicycle";
    private static final int DEFAULT_WHEELS=2;
    private static final double DEFAULT_MAX_SPEED=270;
    private static final double DEFAULT_ACCELERATION=10;
    private static final EnumContainer.Color DEFAULT_color= EnumContainer.Color.GREEN;
    private Wheeled wheeled;
    private EnumContainer.BicycleType type =EnumContainer.BicycleType.MOUNTAIN;

    /**
     * constructor
     * @param name-Name of the bicycle
     * @param maxSpeed-the maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     * @param numOfWheeled-the number of the wheeled
     */
    public Bicycle(String name,double maxSpeed,double acceleration,EnumContainer.Color color,int numOfWheeled){
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheeled);
    }
    public Bicycle(){
        super(" " , DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION , DEFAULT_color);
        this.wheeled=new Wheeled(DEFAULT_WHEELS);
        setName(CLASS_NAME+" #"+getSerialNumber());
    }

    public EnumContainer.BicycleType getType() {
        return type;
    }

    public boolean setType(EnumContainer.BicycleType type) {
        this.type = type;
        return true;
    }
    /**
     * describes the unique details
     */
    public String describeSpecific(){
        return ", Number of Wheeled: "+this.wheeled.getNumOfWheels()+", Bicycle Type: "+this.type;
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
        return "Bicycle";
    }
}
