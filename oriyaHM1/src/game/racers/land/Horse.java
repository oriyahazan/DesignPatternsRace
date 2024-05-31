/**
 * Oriya Hazan. id:211987102
 * A class that extends the "Racer" class and implements the "LandRacer" interface - the class represents a horse
 */

package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

public class Horse extends Racer {
    private static final String CLASS_NAME="Horse";
    private static final double DEFAULT_MAX_SPEED=50;
    private static final double DEFAULT_ACCELERATION=3;
    private static final EnumContainer.Color DEFAULT_color= EnumContainer.Color.BLACK;
    private EnumContainer.Breed breed =EnumContainer.Breed.THOROUGHBRED;

    /**
     * constructor
     * @param name-Name of the horse
     * @param maxSpeed-the maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     */
    public Horse(String name,double maxSpeed,double acceleration,EnumContainer.Color color){
        super(name,maxSpeed,acceleration,color);
    }
    public Horse(){
        super(" " , DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION , DEFAULT_color);
        setName(CLASS_NAME+" #"+getSerialNumber());
    }
    /**
     * describes the unique details
     */
    public String describeSpecific(){
        return ", breed: "+this.breed;
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
        return "Horse";
    }

    /**
     * get and set of the breed
     */
    public EnumContainer.Breed getBreed() {
        return breed;
    }

    public boolean setBreed(EnumContainer.Breed breed) {
        this.breed = breed;
        return true;
    }
}
