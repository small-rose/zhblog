package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysExceptionQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysExceptionQuery() {
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

        public Criteria andExceptionUrlIsNull() {
            addCriterion("exception_url is null");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlIsNotNull() {
            addCriterion("exception_url is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlEqualTo(String value) {
            addCriterion("exception_url =", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlNotEqualTo(String value) {
            addCriterion("exception_url <>", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlGreaterThan(String value) {
            addCriterion("exception_url >", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("exception_url >=", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlLessThan(String value) {
            addCriterion("exception_url <", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlLessThanOrEqualTo(String value) {
            addCriterion("exception_url <=", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlLike(String value) {
            addCriterion("exception_url like", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlNotLike(String value) {
            addCriterion("exception_url not like", value, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlIn(List<String> values) {
            addCriterion("exception_url in", values, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlNotIn(List<String> values) {
            addCriterion("exception_url not in", values, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlBetween(String value1, String value2) {
            addCriterion("exception_url between", value1, value2, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionUrlNotBetween(String value1, String value2) {
            addCriterion("exception_url not between", value1, value2, "exceptionUrl");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceIsNull() {
            addCriterion("exception_Remote_Device is null");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceIsNotNull() {
            addCriterion("exception_Remote_Device is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceEqualTo(String value) {
            addCriterion("exception_Remote_Device =", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceNotEqualTo(String value) {
            addCriterion("exception_Remote_Device <>", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceGreaterThan(String value) {
            addCriterion("exception_Remote_Device >", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("exception_Remote_Device >=", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceLessThan(String value) {
            addCriterion("exception_Remote_Device <", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceLessThanOrEqualTo(String value) {
            addCriterion("exception_Remote_Device <=", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceLike(String value) {
            addCriterion("exception_Remote_Device like", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceNotLike(String value) {
            addCriterion("exception_Remote_Device not like", value, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceIn(List<String> values) {
            addCriterion("exception_Remote_Device in", values, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceNotIn(List<String> values) {
            addCriterion("exception_Remote_Device not in", values, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceBetween(String value1, String value2) {
            addCriterion("exception_Remote_Device between", value1, value2, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteDeviceNotBetween(String value1, String value2) {
            addCriterion("exception_Remote_Device not between", value1, value2, "exceptionRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoIsNull() {
            addCriterion("exception_osinfo is null");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoIsNotNull() {
            addCriterion("exception_osinfo is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoEqualTo(String value) {
            addCriterion("exception_osinfo =", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoNotEqualTo(String value) {
            addCriterion("exception_osinfo <>", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoGreaterThan(String value) {
            addCriterion("exception_osinfo >", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoGreaterThanOrEqualTo(String value) {
            addCriterion("exception_osinfo >=", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoLessThan(String value) {
            addCriterion("exception_osinfo <", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoLessThanOrEqualTo(String value) {
            addCriterion("exception_osinfo <=", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoLike(String value) {
            addCriterion("exception_osinfo like", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoNotLike(String value) {
            addCriterion("exception_osinfo not like", value, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoIn(List<String> values) {
            addCriterion("exception_osinfo in", values, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoNotIn(List<String> values) {
            addCriterion("exception_osinfo not in", values, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoBetween(String value1, String value2) {
            addCriterion("exception_osinfo between", value1, value2, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionOsinfoNotBetween(String value1, String value2) {
            addCriterion("exception_osinfo not between", value1, value2, "exceptionOsinfo");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerIsNull() {
            addCriterion("exception_broswer is null");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerIsNotNull() {
            addCriterion("exception_broswer is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerEqualTo(String value) {
            addCriterion("exception_broswer =", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerNotEqualTo(String value) {
            addCriterion("exception_broswer <>", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerGreaterThan(String value) {
            addCriterion("exception_broswer >", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerGreaterThanOrEqualTo(String value) {
            addCriterion("exception_broswer >=", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerLessThan(String value) {
            addCriterion("exception_broswer <", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerLessThanOrEqualTo(String value) {
            addCriterion("exception_broswer <=", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerLike(String value) {
            addCriterion("exception_broswer like", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerNotLike(String value) {
            addCriterion("exception_broswer not like", value, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerIn(List<String> values) {
            addCriterion("exception_broswer in", values, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerNotIn(List<String> values) {
            addCriterion("exception_broswer not in", values, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerBetween(String value1, String value2) {
            addCriterion("exception_broswer between", value1, value2, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionBroswerNotBetween(String value1, String value2) {
            addCriterion("exception_broswer not between", value1, value2, "exceptionBroswer");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpIsNull() {
            addCriterion("exception_remote_ip is null");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpIsNotNull() {
            addCriterion("exception_remote_ip is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpEqualTo(String value) {
            addCriterion("exception_remote_ip =", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpNotEqualTo(String value) {
            addCriterion("exception_remote_ip <>", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpGreaterThan(String value) {
            addCriterion("exception_remote_ip >", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpGreaterThanOrEqualTo(String value) {
            addCriterion("exception_remote_ip >=", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpLessThan(String value) {
            addCriterion("exception_remote_ip <", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpLessThanOrEqualTo(String value) {
            addCriterion("exception_remote_ip <=", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpLike(String value) {
            addCriterion("exception_remote_ip like", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpNotLike(String value) {
            addCriterion("exception_remote_ip not like", value, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpIn(List<String> values) {
            addCriterion("exception_remote_ip in", values, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpNotIn(List<String> values) {
            addCriterion("exception_remote_ip not in", values, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpBetween(String value1, String value2) {
            addCriterion("exception_remote_ip between", value1, value2, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteIpNotBetween(String value1, String value2) {
            addCriterion("exception_remote_ip not between", value1, value2, "exceptionRemoteIp");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserIsNull() {
            addCriterion("exception_Remote_User is null");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserIsNotNull() {
            addCriterion("exception_Remote_User is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserEqualTo(String value) {
            addCriterion("exception_Remote_User =", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserNotEqualTo(String value) {
            addCriterion("exception_Remote_User <>", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserGreaterThan(String value) {
            addCriterion("exception_Remote_User >", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserGreaterThanOrEqualTo(String value) {
            addCriterion("exception_Remote_User >=", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserLessThan(String value) {
            addCriterion("exception_Remote_User <", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserLessThanOrEqualTo(String value) {
            addCriterion("exception_Remote_User <=", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserLike(String value) {
            addCriterion("exception_Remote_User like", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserNotLike(String value) {
            addCriterion("exception_Remote_User not like", value, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserIn(List<String> values) {
            addCriterion("exception_Remote_User in", values, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserNotIn(List<String> values) {
            addCriterion("exception_Remote_User not in", values, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserBetween(String value1, String value2) {
            addCriterion("exception_Remote_User between", value1, value2, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionRemoteUserNotBetween(String value1, String value2) {
            addCriterion("exception_Remote_User not between", value1, value2, "exceptionRemoteUser");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteIsNull() {
            addCriterion("exception_optNote is null");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteIsNotNull() {
            addCriterion("exception_optNote is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteEqualTo(String value) {
            addCriterion("exception_optNote =", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteNotEqualTo(String value) {
            addCriterion("exception_optNote <>", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteGreaterThan(String value) {
            addCriterion("exception_optNote >", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteGreaterThanOrEqualTo(String value) {
            addCriterion("exception_optNote >=", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteLessThan(String value) {
            addCriterion("exception_optNote <", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteLessThanOrEqualTo(String value) {
            addCriterion("exception_optNote <=", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteLike(String value) {
            addCriterion("exception_optNote like", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteNotLike(String value) {
            addCriterion("exception_optNote not like", value, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteIn(List<String> values) {
            addCriterion("exception_optNote in", values, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteNotIn(List<String> values) {
            addCriterion("exception_optNote not in", values, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteBetween(String value1, String value2) {
            addCriterion("exception_optNote between", value1, value2, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionOptnoteNotBetween(String value1, String value2) {
            addCriterion("exception_optNote not between", value1, value2, "exceptionOptnote");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgIsNull() {
            addCriterion("exception_msg is null");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgIsNotNull() {
            addCriterion("exception_msg is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgEqualTo(String value) {
            addCriterion("exception_msg =", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotEqualTo(String value) {
            addCriterion("exception_msg <>", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgGreaterThan(String value) {
            addCriterion("exception_msg >", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgGreaterThanOrEqualTo(String value) {
            addCriterion("exception_msg >=", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgLessThan(String value) {
            addCriterion("exception_msg <", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgLessThanOrEqualTo(String value) {
            addCriterion("exception_msg <=", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgLike(String value) {
            addCriterion("exception_msg like", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotLike(String value) {
            addCriterion("exception_msg not like", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgIn(List<String> values) {
            addCriterion("exception_msg in", values, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotIn(List<String> values) {
            addCriterion("exception_msg not in", values, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgBetween(String value1, String value2) {
            addCriterion("exception_msg between", value1, value2, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotBetween(String value1, String value2) {
            addCriterion("exception_msg not between", value1, value2, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeIsNull() {
            addCriterion("exception_star_time is null");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeIsNotNull() {
            addCriterion("exception_star_time is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeEqualTo(String value) {
            addCriterion("exception_star_time =", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeNotEqualTo(String value) {
            addCriterion("exception_star_time <>", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeGreaterThan(String value) {
            addCriterion("exception_star_time >", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exception_star_time >=", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeLessThan(String value) {
            addCriterion("exception_star_time <", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeLessThanOrEqualTo(String value) {
            addCriterion("exception_star_time <=", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeLike(String value) {
            addCriterion("exception_star_time like", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeNotLike(String value) {
            addCriterion("exception_star_time not like", value, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeIn(List<String> values) {
            addCriterion("exception_star_time in", values, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeNotIn(List<String> values) {
            addCriterion("exception_star_time not in", values, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeBetween(String value1, String value2) {
            addCriterion("exception_star_time between", value1, value2, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionStarTimeNotBetween(String value1, String value2) {
            addCriterion("exception_star_time not between", value1, value2, "exceptionStarTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeIsNull() {
            addCriterion("exception_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeIsNotNull() {
            addCriterion("exception_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeEqualTo(String value) {
            addCriterion("exception_end_time =", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeNotEqualTo(String value) {
            addCriterion("exception_end_time <>", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeGreaterThan(String value) {
            addCriterion("exception_end_time >", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exception_end_time >=", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeLessThan(String value) {
            addCriterion("exception_end_time <", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeLessThanOrEqualTo(String value) {
            addCriterion("exception_end_time <=", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeLike(String value) {
            addCriterion("exception_end_time like", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeNotLike(String value) {
            addCriterion("exception_end_time not like", value, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeIn(List<String> values) {
            addCriterion("exception_end_time in", values, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeNotIn(List<String> values) {
            addCriterion("exception_end_time not in", values, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeBetween(String value1, String value2) {
            addCriterion("exception_end_time between", value1, value2, "exceptionEndTime");
            return (Criteria) this;
        }

        public Criteria andExceptionEndTimeNotBetween(String value1, String value2) {
            addCriterion("exception_end_time not between", value1, value2, "exceptionEndTime");
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