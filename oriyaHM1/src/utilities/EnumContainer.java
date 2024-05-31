/**
 * Oriya Hazan. id:211987102
 * "Enum" class. auxiliary department
 */

package utilities;

/**
 * Contains all Enums for the game.
 *
 * To set a field type: EnumContainer.Vision vision; To set a value: this.vision
 * = EnumContainer.Vision.Sunny
 *
 * @author
 *
 */
public class EnumContainer {

    public static enum Vision {
        CLOUDS, SUNNY, FOG
    }
    public static enum Team {
        SINGLE, DOUBLE, QUAD, EIGHT
    }
    public static enum BoatType {
        SKULLING, SWEEP
    }
    public static enum Color{
        RED,GREEN,BLUE,BLACK,YELLOW
    }
    public static enum Engine{
        FOURSTROKE, VTYPE, STRAIGHT, BOXER, ROTARY
    }
    public static enum BicycleType{
        MOUNTAIN,HYBRID,CRUISER,ROAD
    }
    public static enum Breed{
        THOROUGHBRED,STANDARDBRED,MORGAN,FRIESIAN
    }
    public enum Weather {
        DRY,RAIN,SNOW
    }
    public enum Height {
        LOW,MEDIUM,HIGH
    }
    public enum Wind {
        LOW,MEDIUM,HIGH
    }
    public enum Coverage{
        SAND,GRASS,MUD
    }
    public enum LandSurface{
        FLAT,MOUNTAIN
    }
    public enum Water{
        SALTED,SWEET
    }
    public enum WaterSurface{
        FLAT,WAVY
    }
    public enum Body{
        SEA,LAKE,RIVER,OCEAN
    }
}

