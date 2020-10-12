package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class SysLog implements Serializable {
    private Long id;

    private String logUrl;

    private String logRemoteDevice;

    private String logOsinfo;

    private String logBroswer;

    private String logMethod;

    private String logOptnote;

    private String logProtocol;

    private String logRemoteIp;

    private String logRemotePort;

    private String logRemoteRemoteuser;

    private String logStarTime;

    private String logEndTime;

    private String logRespHeader;

    private String msgRsv1;

    private String msgRsv2;

    private String msgRsv3;

    private String logReqHeader;

    private String logParamOrg;

    private String logParam;

    private String logRespBody;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl == null ? null : logUrl.trim();
    }

    public String getLogRemoteDevice() {
        return logRemoteDevice;
    }

    public void setLogRemoteDevice(String logRemoteDevice) {
        this.logRemoteDevice = logRemoteDevice == null ? null : logRemoteDevice.trim();
    }

    public String getLogOsinfo() {
        return logOsinfo;
    }

    public void setLogOsinfo(String logOsinfo) {
        this.logOsinfo = logOsinfo == null ? null : logOsinfo.trim();
    }

    public String getLogBroswer() {
        return logBroswer;
    }

    public void setLogBroswer(String logBroswer) {
        this.logBroswer = logBroswer == null ? null : logBroswer.trim();
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod == null ? null : logMethod.trim();
    }

    public String getLogOptnote() {
        return logOptnote;
    }

    public void setLogOptnote(String logOptnote) {
        this.logOptnote = logOptnote == null ? null : logOptnote.trim();
    }

    public String getLogProtocol() {
        return logProtocol;
    }

    public void setLogProtocol(String logProtocol) {
        this.logProtocol = logProtocol == null ? null : logProtocol.trim();
    }

    public String getLogRemoteIp() {
        return logRemoteIp;
    }

    public void setLogRemoteIp(String logRemoteIp) {
        this.logRemoteIp = logRemoteIp == null ? null : logRemoteIp.trim();
    }

    public String getLogRemotePort() {
        return logRemotePort;
    }

    public void setLogRemotePort(String logRemotePort) {
        this.logRemotePort = logRemotePort == null ? null : logRemotePort.trim();
    }

    public String getLogRemoteRemoteuser() {
        return logRemoteRemoteuser;
    }

    public void setLogRemoteRemoteuser(String logRemoteRemoteuser) {
        this.logRemoteRemoteuser = logRemoteRemoteuser == null ? null : logRemoteRemoteuser.trim();
    }

    public String getLogStarTime() {
        return logStarTime;
    }

    public void setLogStarTime(String logStarTime) {
        this.logStarTime = logStarTime == null ? null : logStarTime.trim();
    }

    public String getLogEndTime() {
        return logEndTime;
    }

    public void setLogEndTime(String logEndTime) {
        this.logEndTime = logEndTime == null ? null : logEndTime.trim();
    }

    public String getLogRespHeader() {
        return logRespHeader;
    }

    public void setLogRespHeader(String logRespHeader) {
        this.logRespHeader = logRespHeader == null ? null : logRespHeader.trim();
    }

    public String getMsgRsv1() {
        return msgRsv1;
    }

    public void setMsgRsv1(String msgRsv1) {
        this.msgRsv1 = msgRsv1 == null ? null : msgRsv1.trim();
    }

    public String getMsgRsv2() {
        return msgRsv2;
    }

    public void setMsgRsv2(String msgRsv2) {
        this.msgRsv2 = msgRsv2 == null ? null : msgRsv2.trim();
    }

    public String getMsgRsv3() {
        return msgRsv3;
    }

    public void setMsgRsv3(String msgRsv3) {
        this.msgRsv3 = msgRsv3 == null ? null : msgRsv3.trim();
    }

    public String getLogReqHeader() {
        return logReqHeader;
    }

    public void setLogReqHeader(String logReqHeader) {
        this.logReqHeader = logReqHeader == null ? null : logReqHeader.trim();
    }

    public String getLogParamOrg() {
        return logParamOrg;
    }

    public void setLogParamOrg(String logParamOrg) {
        this.logParamOrg = logParamOrg == null ? null : logParamOrg.trim();
    }

    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logParam) {
        this.logParam = logParam == null ? null : logParam.trim();
    }

    public String getLogRespBody() {
        return logRespBody;
    }

    public void setLogRespBody(String logRespBody) {
        this.logRespBody = logRespBody == null ? null : logRespBody.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logUrl=").append(logUrl);
        sb.append(", logRemoteDevice=").append(logRemoteDevice);
        sb.append(", logOsinfo=").append(logOsinfo);
        sb.append(", logBroswer=").append(logBroswer);
        sb.append(", logMethod=").append(logMethod);
        sb.append(", logOptnote=").append(logOptnote);
        sb.append(", logProtocol=").append(logProtocol);
        sb.append(", logRemoteIp=").append(logRemoteIp);
        sb.append(", logRemotePort=").append(logRemotePort);
        sb.append(", logRemoteRemoteuser=").append(logRemoteRemoteuser);
        sb.append(", logStarTime=").append(logStarTime);
        sb.append(", logEndTime=").append(logEndTime);
        sb.append(", logRespHeader=").append(logRespHeader);
        sb.append(", msgRsv1=").append(msgRsv1);
        sb.append(", msgRsv2=").append(msgRsv2);
        sb.append(", msgRsv3=").append(msgRsv3);
        sb.append(", logReqHeader=").append(logReqHeader);
        sb.append(", logParamOrg=").append(logParamOrg);
        sb.append(", logParam=").append(logParam);
        sb.append(", logRespBody=").append(logRespBody);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}