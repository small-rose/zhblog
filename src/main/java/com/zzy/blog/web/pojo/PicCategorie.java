package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class PicCategorie implements Serializable {
    private Long id;

    private String picCateCode;

    private String picCateName;

    private String picCateNote;

    private Integer isShow;

    private Integer picCateOrder;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicCateCode() {
        return picCateCode;
    }

    public void setPicCateCode(String picCateCode) {
        this.picCateCode = picCateCode == null ? null : picCateCode.trim();
    }

    public String getPicCateName() {
        return picCateName;
    }

    public void setPicCateName(String picCateName) {
        this.picCateName = picCateName == null ? null : picCateName.trim();
    }

    public String getPicCateNote() {
        return picCateNote;
    }

    public void setPicCateNote(String picCateNote) {
        this.picCateNote = picCateNote == null ? null : picCateNote.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getPicCateOrder() {
        return picCateOrder;
    }

    public void setPicCateOrder(Integer picCateOrder) {
        this.picCateOrder = picCateOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", picCateCode=").append(picCateCode);
        sb.append(", picCateName=").append(picCateName);
        sb.append(", picCateNote=").append(picCateNote);
        sb.append(", isShow=").append(isShow);
        sb.append(", picCateOrder=").append(picCateOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}