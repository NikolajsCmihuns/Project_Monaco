package MaximPackage.Entities;

import java.util.Optional;

/**
 * Created by maksimspuskels on 18/10/15.
 */
public class User {

    public final static Integer USER_NOT_FOUND = -9999;

    private Optional<Integer> userID;
    private String  name;
    private String  lastName;
    private String  nickname;
    private String  email;
    private int age;
    private int cityID;
    private int countryID;
    private int userTagID;
    private String  password;

    //  ---===== Constructor ====----
    public User(String nickname, String email, Integer cityID, Integer countryID, String password) {
        this.nickname = nickname;
        this.email = email;
        this.cityID = cityID;
        this.countryID = countryID;
        this.password = password;
    }

    //  ---===== Getters ====----
    public Optional<Integer> getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getCityID() {
        return cityID;
    }

    public int getCountryID() {
        return countryID;
    }

    public int getUserTagID() {
        return userTagID;
    }

    public String getPassword() {
        return password;
    }

    //  ---===== Setters ====----
    public void setUserID(Optional<Integer> userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUserTagID(int userTagID) {
        this.userTagID = userTagID;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "-== USER ==-" + "\n" + userID + "\n" + name + "\n" + lastName + "\n" + nickname + "\n" + email + "\n" + age + "\n" + cityID + "\n" + countryID + "\n" + userTagID + "\n" + "-========-";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (getCityID() != user.getCityID()) return false;
        if (getCountryID() != user.getCountryID()) return false;
        if (getUserTagID() != user.getUserTagID()) return false;
        if (!getUserID().equals(user.getUserID())) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (!getNickname().equals(user.getNickname())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getUserID().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getNickname().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getCityID();
        result = 31 * result + getCountryID();
        result = 31 * result + getUserTagID();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
