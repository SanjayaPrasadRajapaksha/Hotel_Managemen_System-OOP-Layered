/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Sanjaya
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDto {

    private String reservationID;
    private String reservationDate;
    private String cancellationDeadline;
    private String custID;

    List<ReservationDetailDto> resevationDetailDtos;
}
