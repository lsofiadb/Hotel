package hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.model.Reservation;
import hotel.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    ReservationService reservationService;


    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody String newReservation) throws ParseException{
        JSONObject json = new JSONObject(newReservation);
        Reservation reservation= new Reservation();

        System.out.println("---------PRUEBAAAAAAAAA---"+newReservation);
        SimpleDateFormat variable = new SimpleDateFormat("MM/dd/yyyy");
        String cin = json.getString("checkout");
        Date checkout = variable.parse(cin);
        Date checkin = variable.parse(json.getString("checkin"));
        reservation.setCheckin(checkin);
        reservation.setCheckin(checkout);

        return reservationService.addReservation(reservation);
    }
}
