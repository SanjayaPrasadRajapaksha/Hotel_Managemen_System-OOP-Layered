/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.repository.custom.impl;

import hotel.entity.ReservationDetailEntity;
import hotel.repository.CrudUtil;
import hotel.repository.custom.ReservationDetailRepository;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Sanjaya
 */
public class ReservationDetailRepositoryImpl implements ReservationDetailRepository {

    @Override
    public boolean save(ReservationDetailEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Reservation_Detail VALUES (?,?,?,?)",
                t.getReservationID(),
                t.getRoomID(),
                t.getReservationQty(),
                t.getDiscount()
        );
    }

    @Override
    public boolean update(ReservationDetailEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(ReservationDetailEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ReservationDetailEntity get(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservationDetailEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Reservation_Detail");
        List<ReservationDetailEntity> reservationDetailEntities = new ArrayList<>();
        while (resultSet.next()) {
            reservationDetailEntities.add(new ReservationDetailEntity(
                    resultSet.getString("ReservationID"),
                    resultSet.getString("RoomID"),
                    resultSet.getInt("ReservationQty"),
                    resultSet.getInt("Discount")
            ));

        }
        return reservationDetailEntities;
    }

}
