package janis.monaco.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "COMMENT_ON_REVIEW", schema = "", catalog = "monaco")
public class CommentOnReview {
    private int commentId;
    private int commenterId;
    private int reviewId;
    private String body;
    private Date commentDate;
    private User userByCommenterId;
    private Review reviewByReviewId;

    @Id
    @Column(name = "commentID")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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
    @Column(name = "reviewID")
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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
    @Column(name = "commentDate")
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
        if (reviewId != that.reviewId) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + commenterId;
        result = 31 * result + reviewId;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "commenterID", referencedColumnName = "userID", nullable = false)
    public User getUserByCommenterId() {
        return userByCommenterId;
    }

    public void setUserByCommenterId(User userByCommenterId) {
        this.userByCommenterId = userByCommenterId;
    }

    @ManyToOne
    @JoinColumn(name = "reviewID", referencedColumnName = "reviewID", nullable = false)
    public Review getReviewByReviewId() {
        return reviewByReviewId;
    }

    public void setReviewByReviewId(Review reviewByReviewId) {
        this.reviewByReviewId = reviewByReviewId;
    }
}
