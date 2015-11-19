package nikocmihPackage.servlet.MVC;

/**
 * Created by Nikolajs Cmihuns on 11/5/2015.
 */
public class MVCModelR {

    private Object data; // can insert here any Java object
    private String viewName;

    public MVCModelR(Object data, String viewName) {
        this.data = data;
        this.viewName = viewName;
    }

    public Object getData() {
        return data;
    }

    public String getViewName() {
        return viewName;
    }


}
