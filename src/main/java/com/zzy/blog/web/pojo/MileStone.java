package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class MileStone implements Serializable {
    private Long id;

    private String msYear;

    private String msDate;

    private String msContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsYear() {
        return msYear;
    }

    public void setMsYear(String msYear) {
        this.msYear = msYear == null ? null : msYear.trim();
    }

    public String getMsDate() {
        return msDate;
    }

    public void setMsDate(String msDate) {
        this.msDate = msDate == null ? null : msDate.trim();
    }

    public String getMsContent() {
        return msContent;
    }

    public void setMsContent(String msContent) {
        this.msContent = msContent == null ? null : msContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msYear=").append(msYear);
        sb.append(", msDate=").append(msDate);
        sb.append(", msContent=").append(msContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}