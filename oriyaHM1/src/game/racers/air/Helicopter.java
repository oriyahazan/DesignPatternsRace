/**
 * Oriya Hazan. id:211987102
 * A class that extends the "Racer" class and implements the "AerialRacer" interface - the class represents the helicopter
 */

package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class Helicopter extends Racer {
    private static final String CLASS_NAME="Helicopter";
    private static final double DEFAULT_MAX_SPEED=400;
    private static final double DEFAULT_ACCELERATION=50;
    private static final EnumContainer.Color DEFAULT_color= EnumContainer.Color.BLUE;

    /**
     * constructor
     * @param name-Name of the helicopter
     * @param maxSpeed-the maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     */
    public Helicopter(String name,double maxSpeed,double acceleration,EnumContainer.Color color){
        super(name,maxSpeed,acceleration,color);
    }

    public Helicopter(){
        super(" " , DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION , DEFAULT_color);
        setName(CLASS_NAME+" #"+getSerialNumber());
    }
    /**
     * describes the unique details
     */
    public String describeSpecific(){
        return " ";
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
        return "Helicopter";
    }
}
