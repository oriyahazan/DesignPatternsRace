/**
 * Oriya Hazan. id:211987102
 * A class that extends the "Racer" class and implements the "AerialRacer" interface - the class represents an airplane
 */

package game.racers.air;

import game.arenas.Arena;
import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class Airplane extends Racer implements AerialRacer {
    private static final String CLASS_NAME="Airplane";
    private static final int DEFAULT_WHEELS=3;
    private static final double DEFAULT_MAX_SPEED=885;
    private static final double DEFAULT_ACCELERATION=100;
    private static final EnumContainer.Color DEFAULT_color= EnumContainer.Color.BLACK;
    private Wheeled wheeled;

    /**
     * constructor
     * @param name-Name of the plane
     * @param maxSpeed-the maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     * @param numOfWheeled-the number of the wheeled
     */
    public Airplane(String name,double maxSpeed,double acceleration,EnumContainer.Color color,int numOfWheeled){
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheeled);
        //setNumOfWheels(numOfWheeled);
    }
    public Airplane(){
        super(" " , DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION , DEFAULT_color);
        this.wheeled=new Wheeled(DEFAULT_WHEELS);
        setName(CLASS_NAME+" #"+getSerialNumber());
    }

    /**
     * describes the unique details
     */
    public String describeSpecific(){
        return " Number of Wheeled: "+this.wheeled.getNumOfWheels();
    }

    /**
     * describes the Racer
     */
    public String describeRacer(){
        String result=super.describeRacer();
        result+=describeSpecific();
        return result;
    }

    /**
     * return the class name
     */
    public String className(){
        return "Airplane";
    }
}
