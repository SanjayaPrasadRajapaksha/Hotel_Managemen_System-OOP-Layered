/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.dto.RoomCategoryDto;
import hotel.entity.RoomCategoryEntity;
import hotel.service.ServiceFactory;
import hotel.service.custom.RoomCategoryService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class RoomCategoryController {

    private RoomCategoryService roomCategoryService = (RoomCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOM_CATEGORY);

    public String save(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.save(roomCategoryDto);
    }

    public List<RoomCategoryDto> getAll() throws Exception {
        return roomCategoryService.getAll();
    }

    public RoomCategoryDto get(String id) throws Exception {
        return roomCategoryService.get(id);
    }

    public String update(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.update(roomCategoryDto);
    }

    public String delete(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.delete(roomCategoryDto);
    }

}
