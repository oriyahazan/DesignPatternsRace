/**
 * Oriya Hazan. id:211987102
 * A department that is responsible for the arenas belonging to the land. The department inherits from the "Arena" department
 */

package game.arenas.land;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.land.Bicycle;
import game.racers.land.Car;
import game.racers.land.Horse;
import utilities.EnumContainer;

public class LandArena extends Arena {
    private static final double DEFAULT_FRICTION = 0.5;
    private static final int DEFAULT_MAX_RACERS = 8;
    private static final int DEFAULT_LENGTH = 800;
    private EnumContainer.Coverage coverage=EnumContainer.Coverage.GRASS;
    private EnumContainer.LandSurface surface=EnumContainer.LandSurface.FLAT;

    /**
     * constructors
     * @param length-the length of the arena
     * @param maxRacers-Maximum number of participants who can participate in the arena
     */
    public LandArena(double length,int maxRacers){
        super(length,maxRacers,DEFAULT_FRICTION);
    }

    public LandArena(){
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_FRICTION);
    }

//    public void addRacer(Racer newRacer) throws RacerTypeException, RacerLimitException {
//        //super.addRacer(newRacer);
//        if (!((newRacer instanceof Bicycle) || (newRacer instanceof Car) || (newRacer instanceof Horse))) {
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
        if (!((newRacer instanceof Bicycle) || (newRacer instanceof Car) || (newRacer instanceof Horse))) {
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
    public EnumContainer.Coverage getCoverage() {
        return coverage;
    }

    public EnumContainer.LandSurface getSurface() {
        return surface;
    }

    public boolean setCoverage(EnumContainer.Coverage coverage) {
        this.coverage = coverage;
        return true;
    }

    public boolean setSurface(EnumContainer.LandSurface surface) {
        this.surface = surface;
        return true;
    }
}
