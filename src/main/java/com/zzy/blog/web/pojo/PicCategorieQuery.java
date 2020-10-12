package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class PicCategorieQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PicCategorieQuery() {
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

        public Criteria andPicCateCodeIsNull() {
            addCriterion("pic_Cate_code is null");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeIsNotNull() {
            addCriterion("pic_Cate_code is not null");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeEqualTo(String value) {
            addCriterion("pic_Cate_code =", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeNotEqualTo(String value) {
            addCriterion("pic_Cate_code <>", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeGreaterThan(String value) {
            addCriterion("pic_Cate_code >", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pic_Cate_code >=", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeLessThan(String value) {
            addCriterion("pic_Cate_code <", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeLessThanOrEqualTo(String value) {
            addCriterion("pic_Cate_code <=", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeLike(String value) {
            addCriterion("pic_Cate_code like", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeNotLike(String value) {
            addCriterion("pic_Cate_code not like", value, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeIn(List<String> values) {
            addCriterion("pic_Cate_code in", values, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeNotIn(List<String> values) {
            addCriterion("pic_Cate_code not in", values, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeBetween(String value1, String value2) {
            addCriterion("pic_Cate_code between", value1, value2, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateCodeNotBetween(String value1, String value2) {
            addCriterion("pic_Cate_code not between", value1, value2, "picCateCode");
            return (Criteria) this;
        }

        public Criteria andPicCateNameIsNull() {
            addCriterion("pic_Cate_name is null");
            return (Criteria) this;
        }

        public Criteria andPicCateNameIsNotNull() {
            addCriterion("pic_Cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andPicCateNameEqualTo(String value) {
            addCriterion("pic_Cate_name =", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameNotEqualTo(String value) {
            addCriterion("pic_Cate_name <>", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameGreaterThan(String value) {
            addCriterion("pic_Cate_name >", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_Cate_name >=", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameLessThan(String value) {
            addCriterion("pic_Cate_name <", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameLessThanOrEqualTo(String value) {
            addCriterion("pic_Cate_name <=", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameLike(String value) {
            addCriterion("pic_Cate_name like", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameNotLike(String value) {
            addCriterion("pic_Cate_name not like", value, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameIn(List<String> values) {
            addCriterion("pic_Cate_name in", values, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameNotIn(List<String> values) {
            addCriterion("pic_Cate_name not in", values, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameBetween(String value1, String value2) {
            addCriterion("pic_Cate_name between", value1, value2, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNameNotBetween(String value1, String value2) {
            addCriterion("pic_Cate_name not between", value1, value2, "picCateName");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteIsNull() {
            addCriterion("pic_Cate_Note is null");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteIsNotNull() {
            addCriterion("pic_Cate_Note is not null");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteEqualTo(String value) {
            addCriterion("pic_Cate_Note =", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteNotEqualTo(String value) {
            addCriterion("pic_Cate_Note <>", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteGreaterThan(String value) {
            addCriterion("pic_Cate_Note >", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteGreaterThanOrEqualTo(String value) {
            addCriterion("pic_Cate_Note >=", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteLessThan(String value) {
            addCriterion("pic_Cate_Note <", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteLessThanOrEqualTo(String value) {
            addCriterion("pic_Cate_Note <=", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteLike(String value) {
            addCriterion("pic_Cate_Note like", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteNotLike(String value) {
            addCriterion("pic_Cate_Note not like", value, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteIn(List<String> values) {
            addCriterion("pic_Cate_Note in", values, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteNotIn(List<String> values) {
            addCriterion("pic_Cate_Note not in", values, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteBetween(String value1, String value2) {
            addCriterion("pic_Cate_Note between", value1, value2, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andPicCateNoteNotBetween(String value1, String value2) {
            addCriterion("pic_Cate_Note not between", value1, value2, "picCateNote");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderIsNull() {
            addCriterion("pic_Cate_order is null");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderIsNotNull() {
            addCriterion("pic_Cate_order is not null");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderEqualTo(Integer value) {
            addCriterion("pic_Cate_order =", value, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderNotEqualTo(Integer value) {
            addCriterion("pic_Cate_order <>", value, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderGreaterThan(Integer value) {
            addCriterion("pic_Cate_order >", value, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_Cate_order >=", value, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderLessThan(Integer value) {
            addCriterion("pic_Cate_order <", value, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderLessThanOrEqualTo(Integer value) {
            addCriterion("pic_Cate_order <=", value, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderIn(List<Integer> values) {
            addCriterion("pic_Cate_order in", values, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderNotIn(List<Integer> values) {
            addCriterion("pic_Cate_order not in", values, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderBetween(Integer value1, Integer value2) {
            addCriterion("pic_Cate_order between", value1, value2, "picCateOrder");
            return (Criteria) this;
        }

        public Criteria andPicCateOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_Cate_order not between", value1, value2, "picCateOrder");
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