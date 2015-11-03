package janis.monakoTest.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "REVIEW_ON_PLACE", schema = "", catalog = "monaco_test")
public class ReviewOnPlaceEntity {
    private int reviewOnPlaceId;
    private int placeId;
    private int creatorId;
    private String title;
    private String body;
    private Timestamp creationDate;
    private String imageUrl;
    private UserEntity userByCreatorId;
    private PlaceEntity placeByPlaceId;

    @Id
    @Column(name = "reviewOnPlaceID")
    public int getReviewOnPlaceId() {
        return reviewOnPlaceId;
    }

    public void setReviewOnPlaceId(int reviewOnPlaceId) {
        this.reviewOnPlaceId = reviewOnPlaceId;
    }

    @Basic
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
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

        ReviewOnPlaceEntity that = (ReviewOnPlaceEntity) o;

        if (reviewOnPlaceId != that.reviewOnPlaceId) return false;
        if (placeId != that.placeId) return false;
        if (creatorId != that.creatorId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewOnPlaceId;
        result = 31 * result + placeId;
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
    @JoinColumn(name = "placeID", referencedColumnName = "placeID", nullable = false)
    public PlaceEntity getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(PlaceEntity placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }
}
