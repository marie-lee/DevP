package com.devP.Mapper.Repository;

import com.devP.VO.IssueVO;
import com.devP.VO.TaskListVO;
import com.devP.VO.TaskVO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAOMybatis {

    @Autowired
    private SqlSessionTemplate mybatis;

    public List<TaskVO> getTask(TaskVO task) {
        return mybatis.selectList("TaskDAO.getTask", task);
    }
    public List<TaskVO> getMyTask(TaskVO task) {
        return mybatis.selectList("TaskDAO.getMyTask", task);
    }

    public List<TaskListVO> getUserTaskList(String userId){
        return mybatis.selectList("TaskDAO.getTaskList", userId);
    }

    public List<TaskVO> getProjectTaskList(int projectId){ return mybatis.selectList("TaskDAO.getProjectTaskList",projectId); }

    public List<TaskVO> getMyProjectTaskList(TaskVO vo) { return mybatis.selectList("TaskDAO.getMyProjectTaskList", vo); }

    public void insertTask(TaskVO vo){ mybatis.insert("TaskDAO.insertTask",vo);}

    public void updateTaskLeader(TaskVO vo){ mybatis.update("TaskDAO.updateTaskLeader", vo); }
    public void updateTaskStatus(TaskVO vo){ mybatis.update("TaskDAO.updateTaskStatus", vo); }
    public void deleteTask(int taskId){mybatis.delete("TaskDAO.deleteTask", taskId);}

    public int getPastTaskCnt(TaskVO task) {return mybatis.selectOne("TaskDAO.getPastTaskCnt",task); }

    public int getProgressTaskCnt(TaskVO task) {return mybatis.selectOne("TaskDAO.getProgressTaskCnt",task); }

    public int getCompleteTaskCnt(TaskVO task) {return mybatis.selectOne("TaskDAO.getCompleteTaskCnt",task); }
}
