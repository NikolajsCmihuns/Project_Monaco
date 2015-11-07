package AlexPackage.DB;

import java.util.HashMap;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public class Country extends HashMap<String, String> {

    private String shortName;
    private String longName;

    public Country(String shortName, String longName) {
        super();
        super.put(shortName, longName);
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }
}
