package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommentQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentQuery() {
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_Id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_Id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_Id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_Id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_Id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_Id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_Id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_Id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_Id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_Id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_Id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_Id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andCmtUtxIsNull() {
            addCriterion("cmt_utx is null");
            return (Criteria) this;
        }

        public Criteria andCmtUtxIsNotNull() {
            addCriterion("cmt_utx is not null");
            return (Criteria) this;
        }

        public Criteria andCmtUtxEqualTo(String value) {
            addCriterion("cmt_utx =", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxNotEqualTo(String value) {
            addCriterion("cmt_utx <>", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxGreaterThan(String value) {
            addCriterion("cmt_utx >", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxGreaterThanOrEqualTo(String value) {
            addCriterion("cmt_utx >=", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxLessThan(String value) {
            addCriterion("cmt_utx <", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxLessThanOrEqualTo(String value) {
            addCriterion("cmt_utx <=", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxLike(String value) {
            addCriterion("cmt_utx like", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxNotLike(String value) {
            addCriterion("cmt_utx not like", value, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxIn(List<String> values) {
            addCriterion("cmt_utx in", values, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxNotIn(List<String> values) {
            addCriterion("cmt_utx not in", values, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxBetween(String value1, String value2) {
            addCriterion("cmt_utx between", value1, value2, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUtxNotBetween(String value1, String value2) {
            addCriterion("cmt_utx not between", value1, value2, "cmtUtx");
            return (Criteria) this;
        }

        public Criteria andCmtUnameIsNull() {
            addCriterion("cmt_uname is null");
            return (Criteria) this;
        }

        public Criteria andCmtUnameIsNotNull() {
            addCriterion("cmt_uname is not null");
            return (Criteria) this;
        }

        public Criteria andCmtUnameEqualTo(String value) {
            addCriterion("cmt_uname =", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameNotEqualTo(String value) {
            addCriterion("cmt_uname <>", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameGreaterThan(String value) {
            addCriterion("cmt_uname >", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameGreaterThanOrEqualTo(String value) {
            addCriterion("cmt_uname >=", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameLessThan(String value) {
            addCriterion("cmt_uname <", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameLessThanOrEqualTo(String value) {
            addCriterion("cmt_uname <=", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameLike(String value) {
            addCriterion("cmt_uname like", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameNotLike(String value) {
            addCriterion("cmt_uname not like", value, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameIn(List<String> values) {
            addCriterion("cmt_uname in", values, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameNotIn(List<String> values) {
            addCriterion("cmt_uname not in", values, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameBetween(String value1, String value2) {
            addCriterion("cmt_uname between", value1, value2, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUnameNotBetween(String value1, String value2) {
            addCriterion("cmt_uname not between", value1, value2, "cmtUname");
            return (Criteria) this;
        }

        public Criteria andCmtUemailIsNull() {
            addCriterion("cmt_uemail is null");
            return (Criteria) this;
        }

        public Criteria andCmtUemailIsNotNull() {
            addCriterion("cmt_uemail is not null");
            return (Criteria) this;
        }

        public Criteria andCmtUemailEqualTo(String value) {
            addCriterion("cmt_uemail =", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailNotEqualTo(String value) {
            addCriterion("cmt_uemail <>", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailGreaterThan(String value) {
            addCriterion("cmt_uemail >", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailGreaterThanOrEqualTo(String value) {
            addCriterion("cmt_uemail >=", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailLessThan(String value) {
            addCriterion("cmt_uemail <", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailLessThanOrEqualTo(String value) {
            addCriterion("cmt_uemail <=", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailLike(String value) {
            addCriterion("cmt_uemail like", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailNotLike(String value) {
            addCriterion("cmt_uemail not like", value, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailIn(List<String> values) {
            addCriterion("cmt_uemail in", values, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailNotIn(List<String> values) {
            addCriterion("cmt_uemail not in", values, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailBetween(String value1, String value2) {
            addCriterion("cmt_uemail between", value1, value2, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtUemailNotBetween(String value1, String value2) {
            addCriterion("cmt_uemail not between", value1, value2, "cmtUemail");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlIsNull() {
            addCriterion("cmt_web_url is null");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlIsNotNull() {
            addCriterion("cmt_web_url is not null");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlEqualTo(String value) {
            addCriterion("cmt_web_url =", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlNotEqualTo(String value) {
            addCriterion("cmt_web_url <>", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlGreaterThan(String value) {
            addCriterion("cmt_web_url >", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cmt_web_url >=", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlLessThan(String value) {
            addCriterion("cmt_web_url <", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlLessThanOrEqualTo(String value) {
            addCriterion("cmt_web_url <=", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlLike(String value) {
            addCriterion("cmt_web_url like", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlNotLike(String value) {
            addCriterion("cmt_web_url not like", value, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlIn(List<String> values) {
            addCriterion("cmt_web_url in", values, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlNotIn(List<String> values) {
            addCriterion("cmt_web_url not in", values, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlBetween(String value1, String value2) {
            addCriterion("cmt_web_url between", value1, value2, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtWebUrlNotBetween(String value1, String value2) {
            addCriterion("cmt_web_url not between", value1, value2, "cmtWebUrl");
            return (Criteria) this;
        }

        public Criteria andCmtApprIsNull() {
            addCriterion("cmt_appr is null");
            return (Criteria) this;
        }

        public Criteria andCmtApprIsNotNull() {
            addCriterion("cmt_appr is not null");
            return (Criteria) this;
        }

        public Criteria andCmtApprEqualTo(Integer value) {
            addCriterion("cmt_appr =", value, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprNotEqualTo(Integer value) {
            addCriterion("cmt_appr <>", value, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprGreaterThan(Integer value) {
            addCriterion("cmt_appr >", value, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmt_appr >=", value, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprLessThan(Integer value) {
            addCriterion("cmt_appr <", value, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprLessThanOrEqualTo(Integer value) {
            addCriterion("cmt_appr <=", value, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprIn(List<Integer> values) {
            addCriterion("cmt_appr in", values, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprNotIn(List<Integer> values) {
            addCriterion("cmt_appr not in", values, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprBetween(Integer value1, Integer value2) {
            addCriterion("cmt_appr between", value1, value2, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtApprNotBetween(Integer value1, Integer value2) {
            addCriterion("cmt_appr not between", value1, value2, "cmtAppr");
            return (Criteria) this;
        }

        public Criteria andCmtDateIsNull() {
            addCriterion("cmt_Date is null");
            return (Criteria) this;
        }

        public Criteria andCmtDateIsNotNull() {
            addCriterion("cmt_Date is not null");
            return (Criteria) this;
        }

        public Criteria andCmtDateEqualTo(String value) {
            addCriterion("cmt_Date =", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateNotEqualTo(String value) {
            addCriterion("cmt_Date <>", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateGreaterThan(String value) {
            addCriterion("cmt_Date >", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateGreaterThanOrEqualTo(String value) {
            addCriterion("cmt_Date >=", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateLessThan(String value) {
            addCriterion("cmt_Date <", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateLessThanOrEqualTo(String value) {
            addCriterion("cmt_Date <=", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateLike(String value) {
            addCriterion("cmt_Date like", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateNotLike(String value) {
            addCriterion("cmt_Date not like", value, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateIn(List<String> values) {
            addCriterion("cmt_Date in", values, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateNotIn(List<String> values) {
            addCriterion("cmt_Date not in", values, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateBetween(String value1, String value2) {
            addCriterion("cmt_Date between", value1, value2, "cmtDate");
            return (Criteria) this;
        }

        public Criteria andCmtDateNotBetween(String value1, String value2) {
            addCriterion("cmt_Date not between", value1, value2, "cmtDate");
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