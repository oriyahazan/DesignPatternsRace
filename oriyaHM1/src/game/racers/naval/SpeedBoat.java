/**
 * Oriya Hazan. id:211987102
 * A class that extends the "Racer" class and implements the "NavalRacer" interface - the class represents a speed boat
 */

package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer;

public class SpeedBoat extends Racer implements NavalRacer {
    private static final String CLASS_NAME = "SpeedBoat";
    private static final double DEFAULT_MAX_SPEED = 170;
    private static final double DEFAULT_ACCELERATION = 5;
    private static final EnumContainer.Color DEFAULT_color = EnumContainer.Color.RED;
    private EnumContainer.Team team = EnumContainer.Team.DOUBLE;
    private EnumContainer.BoatType type = EnumContainer.BoatType.SKULLING;

    /**
     * constructor
     *
     * @param name-Name        of the boat
     * @param maxSpeed-the     maximum speed
     * @param acceleration-The acceleration
     * @param color-color
     */
    public SpeedBoat(String name, double maxSpeed, double acceleration, EnumContainer.Color color) {
        super(name, maxSpeed, acceleration, color);
    }

    public SpeedBoat() {
        super(" ", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
        setName(CLASS_NAME + " #" + getSerialNumber());
    }

    /**
     * describes the unique details
     */
    public String describeSpecific() {
        return ", Type: " + this.type + ", Team: " + this.team;
    }

    /**
     * describes the Racer
     */
    public String describeRacer() {
        return super.describeRacer() + describeSpecific();
    }

    /**
     * return the class name
     */
    public String className() {
        return "SpeedBoat";
    }

    /**
     * getters and setters
     */
    public EnumContainer.Team getTeam() {
        return team;
    }

    public boolean setTeam(EnumContainer.Team team) {
        this.team = team;
        return true;
    }

    public EnumContainer.BoatType getType() {
        return type;
    }

    public boolean setType(EnumContainer.BoatType type) {
        this.type = type;
        return true;
    }
}

