package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class Message implements Serializable {
    private Long id;

    private String parentId;

    private String msgUtx;

    private String msgUname;

    private String msgUemail;

    private String msgContent;

    private String msgTime;

    private Integer msgLike;

    private Integer msgAppr;

    private String apprTime;

    private String msgRsv1;

    private String msgRsv2;

    private String msgRsv3;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getMsgUtx() {
        return msgUtx;
    }

    public void setMsgUtx(String msgUtx) {
        this.msgUtx = msgUtx == null ? null : msgUtx.trim();
    }

    public String getMsgUname() {
        return msgUname;
    }

    public void setMsgUname(String msgUname) {
        this.msgUname = msgUname == null ? null : msgUname.trim();
    }

    public String getMsgUemail() {
        return msgUemail;
    }

    public void setMsgUemail(String msgUemail) {
        this.msgUemail = msgUemail == null ? null : msgUemail.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime == null ? null : msgTime.trim();
    }

    public Integer getMsgLike() {
        return msgLike;
    }

    public void setMsgLike(Integer msgLike) {
        this.msgLike = msgLike;
    }

    public Integer getMsgAppr() {
        return msgAppr;
    }

    public void setMsgAppr(Integer msgAppr) {
        this.msgAppr = msgAppr;
    }

    public String getApprTime() {
        return apprTime;
    }

    public void setApprTime(String apprTime) {
        this.apprTime = apprTime == null ? null : apprTime.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", msgUtx=").append(msgUtx);
        sb.append(", msgUname=").append(msgUname);
        sb.append(", msgUemail=").append(msgUemail);
        sb.append(", msgContent=").append(msgContent);
        sb.append(", msgTime=").append(msgTime);
        sb.append(", msgLike=").append(msgLike);
        sb.append(", msgAppr=").append(msgAppr);
        sb.append(", apprTime=").append(apprTime);
        sb.append(", msgRsv1=").append(msgRsv1);
        sb.append(", msgRsv2=").append(msgRsv2);
        sb.append(", msgRsv3=").append(msgRsv3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}