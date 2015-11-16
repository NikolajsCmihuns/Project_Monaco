package janis.monaco.domain.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "REVIEW", schema = "", catalog = "monaco")
public class Review {

    @Id
    @Column(name = "reviewID")
    private int reviewId;

    @Basic
    @Column(name = "creatorID")
    private int creatorId;

    @Basic
    @Column(name = "placeID")
    private Integer placeId;

    @Basic
    @Column(name = "routeID")
    private Integer routeId;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "body")
    private String body;

    @Basic
    @Column(name = "creationDate")
    private Timestamp creationDate;

    @Basic
    @Column(name = "imageUrl")
    private String imageUrl;

    @OneToMany(mappedBy = "reviewByReviewId") // mappedBy = "reviewByReviewId"
    private Collection<CommentOnReview> commentOnReviewsByReviewId;

    @ManyToOne
    @JoinColumn(name = "creatorID", referencedColumnName = "userID", nullable = false,insertable=false, updatable=false)
    private User userByCreatorId;

    @ManyToOne
    @JoinColumn(name = "placeID", referencedColumnName = "placeID", insertable=false, updatable=false)
    private Place placeByPlaceId;

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "routeID", insertable=false, updatable=false)
    private Route routeByRouteId;





    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }


    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }


    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }


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

        Review review = (Review) o;

        if (reviewId != review.reviewId) return false;
        if (creatorId != review.creatorId) return false;
        if (placeId != null ? !placeId.equals(review.placeId) : review.placeId != null) return false;
        if (routeId != null ? !routeId.equals(review.routeId) : review.routeId != null) return false;
        if (title != null ? !title.equals(review.title) : review.title != null) return false;
        if (body != null ? !body.equals(review.body) : review.body != null) return false;
        if (creationDate != null ? !creationDate.equals(review.creationDate) : review.creationDate != null)
            return false;
        if (imageUrl != null ? !imageUrl.equals(review.imageUrl) : review.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + creatorId;
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }


    public Collection<CommentOnReview> getCommentOnReviewsByReviewId() {
        return commentOnReviewsByReviewId;
    }

    public void setCommentOnReviewsByReviewId(Collection<CommentOnReview> commentOnReviewsByReviewId) {
        this.commentOnReviewsByReviewId = commentOnReviewsByReviewId;
    }


    public User getUserByCreatorId() {
        return userByCreatorId;
    }

    public void setUserByCreatorId(User userByCreatorId) {
        this.userByCreatorId = userByCreatorId;
    }


    public Place getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(Place placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }


    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
