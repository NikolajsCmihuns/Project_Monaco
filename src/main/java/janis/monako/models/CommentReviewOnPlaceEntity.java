package janis.monako.models;

import javax.persistence.*;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "COMMENT_REVIEW_ON_PLACE", schema = "", catalog = "monaco_test")
public class CommentReviewOnPlaceEntity {
    private int commentOnPlaceId;
    private int commenterId;
    private int placeId;
    private String body;
    private UserEntity userByCommenterId;
    private PlaceEntity placeByPlaceId;

    @Id
    @Column(name = "commentOnPlaceID")
    public int getCommentOnPlaceId() {
        return commentOnPlaceId;
    }

    public void setCommentOnPlaceId(int commentOnPlaceId) {
        this.commentOnPlaceId = commentOnPlaceId;
    }

    @Basic
    @Column(name = "commenterID")
    public int getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(int commenterId) {
        this.commenterId = commenterId;
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
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentReviewOnPlaceEntity that = (CommentReviewOnPlaceEntity) o;

        if (commentOnPlaceId != that.commentOnPlaceId) return false;
        if (commenterId != that.commenterId) return false;
        if (placeId != that.placeId) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentOnPlaceId;
        result = 31 * result + commenterId;
        result = 31 * result + placeId;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "commenterID", referencedColumnName = "userID", nullable = false)
    public UserEntity getUserByCommenterId() {
        return userByCommenterId;
    }

    public void setUserByCommenterId(UserEntity userByCommenterId) {
        this.userByCommenterId = userByCommenterId;
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
