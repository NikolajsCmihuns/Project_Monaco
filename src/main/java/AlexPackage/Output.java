package AlexPackage;

import java.util.Iterator;

/**
 * Created by Aborigens on 21-Oct-15.
 */
public class Output {

    public Output() {

    }

    public void output(String message) {
        System.out.println(message);
    }

    public void output(Menu userMenu) {
        Iterator<Integer> counter = userMenu.getUserMenu().keySet().iterator();
        while (counter.hasNext()) {
            Integer key = counter.next();
            System.out.println(key + ": " + userMenu.getUserMenu().get(key));
        }
    }

}
