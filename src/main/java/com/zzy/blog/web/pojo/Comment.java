package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class Comment implements Serializable {
    private Long id;

    private Long parentId;

    private Long articleId;

    private String cmtUtx;

    private String cmtUname;

    private String cmtUemail;

    private String cmtWebUrl;

    private Integer cmtAppr;

    private String cmtDate;

    private Integer likeYes;

    private Integer likeNo;

    private String cmtContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getCmtUtx() {
        return cmtUtx;
    }

    public void setCmtUtx(String cmtUtx) {
        this.cmtUtx = cmtUtx == null ? null : cmtUtx.trim();
    }

    public String getCmtUname() {
        return cmtUname;
    }

    public void setCmtUname(String cmtUname) {
        this.cmtUname = cmtUname == null ? null : cmtUname.trim();
    }

    public String getCmtUemail() {
        return cmtUemail;
    }

    public void setCmtUemail(String cmtUemail) {
        this.cmtUemail = cmtUemail == null ? null : cmtUemail.trim();
    }

    public String getCmtWebUrl() {
        return cmtWebUrl;
    }

    public void setCmtWebUrl(String cmtWebUrl) {
        this.cmtWebUrl = cmtWebUrl == null ? null : cmtWebUrl.trim();
    }

    public Integer getCmtAppr() {
        return cmtAppr;
    }

    public void setCmtAppr(Integer cmtAppr) {
        this.cmtAppr = cmtAppr;
    }

    public String getCmtDate() {
        return cmtDate;
    }

    public void setCmtDate(String cmtDate) {
        this.cmtDate = cmtDate == null ? null : cmtDate.trim();
    }

    public Integer getLikeYes() {
        return likeYes;
    }

    public void setLikeYes(Integer likeYes) {
        this.likeYes = likeYes;
    }

    public Integer getLikeNo() {
        return likeNo;
    }

    public void setLikeNo(Integer likeNo) {
        this.likeNo = likeNo;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent == null ? null : cmtContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", articleId=").append(articleId);
        sb.append(", cmtUtx=").append(cmtUtx);
        sb.append(", cmtUname=").append(cmtUname);
        sb.append(", cmtUemail=").append(cmtUemail);
        sb.append(", cmtWebUrl=").append(cmtWebUrl);
        sb.append(", cmtAppr=").append(cmtAppr);
        sb.append(", cmtDate=").append(cmtDate);
        sb.append(", likeYes=").append(likeYes);
        sb.append(", likeNo=").append(likeNo);
        sb.append(", cmtContent=").append(cmtContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}