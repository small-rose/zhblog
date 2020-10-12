package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class Link implements Serializable {
    private Long id;

    private String linkUrl;

    private String linkName;

    private String linkTx;

    private Integer apprFlag;

    private String addDate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkTx() {
        return linkTx;
    }

    public void setLinkTx(String linkTx) {
        this.linkTx = linkTx == null ? null : linkTx.trim();
    }

    public Integer getApprFlag() {
        return apprFlag;
    }

    public void setApprFlag(Integer apprFlag) {
        this.apprFlag = apprFlag;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate == null ? null : addDate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkName=").append(linkName);
        sb.append(", linkTx=").append(linkTx);
        sb.append(", apprFlag=").append(apprFlag);
        sb.append(", addDate=").append(addDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}