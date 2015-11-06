package AlexPackage;

/**
 * Created by Aborigens on 06-Nov-15.
 */
public class RouteModel {

    private Object data;
    private String viewName;

    public RouteModel(Object data, String viewName) {
        this.viewName = viewName;
        this.data = data;
    }

    public String getViewName() {
        return viewName;
    }

    public Object getData() {
        return data;
    }
}
