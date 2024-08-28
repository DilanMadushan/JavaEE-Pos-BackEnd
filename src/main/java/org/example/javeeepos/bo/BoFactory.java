package org.example.javeeepos.bo;

import org.example.javeeepos.bo.Custom.impl.*;

public class BoFactory {
    public static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes{
        CUSTOMER,PRODUCT,ORDER,ORDERDETAILS,USER
    }

    public SuperBo getBo(BoTypes boTypes){
        switch(boTypes){
            case ORDER: return new OrderBoImpl();
            case PRODUCT: return new ProductBoImpl();
            case CUSTOMER: return new CustomerBoImpl();
            case ORDERDETAILS: return new OrderDetailsBoImpl();
            case USER: return new UserBoImpl();
        }
        return null;
    }


}
