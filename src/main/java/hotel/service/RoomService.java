package hotel.service;

import hotel.dao.RoomDao;
import hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private final RoomDao roomDao;

    //constructor
    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    //find all rooms
    public List<Room> findAllRooms(){
        return (List<Room>) roomDao.findAll();
    }
    //find a room by id
    public Optional<Room> findRoomById(Long id){
        return roomDao.findRoomById(id);
    }
    //add new room
    public Room addRoom(Room room){
        return roomDao.save(room);
    }
}