package MaximPackage.Servlet.MVC.DataSources;

import java.util.Optional;

/**
 * Created by maksimspuskels on 25/11/15.
 */
public class LoginActionDataSource {
    private String userNickname;

    public LoginActionDataSource(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserNickname() {
        return userNickname;
    }
}
