package com.monaco.Entities;

import javax.persistence.*;
import java.util.Optional;

import static javax.persistence.FetchType.*;

/**
 * Created by maksimspuskels on 18/10/15.
 */

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userID" , nullable = true)
    private Integer userID;
    @Column(name="firstName")
    private String  name;
    @Column(name="lastName")
    private String  lastName;
    @Column(name="nickname")
    private String  nickname;
    @Column(name="email")
    private String  email;
    @Column(name="age")
    private Integer age;
    @Column(name="cityID")
    private Integer cityID;
    @Column(name="countryID")
    private Integer countryID;
    @Column(name="userTagID")
    private Integer userTagID;

    @ManyToOne (fetch = LAZY)
    @JoinColumn(name="userTagID", referencedColumnName="TAG_NAME_ID", insertable=false, updatable=false)
    private Tag tag;

    // TODO: check options for secure password storage in DB
    @Column(name="userPass")
    private String  password;

    //  ---===== Constructor ====----
    public User(String nickname, String email, Integer cityID, Integer countryID, String password) {
        this.nickname = nickname;
        this.email = email;
        this.cityID = cityID;
        this.countryID = countryID;
        this.password = password;
    }

    public User() {

    }

    public Optional<Integer> getUserID() {
        return Optional.of(userID);
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setUserID(Optional<Integer> userID) {
        this.userID = userID.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getUserTagID() {
        return userTagID;
    }

    public void setUserTagID(Integer userTagID) {
        this.userTagID = userTagID;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\n" + "-== USER ==-" + "\n" + userID + "\n" + name + "\n" + lastName + "\n" + nickname + "\n" + email + "\n" + age + "\n" + cityID + "\n" + countryID + "\n" + userTagID + "\n" + "-========-" + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getUserID() != null ? !getUserID().equals(user.getUserID()) : user.getUserID() != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (!getNickname().equals(user.getNickname())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (getAge() != null ? !getAge().equals(user.getAge()) : user.getAge() != null) return false;
        if (!getCityID().equals(user.getCityID())) return false;
        if (!getCountryID().equals(user.getCountryID())) return false;
        if (getUserTagID() != null ? !getUserTagID().equals(user.getUserTagID()) : user.getUserTagID() != null)
            return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getUserID() != null ? getUserID().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getNickname().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + getCityID().hashCode();
        result = 31 * result + getCountryID().hashCode();
        result = 31 * result + (getUserTagID() != null ? getUserTagID().hashCode() : 0);
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
