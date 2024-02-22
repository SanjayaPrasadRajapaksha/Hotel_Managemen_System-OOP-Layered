/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Sanjaya
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString   
public class RoomDto {

    private String roomID;
    private String CategoryID;
    private Integer Quantity;

}
