/**
 * Oriya Hazan. id:211987102
 * A department that builds the array of competitors and arenas
 */

package factory;

import game.arenas.Arena;
import game.racers.Racer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RaceBuilder {
    private static RaceBuilder Instance;
    private ClassLoader classLoader;
    private Class<?> classObject;
    private Constructor<?> constructor;

    public static RaceBuilder getInstance()
    {
        if(Instance==null)
            Instance=new RaceBuilder();
        return Instance;
    }

    public Arena buildArena(String arenaType, double length, int maxRacers) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(arenaType);     //Full name with the package
        constructor = classObject.getConstructor(double.class, int.class);
        return (Arena) constructor.newInstance(length, maxRacers);
    }

    public Racer buildRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(racerType);
        constructor = classObject.getConstructor(String.class, double.class, double.class, utilities.EnumContainer.Color.class);
        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color);
    }

    public Racer buildWheeledRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color, int numOfWheels) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(racerType);
        constructor = classObject.getConstructor(String.class, double.class, double.class, utilities.EnumContainer.Color.class, int.class);
        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color, numOfWheels);
    }
}
