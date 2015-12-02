package com.monaco.MVC;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maksimspuskels on 03/11/15.
 */

public interface MVCController {
    default MVCModel executePost(HttpServletRequest request) {
        return new MVCModel("","");
    }
    default MVCModel executeGet(HttpServletRequest request) {
        return new MVCModel("","");
    }
}
