package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class ArticleQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIsNull() {
            addCriterion("article_author is null");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIsNotNull() {
            addCriterion("article_author is not null");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorEqualTo(String value) {
            addCriterion("article_author =", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotEqualTo(String value) {
            addCriterion("article_author <>", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorGreaterThan(String value) {
            addCriterion("article_author >", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("article_author >=", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLessThan(String value) {
            addCriterion("article_author <", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLessThanOrEqualTo(String value) {
            addCriterion("article_author <=", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLike(String value) {
            addCriterion("article_author like", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotLike(String value) {
            addCriterion("article_author not like", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIn(List<String> values) {
            addCriterion("article_author in", values, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotIn(List<String> values) {
            addCriterion("article_author not in", values, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorBetween(String value1, String value2) {
            addCriterion("article_author between", value1, value2, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotBetween(String value1, String value2) {
            addCriterion("article_author not between", value1, value2, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdIsNull() {
            addCriterion("orig_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdIsNotNull() {
            addCriterion("orig_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdEqualTo(Long value) {
            addCriterion("orig_user_id =", value, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdNotEqualTo(Long value) {
            addCriterion("orig_user_id <>", value, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdGreaterThan(Long value) {
            addCriterion("orig_user_id >", value, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("orig_user_id >=", value, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdLessThan(Long value) {
            addCriterion("orig_user_id <", value, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdLessThanOrEqualTo(Long value) {
            addCriterion("orig_user_id <=", value, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdIn(List<Long> values) {
            addCriterion("orig_user_id in", values, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdNotIn(List<Long> values) {
            addCriterion("orig_user_id not in", values, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdBetween(Long value1, Long value2) {
            addCriterion("orig_user_id between", value1, value2, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOrigUserIdNotBetween(Long value1, Long value2) {
            addCriterion("orig_user_id not between", value1, value2, "origUserId");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorIsNull() {
            addCriterion("original_Author is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorIsNotNull() {
            addCriterion("original_Author is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorEqualTo(String value) {
            addCriterion("original_Author =", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorNotEqualTo(String value) {
            addCriterion("original_Author <>", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorGreaterThan(String value) {
            addCriterion("original_Author >", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("original_Author >=", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorLessThan(String value) {
            addCriterion("original_Author <", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorLessThanOrEqualTo(String value) {
            addCriterion("original_Author <=", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorLike(String value) {
            addCriterion("original_Author like", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorNotLike(String value) {
            addCriterion("original_Author not like", value, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorIn(List<String> values) {
            addCriterion("original_Author in", values, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorNotIn(List<String> values) {
            addCriterion("original_Author not in", values, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorBetween(String value1, String value2) {
            addCriterion("original_Author between", value1, value2, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andOriginalAuthorNotBetween(String value1, String value2) {
            addCriterion("original_Author not between", value1, value2, "originalAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_Title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_Title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_Title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_Title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_Title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_Title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_Title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_Title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_Title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_Title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_Title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_Title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_Title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_Title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNull() {
            addCriterion("article_Type is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNotNull() {
            addCriterion("article_Type is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeEqualTo(Long value) {
            addCriterion("article_Type =", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotEqualTo(Long value) {
            addCriterion("article_Type <>", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThan(Long value) {
            addCriterion("article_Type >", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("article_Type >=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThan(Long value) {
            addCriterion("article_Type <", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThanOrEqualTo(Long value) {
            addCriterion("article_Type <=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIn(List<Long> values) {
            addCriterion("article_Type in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotIn(List<Long> values) {
            addCriterion("article_Type not in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeBetween(Long value1, Long value2) {
            addCriterion("article_Type between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotBetween(Long value1, Long value2) {
            addCriterion("article_Type not between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleImageIsNull() {
            addCriterion("article_image is null");
            return (Criteria) this;
        }

        public Criteria andArticleImageIsNotNull() {
            addCriterion("article_image is not null");
            return (Criteria) this;
        }

        public Criteria andArticleImageEqualTo(Long value) {
            addCriterion("article_image =", value, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageNotEqualTo(Long value) {
            addCriterion("article_image <>", value, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageGreaterThan(Long value) {
            addCriterion("article_image >", value, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageGreaterThanOrEqualTo(Long value) {
            addCriterion("article_image >=", value, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageLessThan(Long value) {
            addCriterion("article_image <", value, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageLessThanOrEqualTo(Long value) {
            addCriterion("article_image <=", value, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageIn(List<Long> values) {
            addCriterion("article_image in", values, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageNotIn(List<Long> values) {
            addCriterion("article_image not in", values, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageBetween(Long value1, Long value2) {
            addCriterion("article_image between", value1, value2, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleImageNotBetween(Long value1, Long value2) {
            addCriterion("article_image not between", value1, value2, "articleImage");
            return (Criteria) this;
        }

        public Criteria andArticleHitsIsNull() {
            addCriterion("article_Hits is null");
            return (Criteria) this;
        }

        public Criteria andArticleHitsIsNotNull() {
            addCriterion("article_Hits is not null");
            return (Criteria) this;
        }

        public Criteria andArticleHitsEqualTo(Long value) {
            addCriterion("article_Hits =", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsNotEqualTo(Long value) {
            addCriterion("article_Hits <>", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsGreaterThan(Long value) {
            addCriterion("article_Hits >", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsGreaterThanOrEqualTo(Long value) {
            addCriterion("article_Hits >=", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsLessThan(Long value) {
            addCriterion("article_Hits <", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsLessThanOrEqualTo(Long value) {
            addCriterion("article_Hits <=", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsLike(Long value) {
            addCriterion("article_Hits like", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsNotLike(Long value) {
            addCriterion("article_Hits not like", value, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsIn(List<Long> values) {
            addCriterion("article_Hits in", values, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsNotIn(List<Long> values) {
            addCriterion("article_Hits not in", values, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsBetween(Long value1, Long value2) {
            addCriterion("article_Hits between", value1, value2, "articleHits");
            return (Criteria) this;
        }

        public Criteria andArticleHitsNotBetween(Long value1, Long value2) {
            addCriterion("article_Hits not between", value1, value2, "articleHits");
            return (Criteria) this;
        }

        public Criteria andSaveDateIsNull() {
            addCriterion("save_Date is null");
            return (Criteria) this;
        }

        public Criteria andSaveDateIsNotNull() {
            addCriterion("save_Date is not null");
            return (Criteria) this;
        }

        public Criteria andSaveDateEqualTo(String value) {
            addCriterion("save_Date =", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateNotEqualTo(String value) {
            addCriterion("save_Date <>", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateGreaterThan(String value) {
            addCriterion("save_Date >", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateGreaterThanOrEqualTo(String value) {
            addCriterion("save_Date >=", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateLessThan(String value) {
            addCriterion("save_Date <", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateLessThanOrEqualTo(String value) {
            addCriterion("save_Date <=", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateLike(String value) {
            addCriterion("save_Date like", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateNotLike(String value) {
            addCriterion("save_Date not like", value, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateIn(List<String> values) {
            addCriterion("save_Date in", values, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateNotIn(List<String> values) {
            addCriterion("save_Date not in", values, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateBetween(String value1, String value2) {
            addCriterion("save_Date between", value1, value2, "saveDate");
            return (Criteria) this;
        }

        public Criteria andSaveDateNotBetween(String value1, String value2) {
            addCriterion("save_Date not between", value1, value2, "saveDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_Date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_Date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(String value) {
            addCriterion("publish_Date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(String value) {
            addCriterion("publish_Date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(String value) {
            addCriterion("publish_Date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(String value) {
            addCriterion("publish_Date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(String value) {
            addCriterion("publish_Date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(String value) {
            addCriterion("publish_Date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLike(String value) {
            addCriterion("publish_Date like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotLike(String value) {
            addCriterion("publish_Date not like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<String> values) {
            addCriterion("publish_Date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<String> values) {
            addCriterion("publish_Date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(String value1, String value2) {
            addCriterion("publish_Date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(String value1, String value2) {
            addCriterion("publish_Date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_Date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_Date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("update_Date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("update_Date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("update_Date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("update_Date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("update_Date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("update_Date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("update_Date like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("update_Date not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("update_Date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("update_Date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("update_Date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("update_Date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUrlIsNull() {
            addCriterion("article_Url is null");
            return (Criteria) this;
        }

        public Criteria andArticleUrlIsNotNull() {
            addCriterion("article_Url is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUrlEqualTo(String value) {
            addCriterion("article_Url =", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotEqualTo(String value) {
            addCriterion("article_Url <>", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlGreaterThan(String value) {
            addCriterion("article_Url >", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("article_Url >=", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlLessThan(String value) {
            addCriterion("article_Url <", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlLessThanOrEqualTo(String value) {
            addCriterion("article_Url <=", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlLike(String value) {
            addCriterion("article_Url like", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotLike(String value) {
            addCriterion("article_Url not like", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlIn(List<String> values) {
            addCriterion("article_Url in", values, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotIn(List<String> values) {
            addCriterion("article_Url not in", values, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlBetween(String value1, String value2) {
            addCriterion("article_Url between", value1, value2, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotBetween(String value1, String value2) {
            addCriterion("article_Url not between", value1, value2, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidIsNull() {
            addCriterion("article_Tabloid is null");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidIsNotNull() {
            addCriterion("article_Tabloid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidEqualTo(String value) {
            addCriterion("article_Tabloid =", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidNotEqualTo(String value) {
            addCriterion("article_Tabloid <>", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidGreaterThan(String value) {
            addCriterion("article_Tabloid >", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidGreaterThanOrEqualTo(String value) {
            addCriterion("article_Tabloid >=", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidLessThan(String value) {
            addCriterion("article_Tabloid <", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidLessThanOrEqualTo(String value) {
            addCriterion("article_Tabloid <=", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidLike(String value) {
            addCriterion("article_Tabloid like", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidNotLike(String value) {
            addCriterion("article_Tabloid not like", value, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidIn(List<String> values) {
            addCriterion("article_Tabloid in", values, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidNotIn(List<String> values) {
            addCriterion("article_Tabloid not in", values, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidBetween(String value1, String value2) {
            addCriterion("article_Tabloid between", value1, value2, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andArticleTabloidNotBetween(String value1, String value2) {
            addCriterion("article_Tabloid not between", value1, value2, "articleTabloid");
            return (Criteria) this;
        }

        public Criteria andLikeYesIsNull() {
            addCriterion("like_yes is null");
            return (Criteria) this;
        }

        public Criteria andLikeYesIsNotNull() {
            addCriterion("like_yes is not null");
            return (Criteria) this;
        }

        public Criteria andLikeYesEqualTo(Integer value) {
            addCriterion("like_yes =", value, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesNotEqualTo(Integer value) {
            addCriterion("like_yes <>", value, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesGreaterThan(Integer value) {
            addCriterion("like_yes >", value, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_yes >=", value, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesLessThan(Integer value) {
            addCriterion("like_yes <", value, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesLessThanOrEqualTo(Integer value) {
            addCriterion("like_yes <=", value, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesIn(List<Integer> values) {
            addCriterion("like_yes in", values, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesNotIn(List<Integer> values) {
            addCriterion("like_yes not in", values, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesBetween(Integer value1, Integer value2) {
            addCriterion("like_yes between", value1, value2, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeYesNotBetween(Integer value1, Integer value2) {
            addCriterion("like_yes not between", value1, value2, "likeYes");
            return (Criteria) this;
        }

        public Criteria andLikeNoIsNull() {
            addCriterion("like_no is null");
            return (Criteria) this;
        }

        public Criteria andLikeNoIsNotNull() {
            addCriterion("like_no is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNoEqualTo(Integer value) {
            addCriterion("like_no =", value, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoNotEqualTo(Integer value) {
            addCriterion("like_no <>", value, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoGreaterThan(Integer value) {
            addCriterion("like_no >", value, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_no >=", value, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoLessThan(Integer value) {
            addCriterion("like_no <", value, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoLessThanOrEqualTo(Integer value) {
            addCriterion("like_no <=", value, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoIn(List<Integer> values) {
            addCriterion("like_no in", values, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoNotIn(List<Integer> values) {
            addCriterion("like_no not in", values, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoBetween(Integer value1, Integer value2) {
            addCriterion("like_no between", value1, value2, "likeNo");
            return (Criteria) this;
        }

        public Criteria andLikeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("like_no not between", value1, value2, "likeNo");
            return (Criteria) this;
        }

        public Criteria andBestIsNull() {
            addCriterion("best is null");
            return (Criteria) this;
        }

        public Criteria andBestIsNotNull() {
            addCriterion("best is not null");
            return (Criteria) this;
        }

        public Criteria andBestEqualTo(Integer value) {
            addCriterion("best =", value, "best");
            return (Criteria) this;
        }

        public Criteria andBestNotEqualTo(Integer value) {
            addCriterion("best <>", value, "best");
            return (Criteria) this;
        }

        public Criteria andBestGreaterThan(Integer value) {
            addCriterion("best >", value, "best");
            return (Criteria) this;
        }

        public Criteria andBestGreaterThanOrEqualTo(Integer value) {
            addCriterion("best >=", value, "best");
            return (Criteria) this;
        }

        public Criteria andBestLessThan(Integer value) {
            addCriterion("best <", value, "best");
            return (Criteria) this;
        }

        public Criteria andBestLessThanOrEqualTo(Integer value) {
            addCriterion("best <=", value, "best");
            return (Criteria) this;
        }

        public Criteria andBestIn(List<Integer> values) {
            addCriterion("best in", values, "best");
            return (Criteria) this;
        }

        public Criteria andBestNotIn(List<Integer> values) {
            addCriterion("best not in", values, "best");
            return (Criteria) this;
        }

        public Criteria andBestBetween(Integer value1, Integer value2) {
            addCriterion("best between", value1, value2, "best");
            return (Criteria) this;
        }

        public Criteria andBestNotBetween(Integer value1, Integer value2) {
            addCriterion("best not between", value1, value2, "best");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdIsNull() {
            addCriterion("last_Article_Id is null");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdIsNotNull() {
            addCriterion("last_Article_Id is not null");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdEqualTo(Long value) {
            addCriterion("last_Article_Id =", value, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdNotEqualTo(Long value) {
            addCriterion("last_Article_Id <>", value, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdGreaterThan(Long value) {
            addCriterion("last_Article_Id >", value, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_Article_Id >=", value, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdLessThan(Long value) {
            addCriterion("last_Article_Id <", value, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("last_Article_Id <=", value, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdIn(List<Long> values) {
            addCriterion("last_Article_Id in", values, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdNotIn(List<Long> values) {
            addCriterion("last_Article_Id not in", values, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdBetween(Long value1, Long value2) {
            addCriterion("last_Article_Id between", value1, value2, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andLastArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("last_Article_Id not between", value1, value2, "lastArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdIsNull() {
            addCriterion("next_Article_Id is null");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdIsNotNull() {
            addCriterion("next_Article_Id is not null");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdEqualTo(Long value) {
            addCriterion("next_Article_Id =", value, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdNotEqualTo(Long value) {
            addCriterion("next_Article_Id <>", value, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdGreaterThan(Long value) {
            addCriterion("next_Article_Id >", value, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("next_Article_Id >=", value, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdLessThan(Long value) {
            addCriterion("next_Article_Id <", value, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("next_Article_Id <=", value, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdIn(List<Long> values) {
            addCriterion("next_Article_Id in", values, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdNotIn(List<Long> values) {
            addCriterion("next_Article_Id not in", values, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdBetween(Long value1, Long value2) {
            addCriterion("next_Article_Id between", value1, value2, "nextArticleId");
            return (Criteria) this;
        }

        public Criteria andNextArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("next_Article_Id not between", value1, value2, "nextArticleId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}