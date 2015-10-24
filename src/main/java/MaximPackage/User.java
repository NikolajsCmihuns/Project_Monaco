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

    public Integer getAge() {
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

    @Override
    public String toString() {
        return "-== USER ==-" + "\n" + userID + "\n" + name + "\n" + lastName + "\n" + nickname + "\n" + email + "\n" + age + "\n" + city + "\n" + country + "\n" + userTag + "\n" + reviews + "\n" + routes + "\n" + "-========-";
    }
}
