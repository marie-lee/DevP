package com.devP.Mapper.Repository;

import com.devP.VO.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaderDAOMybatis {

    @Autowired
    private SqlSessionTemplate mybatis;

    public List<MemberVO> getMemberList(MemberVO vo){
        return mybatis.selectList("LeaderDAO.getMemberList", vo);
    }

}