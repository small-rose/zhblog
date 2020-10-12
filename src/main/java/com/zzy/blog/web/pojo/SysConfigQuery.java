package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysConfigQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysConfigQuery() {
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

        public Criteria andConfigModuleIsNull() {
            addCriterion("config_module is null");
            return (Criteria) this;
        }

        public Criteria andConfigModuleIsNotNull() {
            addCriterion("config_module is not null");
            return (Criteria) this;
        }

        public Criteria andConfigModuleEqualTo(String value) {
            addCriterion("config_module =", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleNotEqualTo(String value) {
            addCriterion("config_module <>", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleGreaterThan(String value) {
            addCriterion("config_module >", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleGreaterThanOrEqualTo(String value) {
            addCriterion("config_module >=", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleLessThan(String value) {
            addCriterion("config_module <", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleLessThanOrEqualTo(String value) {
            addCriterion("config_module <=", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleLike(String value) {
            addCriterion("config_module like", value, "configModule");
            return (Criteria) this;
        }
        public Criteria andConfigModuleLikeAnyWhere(String value) {
            addCriterion("config_module like", "%" +value + "%", "configModule");
            return (Criteria) this;
        }
        
        public Criteria andConfigModuleNotLike(String value) {
            addCriterion("config_module not like", value, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleIn(List<String> values) {
            addCriterion("config_module in", values, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleNotIn(List<String> values) {
            addCriterion("config_module not in", values, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleBetween(String value1, String value2) {
            addCriterion("config_module between", value1, value2, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigModuleNotBetween(String value1, String value2) {
            addCriterion("config_module not between", value1, value2, "configModule");
            return (Criteria) this;
        }

        public Criteria andConfigCodeIsNull() {
            addCriterion("config_code is null");
            return (Criteria) this;
        }

        public Criteria andConfigCodeIsNotNull() {
            addCriterion("config_code is not null");
            return (Criteria) this;
        }

        public Criteria andConfigCodeEqualTo(String value) {
            addCriterion("config_code =", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeNotEqualTo(String value) {
            addCriterion("config_code <>", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeGreaterThan(String value) {
            addCriterion("config_code >", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeGreaterThanOrEqualTo(String value) {
            addCriterion("config_code >=", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeLessThan(String value) {
            addCriterion("config_code <", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeLessThanOrEqualTo(String value) {
            addCriterion("config_code <=", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeLike(String value) {
            addCriterion("config_code like", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeNotLike(String value) {
            addCriterion("config_code not like", value, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeIn(List<String> values) {
            addCriterion("config_code in", values, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeNotIn(List<String> values) {
            addCriterion("config_code not in", values, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeBetween(String value1, String value2) {
            addCriterion("config_code between", value1, value2, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigCodeNotBetween(String value1, String value2) {
            addCriterion("config_code not between", value1, value2, "configCode");
            return (Criteria) this;
        }

        public Criteria andConfigNameIsNull() {
            addCriterion("config_name is null");
            return (Criteria) this;
        }

        public Criteria andConfigNameIsNotNull() {
            addCriterion("config_name is not null");
            return (Criteria) this;
        }

        public Criteria andConfigNameEqualTo(String value) {
            addCriterion("config_name =", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotEqualTo(String value) {
            addCriterion("config_name <>", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameGreaterThan(String value) {
            addCriterion("config_name >", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameGreaterThanOrEqualTo(String value) {
            addCriterion("config_name >=", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameLessThan(String value) {
            addCriterion("config_name <", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameLessThanOrEqualTo(String value) {
            addCriterion("config_name <=", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameLike(String value) {
            addCriterion("config_name like", value, "configName");
            return (Criteria) this;
        }
        public Criteria andConfigNameLikeAnyWhere(String value) {
            addCriterion("config_name like", "%"+value+"%", "configName");
            return (Criteria) this;
        }
        
        public Criteria andConfigNameNotLike(String value) {
            addCriterion("config_name not like", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameIn(List<String> values) {
            addCriterion("config_name in", values, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotIn(List<String> values) {
            addCriterion("config_name not in", values, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameBetween(String value1, String value2) {
            addCriterion("config_name between", value1, value2, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotBetween(String value1, String value2) {
            addCriterion("config_name not between", value1, value2, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigValueIsNull() {
            addCriterion("config_value is null");
            return (Criteria) this;
        }

        public Criteria andConfigValueIsNotNull() {
            addCriterion("config_value is not null");
            return (Criteria) this;
        }

        public Criteria andConfigValueEqualTo(String value) {
            addCriterion("config_value =", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueNotEqualTo(String value) {
            addCriterion("config_value <>", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueGreaterThan(String value) {
            addCriterion("config_value >", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueGreaterThanOrEqualTo(String value) {
            addCriterion("config_value >=", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueLessThan(String value) {
            addCriterion("config_value <", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueLessThanOrEqualTo(String value) {
            addCriterion("config_value <=", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueLike(String value) {
            addCriterion("config_value like", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueNotLike(String value) {
            addCriterion("config_value not like", value, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueIn(List<String> values) {
            addCriterion("config_value in", values, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueNotIn(List<String> values) {
            addCriterion("config_value not in", values, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueBetween(String value1, String value2) {
            addCriterion("config_value between", value1, value2, "configValue");
            return (Criteria) this;
        }

        public Criteria andConfigValueNotBetween(String value1, String value2) {
            addCriterion("config_value not between", value1, value2, "configValue");
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

        public Criteria andUpdDateIsNull() {
            addCriterion("upd_Date is null");
            return (Criteria) this;
        }

        public Criteria andUpdDateIsNotNull() {
            addCriterion("upd_Date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdDateEqualTo(String value) {
            addCriterion("upd_Date =", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateNotEqualTo(String value) {
            addCriterion("upd_Date <>", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateGreaterThan(String value) {
            addCriterion("upd_Date >", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateGreaterThanOrEqualTo(String value) {
            addCriterion("upd_Date >=", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateLessThan(String value) {
            addCriterion("upd_Date <", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateLessThanOrEqualTo(String value) {
            addCriterion("upd_Date <=", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateLike(String value) {
            addCriterion("upd_Date like", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateNotLike(String value) {
            addCriterion("upd_Date not like", value, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateIn(List<String> values) {
            addCriterion("upd_Date in", values, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateNotIn(List<String> values) {
            addCriterion("upd_Date not in", values, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateBetween(String value1, String value2) {
            addCriterion("upd_Date between", value1, value2, "updDate");
            return (Criteria) this;
        }

        public Criteria andUpdDateNotBetween(String value1, String value2) {
            addCriterion("upd_Date not between", value1, value2, "updDate");
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