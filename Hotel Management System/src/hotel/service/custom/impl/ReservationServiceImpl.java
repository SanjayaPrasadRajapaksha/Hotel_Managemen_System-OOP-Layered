/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom.impl;

import hotel.db.DBConnection;
import hotel.dto.ReservationDetailDto;
import hotel.dto.ReservationDto;
import hotel.entity.ReservationDetailEntity;
import hotel.entity.ReservationEntity;
import hotel.entity.RoomEntity;
import hotel.repository.RepositoryFactory;
import hotel.repository.custom.ReservationDetailRepository;
import hotel.repository.custom.ReservationRepository;
import hotel.repository.custom.RoomRepository;
import hotel.service.custom.ReservationService;
import java.sql.Connection;

/**
 *
 * @author Sanjaya
 */
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository = (ReservationRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.RESERVATION);
    private ReservationDetailRepository reservationDetailRepository = (ReservationDetailRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.RESERVATION_DETAIL);
    private RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOM);

    @Override
    public String book(ReservationDto reservationDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            ReservationEntity reservationEntity = new ReservationEntity();
            reservationEntity.setReservationID(reservationDto.getReservationID());
            reservationEntity.setCustID(reservationDto.getCustID());

            if (reservationRepository.save(reservationEntity)) {

                boolean isReservationDetailSaved = true;

                for (ReservationDetailDto e : reservationDto.getResevationDetailDtos()) {
                    if (!reservationDetailRepository.save(new ReservationDetailEntity(reservationDto.getReservationID(), e.getRoomID(), e.getQuantity(), e.getDiscount()))) {
                        isReservationDetailSaved = false;
                    }
                }

                if (isReservationDetailSaved) {

                    boolean isRoomUpdated = true;
                    for (ReservationDetailDto e : reservationDto.getResevationDetailDtos()) {
                        RoomEntity roomEntity = roomRepository.get(e.getRoomID());
                        if (roomEntity != null) {
                            roomEntity.setQuantity(roomEntity.getQuantity() - e.getQuantity());

                            if (!roomRepository.update(roomEntity)) {
                                isRoomUpdated = false;
                            }
                        }
                    }

                    if (isRoomUpdated) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Reservation Update Error";
                    }

                } else {
                    connection.rollback();
                    return "Reservation Details Save Error";
                }

            } else {
                connection.rollback();
                return "Reservation Save Error";
            }

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ReservationDto get(String id) throws Exception {
        ReservationEntity reservationEntity = reservationRepository.get(id);

        if (reservationEntity != null) {
            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setReservationID(reservationEntity.getReservationID());
            reservationDto.setReservationDate(reservationEntity.getReservationDate());
            reservationDto.setCancellationDeadline(reservationEntity.getCancellationDeadline());
            reservationDto.setCustID(reservationEntity.getCustID());

            return reservationDto;

        } else {
            return null;
        }
    }

    @Override
    public String cancel(ReservationDto reservationDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            ReservationEntity reservationEntity = new ReservationEntity();
            reservationEntity.setReservationID(reservationDto.getReservationID());

            if (reservationRepository.delete(reservationEntity)) {

                boolean isRoomUpdated = true;
                for (ReservationDetailDto e : reservationDto.getResevationDetailDtos()) {
                    RoomEntity roomEntity = roomRepository.get(e.getRoomID());
                    if (roomEntity != null) {
                        roomEntity.setQuantity(roomEntity.getQuantity() + e.getQuantity());

                        if (!roomRepository.update(roomEntity)) {
                            isRoomUpdated = false;
                        }
                    }
                }

                if (isRoomUpdated) {
                    connection.commit();
                    return "Success";
                } else {
                    connection.rollback();
                    return "Reservation Update Error";
                }

            } else {
                connection.rollback();
                return "Reservation Delete Error";
            }

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
