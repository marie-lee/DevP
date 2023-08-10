package com.devP.Controller;

import com.devP.Service.ProjectService;
import com.devP.VO.ProjectGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/projectList.do", method = RequestMethod.POST)
    public String mainView() {
        System.out.println("get");
        return "redirect:/";
    }

    @RequestMapping(value = "/projectList.do", method = RequestMethod.GET)
    public String projectList(@RequestParam("userId") String userId, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
//        String userName = (String)session.getAttribute("name");

        System.out.println("post");

//        if(userId.equals("")){
//            System.out.println("post1");
//            return "login";
//        }else {
//            if(userId.equals(id)){
//                System.out.println("post2");
//                model.addAttribute("projectList", projectService.getProjectList(vo));
//                return "projectList";
//            }
//        }

        if(userId.equals(id)){
            System.out.println("post1");
        }
        else{
            System.out.println("post2");
        }
        return "redirect:longin.do";
    }

}
