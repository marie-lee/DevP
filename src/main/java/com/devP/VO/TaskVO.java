package com.devP.VO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//VO(Value Object)
public class TaskVO {
	private int taskId;
	private int projectId;
    private String userId;

	private String userName;
    private String category;
	private String workPackage;
    private int priority;
    private String depth;
    private String detail;
    private int progress;
	private String status;

    private String startdate;
	private String enddate;
	private String realEnd;

	private Date now;

	private ArrayList<TaskVO> taskVOList;
    
    public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {this.userId = userId;	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {this.userName = userName;	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWorkPackage() {return workPackage;	}
	public void setWorkPackage(String workPackage) {this.workPackage = workPackage;	}
	public String getStatus() {return status;	}
	public void setStatus(String status) {this.status = status;	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String  getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {

		this.startdate = startdate;
	}
	public String  getEnddate() {
		return enddate;
	}
	public void setEnddate(String  enddate) {
		this.enddate = enddate;
	}
	public String  getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(String  realEnd) {
		this.realEnd = realEnd;
	}

	public Date  getNow() {
		return now;
	}
	public void setNow(Date  now) {
		this.now = now;
	}

	public ArrayList<TaskVO> getTaskVOList(){return taskVOList;}
	public void setTaskVOList(ArrayList<TaskVO> taskVOList){ this.taskVOList = taskVOList;}
}