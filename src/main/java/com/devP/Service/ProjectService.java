package com.devP.Service;

import com.devP.VO.ProjectGroupVO;
import com.devP.VO.ProjectVO;

import java.util.List;

public interface ProjectService {
	
	List<ProjectGroupVO> getProjectList(ProjectGroupVO vo);

}
