package com.devP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProjectController {

    @RequestMapping(value = "/projectList.do", method = RequestMethod.GET)
    public String projectListView(HttpServletRequest request) {
        return "projectList";
    }
}
