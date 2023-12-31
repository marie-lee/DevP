package com.devP.VO;
import java.util.Date;
import org.apache.ibatis.session.ResultHandler;

//VO(Value Object)
public class ProjectVO {
    private int projectId;
    private String projectName;
    private String startDate;
    private String endDate;
    private String realEnd;
    private String wbsFile;
    private String planFile;
    private int progress;
    private String leader;
    private String script;
    private String email;

    private String status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

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



    public String getRealEnd() {
        return realEnd;
    }

    public void setRealEnd(String realEnd) {
        this.realEnd = realEnd;
    }
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }



    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}