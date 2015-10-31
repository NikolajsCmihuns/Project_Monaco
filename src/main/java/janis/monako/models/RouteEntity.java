package janis.monako.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "ROUTE", schema = "", catalog = "monaco_test")
public class RouteEntity {
    private int routeId;
    private String distance;
    private String completionTime;
    private Integer routeTagId;
    private Timestamp creationDate;
    private Integer creatorId;
    private Collection<CommentReviewOnRouteEntity> commentReviewOnRoutesByRouteId;
    private Collection<PlacesInRouteEntity> placesInRoutesByRouteId;
    private Collection<ReviewOnRouteEntity> reviewOnRoutesByRouteId;
    private UserEntity userByCreatorId;
    private TagsRefEntity tagsRefByRouteTagId;

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
    public Integer getRouteTagId() {
        return routeTagId;
    }

    public void setRouteTagId(Integer routeTagId) {
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
    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (routeId != that.routeId) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (completionTime != null ? !completionTime.equals(that.completionTime) : that.completionTime != null)
            return false;
        if (routeTagId != null ? !routeTagId.equals(that.routeTagId) : that.routeTagId != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (completionTime != null ? completionTime.hashCode() : 0);
        result = 31 * result + (routeTagId != null ? routeTagId.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<CommentReviewOnRouteEntity> getCommentReviewOnRoutesByRouteId() {
        return commentReviewOnRoutesByRouteId;
    }

    public void setCommentReviewOnRoutesByRouteId(Collection<CommentReviewOnRouteEntity> commentReviewOnRoutesByRouteId) {
        this.commentReviewOnRoutesByRouteId = commentReviewOnRoutesByRouteId;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<PlacesInRouteEntity> getPlacesInRoutesByRouteId() {
        return placesInRoutesByRouteId;
    }

    public void setPlacesInRoutesByRouteId(Collection<PlacesInRouteEntity> placesInRoutesByRouteId) {
        this.placesInRoutesByRouteId = placesInRoutesByRouteId;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<ReviewOnRouteEntity> getReviewOnRoutesByRouteId() {
        return reviewOnRoutesByRouteId;
    }

    public void setReviewOnRoutesByRouteId(Collection<ReviewOnRouteEntity> reviewOnRoutesByRouteId) {
        this.reviewOnRoutesByRouteId = reviewOnRoutesByRouteId;
    }

    @ManyToOne
    @JoinColumn(name = "creatorID", referencedColumnName = "userID")
    public UserEntity getUserByCreatorId() {
        return userByCreatorId;
    }

    public void setUserByCreatorId(UserEntity userByCreatorId) {
        this.userByCreatorId = userByCreatorId;
    }

    @ManyToOne
    @JoinColumn(name = "routeTagID", referencedColumnName = "TAG_NAME_ID")
    public TagsRefEntity getTagsRefByRouteTagId() {
        return tagsRefByRouteTagId;
    }

    public void setTagsRefByRouteTagId(TagsRefEntity tagsRefByRouteTagId) {
        this.tagsRefByRouteTagId = tagsRefByRouteTagId;
    }
}
