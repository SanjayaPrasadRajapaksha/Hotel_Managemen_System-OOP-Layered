/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom;

import hotel.dto.ReservationDetailDto;
import hotel.service.SuperService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public interface ReservationDetailService extends SuperService{
    List<ReservationDetailDto> getAll()throws Exception;  
}
