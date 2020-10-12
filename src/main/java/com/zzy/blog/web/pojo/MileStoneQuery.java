package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class MileStoneQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MileStoneQuery() {
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

        public Criteria andMsYearIsNull() {
            addCriterion("ms_year is null");
            return (Criteria) this;
        }

        public Criteria andMsYearIsNotNull() {
            addCriterion("ms_year is not null");
            return (Criteria) this;
        }

        public Criteria andMsYearEqualTo(String value) {
            addCriterion("ms_year =", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearNotEqualTo(String value) {
            addCriterion("ms_year <>", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearGreaterThan(String value) {
            addCriterion("ms_year >", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearGreaterThanOrEqualTo(String value) {
            addCriterion("ms_year >=", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearLessThan(String value) {
            addCriterion("ms_year <", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearLessThanOrEqualTo(String value) {
            addCriterion("ms_year <=", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearLike(String value) {
            addCriterion("ms_year like", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearNotLike(String value) {
            addCriterion("ms_year not like", value, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearIn(List<String> values) {
            addCriterion("ms_year in", values, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearNotIn(List<String> values) {
            addCriterion("ms_year not in", values, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearBetween(String value1, String value2) {
            addCriterion("ms_year between", value1, value2, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsYearNotBetween(String value1, String value2) {
            addCriterion("ms_year not between", value1, value2, "msYear");
            return (Criteria) this;
        }

        public Criteria andMsDateIsNull() {
            addCriterion("ms_date is null");
            return (Criteria) this;
        }

        public Criteria andMsDateIsNotNull() {
            addCriterion("ms_date is not null");
            return (Criteria) this;
        }

        public Criteria andMsDateEqualTo(String value) {
            addCriterion("ms_date =", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateNotEqualTo(String value) {
            addCriterion("ms_date <>", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateGreaterThan(String value) {
            addCriterion("ms_date >", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateGreaterThanOrEqualTo(String value) {
            addCriterion("ms_date >=", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateLessThan(String value) {
            addCriterion("ms_date <", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateLessThanOrEqualTo(String value) {
            addCriterion("ms_date <=", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateLike(String value) {
            addCriterion("ms_date like", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateNotLike(String value) {
            addCriterion("ms_date not like", value, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateIn(List<String> values) {
            addCriterion("ms_date in", values, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateNotIn(List<String> values) {
            addCriterion("ms_date not in", values, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateBetween(String value1, String value2) {
            addCriterion("ms_date between", value1, value2, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsDateNotBetween(String value1, String value2) {
            addCriterion("ms_date not between", value1, value2, "msDate");
            return (Criteria) this;
        }

        public Criteria andMsContentIsNull() {
            addCriterion("ms_content is null");
            return (Criteria) this;
        }

        public Criteria andMsContentIsNotNull() {
            addCriterion("ms_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsContentEqualTo(String value) {
            addCriterion("ms_content =", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentNotEqualTo(String value) {
            addCriterion("ms_content <>", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentGreaterThan(String value) {
            addCriterion("ms_content >", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentGreaterThanOrEqualTo(String value) {
            addCriterion("ms_content >=", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentLessThan(String value) {
            addCriterion("ms_content <", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentLessThanOrEqualTo(String value) {
            addCriterion("ms_content <=", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentLike(String value) {
            addCriterion("ms_content like", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentNotLike(String value) {
            addCriterion("ms_content not like", value, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentIn(List<String> values) {
            addCriterion("ms_content in", values, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentNotIn(List<String> values) {
            addCriterion("ms_content not in", values, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentBetween(String value1, String value2) {
            addCriterion("ms_content between", value1, value2, "msContent");
            return (Criteria) this;
        }

        public Criteria andMsContentNotBetween(String value1, String value2) {
            addCriterion("ms_content not between", value1, value2, "msContent");
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