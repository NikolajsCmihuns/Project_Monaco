package com.monaco.Entities;

/**
 * Created by maksimspuskels on 15/12/15.
 */

public class UserBuilder {
    
    private Integer userID;
    private String  name;
    private String  lastName;
    private String  nickname;
    private String  email;
    private Integer age;
    private Integer cityID;
    private Integer countryID;
    private Integer userTagID;
    private Tag tag;
    private String  password;
    
    private UserBuilder() {
        
    }
    
    public static UserBuilder createUser() {
        return new UserBuilder();
    }


    public UserBuilder withUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserBuilder withCityID(Integer cityID) {
        this.cityID = cityID;
        return this;
    }

    public UserBuilder withCountryID(Integer countryID) {
        this.countryID = countryID;
        return this;
    }

    public UserBuilder withUserTagID(Integer userTagID) {
        this.userTagID = userTagID;
        return this;
    }

    public UserBuilder withTag(Tag tag) {
        this.tag = tag;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        User createdUser = new User(this.nickname, this.email, this.cityID, this.countryID, this.password);
        createdUser.setAge(this.age);
        createdUser.setTag(this.tag);
        createdUser.setName(this.name);
        createdUser.setLastName(this.lastName);
        createdUser.setUserTagID(this.userTagID);
        return createdUser;
    }
}
