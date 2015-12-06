package VadimPackage.Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Prilepishev Vadim on 04.12.2015.
 */

@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @Column(name = "eventID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;

    @Column(name = "eventTitle")
    private String eventTitle;

    @Column(name = "eventDescription")
    private String eventDescription;

    @Column(name = "eventLink")
    private String eventLink;

    @Column(name = "userID")
    private int userID;

    @Column(name = "placeID")
    private int placeID;

    @Column(name = "date")
    private Date eventDate;

    public void setEventId(int eventId) { this.eventId = eventId; }

    public void setEventTitle(String eventTitle) { this.eventTitle = eventTitle; }

    public void setEventDescription(String eventDescription) { this.eventDescription = eventDescription; }

    public void setEventLink(String eventLink) { this.eventLink = eventLink; }

    public void setUserID(int userID) { this.userID = userID; }

    public void setPlaceID(int placeID) { this.placeID = placeID; }

    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public int getEventId() { return eventId; }

    public String getEventTitle() { return eventTitle; }

    public String getEventDescription() { return eventDescription; }

    public String getEventLink() { return eventLink; }

    public int getUserID() { return userID; }

    public int getPlaceID() { return placeID; }

    public Date getEventDate() { return eventDate; }

}
