package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class Picture implements Serializable {
    private Long id;

    private String picName;

    private String picNewName;

    private String picLocalAddress;

    private String absLocalAddress;

    private String originalAddress;

    private Long picLength;

    private String picSuffix;

    private Long picType;

    private String uploadDate;

    private Integer likes;

    private byte[] picContent;

    private Long cateId ;
    
    private static final long serialVersionUID = 1L;

    public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getPicNewName() {
        return picNewName;
    }

    public void setPicNewName(String picNewName) {
        this.picNewName = picNewName == null ? null : picNewName.trim();
    }

    public String getPicLocalAddress() {
        return picLocalAddress;
    }

    public void setPicLocalAddress(String picLocalAddress) {
        this.picLocalAddress = picLocalAddress == null ? null : picLocalAddress.trim();
    }

    public String getAbsLocalAddress() {
        return absLocalAddress;
    }

    public void setAbsLocalAddress(String absLocalAddress) {
        this.absLocalAddress = absLocalAddress == null ? null : absLocalAddress.trim();
    }

    public String getOriginalAddress() {
        return originalAddress;
    }

    public void setOriginalAddress(String originalAddress) {
        this.originalAddress = originalAddress == null ? null : originalAddress.trim();
    }

    public Long getPicLength() {
        return picLength;
    }

    public void setPicLength(Long picLength) {
        this.picLength = picLength;
    }

    public String getPicSuffix() {
        return picSuffix;
    }

    public void setPicSuffix(String picSuffix) {
        this.picSuffix = picSuffix == null ? null : picSuffix.trim();
    }

    public Long getPicType() {
        return picType;
    }

    public void setPicType(Long picType) {
        this.picType = picType;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate == null ? null : uploadDate.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public byte[] getPicContent() {
        return picContent;
    }

    public void setPicContent(byte[] picContent) {
        this.picContent = picContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", picName=").append(picName);
        sb.append(", picNewName=").append(picNewName);
        sb.append(", picLocalAddress=").append(picLocalAddress);
        sb.append(", absLocalAddress=").append(absLocalAddress);
        sb.append(", originalAddress=").append(originalAddress);
        sb.append(", picLength=").append(picLength);
        sb.append(", picSuffix=").append(picSuffix);
        sb.append(", picType=").append(picType);
        sb.append(", uploadDate=").append(uploadDate);
        sb.append(", likes=").append(likes);
        sb.append(", picContent=").append(picContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}