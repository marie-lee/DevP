package com.devP.VO;

import java.util.Date;

//VO(Value Object)
public class ProjectVO {

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    private int projectId;

    public int getProjectName() {
        return projectName;
    }

    public void setProjectName(int projectName) {
        this.projectName = projectName;
    }

    private int projectName;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date startDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Date endDate;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int progress;

    public int getWbsFileId() {
        return wbsFileId;
    }

    public void setWbsFileId(int wbsFileId) {
        this.wbsFileId = wbsFileId;
    }

    public int wbsFileId;

    public int getPlanFileId() {
        return planFileId;
    }

    public void setPlanFileId(int planFileId) {
        this.planFileId = planFileId;
    }

    public int planFileId;
}