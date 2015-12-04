package VadimPackage.Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Prilepishev Vadim on 04.12.2015.
 */

@Entity
@Table(name = "event")
public class EventEntity {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int event_id;

    @Column(name = "event")
    private String event;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "place_id")
    private int place_id;

    @Column(name = "event_date")
    private Date event_date;

    public void setEvent_id(int event_id) { this.event_id = event_id; }

    public void setEvent(String event) { this.event = event; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getEvent_id() { return event_id; }

    public String getEvent() { return event; }

    public int getUser_id() { return user_id; }

    public int getPlace_id() { return place_id; }

    public Date getEvent_date() { return event_date; }

}
