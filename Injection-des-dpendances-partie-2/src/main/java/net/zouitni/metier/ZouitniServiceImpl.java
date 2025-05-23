package net.zouitni.metier;

import net.zouitni.dao.IZouitniDao;

public class ZouitniServiceImpl implements IZouitniService {

    private IZouitniDao dao;


    public ZouitniServiceImpl() {
    }


    public ZouitniServiceImpl(IZouitniDao dao) {
        this.dao = dao;
    }

    @Override
    public void calcul() {
        System.out.println("Business logic with DAO: " + dao.getData());
    }
}
