package janis.monaco.controllers;

import janis.monaco.database.PlaceTypeRefDAO;
import janis.monaco.domain.PlaceTypeRef;
import janis.monaco.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by janis on 12/15/15.
 */

@Controller
public class ControllerPlaceFormImpl implements ControllerPlaceForm {

    @Autowired
    PlaceTypeRefDAO placeTypeRefDAO;


    @Transactional
    public MVCModel execute(HttpServletRequest request) {

        System.out.println("ControllerPlaceForm is called!!!");

        List<PlaceTypeRef> placeTypeRefs = placeTypeRefDAO.getAll();

        List placeRefList = new ArrayList();

        for(PlaceTypeRef ref : placeTypeRefs)
        {
            String properties = ref.getPlaceType();
            placeRefList.add(properties);
        }

        return new MVCModel(placeRefList, "/views/place_views/PlaceForm.jsp");
    }


}
