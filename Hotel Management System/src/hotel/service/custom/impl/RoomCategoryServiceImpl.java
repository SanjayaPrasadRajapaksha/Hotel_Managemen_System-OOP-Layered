/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom.impl;

import hotel.dto.RoomCategoryDto;
import hotel.entity.RoomCategoryEntity;
import hotel.repository.RepositoryFactory;
import hotel.repository.custom.RoomCategoryRepository;
import hotel.service.custom.RoomCategoryService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class RoomCategoryServiceImpl implements RoomCategoryService {

    private RoomCategoryRepository roomCategoryRepository = (RoomCategoryRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOM_CATEGORY);

    @Override
    public String save(RoomCategoryDto roomCategoryDto) throws Exception {
        if (roomCategoryRepository.save(new RoomCategoryEntity(roomCategoryDto.getCategoryID(), roomCategoryDto.getPackageName(), roomCategoryDto.getPackagePrice()))) {
            return "SuccessFully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String update(RoomCategoryDto roomCategoryDto) throws Exception {
        if (roomCategoryRepository.update(new RoomCategoryEntity(roomCategoryDto.getCategoryID(), roomCategoryDto.getPackageName(), roomCategoryDto.getPackagePrice()))) {
            return "SuccessFully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String delete(RoomCategoryDto roomCategoryDto) throws Exception {
     RoomCategoryEntity roomCategoryEntity = new RoomCategoryEntity();
        roomCategoryEntity.setCategoryID(roomCategoryDto.getCategoryID());
        if (roomCategoryRepository.delete(roomCategoryEntity)) {
            return "SuccessFully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public RoomCategoryDto get(String id) throws Exception {
        RoomCategoryEntity roomCategoryEntity = roomCategoryRepository.get(id);
        if (roomCategoryEntity != null) {
            return new RoomCategoryDto(
                    roomCategoryEntity.getCategoryID(),
                    roomCategoryEntity.getCategoryID(),
                    roomCategoryEntity.getPackagePrice()
            );

        } else {
            return null;
        }
    }

    @Override
    public List<RoomCategoryDto> getAll() throws Exception {
        List<RoomCategoryDto> roomCategoryDtos = new ArrayList<>();
        List<RoomCategoryEntity> roomCategoryEntities = roomCategoryRepository.getAll();

        for (RoomCategoryEntity e : roomCategoryEntities) {
            roomCategoryDtos.add(new RoomCategoryDto(
                    e.getCategoryID(),
                    e.getPackageName(),
                    e.getPackagePrice()
            ));
        }
        return roomCategoryDtos;

    }

}
