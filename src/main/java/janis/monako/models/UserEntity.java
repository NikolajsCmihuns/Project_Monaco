package janis.monako.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "USER", schema = "", catalog = "monaco_test")
public class UserEntity {
    private int userId;
    private String nickname;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String city;
    private String country;
    private Integer userTagId;
    private String userPass;
    private Timestamp creationDate;
    private Collection<CommentReviewOnPlaceEntity> commentReviewOnPlacesByUserId;
    private Collection<CommentReviewOnRouteEntity> commentReviewOnRoutesByUserId;
    private Collection<ReviewOnPlaceEntity> reviewOnPlacesByUserId;
    private Collection<ReviewOnRouteEntity> reviewOnRoutesByUserId;
    private Collection<RouteEntity> routesByUserId;
    private TagsRefEntity tagsRefByUserTagId;

    @Id
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "userTagID")
    public Integer getUserTagId() {
        return userTagId;
    }

    public void setUserTagId(Integer userTagId) {
        this.userTagId = userTagId;
    }

    @Basic
    @Column(name = "userPass")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "creationDate")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (userTagId != null ? !userTagId.equals(that.userTagId) : that.userTagId != null) return false;
        if (userPass != null ? !userPass.equals(that.userPass) : that.userPass != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (userTagId != null ? userTagId.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByCommenterId")
    public Collection<CommentReviewOnPlaceEntity> getCommentReviewOnPlacesByUserId() {
        return commentReviewOnPlacesByUserId;
    }

    public void setCommentReviewOnPlacesByUserId(Collection<CommentReviewOnPlaceEntity> commentReviewOnPlacesByUserId) {
        this.commentReviewOnPlacesByUserId = commentReviewOnPlacesByUserId;
    }

    @OneToMany(mappedBy = "userByCommenterId")
    public Collection<CommentReviewOnRouteEntity> getCommentReviewOnRoutesByUserId() {
        return commentReviewOnRoutesByUserId;
    }

    public void setCommentReviewOnRoutesByUserId(Collection<CommentReviewOnRouteEntity> commentReviewOnRoutesByUserId) {
        this.commentReviewOnRoutesByUserId = commentReviewOnRoutesByUserId;
    }

    @OneToMany(mappedBy = "userByCreatorId")
    public Collection<ReviewOnPlaceEntity> getReviewOnPlacesByUserId() {
        return reviewOnPlacesByUserId;
    }

    public void setReviewOnPlacesByUserId(Collection<ReviewOnPlaceEntity> reviewOnPlacesByUserId) {
        this.reviewOnPlacesByUserId = reviewOnPlacesByUserId;
    }

    @OneToMany(mappedBy = "userByCreatorId")
    public Collection<ReviewOnRouteEntity> getReviewOnRoutesByUserId() {
        return reviewOnRoutesByUserId;
    }

    public void setReviewOnRoutesByUserId(Collection<ReviewOnRouteEntity> reviewOnRoutesByUserId) {
        this.reviewOnRoutesByUserId = reviewOnRoutesByUserId;
    }

    @OneToMany(mappedBy = "userByCreatorId")
    public Collection<RouteEntity> getRoutesByUserId() {
        return routesByUserId;
    }

    public void setRoutesByUserId(Collection<RouteEntity> routesByUserId) {
        this.routesByUserId = routesByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "userTagID", referencedColumnName = "TAG_NAME_ID")
    public TagsRefEntity getTagsRefByUserTagId() {
        return tagsRefByUserTagId;
    }

    public void setTagsRefByUserTagId(TagsRefEntity tagsRefByUserTagId) {
        this.tagsRefByUserTagId = tagsRefByUserTagId;
    }
}
