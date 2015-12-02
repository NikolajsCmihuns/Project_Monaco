package com.monaco.MVC;

/**
 * Created by maksimspuskels on 03/11/15.
 */

public class MVCModel {
    private Object data;
    private String viewName;

    public MVCModel(Object data, String viewName) {
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
