package com.devP.Mapper.Impl;

import com.devP.Mapper.Repository.ProjectDAOMybatis;
import com.devP.Service.ProjectService;
import com.devP.VO.ProjectGroupVO;
import com.devP.VO.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAOMybatis projectDAO;

    public List<ProjectGroupVO> getProjectList(ProjectGroupVO vo) { return projectDAO.getProjectList(vo); }

    public List<ProjectVO> getProjectName(ProjectVO vo) {return projectDAO.getProjectName(vo);}
}
