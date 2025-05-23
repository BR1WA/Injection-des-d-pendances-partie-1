package net.zouitni.config;

import net.zouitni.dao.ZouitniDaoImpl;
import net.zouitni.dao.IZouitniDao;
import net.zouitni.metier.IZouitniService;
import net.zouitni.metier.ZouitniServiceImpl;

import java.lang.reflect.Constructor;

public class ZouitniBeanFactory {

    public static <T> T createBean(Class<T> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();

                // Check if the constructor expects an IZouitniDao parameter
                if (parameterTypes.length == 1 && parameterTypes[0].equals(IZouitniDao.class)) {
                    // Create the dependency (IZouitniDao)
                    IZouitniDao dao = new ZouitniDaoImpl(); // Create the ZouitniDaoImpl dependency

                    // ZouitniInject the dependency through the constructor
                    return (T) constructor.newInstance(dao);
                }
            }
        }

        // Fallback to no-argument constructor if no dependencies are required
        return clazz.getDeclaredConstructor().newInstance();
    }
}
