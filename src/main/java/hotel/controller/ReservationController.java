package hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.model.Customer;
import hotel.model.Reservation;
import hotel.model.Room;
import hotel.service.CustomerService;
import hotel.service.ReservationService;
import hotel.service.RoomService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    CustomerService customerService;
    @Autowired
    RoomService roomService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody String newReservation) throws ParseException{
        JSONObject json = new JSONObject(newReservation);
        Reservation reservation= new Reservation();

        System.out.println("---------PRUEBAAAAAAAAA---"+newReservation);
        SimpleDateFormat variable = new SimpleDateFormat("MM/dd/yyyy");

        //New Customer
        Customer newCustomer = new Customer();
        JSONObject json2 = json.getJSONObject("customer");
        String a = json2.toString();
        System.out.println("---------NAME:---"+a);
        if(customerService.findCustomerByName(json2.getString("name"))!=null){
            newCustomer = customerService.findCustomerByName(json2.getString("name")).get();
        }
        

        //New Room
        Room newRoom = new Room();
        JSONObject json3 = json.getJSONObject("room");
        if(roomService.findRoomById(json3.getLong("numeroCuarto"))!=null){
            newRoom = roomService.findRoomById(json3.getLong("numeroCuarto")).get();
        }

        //Conversion
        JSONObject json4 = json.getJSONObject("reserva");
        Date checkout = variable.parse(json4.getString("checkout"));
        Date checkin = variable.parse(json4.getString("checkin"));
        reservation.setGuests(json4.getInt("guests"));
        reservation.setCheckin(checkin);
        reservation.setCheckout(checkout);

        reservation.setCustomer(newCustomer);
        reservation.setRoom(newRoom);

        return reservationService.addReservation(reservation);
    }
}
