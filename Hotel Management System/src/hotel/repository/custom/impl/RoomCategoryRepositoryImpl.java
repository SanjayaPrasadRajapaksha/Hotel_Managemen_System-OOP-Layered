/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.repository.custom.impl;

import hotel.entity.RoomCategoryEntity;
import hotel.repository.CrudUtil;
import hotel.repository.custom.RoomCategoryRepository;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sanjaya
 */
public class RoomCategoryRepositoryImpl implements RoomCategoryRepository {

    @Override
    public boolean save(RoomCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Room_Category VALUES (?,?,?)", t.getCategoryID(), t.getPackageName(), t.getPackagePrice());
    }

    @Override
    public boolean update(RoomCategoryEntity t) throws Exception {
     return CrudUtil.executeUpdate("UPDATE Room_Category SET PackageName=?,PackagePrice=? WHERE  CategoryID=?",
                t.getPackageName(),
                t.getPackagePrice(),
                t.getCategoryID()
                );
    }

    @Override
    public boolean delete(RoomCategoryEntity t) throws Exception {
      return CrudUtil.executeUpdate("DELETE FROM Room_Category WHERE CategoryID=?",
                t.getCategoryID());
    }

    @Override
    public RoomCategoryEntity get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Room_Category WHERE CategoryID=?", id);

        while (resultSet.next()) {
            return new RoomCategoryEntity(
                    resultSet.getString("CategoryID"),
                    resultSet.getString("PackageName"),
                    resultSet.getDouble("PackagePrice")
            );

        }
        return null;
    }

    @Override
    public List<RoomCategoryEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Room_Category");
        List<RoomCategoryEntity> RoomCategoryEntities = new ArrayList<>();
        while (resultSet.next()) {
            RoomCategoryEntities.add(new RoomCategoryEntity(
                    resultSet.getString("CategoryID"),
                    resultSet.getString("PackageName"),
                    resultSet.getDouble("PackagePrice")
            ));

        }
        return RoomCategoryEntities;
    }

}
