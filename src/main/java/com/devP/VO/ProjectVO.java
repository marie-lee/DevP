package com.devP.VO;

import java.util.Date;

//VO(Value Object)
public class ProjectVO {
    private String projectName;
    private String startDate;
    private String endDate;
    private int progress;
    private int projectId;
    private String wbsFile;
    private String planFile;

    public String getPlanFile() {
        return planFile;
    }

    public void setPlanFile(String planFile) {
        this.planFile = planFile;
    }



    public String getWbsFile() {
        return wbsFile;
    }

    public void setWbsFile(String wbsFile) {
        this.wbsFile = wbsFile;
    }



    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }




}