package net.zouitni;

import net.zouitni.config.ZouitniBeanFactory;
import net.zouitni.metier.IZouitniService;
import net.zouitni.metier.ZouitniServiceImpl;

public class ZouitniMain {
    public static void main(String[] args) throws Exception {
        IZouitniService metier = ZouitniBeanFactory.createBean(ZouitniServiceImpl.class);
        metier.calcul();
    }
}
