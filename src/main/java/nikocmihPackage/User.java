package nikocmihPackage;

/**
 * Created by Nikolajs Cmihuns on 19/10/2015.
 */
public class User {
    // class variables
    private Integer userId;
    private String userPass;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String age;
    private String city;
    private String country;
    private String userTag;


    //Constructor

    public User(String userPass, Integer userId, String nickName, String email, String city, String country) {
        this.userPass = userPass;
        this.userId = userId;
        this.nickName = nickName;
        this.email = email;
        this.city = city;
        this.country = country;
    }




    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", nickName='" + nickName + '\'' + ", email='" + email + '\'' + ", country='" + country + '\'' + ", city='" + city + '\'' + '}';
    }






}
