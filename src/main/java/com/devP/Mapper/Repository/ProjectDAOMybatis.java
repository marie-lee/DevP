package com.devP.Mapper.Repository;

import com.devP.VO.ProjectGroupVO;
import com.devP.VO.ProjectVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOMybatis {

    @Autowired
    private SqlSessionTemplate mybatis;

    public List<ProjectGroupVO> getProjectList(ProjectGroupVO vo) {
        return mybatis.selectList("ProjectDAO.getProjectList", vo);
    }


    public List<ProjectVO> getProjectName(ProjectVO vo){return mybatis.selectList("ProjectDAO.getProjectName", vo); }
}
