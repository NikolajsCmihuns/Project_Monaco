package AlexPackage;

/**
 * Created by Aborigens on 23-Oct-15.
 */
public class Action {

    Execute execute;

    public Action() {

    }

    public void setExecute(Execute execute) {
        this.execute = execute;
    }

    public void runAction() {
        this.execute.execute();
    }
}
