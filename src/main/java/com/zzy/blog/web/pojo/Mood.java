package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class Mood implements Serializable {
    private Long id;

    private String moodDate;

    private String moodTitle;

    private String moodContent;

    private String moodPic;

    private Integer moodLike;
    
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoodDate() {
        return moodDate;
    }

    public void setMoodDate(String moodDate) {
        this.moodDate = moodDate == null ? null : moodDate.trim();
    }

    public String getMoodTitle() {
        return moodTitle;
    }

    public void setMoodTitle(String moodTitle) {
        this.moodTitle = moodTitle == null ? null : moodTitle.trim();
    }

    public String getMoodContent() {
        return moodContent;
    }

    public void setMoodContent(String moodContent) {
        this.moodContent = moodContent == null ? null : moodContent.trim();
    }

    public String getMoodPic() {
        return moodPic;
    }

    public void setMoodPic(String moodPic) {
        this.moodPic = moodPic == null ? null : moodPic.trim();
    }

    public Integer getMoodLike() {
		return moodLike;
	}

	public void setMoodLike(Integer moodLike) {
		this.moodLike = moodLike;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", moodDate=").append(moodDate);
        sb.append(", moodTitle=").append(moodTitle);
        sb.append(", moodContent=").append(moodContent);
        sb.append(", moodPic=").append(moodPic);
        sb.append(", moodLike=").append(moodLike);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}