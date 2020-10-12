package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysInfoQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysInfoQuery() {
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

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogStieIsNull() {
            addCriterion("blog_stie is null");
            return (Criteria) this;
        }

        public Criteria andBlogStieIsNotNull() {
            addCriterion("blog_stie is not null");
            return (Criteria) this;
        }

        public Criteria andBlogStieEqualTo(String value) {
            addCriterion("blog_stie =", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieNotEqualTo(String value) {
            addCriterion("blog_stie <>", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieGreaterThan(String value) {
            addCriterion("blog_stie >", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieGreaterThanOrEqualTo(String value) {
            addCriterion("blog_stie >=", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieLessThan(String value) {
            addCriterion("blog_stie <", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieLessThanOrEqualTo(String value) {
            addCriterion("blog_stie <=", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieLike(String value) {
            addCriterion("blog_stie like", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieNotLike(String value) {
            addCriterion("blog_stie not like", value, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieIn(List<String> values) {
            addCriterion("blog_stie in", values, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieNotIn(List<String> values) {
            addCriterion("blog_stie not in", values, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieBetween(String value1, String value2) {
            addCriterion("blog_stie between", value1, value2, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogStieNotBetween(String value1, String value2) {
            addCriterion("blog_stie not between", value1, value2, "blogStie");
            return (Criteria) this;
        }

        public Criteria andBlogBriefIsNull() {
            addCriterion("blog_brief is null");
            return (Criteria) this;
        }

        public Criteria andBlogBriefIsNotNull() {
            addCriterion("blog_brief is not null");
            return (Criteria) this;
        }

        public Criteria andBlogBriefEqualTo(String value) {
            addCriterion("blog_brief =", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefNotEqualTo(String value) {
            addCriterion("blog_brief <>", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefGreaterThan(String value) {
            addCriterion("blog_brief >", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefGreaterThanOrEqualTo(String value) {
            addCriterion("blog_brief >=", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefLessThan(String value) {
            addCriterion("blog_brief <", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefLessThanOrEqualTo(String value) {
            addCriterion("blog_brief <=", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefLike(String value) {
            addCriterion("blog_brief like", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefNotLike(String value) {
            addCriterion("blog_brief not like", value, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefIn(List<String> values) {
            addCriterion("blog_brief in", values, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefNotIn(List<String> values) {
            addCriterion("blog_brief not in", values, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefBetween(String value1, String value2) {
            addCriterion("blog_brief between", value1, value2, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogBriefNotBetween(String value1, String value2) {
            addCriterion("blog_brief not between", value1, value2, "blogBrief");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeIsNull() {
            addCriterion("blog_notice is null");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeIsNotNull() {
            addCriterion("blog_notice is not null");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeEqualTo(String value) {
            addCriterion("blog_notice =", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeNotEqualTo(String value) {
            addCriterion("blog_notice <>", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeGreaterThan(String value) {
            addCriterion("blog_notice >", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("blog_notice >=", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeLessThan(String value) {
            addCriterion("blog_notice <", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeLessThanOrEqualTo(String value) {
            addCriterion("blog_notice <=", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeLike(String value) {
            addCriterion("blog_notice like", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeNotLike(String value) {
            addCriterion("blog_notice not like", value, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeIn(List<String> values) {
            addCriterion("blog_notice in", values, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeNotIn(List<String> values) {
            addCriterion("blog_notice not in", values, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeBetween(String value1, String value2) {
            addCriterion("blog_notice between", value1, value2, "blogNotice");
            return (Criteria) this;
        }

        public Criteria andBlogNoticeNotBetween(String value1, String value2) {
            addCriterion("blog_notice not between", value1, value2, "blogNotice");
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