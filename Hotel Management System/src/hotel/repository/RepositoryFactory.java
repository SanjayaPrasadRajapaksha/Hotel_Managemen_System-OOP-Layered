/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.repository;

import hotel.repository.custom.impl.CustomerRepositoryImpl;
import hotel.repository.custom.impl.ReservationDetailRepositoryImpl;
import hotel.repository.custom.impl.ReservationRepositoryImpl;
import hotel.repository.custom.impl.RoomCategoryRepositoryImpl;
import hotel.repository.custom.impl.RoomRepositoryImpl;

/**
 *
 * @author Sanjaya
 */
public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryType repositoryType) {
        switch (repositoryType) {

            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case ROOM_CATEGORY:
                return new RoomCategoryRepositoryImpl();
            case ROOM:
                return new RoomRepositoryImpl();
            case RESERVATION:
                return new ReservationRepositoryImpl();
            case RESERVATION_DETAIL:
                return new ReservationDetailRepositoryImpl();
            default:
                return null;
        }
    }

    public enum RepositoryType {
        CUSTOMER, ROOM_CATEGORY, ROOM, RESERVATION, RESERVATION_DETAIL
    }
}
