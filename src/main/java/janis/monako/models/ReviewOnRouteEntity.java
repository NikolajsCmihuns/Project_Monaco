package janis.monako.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "REVIEW_ON_ROUTE", schema = "", catalog = "monaco_test")
public class ReviewOnRouteEntity {
    private int reviewOnRouteId;
    private int routeId;
    private int creatorId;
    private String title;
    private String body;
    private Timestamp creationDate;
    private String imageUrl;
    private UserEntity userByCreatorId;
    private RouteEntity routeByRouteId;

    @Id
    @Column(name = "reviewOnRouteID")
    public int getReviewOnRouteId() {
        return reviewOnRouteId;
    }

    public void setReviewOnRouteId(int reviewOnRouteId) {
        this.reviewOnRouteId = reviewOnRouteId;
    }

    @Basic
    @Column(name = "routeID")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "creatorID")
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
    @Column(name = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewOnRouteEntity that = (ReviewOnRouteEntity) o;

        if (reviewOnRouteId != that.reviewOnRouteId) return false;
        if (routeId != that.routeId) return false;
        if (creatorId != that.creatorId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewOnRouteId;
        result = 31 * result + routeId;
        result = 31 * result + creatorId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "creatorID", referencedColumnName = "userID", nullable = false)
    public UserEntity getUserByCreatorId() {
        return userByCreatorId;
    }

    public void setUserByCreatorId(UserEntity userByCreatorId) {
        this.userByCreatorId = userByCreatorId;
    }

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "routeID", nullable = false)
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
