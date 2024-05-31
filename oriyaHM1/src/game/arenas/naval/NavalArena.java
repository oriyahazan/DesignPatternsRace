/**
 * Oriya Hazan. id:211987102
 *A department that is responsible for the arenas belonging to the sea. The department inherits from the "Arena" department
 */

package game.arenas.naval;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.Airplane;
import game.racers.air.Helicopter;
import game.racers.land.Bicycle;
import game.racers.land.Car;
import game.racers.land.Horse;
import game.racers.naval.RowBoat;
import game.racers.naval.SpeedBoat;
import utilities.EnumContainer;

public class NavalArena extends Arena {
    private static final double DEFAULT_FRICTION = 0.7;
    private static final int DEFAULT_MAX_RACERS = 5;
    private static final int DEFAULT_LENGTH = 1000;
    private EnumContainer.Water water=EnumContainer.Water.SWEET;
    private EnumContainer.WaterSurface surface=EnumContainer.WaterSurface.FLAT;
    private EnumContainer.Body body=EnumContainer.Body.LAKE;

    /**
     * constructors
     * @param length-the length of the arena
     * @param maxRacers-Maximum number of participants who can participate in the arena
     */
    public NavalArena(double length,int maxRacers){
        super(length,maxRacers,DEFAULT_FRICTION);
    }

    public NavalArena(){
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_FRICTION);
    }

//    public void addRacer(Racer newRacer) throws RacerTypeException, RacerLimitException {
//        //super.addRacer(newRacer);
//        if (!((newRacer instanceof SpeedBoat) || (newRacer instanceof RowBoat))) {
//            throw new RacerTypeException("This is not the Type");
//        }
//        activeRacers.add(newRacer);
//    }
    /**
     * Adding a racer to the arena
     * @param newRacer-input
     * @throws RacerTypeException-Exceptions Department
     * @throws RacerLimitException-Exceptions Department
     */
    public void addRacer(Racer newRacer) throws RacerTypeException, RacerLimitException {
        if (!((newRacer instanceof SpeedBoat) || (newRacer instanceof RowBoat))) {
            throw new RacerTypeException("Invalid Racer of type \"" + newRacer.getClass().getSimpleName() + "\" for Aerial arena");
        }
        if (activeRacers.size() >= super.getMAX_RACERS()) {
            throw new RacerLimitException("Arena is full! (" + MAX_RACERS + " active racers exist). racer #"+newRacer.getSerialNumber()+ " was not added");
        }
        activeRacers.add(newRacer);
    }

    /**
     * getters and setters.
     */
    public EnumContainer.Water getWater() {
        return water;
    }

    public EnumContainer.WaterSurface getSurface() {
        return surface;
    }

    public EnumContainer.Body getBody() {
        return body;
    }

    public boolean setWater(EnumContainer.Water water) {
        this.water = water;
        return true;
    }

    public boolean setSurface(EnumContainer.WaterSurface surface) {
        this.surface = surface;
        return true;
    }

    public boolean setBody(EnumContainer.Body body) {
        this.body = body;
        return true;
    }
}
