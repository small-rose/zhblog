package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class LinkQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LinkQuery() {
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

        public Criteria andLinkUrlIsNull() {
            addCriterion("link_url is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("link_url is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("link_url =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("link_url <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("link_url >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("link_url >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("link_url <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("link_url <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("link_url like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("link_url not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("link_url in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("link_url not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("link_url between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("link_url not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNull() {
            addCriterion("link_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("link_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("link_name =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("link_name <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("link_name >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("link_name >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("link_name <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("link_name <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("link_name like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("link_name not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("link_name in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("link_name not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("link_name between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("link_name not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkTxIsNull() {
            addCriterion("link_tx is null");
            return (Criteria) this;
        }

        public Criteria andLinkTxIsNotNull() {
            addCriterion("link_tx is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTxEqualTo(String value) {
            addCriterion("link_tx =", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxNotEqualTo(String value) {
            addCriterion("link_tx <>", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxGreaterThan(String value) {
            addCriterion("link_tx >", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxGreaterThanOrEqualTo(String value) {
            addCriterion("link_tx >=", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxLessThan(String value) {
            addCriterion("link_tx <", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxLessThanOrEqualTo(String value) {
            addCriterion("link_tx <=", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxLike(String value) {
            addCriterion("link_tx like", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxNotLike(String value) {
            addCriterion("link_tx not like", value, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxIn(List<String> values) {
            addCriterion("link_tx in", values, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxNotIn(List<String> values) {
            addCriterion("link_tx not in", values, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxBetween(String value1, String value2) {
            addCriterion("link_tx between", value1, value2, "linkTx");
            return (Criteria) this;
        }

        public Criteria andLinkTxNotBetween(String value1, String value2) {
            addCriterion("link_tx not between", value1, value2, "linkTx");
            return (Criteria) this;
        }

        public Criteria andApprFlagIsNull() {
            addCriterion("appr_flag is null");
            return (Criteria) this;
        }

        public Criteria andApprFlagIsNotNull() {
            addCriterion("appr_flag is not null");
            return (Criteria) this;
        }

        public Criteria andApprFlagEqualTo(Integer value) {
            addCriterion("appr_flag =", value, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagNotEqualTo(Integer value) {
            addCriterion("appr_flag <>", value, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagGreaterThan(Integer value) {
            addCriterion("appr_flag >", value, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("appr_flag >=", value, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagLessThan(Integer value) {
            addCriterion("appr_flag <", value, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagLessThanOrEqualTo(Integer value) {
            addCriterion("appr_flag <=", value, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagIn(List<Integer> values) {
            addCriterion("appr_flag in", values, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagNotIn(List<Integer> values) {
            addCriterion("appr_flag not in", values, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagBetween(Integer value1, Integer value2) {
            addCriterion("appr_flag between", value1, value2, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andApprFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("appr_flag not between", value1, value2, "apprFlag");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("add_Date is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("add_Date is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(String value) {
            addCriterion("add_Date =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(String value) {
            addCriterion("add_Date <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(String value) {
            addCriterion("add_Date >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(String value) {
            addCriterion("add_Date >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(String value) {
            addCriterion("add_Date <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(String value) {
            addCriterion("add_Date <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLike(String value) {
            addCriterion("add_Date like", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotLike(String value) {
            addCriterion("add_Date not like", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<String> values) {
            addCriterion("add_Date in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<String> values) {
            addCriterion("add_Date not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(String value1, String value2) {
            addCriterion("add_Date between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(String value1, String value2) {
            addCriterion("add_Date not between", value1, value2, "addDate");
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