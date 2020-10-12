package com.zzy.blog.web.pojo;

import java.io.Serializable;

public class Article implements Serializable {
    private Long id;

    private Long userId;

    private String articleAuthor;

    private Long origUserId;

    private String originalAuthor;

    private String articleTitle;

    private Long articleType;

    private Long articleImage;

    private Long articleHits;
    
    private String saveDate;

    private String publishDate;

    private String updateDate;

    private String articleUrl;

    private String articleTabloid;

    private Integer likeYes;

    private Integer likeNo;

    private Integer best;

    private Long lastArticleId;

    private Long nextArticleId;

    private Integer  isDraft;
    
    private String articleContent;
    private String articleContentMd ;
    
    
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    public Long getOrigUserId() {
        return origUserId;
    }

    public void setOrigUserId(Long origUserId) {
        this.origUserId = origUserId;
    }

    public String getOriginalAuthor() {
        return originalAuthor;
    }

    public void setOriginalAuthor(String originalAuthor) {
        this.originalAuthor = originalAuthor == null ? null : originalAuthor.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Long getArticleType() {
        return articleType;
    }

    public void setArticleType(Long articleType) {
        this.articleType = articleType;
    }

    public Long getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(Long articleImage) {
        this.articleImage = articleImage;
    }

    public Long getArticleHits() {
        return articleHits;
    }

    public void setArticleHits(Long articleHits) {
        this.articleHits = articleHits ;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate == null ? null : saveDate.trim();
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate == null ? null : publishDate.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl == null ? null : articleUrl.trim();
    }

    public String getArticleTabloid() {
        return articleTabloid;
    }

    public void setArticleTabloid(String articleTabloid) {
        this.articleTabloid = articleTabloid == null ? null : articleTabloid.trim();
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

    public Integer getBest() {
        return best;
    }

    public void setBest(Integer best) {
        this.best = best;
    }

    public Long getLastArticleId() {
        return lastArticleId;
    }

    public void setLastArticleId(Long lastArticleId) {
        this.lastArticleId = lastArticleId;
    }

    public Long getNextArticleId() {
        return nextArticleId;
    }

    public void setNextArticleId(Long nextArticleId) {
        this.nextArticleId = nextArticleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public Integer getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Integer isDraft) {
		this.isDraft = isDraft;
	}

	public String getArticleContentMd() {
		return articleContentMd;
	}

	public void setArticleContentMd(String articleContentMd) {
		this.articleContentMd = articleContentMd;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", articleAuthor=").append(articleAuthor);
        sb.append(", origUserId=").append(origUserId);
        sb.append(", originalAuthor=").append(originalAuthor);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleType=").append(articleType);
        sb.append(", articleImage=").append(articleImage);
        sb.append(", articleHits=").append(articleHits);
        sb.append(", saveDate=").append(saveDate);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", articleUrl=").append(articleUrl);
        sb.append(", articleTabloid=").append(articleTabloid);
        sb.append(", likeYes=").append(likeYes);
        sb.append(", likeNo=").append(likeNo);
        sb.append(", best=").append(best);
        sb.append(", lastArticleId=").append(lastArticleId);
        sb.append(", nextArticleId=").append(nextArticleId);
        sb.append(", isDraft=").append(isDraft);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}