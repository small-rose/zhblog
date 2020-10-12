package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class MoodQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoodQuery() {
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

        public Criteria andMoodDateIsNull() {
            addCriterion("mood_date is null");
            return (Criteria) this;
        }

        public Criteria andMoodDateIsNotNull() {
            addCriterion("mood_date is not null");
            return (Criteria) this;
        }

        public Criteria andMoodDateEqualTo(String value) {
            addCriterion("mood_date =", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotEqualTo(String value) {
            addCriterion("mood_date <>", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateGreaterThan(String value) {
            addCriterion("mood_date >", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateGreaterThanOrEqualTo(String value) {
            addCriterion("mood_date >=", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateLessThan(String value) {
            addCriterion("mood_date <", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateLessThanOrEqualTo(String value) {
            addCriterion("mood_date <=", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateLike(String value) {
            addCriterion("mood_date like", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotLike(String value) {
            addCriterion("mood_date not like", value, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateIn(List<String> values) {
            addCriterion("mood_date in", values, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotIn(List<String> values) {
            addCriterion("mood_date not in", values, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateBetween(String value1, String value2) {
            addCriterion("mood_date between", value1, value2, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodDateNotBetween(String value1, String value2) {
            addCriterion("mood_date not between", value1, value2, "moodDate");
            return (Criteria) this;
        }

        public Criteria andMoodTitleIsNull() {
            addCriterion("mood_title is null");
            return (Criteria) this;
        }

        public Criteria andMoodTitleIsNotNull() {
            addCriterion("mood_title is not null");
            return (Criteria) this;
        }

        public Criteria andMoodTitleEqualTo(String value) {
            addCriterion("mood_title =", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleNotEqualTo(String value) {
            addCriterion("mood_title <>", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleGreaterThan(String value) {
            addCriterion("mood_title >", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleGreaterThanOrEqualTo(String value) {
            addCriterion("mood_title >=", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleLessThan(String value) {
            addCriterion("mood_title <", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleLessThanOrEqualTo(String value) {
            addCriterion("mood_title <=", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleLike(String value) {
            addCriterion("mood_title like","%"+ value + "%", "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleNotLike(String value) {
            addCriterion("mood_title not like", value, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleIn(List<String> values) {
            addCriterion("mood_title in", values, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleNotIn(List<String> values) {
            addCriterion("mood_title not in", values, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleBetween(String value1, String value2) {
            addCriterion("mood_title between", value1, value2, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodTitleNotBetween(String value1, String value2) {
            addCriterion("mood_title not between", value1, value2, "moodTitle");
            return (Criteria) this;
        }

        public Criteria andMoodContentIsNull() {
            addCriterion("mood_content is null");
            return (Criteria) this;
        }

        public Criteria andMoodContentIsNotNull() {
            addCriterion("mood_content is not null");
            return (Criteria) this;
        }

        public Criteria andMoodContentEqualTo(String value) {
            addCriterion("mood_content =", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotEqualTo(String value) {
            addCriterion("mood_content <>", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentGreaterThan(String value) {
            addCriterion("mood_content >", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentGreaterThanOrEqualTo(String value) {
            addCriterion("mood_content >=", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentLessThan(String value) {
            addCriterion("mood_content <", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentLessThanOrEqualTo(String value) {
            addCriterion("mood_content <=", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentLike(String value) {
            addCriterion("mood_content like", "%" + value + "%", "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotLike(String value) {
            addCriterion("mood_content not like", value, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentIn(List<String> values) {
            addCriterion("mood_content in", values, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotIn(List<String> values) {
            addCriterion("mood_content not in", values, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentBetween(String value1, String value2) {
            addCriterion("mood_content between", value1, value2, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodContentNotBetween(String value1, String value2) {
            addCriterion("mood_content not between", value1, value2, "moodContent");
            return (Criteria) this;
        }

        public Criteria andMoodPicIsNull() {
            addCriterion("mood_pic is null");
            return (Criteria) this;
        }

        public Criteria andMoodPicIsNotNull() {
            addCriterion("mood_pic is not null");
            return (Criteria) this;
        }

        public Criteria andMoodPicEqualTo(String value) {
            addCriterion("mood_pic =", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotEqualTo(String value) {
            addCriterion("mood_pic <>", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicGreaterThan(String value) {
            addCriterion("mood_pic >", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicGreaterThanOrEqualTo(String value) {
            addCriterion("mood_pic >=", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicLessThan(String value) {
            addCriterion("mood_pic <", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicLessThanOrEqualTo(String value) {
            addCriterion("mood_pic <=", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicLike(String value) {
            addCriterion("mood_pic like", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotLike(String value) {
            addCriterion("mood_pic not like", value, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicIn(List<String> values) {
            addCriterion("mood_pic in", values, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotIn(List<String> values) {
            addCriterion("mood_pic not in", values, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicBetween(String value1, String value2) {
            addCriterion("mood_pic between", value1, value2, "moodPic");
            return (Criteria) this;
        }

        public Criteria andMoodPicNotBetween(String value1, String value2) {
            addCriterion("mood_pic not between", value1, value2, "moodPic");
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