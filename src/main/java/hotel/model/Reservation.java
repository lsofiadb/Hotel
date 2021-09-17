package hotel.model;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) //nobody can modify
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkout;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkin;
    @Column
    private int guests; //amount
    //@Column(nullable = false, updatable = false) //nobody can modify
   // private Long idCustomer;
   // @Column(nullable = false, updatable = false) //nobody can modify
  //  private Long idCuarto;

    //Foreign Keys
    @OneToOne
    private Customer customer;
    @OneToOne
    private Room room;

    //Constructor
    public Reservation(Long idReservation, Date checkout, Date checkin, int guests, Customer customer, Room room) {
        this.id = idReservation;
        this.checkout = checkout;
        this.checkin = checkin;
        this.guests = guests;
      //  this.idCustomer = customer.getId();
      //  this.idCuarto = room.getIdRoom();
    }

    public Reservation(){
        super();
    }

    //Getters and Setters
    public Long getIdReservation() {
        return id;
    }

    public void setIdReservation(Long idReservation) {
        this.id = idReservation;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }


    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



}
