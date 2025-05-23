package net.zouitni.pres;

import net.zouitni.dao.DaoImpl;
import net.zouitni.ext.DaoImplV2;
import net.zouitni.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d);// Injection des dépendances via le setter
        System.out.println("RES= "+metier.calcul());
    }
}
