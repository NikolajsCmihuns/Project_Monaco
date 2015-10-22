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

    public User(Integer userID, String nickname, String email, String city, String country, String password) {
        this.userID = userID;
        this.nickname = nickname;
        this.email = email;
        this.city = city;
        this.country = country;
        this.password = password;
    }

    public Integer getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "-== USER ==-" + "\n" +userID + "\n" + name + "\n" + lastName + "\n" + nickname + "\n" + email + "\n" + age + "\n" + city + "\n" + country + "\n" +  userTag + "\n" + reviews + "\n" + routes + "\n" + "-========-";
    }
}
