/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.dto.RoomDto;
import hotel.service.ServiceFactory;
import hotel.service.custom.RoomService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class RoomController {

    private RoomService roomService = (RoomService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOM);

    public String save(RoomDto roomDto) throws Exception {
        return roomService.save(roomDto);
    }

    public List<RoomDto> getAll() throws Exception {
        return roomService.getAll();
    }

    public RoomDto get(String id) throws Exception {
        return roomService.get(id);
    }

    public String update(RoomDto roomDto) throws Exception {
        return roomService.update(roomDto);
    }

    public String delete(RoomDto roomDto) throws Exception {
        return roomService.delete(roomDto);
    }

}
