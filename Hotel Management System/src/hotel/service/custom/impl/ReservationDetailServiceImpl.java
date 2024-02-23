/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.service.custom.impl;

import hotel.dto.ReservationDetailDto;
import hotel.entity.ReservationDetailEntity;
import hotel.repository.RepositoryFactory;
import hotel.repository.custom.ReservationDetailRepository;
import hotel.service.custom.ReservationDetailService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanjaya
 */
public class ReservationDetailServiceImpl implements ReservationDetailService {

    private ReservationDetailRepository reservationDetailRepository = (ReservationDetailRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.RESERVATION_DETAIL);

    @Override
    public List<ReservationDetailDto> getAll() throws Exception {
        List<ReservationDetailDto> reservationDetailDtos = new ArrayList<>();
        List<ReservationDetailEntity> ReservationDetailEntities = reservationDetailRepository.getAll();

        for (ReservationDetailEntity e : ReservationDetailEntities) {
            reservationDetailDtos.add(new ReservationDetailDto(
                    e.getReservationID(),
                    e.getRoomID(),
                    e.getReservationQty(),
                    e.getDiscount()
            )
            );
        }

        return reservationDetailDtos;
    }

}
