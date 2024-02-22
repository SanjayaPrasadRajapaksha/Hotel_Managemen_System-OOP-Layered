/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.repository.custom.impl;

import hotel.entity.RoomEntity;
import hotel.repository.CrudUtil;
import hotel.repository.custom.RoomRepository;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sanjaya
 */
public class RoomRepositoryImpl implements RoomRepository {

    @Override
    public boolean save(RoomEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Room VALUES (?,?,?)", t.getRoomID(), t.getCategoryID(), t.getQuantity());

    }

    @Override
    public boolean update(RoomEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Room SET CategoryID=?,Quantity=? WHERE  RoomID=?",
                t.getCategoryID(),
                t.getQuantity(),
                t.getRoomID()
        );
    }

    @Override
    public boolean delete(RoomEntity t) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM Room WHERE RoomID=?",
                t.getCategoryID());
    }

    @Override
    public RoomEntity get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Room WHERE RoomID=?", id);

        while (resultSet.next()) {
            return new RoomEntity(
                    resultSet.getString("RoomID"),
                    resultSet.getString("CategoryID"),
                    resultSet.getInt("Quantity")
            );

        }
        return null;
    }

    @Override
    public List<RoomEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Room");
        List<RoomEntity> roomEntities = new ArrayList<>();
        while (resultSet.next()) {
            roomEntities.add(new RoomEntity(
                    resultSet.getString("RoomID"),
                    resultSet.getString("CategoryID"),
                    resultSet.getInt("Quantity")
            ));

        }
        return roomEntities;
    }
}
