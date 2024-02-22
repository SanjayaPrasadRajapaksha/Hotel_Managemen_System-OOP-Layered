/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service;

import hotel.service.custom.impl.CustomerServiceImpl;
import hotel.service.custom.impl.RoomCategoryServiceImpl;
import hotel.service.custom.impl.RoomServiceImpl;

/**
 *
 * @author Sanjaya
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType serviceType) {
        switch (serviceType) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ROOM_CATEGORY:
                return new RoomCategoryServiceImpl();
            case ROOM:
                return new RoomServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        CUSTOMER, ROOM_CATEGORY, ROOM
    }
}
