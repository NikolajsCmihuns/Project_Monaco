package janis.monako.models;

import javax.persistence.*;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "COMMENT_REVIEW_ON_ROUTE", schema = "", catalog = "monaco_test")
public class CommentReviewOnRouteEntity {
    private int commentOnRouteId;
    private int commenterId;
    private int routeId;
    private String body;
    private UserEntity userByCommenterId;
    private RouteEntity routeByRouteId;

    @Id
    @Column(name = "commentOnRouteID")
    public int getCommentOnRouteId() {
        return commentOnRouteId;
    }

    public void setCommentOnRouteId(int commentOnRouteId) {
        this.commentOnRouteId = commentOnRouteId;
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
    @Column(name = "routeID")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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

        CommentReviewOnRouteEntity that = (CommentReviewOnRouteEntity) o;

        if (commentOnRouteId != that.commentOnRouteId) return false;
        if (commenterId != that.commenterId) return false;
        if (routeId != that.routeId) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentOnRouteId;
        result = 31 * result + commenterId;
        result = 31 * result + routeId;
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
    @JoinColumn(name = "routeID", referencedColumnName = "routeID", nullable = false)
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
