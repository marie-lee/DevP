package com.devP.Controller;

import com.devP.Service.IssueService;
import com.devP.Service.MailService;
import com.devP.Service.ProjectService;
import com.devP.Service.TaskService;
import com.devP.VO.MemberVO;
import com.devP.VO.ProjectGroupVO;
import com.devP.VO.ProjectVO;
import com.devP.VO.TaskVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static java.lang.System.out;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("project")
@RequestMapping("project")
public class ProjectController {
	

		@Autowired
		private IssueService issueService;
		
        @Autowired
        private ProjectService projectService;

        @Autowired
        private TaskService taskService;

        @Autowired
        private MailController mailController;

        @Autowired
        private HttpSession session;

        //프로젝트 추가 화면
        @RequestMapping(value = "/insert.do", method = RequestMethod.GET)
        public String insertProjectView() {
                if(projectService.insertProjectView() == 200) {
                        return "insertProject";
                }else if(projectService.insertProjectView() == 405){
                        return "redirect:/login.do";
                }else{
                        return "redirect:/";
                }
        }

        
        //프로젝트 상세
        @RequestMapping(value="/detail.do", method= RequestMethod.GET)
  	    public String projectView(@RequestParam int projectId, ProjectVO vo, MemberVO member, Model model){
            if(session.getAttribute("projectId")!=null) session.removeAttribute("projectId");
            session.setAttribute("projectId", projectId);
            vo.setProjectId(projectId);
            member.setProjectId(projectId);
            member.setUserId(session.getAttribute("id").toString());

            // 프로젝트 데이터 가져오기
            //이슈 리스트 가져오기
  			issueService.getIssuelist(projectId, model);
  			//멤버 리스트 가져오기
            model.addAttribute("project",projectService.getProject(vo));
            model.addAttribute("myData",projectService.getMyProjectData(member));
  			model.addAttribute("memberList", projectService.getProjectMemberList(projectId));
  			model.addAttribute("myTask", taskService.getTask());
  			taskService.getTaskCount(model);
  	        return "projectDetail";
      	}

        @RequestMapping(value = "/insert.do", method = RequestMethod.POST)
        public String insertProject(@ModelAttribute ProjectVO vo, MemberVO vo2, ProjectGroupVO vo3) throws Exception {
                if(projectService.insertProject(vo, vo2, vo3) == 200) return "redirect: /project/list.do";
                else if(projectService.insertProject(vo, vo2, vo3) == 405) return "redirect: /project/insertProject.do";
                return null;
        }

        //프로젝트 목록
        @RequestMapping(value = "/list.do", method = RequestMethod.GET)
        public String projectList(Model model) {
                if(projectService.getProjectList(model) == 200){
                        return "projectList";
                } else if (projectService.getProjectList(model) == 405) {
                        return "login";
                }
                return null;
        }

        @RequestMapping(value="/myTask.do", method = RequestMethod.GET)
        public String myTaskView(ProjectVO project, MemberVO member, TaskVO task, Model model) throws Exception {
                int result = projectService.showTaskView(project, member, task, model);
                if(result == 200) return "task";
                else return "man";
        }


        @RequestMapping(value="/gant.do", method = RequestMethod.GET)
        public String gantChartView(){
                return "gantChart";
        }

        @RequestMapping(value="/member.do", method = RequestMethod.GET)
        public String manageMemberView(MemberVO vo, HttpSession session, Model model) {
                int result = projectService.showProjectMemberList(vo, model);

                if (result == 200) return "member";
                else return "main";
        }

        //멤버 가져오기
        @RequestMapping(value="/getTeam.do", method = RequestMethod.GET)
        public String getTeamView(){
                return "member";
        }

}
