/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom.impl;

import hotel.dto.RoomDto;
import hotel.entity.RoomEntity;
import hotel.repository.RepositoryFactory;
import hotel.repository.custom.RoomRepository;
import hotel.service.custom.RoomService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOM);

    @Override
    public String save(RoomDto roomDto) throws Exception {
        if (roomRepository.save(new RoomEntity(roomDto.getRoomID(), roomDto.getCategoryID(), roomDto.getQuantity()))) {
            return "SuccessFully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String update(RoomDto roomDto) throws Exception {
        if (roomRepository.update(new RoomEntity(roomDto.getRoomID(), roomDto.getCategoryID(), roomDto.getQuantity()))) {
            return "SuccessFully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String delete(RoomDto roomDto) throws Exception {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setCategoryID(roomDto.getRoomID());
        if (roomRepository.delete(roomEntity)) {
            return "SuccessFully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public RoomDto get(String id) throws Exception {
        RoomEntity roomEntity = roomRepository.get(id);
        if (roomEntity != null) {
            return new RoomDto(
                    roomEntity.getRoomID(),
                    roomEntity.getCategoryID(),
                    roomEntity.getQuantity()
            );

        } else {
            return null;
        }
    }

    @Override
    public List<RoomDto> getAll() throws Exception {
        List<RoomDto> roomDtos = new ArrayList<>();
        List<RoomEntity> roomEntities = roomRepository.getAll();

        for (RoomEntity e : roomEntities) {
            roomDtos.add(new RoomDto(
                    e.getRoomID(),
                    e.getCategoryID(),
                    e.getQuantity()
            ));
        }
        return roomDtos;

    }

}
