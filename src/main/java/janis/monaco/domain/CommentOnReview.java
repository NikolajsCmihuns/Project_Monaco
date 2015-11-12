package janis.monaco.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "COMMENT_ON_REVIEW", schema = "", catalog = "monaco")
public class CommentOnReview {

    @Id
    @Column(name = "commentID")
    private int commentId;

    @Basic
    @Column(name = "commenterID")
    private int commenterId;

    @Basic
    @Column(name = "reviewID")
    private int review;

    @Basic
    @Column(name = "body")
    private String body;

    @Basic
    @Column(name = "commentDate")
    private Date commentDate;

    @ManyToOne
    @JoinColumn(name = "commenterID", referencedColumnName = "userID", nullable = false, insertable=false, updatable=false)
    private User userByCommenterId;

    @ManyToOne
    @JoinColumn(name = "reviewID", referencedColumnName = "reviewID", nullable = false, insertable=false, updatable=false)
    private Review reviewByReviewId;

    @ManyToOne(optional = false)
    private Review reviews;


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }


    public int getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(int commenterId) {
        this.commenterId = commenterId;
    }


    public int getReview() {
        return review;
    }

    public void setReview(int rev) {
        this.review = rev;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentOnReview that = (CommentOnReview) o;

        if (commentId != that.commentId) return false;
        if (commenterId != that.commenterId) return false;
        if (review != that.review) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + commenterId;
        result = 31 * result + review;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        return result;
    }


    public User getUserByCommenterId() {
        return userByCommenterId;
    }

    public void setUserByCommenterId(User userByCommenterId) {
        this.userByCommenterId = userByCommenterId;
    }


    public Review getReviewByReviewId() {
        return reviewByReviewId;
    }

    public void setReviewByReviewId(Review reviewByReviewId) {
        this.reviewByReviewId = reviewByReviewId;
    }


    public Review getReviews() {
        return reviews;
    }

    public void setReviews(Review reviews) {
        this.reviews = reviews;
    }
}
