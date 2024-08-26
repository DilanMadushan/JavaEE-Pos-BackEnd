package org.example.javeeepos.dao;

import org.example.javeeepos.dao.custom.impl.CustomerDaoImpl;
import org.example.javeeepos.dao.custom.impl.OrderDaoImpl;
import org.example.javeeepos.dao.custom.impl.OrderDetailsDaoImpl;
import org.example.javeeepos.dao.custom.impl.ProductDaoImpl;

public class DaoFactory {
    public static DaoFactory daoFactory;

    private DaoFactory(){

    }
    public static DaoFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER,PRODUCT,ORDER,ORDERDETAILS
    }

    public SuperDao getDao(DaoTypes daoTypes){

        switch (daoTypes){
            case CUSTOMER: return new CustomerDaoImpl();
            case PRODUCT: return new ProductDaoImpl();
            case ORDER: return new OrderDaoImpl();
            case ORDERDETAILS: return new OrderDetailsDaoImpl();
        }
        return null;
    }
}
