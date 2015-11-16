package janis.monaco.domain.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "ROUTE", schema = "", catalog = "monaco")
public class Route {
    private int routeId;
    private String distance;
    private String completionTime;
    private int routeTagId;
    private Timestamp creationDate;
    private int creatorId;
    private Collection<PlacesInRoute> placesInRoutesByRouteId;
    private Collection<Review> reviewsByRouteId;
    private User userByCreatorId;
    private TagsRef tagsRefByRouteTagId;

    @Id
    @Column(name = "routeID")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "distance")
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    @Basic
    @Column(name = "routeTagID")
    public int getRouteTagId() {
        return routeTagId;
    }

    public void setRouteTagId(int routeTagId) {
        this.routeTagId = routeTagId;
    }

    @Basic
    @Column(name = "creationDate")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "creatorID")
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (routeId != route.routeId) return false;
        if (routeTagId != route.routeTagId) return false;
        if (creatorId != route.creatorId) return false;
        if (distance != null ? !distance.equals(route.distance) : route.distance != null) return false;
        if (completionTime != null ? !completionTime.equals(route.completionTime) : route.completionTime != null)
            return false;
        if (creationDate != null ? !creationDate.equals(route.creationDate) : route.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (completionTime != null ? completionTime.hashCode() : 0);
        result = 31 * result + routeTagId;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + creatorId;
        return result;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<PlacesInRoute> getPlacesInRoutesByRouteId() {
        return placesInRoutesByRouteId;
    }

    public void setPlacesInRoutesByRouteId(Collection<PlacesInRoute> placesInRoutesByRouteId) {
        this.placesInRoutesByRouteId = placesInRoutesByRouteId;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<Review> getReviewsByRouteId() {
        return reviewsByRouteId;
    }

    public void setReviewsByRouteId(Collection<Review> reviewsByRouteId) {
        this.reviewsByRouteId = reviewsByRouteId;
    }

    @ManyToOne
    @JoinColumn(name = "creatorID", referencedColumnName = "userID", nullable = false, insertable=false, updatable=false)
    public User getUserByCreatorId() {
        return userByCreatorId;
    }

    public void setUserByCreatorId(User userByCreatorId) {
        this.userByCreatorId = userByCreatorId;
    }

    @ManyToOne
    @JoinColumn(name = "routeTagID", referencedColumnName = "TAG_NAME_ID", nullable = false, insertable=false, updatable=false)
    public TagsRef getTagsRefByRouteTagId() {
        return tagsRefByRouteTagId;
    }

    public void setTagsRefByRouteTagId(TagsRef tagsRefByRouteTagId) {
        this.tagsRefByRouteTagId = tagsRefByRouteTagId;
    }
}
