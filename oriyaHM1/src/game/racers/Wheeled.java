/**
 * Oriya Hazan. id:211987102
 * A class representing wheels. Several competitors have wheels
 */

package game.racers;

public class Wheeled {
    private int numOfWheels;

    /**
     * constructor
     * @param numOfWheels-the numbet of the wheels
     */
    public Wheeled(int numOfWheels){
        this.numOfWheels=numOfWheels;
    }
    public Wheeled(){
        this.numOfWheels=0;
    }

    /**
     * Describes the number of wheels
     */
    public String describeSpecific(){
        return "The number of the wheelds is:"+this.numOfWheels;
    }

    /**
     * getters and setters
     */
    public int getNumOfWheels() {
        return numOfWheels;
    }

    public boolean setNumOfWheels(int numOfWheels) {
        if(numOfWheels>=0) {
            this.numOfWheels = numOfWheels;
            return true;
        }
        return false;
    }
}
