package hotel.dao;

import hotel.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomDao extends CrudRepository<Room,Long> {

    Optional<Room> findRoomById(Long id);
}
