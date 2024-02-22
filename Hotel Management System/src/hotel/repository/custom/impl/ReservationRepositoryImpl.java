/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.repository.custom.impl;

import hotel.entity.ReservationEntity;
import hotel.repository.CrudUtil;
import hotel.repository.custom.ReservationRepository;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class ReservationRepositoryImpl implements ReservationRepository {

    @Override
    public boolean save(ReservationEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Reservation VALUES (?,?,?,?)",
                t.getReservationID(),
                t.getReservationDate(),
                t.getCancellationDeadline(),
                t.getCustID()
        );
    }

    @Override
    public boolean update(ReservationEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(ReservationEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ReservationEntity get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservationEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
