package hotel.dao;

import hotel.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationDao extends CrudRepository<Reservation,Long> {
    Optional<Reservation> findReservationById(Long id);

    void deleteReservationById(Long id);
}
