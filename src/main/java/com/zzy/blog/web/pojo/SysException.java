package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class SysException implements Serializable {
    private Long id;

    private String exceptionUrl;

    private String exceptionRemoteDevice;

    private String exceptionOsinfo;

    private String exceptionBroswer;

    private String exceptionRemoteIp;

    private String exceptionRemoteUser;

    private String exceptionOptnote;

    private String exceptionMsg;

    private String exceptionStarTime;

    private String exceptionEndTime;

    private String msgRsv1;

    private String msgRsv2;

    private String msgRsv3;

    private String exceptionContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExceptionUrl() {
        return exceptionUrl;
    }

    public void setExceptionUrl(String exceptionUrl) {
        this.exceptionUrl = exceptionUrl == null ? null : exceptionUrl.trim();
    }

    public String getExceptionRemoteDevice() {
        return exceptionRemoteDevice;
    }

    public void setExceptionRemoteDevice(String exceptionRemoteDevice) {
        this.exceptionRemoteDevice = exceptionRemoteDevice == null ? null : exceptionRemoteDevice.trim();
    }

    public String getExceptionOsinfo() {
        return exceptionOsinfo;
    }

    public void setExceptionOsinfo(String exceptionOsinfo) {
        this.exceptionOsinfo = exceptionOsinfo == null ? null : exceptionOsinfo.trim();
    }

    public String getExceptionBroswer() {
        return exceptionBroswer;
    }

    public void setExceptionBroswer(String exceptionBroswer) {
        this.exceptionBroswer = exceptionBroswer == null ? null : exceptionBroswer.trim();
    }

    public String getExceptionRemoteIp() {
        return exceptionRemoteIp;
    }

    public void setExceptionRemoteIp(String exceptionRemoteIp) {
        this.exceptionRemoteIp = exceptionRemoteIp == null ? null : exceptionRemoteIp.trim();
    }

    public String getExceptionRemoteUser() {
        return exceptionRemoteUser;
    }

    public void setExceptionRemoteUser(String exceptionRemoteUser) {
        this.exceptionRemoteUser = exceptionRemoteUser == null ? null : exceptionRemoteUser.trim();
    }

    public String getExceptionOptnote() {
        return exceptionOptnote;
    }

    public void setExceptionOptnote(String exceptionOptnote) {
        this.exceptionOptnote = exceptionOptnote == null ? null : exceptionOptnote.trim();
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg == null ? null : exceptionMsg.trim();
    }

    public String getExceptionStarTime() {
        return exceptionStarTime;
    }

    public void setExceptionStarTime(String exceptionStarTime) {
        this.exceptionStarTime = exceptionStarTime == null ? null : exceptionStarTime.trim();
    }

    public String getExceptionEndTime() {
        return exceptionEndTime;
    }

    public void setExceptionEndTime(String exceptionEndTime) {
        this.exceptionEndTime = exceptionEndTime == null ? null : exceptionEndTime.trim();
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

    public String getExceptionContent() {
        return exceptionContent;
    }

    public void setExceptionContent(String exceptionContent) {
        this.exceptionContent = exceptionContent == null ? null : exceptionContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", exceptionUrl=").append(exceptionUrl);
        sb.append(", exceptionRemoteDevice=").append(exceptionRemoteDevice);
        sb.append(", exceptionOsinfo=").append(exceptionOsinfo);
        sb.append(", exceptionBroswer=").append(exceptionBroswer);
        sb.append(", exceptionRemoteIp=").append(exceptionRemoteIp);
        sb.append(", exceptionRemoteUser=").append(exceptionRemoteUser);
        sb.append(", exceptionOptnote=").append(exceptionOptnote);
        sb.append(", exceptionMsg=").append(exceptionMsg);
        sb.append(", exceptionStarTime=").append(exceptionStarTime);
        sb.append(", exceptionEndTime=").append(exceptionEndTime);
        sb.append(", msgRsv1=").append(msgRsv1);
        sb.append(", msgRsv2=").append(msgRsv2);
        sb.append(", msgRsv3=").append(msgRsv3);
        sb.append(", exceptionContent=").append(exceptionContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}