package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class MessageQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageQuery() {
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
        public Criteria andParentIdIsNullOrZero() {
            addCriterion(" ( parent_id is null or parent_id = 0 ) ");
            return (Criteria) this;
        }
        
        
        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andMsgUtxIsNull() {
            addCriterion("msg_utx is null");
            return (Criteria) this;
        }

        public Criteria andMsgUtxIsNotNull() {
            addCriterion("msg_utx is not null");
            return (Criteria) this;
        }

        public Criteria andMsgUtxEqualTo(String value) {
            addCriterion("msg_utx =", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxNotEqualTo(String value) {
            addCriterion("msg_utx <>", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxGreaterThan(String value) {
            addCriterion("msg_utx >", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxGreaterThanOrEqualTo(String value) {
            addCriterion("msg_utx >=", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxLessThan(String value) {
            addCriterion("msg_utx <", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxLessThanOrEqualTo(String value) {
            addCriterion("msg_utx <=", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxLike(String value) {
            addCriterion("msg_utx like", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxNotLike(String value) {
            addCriterion("msg_utx not like", value, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxIn(List<String> values) {
            addCriterion("msg_utx in", values, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxNotIn(List<String> values) {
            addCriterion("msg_utx not in", values, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxBetween(String value1, String value2) {
            addCriterion("msg_utx between", value1, value2, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUtxNotBetween(String value1, String value2) {
            addCriterion("msg_utx not between", value1, value2, "msgUtx");
            return (Criteria) this;
        }

        public Criteria andMsgUnameIsNull() {
            addCriterion("msg_uname is null");
            return (Criteria) this;
        }

        public Criteria andMsgUnameIsNotNull() {
            addCriterion("msg_uname is not null");
            return (Criteria) this;
        }

        public Criteria andMsgUnameEqualTo(String value) {
            addCriterion("msg_uname =", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameNotEqualTo(String value) {
            addCriterion("msg_uname <>", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameGreaterThan(String value) {
            addCriterion("msg_uname >", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameGreaterThanOrEqualTo(String value) {
            addCriterion("msg_uname >=", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameLessThan(String value) {
            addCriterion("msg_uname <", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameLessThanOrEqualTo(String value) {
            addCriterion("msg_uname <=", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameLike(String value) {
            addCriterion("msg_uname like", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameNotLike(String value) {
            addCriterion("msg_uname not like", value, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameIn(List<String> values) {
            addCriterion("msg_uname in", values, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameNotIn(List<String> values) {
            addCriterion("msg_uname not in", values, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameBetween(String value1, String value2) {
            addCriterion("msg_uname between", value1, value2, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUnameNotBetween(String value1, String value2) {
            addCriterion("msg_uname not between", value1, value2, "msgUname");
            return (Criteria) this;
        }

        public Criteria andMsgUemailIsNull() {
            addCriterion("msg_uemail is null");
            return (Criteria) this;
        }

        public Criteria andMsgUemailIsNotNull() {
            addCriterion("msg_uemail is not null");
            return (Criteria) this;
        }

        public Criteria andMsgUemailEqualTo(String value) {
            addCriterion("msg_uemail =", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailNotEqualTo(String value) {
            addCriterion("msg_uemail <>", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailGreaterThan(String value) {
            addCriterion("msg_uemail >", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailGreaterThanOrEqualTo(String value) {
            addCriterion("msg_uemail >=", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailLessThan(String value) {
            addCriterion("msg_uemail <", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailLessThanOrEqualTo(String value) {
            addCriterion("msg_uemail <=", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailLike(String value) {
            addCriterion("msg_uemail like", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailNotLike(String value) {
            addCriterion("msg_uemail not like", value, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailIn(List<String> values) {
            addCriterion("msg_uemail in", values, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailNotIn(List<String> values) {
            addCriterion("msg_uemail not in", values, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailBetween(String value1, String value2) {
            addCriterion("msg_uemail between", value1, value2, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgUemailNotBetween(String value1, String value2) {
            addCriterion("msg_uemail not between", value1, value2, "msgUemail");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("msg_content is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("msg_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(String value) {
            addCriterion("msg_content =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(String value) {
            addCriterion("msg_content <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(String value) {
            addCriterion("msg_content >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("msg_content >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(String value) {
            addCriterion("msg_content <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(String value) {
            addCriterion("msg_content <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLike(String value) {
            addCriterion("msg_content like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotLike(String value) {
            addCriterion("msg_content not like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<String> values) {
            addCriterion("msg_content in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<String> values) {
            addCriterion("msg_content not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(String value1, String value2) {
            addCriterion("msg_content between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(String value1, String value2) {
            addCriterion("msg_content not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgTimeIsNull() {
            addCriterion("msg_time is null");
            return (Criteria) this;
        }

        public Criteria andMsgTimeIsNotNull() {
            addCriterion("msg_time is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTimeEqualTo(String value) {
            addCriterion("msg_time =", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotEqualTo(String value) {
            addCriterion("msg_time <>", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeGreaterThan(String value) {
            addCriterion("msg_time >", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeGreaterThanOrEqualTo(String value) {
            addCriterion("msg_time >=", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeLessThan(String value) {
            addCriterion("msg_time <", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeLessThanOrEqualTo(String value) {
            addCriterion("msg_time <=", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeLike(String value) {
            addCriterion("msg_time like", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotLike(String value) {
            addCriterion("msg_time not like", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeIn(List<String> values) {
            addCriterion("msg_time in", values, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotIn(List<String> values) {
            addCriterion("msg_time not in", values, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeBetween(String value1, String value2) {
            addCriterion("msg_time between", value1, value2, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotBetween(String value1, String value2) {
            addCriterion("msg_time not between", value1, value2, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgLikeIsNull() {
            addCriterion("msg_like is null");
            return (Criteria) this;
        }

        public Criteria andMsgLikeIsNotNull() {
            addCriterion("msg_like is not null");
            return (Criteria) this;
        }

        public Criteria andMsgLikeEqualTo(Integer value) {
            addCriterion("msg_like =", value, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeNotEqualTo(Integer value) {
            addCriterion("msg_like <>", value, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeGreaterThan(Integer value) {
            addCriterion("msg_like >", value, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_like >=", value, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeLessThan(Integer value) {
            addCriterion("msg_like <", value, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeLessThanOrEqualTo(Integer value) {
            addCriterion("msg_like <=", value, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeIn(List<Integer> values) {
            addCriterion("msg_like in", values, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeNotIn(List<Integer> values) {
            addCriterion("msg_like not in", values, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeBetween(Integer value1, Integer value2) {
            addCriterion("msg_like between", value1, value2, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_like not between", value1, value2, "msgLike");
            return (Criteria) this;
        }

        public Criteria andMsgApprIsNull() {
            addCriterion("msg_appr is null");
            return (Criteria) this;
        }

        public Criteria andMsgApprIsNotNull() {
            addCriterion("msg_appr is not null");
            return (Criteria) this;
        }

        public Criteria andMsgApprEqualTo(Integer value) {
            addCriterion("msg_appr =", value, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprNotEqualTo(Integer value) {
            addCriterion("msg_appr <>", value, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprGreaterThan(Integer value) {
            addCriterion("msg_appr >", value, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_appr >=", value, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprLessThan(Integer value) {
            addCriterion("msg_appr <", value, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprLessThanOrEqualTo(Integer value) {
            addCriterion("msg_appr <=", value, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprIn(List<Integer> values) {
            addCriterion("msg_appr in", values, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprNotIn(List<Integer> values) {
            addCriterion("msg_appr not in", values, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprBetween(Integer value1, Integer value2) {
            addCriterion("msg_appr between", value1, value2, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andMsgApprNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_appr not between", value1, value2, "msgAppr");
            return (Criteria) this;
        }

        public Criteria andApprTimeIsNull() {
            addCriterion("appr_time is null");
            return (Criteria) this;
        }

        public Criteria andApprTimeIsNotNull() {
            addCriterion("appr_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprTimeEqualTo(String value) {
            addCriterion("appr_time =", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotEqualTo(String value) {
            addCriterion("appr_time <>", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeGreaterThan(String value) {
            addCriterion("appr_time >", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeGreaterThanOrEqualTo(String value) {
            addCriterion("appr_time >=", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeLessThan(String value) {
            addCriterion("appr_time <", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeLessThanOrEqualTo(String value) {
            addCriterion("appr_time <=", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeLike(String value) {
            addCriterion("appr_time like", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotLike(String value) {
            addCriterion("appr_time not like", value, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeIn(List<String> values) {
            addCriterion("appr_time in", values, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotIn(List<String> values) {
            addCriterion("appr_time not in", values, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeBetween(String value1, String value2) {
            addCriterion("appr_time between", value1, value2, "apprTime");
            return (Criteria) this;
        }

        public Criteria andApprTimeNotBetween(String value1, String value2) {
            addCriterion("appr_time not between", value1, value2, "apprTime");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1IsNull() {
            addCriterion("msg_rsv1 is null");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1IsNotNull() {
            addCriterion("msg_rsv1 is not null");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1EqualTo(String value) {
            addCriterion("msg_rsv1 =", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1NotEqualTo(String value) {
            addCriterion("msg_rsv1 <>", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1GreaterThan(String value) {
            addCriterion("msg_rsv1 >", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1GreaterThanOrEqualTo(String value) {
            addCriterion("msg_rsv1 >=", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1LessThan(String value) {
            addCriterion("msg_rsv1 <", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1LessThanOrEqualTo(String value) {
            addCriterion("msg_rsv1 <=", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1Like(String value) {
            addCriterion("msg_rsv1 like", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1NotLike(String value) {
            addCriterion("msg_rsv1 not like", value, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1In(List<String> values) {
            addCriterion("msg_rsv1 in", values, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1NotIn(List<String> values) {
            addCriterion("msg_rsv1 not in", values, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1Between(String value1, String value2) {
            addCriterion("msg_rsv1 between", value1, value2, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv1NotBetween(String value1, String value2) {
            addCriterion("msg_rsv1 not between", value1, value2, "msgRsv1");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2IsNull() {
            addCriterion("msg_rsv2 is null");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2IsNotNull() {
            addCriterion("msg_rsv2 is not null");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2EqualTo(String value) {
            addCriterion("msg_rsv2 =", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2NotEqualTo(String value) {
            addCriterion("msg_rsv2 <>", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2GreaterThan(String value) {
            addCriterion("msg_rsv2 >", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2GreaterThanOrEqualTo(String value) {
            addCriterion("msg_rsv2 >=", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2LessThan(String value) {
            addCriterion("msg_rsv2 <", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2LessThanOrEqualTo(String value) {
            addCriterion("msg_rsv2 <=", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2Like(String value) {
            addCriterion("msg_rsv2 like", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2NotLike(String value) {
            addCriterion("msg_rsv2 not like", value, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2In(List<String> values) {
            addCriterion("msg_rsv2 in", values, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2NotIn(List<String> values) {
            addCriterion("msg_rsv2 not in", values, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2Between(String value1, String value2) {
            addCriterion("msg_rsv2 between", value1, value2, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv2NotBetween(String value1, String value2) {
            addCriterion("msg_rsv2 not between", value1, value2, "msgRsv2");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3IsNull() {
            addCriterion("msg_rsv3 is null");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3IsNotNull() {
            addCriterion("msg_rsv3 is not null");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3EqualTo(String value) {
            addCriterion("msg_rsv3 =", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3NotEqualTo(String value) {
            addCriterion("msg_rsv3 <>", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3GreaterThan(String value) {
            addCriterion("msg_rsv3 >", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3GreaterThanOrEqualTo(String value) {
            addCriterion("msg_rsv3 >=", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3LessThan(String value) {
            addCriterion("msg_rsv3 <", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3LessThanOrEqualTo(String value) {
            addCriterion("msg_rsv3 <=", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3Like(String value) {
            addCriterion("msg_rsv3 like", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3NotLike(String value) {
            addCriterion("msg_rsv3 not like", value, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3In(List<String> values) {
            addCriterion("msg_rsv3 in", values, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3NotIn(List<String> values) {
            addCriterion("msg_rsv3 not in", values, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3Between(String value1, String value2) {
            addCriterion("msg_rsv3 between", value1, value2, "msgRsv3");
            return (Criteria) this;
        }

        public Criteria andMsgRsv3NotBetween(String value1, String value2) {
            addCriterion("msg_rsv3 not between", value1, value2, "msgRsv3");
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