package hotel.service;

import hotel.dao.ReservationDao;
import hotel.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    //constructor


    //add new reservation
    public Reservation addReservation(Reservation reservation){
        return reservationDao.save(reservation);
    }

    //verify before add a reservation
    public void verifyReservationById(Reservation reservation){
        if(findReservationById(reservation.getIdReservation())==null){
            addReservation(reservation);
        }else{
            System.out.println("ID is already in the DB");
        }
    }

    //find a reservation by id
    public Optional<Reservation> findReservationById(Long id){
        return reservationDao.findReservationById(id);
    }

    public boolean deleteReservationById(Long id){
        if(findReservationById(id)==null){
            System.out.println("Doesn´t exist the id");
            return false;
        } else{
            reservationDao.deleteReservationById(id);
            return true;
        }
    }

}
