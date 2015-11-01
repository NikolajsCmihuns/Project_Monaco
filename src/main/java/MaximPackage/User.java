package MaximPackage;

/**
 * Created by maksimspuskels on 18/10/15.
 */
public class User {

    private Integer userID;
    private String  name;
    private String  lastName;
    private String  nickname;
    private String  email;
    private Integer age;
    private Integer cityID;
    private Integer countryID;
    private Integer userTagID;
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
    public Integer getUserID() {
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

    public Integer getAge() {
        return age;
    }

    public Integer getCityID() {
        return cityID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public Integer getUserTagID() {
        return userTagID;
    }

    public String getPassword() {
        return password;
    }

    //  ---===== Setters ====----
    public void setUserID(Integer userID) {
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

    public void setUserTagID(Integer userTagID) {
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

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public void setCountryID(Integer countryID) {
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

        if (!getUserID().equals(user.getUserID())) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (!getNickname().equals(user.getNickname())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (getAge() != null ? !getAge().equals(user.getAge()) : user.getAge() != null) return false;
        if (!cityID.equals(user.cityID)) return false;
        if (!countryID.equals(user.countryID)) return false;
        if (userTagID != null ? !userTagID.equals(user.userTagID) : user.userTagID != null) return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getUserID().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getNickname().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + cityID.hashCode();
        result = 31 * result + countryID.hashCode();
        result = 31 * result + (userTagID != null ? userTagID.hashCode() : 0);
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
