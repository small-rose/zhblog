package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class SysInfo implements Serializable {
    private Long id;

    private String blogTitle;

    private String blogStie;

    private String blogBrief;

    private String blogNotice;

    private String blogNote;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogStie() {
        return blogStie;
    }

    public void setBlogStie(String blogStie) {
        this.blogStie = blogStie == null ? null : blogStie.trim();
    }

    public String getBlogBrief() {
        return blogBrief;
    }

    public void setBlogBrief(String blogBrief) {
        this.blogBrief = blogBrief == null ? null : blogBrief.trim();
    }

    public String getBlogNotice() {
        return blogNotice;
    }

    public void setBlogNotice(String blogNotice) {
        this.blogNotice = blogNotice == null ? null : blogNotice.trim();
    }

    public String getBlogNote() {
        return blogNote;
    }

    public void setBlogNote(String blogNote) {
        this.blogNote = blogNote == null ? null : blogNote.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogTitle=").append(blogTitle);
        sb.append(", blogStie=").append(blogStie);
        sb.append(", blogBrief=").append(blogBrief);
        sb.append(", blogNotice=").append(blogNotice);
        sb.append(", blogNote=").append(blogNote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}