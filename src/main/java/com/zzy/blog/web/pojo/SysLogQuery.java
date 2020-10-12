package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysLogQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLogQuery() {
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

        public Criteria andLogUrlIsNull() {
            addCriterion("log_url is null");
            return (Criteria) this;
        }

        public Criteria andLogUrlIsNotNull() {
            addCriterion("log_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogUrlEqualTo(String value) {
            addCriterion("log_url =", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotEqualTo(String value) {
            addCriterion("log_url <>", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlGreaterThan(String value) {
            addCriterion("log_url >", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlGreaterThanOrEqualTo(String value) {
            addCriterion("log_url >=", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlLessThan(String value) {
            addCriterion("log_url <", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlLessThanOrEqualTo(String value) {
            addCriterion("log_url <=", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlLike(String value) {
            addCriterion("log_url like", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotLike(String value) {
            addCriterion("log_url not like", value, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlIn(List<String> values) {
            addCriterion("log_url in", values, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotIn(List<String> values) {
            addCriterion("log_url not in", values, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlBetween(String value1, String value2) {
            addCriterion("log_url between", value1, value2, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogUrlNotBetween(String value1, String value2) {
            addCriterion("log_url not between", value1, value2, "logUrl");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceIsNull() {
            addCriterion("log_Remote_Device is null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceIsNotNull() {
            addCriterion("log_Remote_Device is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceEqualTo(String value) {
            addCriterion("log_Remote_Device =", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceNotEqualTo(String value) {
            addCriterion("log_Remote_Device <>", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceGreaterThan(String value) {
            addCriterion("log_Remote_Device >", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("log_Remote_Device >=", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceLessThan(String value) {
            addCriterion("log_Remote_Device <", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceLessThanOrEqualTo(String value) {
            addCriterion("log_Remote_Device <=", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceLike(String value) {
            addCriterion("log_Remote_Device like", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceNotLike(String value) {
            addCriterion("log_Remote_Device not like", value, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceIn(List<String> values) {
            addCriterion("log_Remote_Device in", values, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceNotIn(List<String> values) {
            addCriterion("log_Remote_Device not in", values, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceBetween(String value1, String value2) {
            addCriterion("log_Remote_Device between", value1, value2, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogRemoteDeviceNotBetween(String value1, String value2) {
            addCriterion("log_Remote_Device not between", value1, value2, "logRemoteDevice");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoIsNull() {
            addCriterion("log_osinfo is null");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoIsNotNull() {
            addCriterion("log_osinfo is not null");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoEqualTo(String value) {
            addCriterion("log_osinfo =", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoNotEqualTo(String value) {
            addCriterion("log_osinfo <>", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoGreaterThan(String value) {
            addCriterion("log_osinfo >", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoGreaterThanOrEqualTo(String value) {
            addCriterion("log_osinfo >=", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoLessThan(String value) {
            addCriterion("log_osinfo <", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoLessThanOrEqualTo(String value) {
            addCriterion("log_osinfo <=", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoLike(String value) {
            addCriterion("log_osinfo like", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoNotLike(String value) {
            addCriterion("log_osinfo not like", value, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoIn(List<String> values) {
            addCriterion("log_osinfo in", values, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoNotIn(List<String> values) {
            addCriterion("log_osinfo not in", values, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoBetween(String value1, String value2) {
            addCriterion("log_osinfo between", value1, value2, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogOsinfoNotBetween(String value1, String value2) {
            addCriterion("log_osinfo not between", value1, value2, "logOsinfo");
            return (Criteria) this;
        }

        public Criteria andLogBroswerIsNull() {
            addCriterion("log_broswer is null");
            return (Criteria) this;
        }

        public Criteria andLogBroswerIsNotNull() {
            addCriterion("log_broswer is not null");
            return (Criteria) this;
        }

        public Criteria andLogBroswerEqualTo(String value) {
            addCriterion("log_broswer =", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerNotEqualTo(String value) {
            addCriterion("log_broswer <>", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerGreaterThan(String value) {
            addCriterion("log_broswer >", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerGreaterThanOrEqualTo(String value) {
            addCriterion("log_broswer >=", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerLessThan(String value) {
            addCriterion("log_broswer <", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerLessThanOrEqualTo(String value) {
            addCriterion("log_broswer <=", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerLike(String value) {
            addCriterion("log_broswer like", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerNotLike(String value) {
            addCriterion("log_broswer not like", value, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerIn(List<String> values) {
            addCriterion("log_broswer in", values, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerNotIn(List<String> values) {
            addCriterion("log_broswer not in", values, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerBetween(String value1, String value2) {
            addCriterion("log_broswer between", value1, value2, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogBroswerNotBetween(String value1, String value2) {
            addCriterion("log_broswer not between", value1, value2, "logBroswer");
            return (Criteria) this;
        }

        public Criteria andLogMethodIsNull() {
            addCriterion("log_Method is null");
            return (Criteria) this;
        }

        public Criteria andLogMethodIsNotNull() {
            addCriterion("log_Method is not null");
            return (Criteria) this;
        }

        public Criteria andLogMethodEqualTo(String value) {
            addCriterion("log_Method =", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotEqualTo(String value) {
            addCriterion("log_Method <>", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodGreaterThan(String value) {
            addCriterion("log_Method >", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodGreaterThanOrEqualTo(String value) {
            addCriterion("log_Method >=", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodLessThan(String value) {
            addCriterion("log_Method <", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodLessThanOrEqualTo(String value) {
            addCriterion("log_Method <=", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodLike(String value) {
            addCriterion("log_Method like", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotLike(String value) {
            addCriterion("log_Method not like", value, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodIn(List<String> values) {
            addCriterion("log_Method in", values, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotIn(List<String> values) {
            addCriterion("log_Method not in", values, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodBetween(String value1, String value2) {
            addCriterion("log_Method between", value1, value2, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogMethodNotBetween(String value1, String value2) {
            addCriterion("log_Method not between", value1, value2, "logMethod");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteIsNull() {
            addCriterion("log_optNote is null");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteIsNotNull() {
            addCriterion("log_optNote is not null");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteEqualTo(String value) {
            addCriterion("log_optNote =", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteNotEqualTo(String value) {
            addCriterion("log_optNote <>", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteGreaterThan(String value) {
            addCriterion("log_optNote >", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteGreaterThanOrEqualTo(String value) {
            addCriterion("log_optNote >=", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteLessThan(String value) {
            addCriterion("log_optNote <", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteLessThanOrEqualTo(String value) {
            addCriterion("log_optNote <=", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteLike(String value) {
            addCriterion("log_optNote like", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteNotLike(String value) {
            addCriterion("log_optNote not like", value, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteIn(List<String> values) {
            addCriterion("log_optNote in", values, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteNotIn(List<String> values) {
            addCriterion("log_optNote not in", values, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteBetween(String value1, String value2) {
            addCriterion("log_optNote between", value1, value2, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogOptnoteNotBetween(String value1, String value2) {
            addCriterion("log_optNote not between", value1, value2, "logOptnote");
            return (Criteria) this;
        }

        public Criteria andLogProtocolIsNull() {
            addCriterion("log_Protocol is null");
            return (Criteria) this;
        }

        public Criteria andLogProtocolIsNotNull() {
            addCriterion("log_Protocol is not null");
            return (Criteria) this;
        }

        public Criteria andLogProtocolEqualTo(String value) {
            addCriterion("log_Protocol =", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolNotEqualTo(String value) {
            addCriterion("log_Protocol <>", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolGreaterThan(String value) {
            addCriterion("log_Protocol >", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("log_Protocol >=", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolLessThan(String value) {
            addCriterion("log_Protocol <", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolLessThanOrEqualTo(String value) {
            addCriterion("log_Protocol <=", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolLike(String value) {
            addCriterion("log_Protocol like", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolNotLike(String value) {
            addCriterion("log_Protocol not like", value, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolIn(List<String> values) {
            addCriterion("log_Protocol in", values, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolNotIn(List<String> values) {
            addCriterion("log_Protocol not in", values, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolBetween(String value1, String value2) {
            addCriterion("log_Protocol between", value1, value2, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogProtocolNotBetween(String value1, String value2) {
            addCriterion("log_Protocol not between", value1, value2, "logProtocol");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpIsNull() {
            addCriterion("log_remote_ip is null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpIsNotNull() {
            addCriterion("log_remote_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpEqualTo(String value) {
            addCriterion("log_remote_ip =", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpNotEqualTo(String value) {
            addCriterion("log_remote_ip <>", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpGreaterThan(String value) {
            addCriterion("log_remote_ip >", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpGreaterThanOrEqualTo(String value) {
            addCriterion("log_remote_ip >=", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpLessThan(String value) {
            addCriterion("log_remote_ip <", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpLessThanOrEqualTo(String value) {
            addCriterion("log_remote_ip <=", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpLike(String value) {
            addCriterion("log_remote_ip like", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpNotLike(String value) {
            addCriterion("log_remote_ip not like", value, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpIn(List<String> values) {
            addCriterion("log_remote_ip in", values, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpNotIn(List<String> values) {
            addCriterion("log_remote_ip not in", values, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpBetween(String value1, String value2) {
            addCriterion("log_remote_ip between", value1, value2, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemoteIpNotBetween(String value1, String value2) {
            addCriterion("log_remote_ip not between", value1, value2, "logRemoteIp");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortIsNull() {
            addCriterion("log_remote_port is null");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortIsNotNull() {
            addCriterion("log_remote_port is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortEqualTo(String value) {
            addCriterion("log_remote_port =", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortNotEqualTo(String value) {
            addCriterion("log_remote_port <>", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortGreaterThan(String value) {
            addCriterion("log_remote_port >", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortGreaterThanOrEqualTo(String value) {
            addCriterion("log_remote_port >=", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortLessThan(String value) {
            addCriterion("log_remote_port <", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortLessThanOrEqualTo(String value) {
            addCriterion("log_remote_port <=", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortLike(String value) {
            addCriterion("log_remote_port like", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortNotLike(String value) {
            addCriterion("log_remote_port not like", value, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortIn(List<String> values) {
            addCriterion("log_remote_port in", values, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortNotIn(List<String> values) {
            addCriterion("log_remote_port not in", values, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortBetween(String value1, String value2) {
            addCriterion("log_remote_port between", value1, value2, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemotePortNotBetween(String value1, String value2) {
            addCriterion("log_remote_port not between", value1, value2, "logRemotePort");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserIsNull() {
            addCriterion("log_remote_RemoteUser is null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserIsNotNull() {
            addCriterion("log_remote_RemoteUser is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserEqualTo(String value) {
            addCriterion("log_remote_RemoteUser =", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserNotEqualTo(String value) {
            addCriterion("log_remote_RemoteUser <>", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserGreaterThan(String value) {
            addCriterion("log_remote_RemoteUser >", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserGreaterThanOrEqualTo(String value) {
            addCriterion("log_remote_RemoteUser >=", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserLessThan(String value) {
            addCriterion("log_remote_RemoteUser <", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserLessThanOrEqualTo(String value) {
            addCriterion("log_remote_RemoteUser <=", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserLike(String value) {
            addCriterion("log_remote_RemoteUser like", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserNotLike(String value) {
            addCriterion("log_remote_RemoteUser not like", value, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserIn(List<String> values) {
            addCriterion("log_remote_RemoteUser in", values, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserNotIn(List<String> values) {
            addCriterion("log_remote_RemoteUser not in", values, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserBetween(String value1, String value2) {
            addCriterion("log_remote_RemoteUser between", value1, value2, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogRemoteRemoteuserNotBetween(String value1, String value2) {
            addCriterion("log_remote_RemoteUser not between", value1, value2, "logRemoteRemoteuser");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeIsNull() {
            addCriterion("log_star_time is null");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeIsNotNull() {
            addCriterion("log_star_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeEqualTo(String value) {
            addCriterion("log_star_time =", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeNotEqualTo(String value) {
            addCriterion("log_star_time <>", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeGreaterThan(String value) {
            addCriterion("log_star_time >", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeGreaterThanOrEqualTo(String value) {
            addCriterion("log_star_time >=", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeLessThan(String value) {
            addCriterion("log_star_time <", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeLessThanOrEqualTo(String value) {
            addCriterion("log_star_time <=", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeLike(String value) {
            addCriterion("log_star_time like", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeNotLike(String value) {
            addCriterion("log_star_time not like", value, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeIn(List<String> values) {
            addCriterion("log_star_time in", values, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeNotIn(List<String> values) {
            addCriterion("log_star_time not in", values, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeBetween(String value1, String value2) {
            addCriterion("log_star_time between", value1, value2, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogStarTimeNotBetween(String value1, String value2) {
            addCriterion("log_star_time not between", value1, value2, "logStarTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeIsNull() {
            addCriterion("log_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeIsNotNull() {
            addCriterion("log_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeEqualTo(String value) {
            addCriterion("log_end_time =", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotEqualTo(String value) {
            addCriterion("log_end_time <>", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeGreaterThan(String value) {
            addCriterion("log_end_time >", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("log_end_time >=", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeLessThan(String value) {
            addCriterion("log_end_time <", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeLessThanOrEqualTo(String value) {
            addCriterion("log_end_time <=", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeLike(String value) {
            addCriterion("log_end_time like", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotLike(String value) {
            addCriterion("log_end_time not like", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeIn(List<String> values) {
            addCriterion("log_end_time in", values, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotIn(List<String> values) {
            addCriterion("log_end_time not in", values, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeBetween(String value1, String value2) {
            addCriterion("log_end_time between", value1, value2, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotBetween(String value1, String value2) {
            addCriterion("log_end_time not between", value1, value2, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderIsNull() {
            addCriterion("log_resp_header is null");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderIsNotNull() {
            addCriterion("log_resp_header is not null");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderEqualTo(String value) {
            addCriterion("log_resp_header =", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderNotEqualTo(String value) {
            addCriterion("log_resp_header <>", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderGreaterThan(String value) {
            addCriterion("log_resp_header >", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("log_resp_header >=", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderLessThan(String value) {
            addCriterion("log_resp_header <", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderLessThanOrEqualTo(String value) {
            addCriterion("log_resp_header <=", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderLike(String value) {
            addCriterion("log_resp_header like", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderNotLike(String value) {
            addCriterion("log_resp_header not like", value, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderIn(List<String> values) {
            addCriterion("log_resp_header in", values, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderNotIn(List<String> values) {
            addCriterion("log_resp_header not in", values, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderBetween(String value1, String value2) {
            addCriterion("log_resp_header between", value1, value2, "logRespHeader");
            return (Criteria) this;
        }

        public Criteria andLogRespHeaderNotBetween(String value1, String value2) {
            addCriterion("log_resp_header not between", value1, value2, "logRespHeader");
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