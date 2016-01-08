package janis.monaco.backup_entities;

import janis.monaco.domain.Place;
import janis.monaco.domain.User;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by janis on 1/8/16.
 */
@Entity
public class Events {
    private int eventId;
    private String eventTitle;
    private String eventDescription;
    private String eventLink;
    private Integer userId;
    private Integer placeId;
    private Timestamp date;
    private User userByUserId;
    private Place placeByPlaceId;

    @Id
    @Column(name = "eventID")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "eventTitle")
    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    @Basic
    @Column(name = "eventDescription")
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Basic
    @Column(name = "eventLink")
    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    @Basic
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "placeID")
    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events events = (Events) o;

        if (eventId != events.eventId) return false;
        if (eventTitle != null ? !eventTitle.equals(events.eventTitle) : events.eventTitle != null) return false;
        if (eventDescription != null ? !eventDescription.equals(events.eventDescription) : events.eventDescription != null)
            return false;
        if (eventLink != null ? !eventLink.equals(events.eventLink) : events.eventLink != null) return false;
        if (userId != null ? !userId.equals(events.userId) : events.userId != null) return false;
        if (placeId != null ? !placeId.equals(events.placeId) : events.placeId != null) return false;
        if (date != null ? !date.equals(events.date) : events.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (eventTitle != null ? eventTitle.hashCode() : 0);
        result = 31 * result + (eventDescription != null ? eventDescription.hashCode() : 0);
        result = 31 * result + (eventLink != null ? eventLink.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "placeID", referencedColumnName = "placeID")
    public Place getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(Place placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }
}
