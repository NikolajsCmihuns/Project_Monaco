package janis.monaco.domain.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "USER", schema = "", catalog = "monaco")
public class User {
    private int userId;
    private String nickname;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private int cityId;
    private int countryId;
    private Integer userTagId;
    private String userPass;
    private Timestamp creationDate;
    private Collection<CommentOnReview> commentOnReviewsByUserId;
    private Collection<Review> reviewsByUserId;
    private Collection<Route> routesByUserId;
    private CityRef cityRefByCityId;
    private CountryRef countryRefByCountryId;
    private TagsRef tagsRefByUserTagId;

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
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "cityID")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "countryID")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

        User user = (User) o;

        if (userId != user.userId) return false;
        if (cityId != user.cityId) return false;
        if (countryId != user.countryId) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (userTagId != null ? !userTagId.equals(user.userTagId) : user.userTagId != null) return false;
        if (userPass != null ? !userPass.equals(user.userPass) : user.userPass != null) return false;
        if (creationDate != null ? !creationDate.equals(user.creationDate) : user.creationDate != null) return false;

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
        result = 31 * result + cityId;
        result = 31 * result + countryId;
        result = 31 * result + (userTagId != null ? userTagId.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByCommenterId")
    public Collection<CommentOnReview> getCommentOnReviewsByUserId() {
        return commentOnReviewsByUserId;
    }

    public void setCommentOnReviewsByUserId(Collection<CommentOnReview> commentOnReviewsByUserId) {
        this.commentOnReviewsByUserId = commentOnReviewsByUserId;
    }

    @OneToMany(mappedBy = "userByCreatorId")
    public Collection<Review> getReviewsByUserId() {
        return reviewsByUserId;
    }

    public void setReviewsByUserId(Collection<Review> reviewsByUserId) {
        this.reviewsByUserId = reviewsByUserId;
    }

    @OneToMany(mappedBy = "userByCreatorId")
    public Collection<Route> getRoutesByUserId() {
        return routesByUserId;
    }

    public void setRoutesByUserId(Collection<Route> routesByUserId) {
        this.routesByUserId = routesByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "cityID", referencedColumnName = "CITY_NAME_ID", nullable = false, insertable=false, updatable=false)
    public CityRef getCityRefByCityId() {
        return cityRefByCityId;
    }

    public void setCityRefByCityId(CityRef cityRefByCityId) {
        this.cityRefByCityId = cityRefByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "countryID", referencedColumnName = "COUNTRY_NAME_ID", nullable = false, insertable=false, updatable=false)
    public CountryRef getCountryRefByCountryId() {
        return countryRefByCountryId;
    }

    public void setCountryRefByCountryId(CountryRef countryRefByCountryId) {
        this.countryRefByCountryId = countryRefByCountryId;
    }

    @ManyToOne
    @JoinColumn(name = "userTagID", referencedColumnName = "TAG_NAME_ID", insertable=false, updatable=false)
    public TagsRef getTagsRefByUserTagId() {
        return tagsRefByUserTagId;
    }

    public void setTagsRefByUserTagId(TagsRef tagsRefByUserTagId) {
        this.tagsRefByUserTagId = tagsRefByUserTagId;
    }
}
