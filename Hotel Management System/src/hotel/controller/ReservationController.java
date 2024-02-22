/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.dto.ReservationDto;
import hotel.service.ServiceFactory;
import hotel.service.custom.ReservationService;

/**
 *
 * @author Sanjaya
 */
public class ReservationController {

    private ReservationService reservationService = (ReservationService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESERVATION);

    public String book(ReservationDto reservationDto) throws Exception {
        return reservationService.book(reservationDto);
    }

}
