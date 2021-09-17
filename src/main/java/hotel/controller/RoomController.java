package hotel.controller;

import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.model.Room;
import hotel.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody String newRoom){
        JSONObject json = new JSONObject(newRoom);
        Room room = new Room();
        
        System.out.println("---------PRUEBAAAAAAAAA---"+newRoom);
        room.setBedrooms(json.getInt("bedrooms"));
        room.setBathrooms(json.getInt("bathrooms"));
        return roomService.addRoom(room);
    }
}
