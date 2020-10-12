package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String telNo;

    private String userName;

    private String password;

    private Integer gender;

    private String realName;

    private String birthDay;

    private String email;

    private String wxPrivate;

    private String wxPublic;

    private String wbAcct;

    private String gitAcct;

    private String qqAcct;

    private String ext1Acct;

    private String ext2Acct;

    private String ext3Acct;

    private String personalBrief;

    private String avatarImgUrl;

    private String localImgUrl;

    private String registerDate;

    private String recentlyLanded;
    private String  bloggerMsg;
    private String  gitBlogUrl;
    
    private static final long serialVersionUID = 1L;

    public String getBloggerMsg() {
		return bloggerMsg;
	}

	public void setBloggerMsg(String bloggerMsg) {
		this.bloggerMsg = bloggerMsg;
	}

	public String getGitBlogUrl() {
		return gitBlogUrl;
	}

	public void setGitBlogUrl(String gitBlogUrl) {
		this.gitBlogUrl = gitBlogUrl;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay == null ? null : birthDay.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWxPrivate() {
        return wxPrivate;
    }

    public void setWxPrivate(String wxPrivate) {
        this.wxPrivate = wxPrivate == null ? null : wxPrivate.trim();
    }

    public String getWxPublic() {
        return wxPublic;
    }

    public void setWxPublic(String wxPublic) {
        this.wxPublic = wxPublic == null ? null : wxPublic.trim();
    }

    public String getWbAcct() {
        return wbAcct;
    }

    public void setWbAcct(String wbAcct) {
        this.wbAcct = wbAcct == null ? null : wbAcct.trim();
    }

    public String getGitAcct() {
        return gitAcct;
    }

    public void setGitAcct(String gitAcct) {
        this.gitAcct = gitAcct == null ? null : gitAcct.trim();
    }

    public String getQqAcct() {
        return qqAcct;
    }

    public void setQqAcct(String qqAcct) {
        this.qqAcct = qqAcct == null ? null : qqAcct.trim();
    }

    public String getExt1Acct() {
        return ext1Acct;
    }

    public void setExt1Acct(String ext1Acct) {
        this.ext1Acct = ext1Acct == null ? null : ext1Acct.trim();
    }

    public String getExt2Acct() {
        return ext2Acct;
    }

    public void setExt2Acct(String ext2Acct) {
        this.ext2Acct = ext2Acct == null ? null : ext2Acct.trim();
    }

    public String getExt3Acct() {
        return ext3Acct;
    }

    public void setExt3Acct(String ext3Acct) {
        this.ext3Acct = ext3Acct == null ? null : ext3Acct.trim();
    }

    public String getPersonalBrief() {
        return personalBrief;
    }

    public void setPersonalBrief(String personalBrief) {
        this.personalBrief = personalBrief == null ? null : personalBrief.trim();
    }

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl == null ? null : avatarImgUrl.trim();
    }

    public String getLocalImgUrl() {
        return localImgUrl;
    }

    public void setLocalImgUrl(String localImgUrl) {
        this.localImgUrl = localImgUrl == null ? null : localImgUrl.trim();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate == null ? null : registerDate.trim();
    }

    public String getRecentlyLanded() {
        return recentlyLanded;
    }

    public void setRecentlyLanded(String recentlyLanded) {
        this.recentlyLanded = recentlyLanded == null ? null : recentlyLanded.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", telNo=").append(telNo);
        sb.append(", userName=").append(userName);
        sb.append(", gender=").append(gender);
        sb.append(", realName=").append(realName);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", email=").append(email);
        sb.append(", wxPrivate=").append(wxPrivate);
        sb.append(", wxPublic=").append(wxPublic);
        sb.append(", wbAcct=").append(wbAcct);
        sb.append(", gitAcct=").append(gitAcct);
        sb.append(", qqAcct=").append(qqAcct);
        sb.append(", ext1Acct=").append(ext1Acct);
        sb.append(", ext2Acct=").append(ext2Acct);
        sb.append(", ext3Acct=").append(ext3Acct);
        sb.append(", personalBrief=").append(personalBrief);
        sb.append(", avatarImgUrl=").append(avatarImgUrl);
        sb.append(", localImgUrl=").append(localImgUrl);
        sb.append(", registerDate=").append(registerDate);
        sb.append(", recentlyLanded=").append(recentlyLanded);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}