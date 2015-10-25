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
    private int age;
    private String  city;
    private String  country;
    private String  userTag;
    private String  password;

    private Review  reviews;

    private Route  routes;

    //  ---===== Constructor ====----
    public User(String nickname, String email, String city, String country, String password) {
        this.nickname = nickname;
        this.email = email;
        this.city = city;
        this.country = country;
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

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getUserTag() {
        return userTag;
    }

    public String getPassword() {
        return password;
    }

    public Review getReviews() {
        return reviews;
    }

    public Route getRoutes() {
        return routes;
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

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public void setReviews(Review reviews) {
        this.reviews = reviews;
    }

    public void setRoutes(Route routes) {
        this.routes = routes;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "-== USER ==-" + "\n" + userID + "\n" + name + "\n" + lastName + "\n" + nickname + "\n" + email + "\n" + age + "\n" + city + "\n" + country + "\n" + userTag + "\n" + reviews + "\n" + routes + "\n" + "-========-";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (getUserID() != null ? !getUserID().equals(user.getUserID()) : user.getUserID() != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (!getNickname().equals(user.getNickname())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getCity().equals(user.getCity())) return false;
        if (!getCountry().equals(user.getCountry())) return false;
        if (getUserTag() != null ? !getUserTag().equals(user.getUserTag()) : user.getUserTag() != null) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getReviews() != null ? !getReviews().equals(user.getReviews()) : user.getReviews() != null) return false;
        return !(getRoutes() != null ? !getRoutes().equals(user.getRoutes()) : user.getRoutes() != null);

    }

    @Override
    public int hashCode() {
        int result = getUserID() != null ? getUserID().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getNickname().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + (getUserTag() != null ? getUserTag().hashCode() : 0);
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getReviews() != null ? getReviews().hashCode() : 0);
        result = 31 * result + (getRoutes() != null ? getRoutes().hashCode() : 0);
        return result;
    }
}
