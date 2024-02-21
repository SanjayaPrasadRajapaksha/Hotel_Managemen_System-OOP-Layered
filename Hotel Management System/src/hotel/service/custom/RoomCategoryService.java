/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.service.custom;

import hotel.dto.RoomCategoryDto;
import hotel.service.SuperService;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public interface RoomCategoryService extends SuperService {

    String save(RoomCategoryDto roomCategoryDto) throws Exception;

    String update(RoomCategoryDto roomCategoryDto) throws Exception;

    String delete(RoomCategoryDto roomCategoryDto) throws Exception;

    RoomCategoryDto get(String id) throws Exception;

    List<RoomCategoryDto> getAll() throws Exception;
}
