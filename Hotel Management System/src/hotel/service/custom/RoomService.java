/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.service.custom;

import hotel.dto.RoomDto;
import hotel.service.SuperService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public interface RoomService extends SuperService {

    String save(RoomDto roomDto) throws Exception;

    String update(RoomDto roomDto) throws Exception;

    String delete(RoomDto roomDto) throws Exception;

    RoomDto get(String id) throws Exception;

    List<RoomDto> getAll() throws Exception;
}
