/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.service.custom;

import hotel.dto.ReservationDto;
import hotel.service.SuperService;

/**
 *
 * @author Sanjaya
 */
public interface ReservationService extends SuperService{
    
    String book(ReservationDto reservationDto) throws Exception;
    ReservationDto get(String id) throws Exception;

    public String cancel(ReservationDto reservationDto)throws Exception;
}
