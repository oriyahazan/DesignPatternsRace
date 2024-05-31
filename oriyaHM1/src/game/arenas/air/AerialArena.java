/**
 * Oriya Hazan. id:211987102
 * A department that is responsible for the arenas belonging to the air. The department inherits from the "Arena" department
 */


package game.arenas.air;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.Airplane;
import game.racers.air.Helicopter;
import utilities.EnumContainer;


public class AerialArena extends Arena {
    private static final double DEFAULT_FRICTION = 0.4;
    private static final int DEFAULT_MAX_RACERS = 6;
    private static final int DEFAULT_LENGTH = 1500;
    private EnumContainer.Vision vision=EnumContainer.Vision.SUNNY;
    private EnumContainer.Weather weather=EnumContainer.Weather.DRY;
    private EnumContainer.Height height=EnumContainer.Height.HIGH;
    private EnumContainer.Wind wind=EnumContainer.Wind.HIGH;

    /**
     * constructors
      * @param length-the length of the arena
     * @param maxRacers-Maximum number of participants who can participate in the arena
     */
    public AerialArena(double length,int maxRacers){
        super(length,maxRacers,DEFAULT_FRICTION);
    }

    public AerialArena(){
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_FRICTION);
    }

//    public void addRacer(Racer newRacer) throws RacerTypeException, RacerLimitException {
//        //super.addRacer(newRacer);
//        if (!((newRacer instanceof Airplane) || (newRacer instanceof Helicopter))) {
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
        if (!((newRacer instanceof Airplane) || (newRacer instanceof Helicopter))) {
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
    public EnumContainer.Vision getVision() {
        return vision;
    }

    public EnumContainer.Weather getWeather() {
        return weather;
    }

    public EnumContainer.Height getHeight() {
        return height;
    }

    public EnumContainer.Wind getWind() {
        return wind;
    }

    public boolean setVision(EnumContainer.Vision vision) {
        this.vision = vision;
        return true;
    }

    public boolean setHeight(EnumContainer.Height height) {
        this.height = height;
        return true;
    }

    public boolean setWeather(EnumContainer.Weather weather) {
        this.weather = weather;
        return true;
    }

    public boolean setWind(EnumContainer.Wind wind) {
        this.wind = wind;
        return true;
    }

}

