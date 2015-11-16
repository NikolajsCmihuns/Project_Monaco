package nikocmihPackage;

/**
 * Created by Nikolajs Cmihuns on 11/16/2015.
 */
public class User {

    private String inputPassword;
    private int inputUserId;
    private String inputNickname;
    private String inputEmail;


    public User(String inputPassword, int inputUserId, String inputNickname, String inputEmail) {
        this.inputPassword = inputPassword;
        this.inputUserId = inputUserId;
        this.inputNickname = inputNickname;
        this.inputEmail = inputEmail;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public int getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(int inputUserId) {
        this.inputUserId = inputUserId;
    }

    public String getInputNickname() {
        return inputNickname;
    }

    public void setInputNickname(String inputNickname) {
        this.inputNickname = inputNickname;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (inputUserId != user.inputUserId) return false;
        if (!inputPassword.equals(user.inputPassword)) return false;
        if (!inputNickname.equals(user.inputNickname)) return false;
        return inputEmail.equals(user.inputEmail);

    }

    @Override
    public int hashCode() {
        int result = inputPassword.hashCode();
        result = 31 * result + inputUserId;
        result = 31 * result + inputNickname.hashCode();
        result = 31 * result + inputEmail.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "inputPassword='" + inputPassword + '\'' +
                ", inputUserId=" + inputUserId +
                ", inputNickname='" + inputNickname + '\'' +
                ", inputEmail='" + inputEmail + '\'' +
                '}';
    }
}
