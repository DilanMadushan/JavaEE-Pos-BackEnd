package org.example.javeeepos.bo;

import org.example.javeeepos.bo.Custom.impl.CustomerBoImpl;
import org.example.javeeepos.bo.Custom.impl.OrderBoImpl;
import org.example.javeeepos.bo.Custom.impl.OrderDetailsBoImpl;
import org.example.javeeepos.bo.Custom.impl.ProductBoImpl;

public class BoFactory {
    public static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes{
        CUSTOMER,PRODUCT,ORDER,ORDERDETAILS
    }

    public SuperBo getBo(BoTypes boTypes){
        switch(boTypes){
            case ORDER: return new OrderBoImpl();
            case PRODUCT: return new ProductBoImpl();
            case CUSTOMER: return new CustomerBoImpl();
            case ORDERDETAILS: return new OrderDetailsBoImpl();
        }
        return null;
    }


}
