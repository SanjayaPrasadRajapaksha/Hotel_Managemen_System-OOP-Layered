/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.dto.ReservationDto;
import hotel.service.ServiceFactory;
import hotel.service.custom.ReservationService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class ReservationController {

    private ReservationService reservationService = (ReservationService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESERVATION);

    public String book(ReservationDto reservationDto) throws Exception {
        return reservationService.book(reservationDto);
    }

    public ReservationDto get(String id) throws Exception {
        return reservationService.get(id);
    }

    public String Cancel(ReservationDto reservationDto) throws Exception {
        return reservationService.cancel(reservationDto);
    }

}
