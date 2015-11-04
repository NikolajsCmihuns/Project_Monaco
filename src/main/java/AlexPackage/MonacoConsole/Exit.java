package AlexPackage.MonacoConsole;

/**
 * Created by Aborigens on 23-Oct-15.
 */
public class Exit implements Execute {
    @Override
    public void execute() {
        new Output().output(SystemMessages.BYE.getString());
        System.exit(0);
    }
}
