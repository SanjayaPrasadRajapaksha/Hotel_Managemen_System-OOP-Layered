/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.entity;

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
public class ReservationDetailEntity {

    private String reservationID;
    private String roomID;
    private Integer reservationQty;
    private Integer discount;

}
