/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.dto.ReservationDetailDto;
import hotel.service.ServiceFactory;
import hotel.service.custom.ReservationDetailService;
import hotel.service.custom.ReservationService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class ReservationDetailController {

    private ReservationDetailService reservationDetailService = (ReservationDetailService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESERVATION_DETAIL);

    public List<ReservationDetailDto> getAll() throws Exception {
        return reservationDetailService.getAll();
    }

}
