package hotel.model;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Room implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) //nobody can modify
    private Long id;
    @Column
    private int bedrooms; //amount
    @Column
    private int bathrooms; //amount

    public Room(Long idRoom, int bedrooms, int bathrooms) {
        this.id = idRoom;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }


    public Long getIdRoom() {
        return id;
    }

    public void setIdRoom(Long idRoom) {
        this.id = idRoom;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + id +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                '}';
    }
}
