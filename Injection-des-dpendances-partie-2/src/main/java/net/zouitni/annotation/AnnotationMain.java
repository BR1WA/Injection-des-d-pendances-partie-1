package net.zouitni.annotation;

import net.zouitni.config.ZouitniBeanFactory;
import net.zouitni.metier.IZouitniService;
import net.zouitni.metier.ZouitniServiceImpl;

public class AnnotationMain {
    public static void main(String[] args) {
        try {
            // Create an instance of ZouitniServiceImpl through the ZouitniBeanFactory
            IZouitniService metier = (IZouitniService) ZouitniBeanFactory.createBean(ZouitniServiceImpl.class);
            // Call the business logic
            metier.calcul();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
