package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserQuery() {
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

        public Criteria andTelNoIsNull() {
            addCriterion("tel_no is null");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNotNull() {
            addCriterion("tel_no is not null");
            return (Criteria) this;
        }

        public Criteria andTelNoEqualTo(String value) {
            addCriterion("tel_no =", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotEqualTo(String value) {
            addCriterion("tel_no <>", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThan(String value) {
            addCriterion("tel_no >", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanOrEqualTo(String value) {
            addCriterion("tel_no >=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThan(String value) {
            addCriterion("tel_no <", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanOrEqualTo(String value) {
            addCriterion("tel_no <=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLike(String value) {
            addCriterion("tel_no like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotLike(String value) {
            addCriterion("tel_no not like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoIn(List<String> values) {
            addCriterion("tel_no in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotIn(List<String> values) {
            addCriterion("tel_no not in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoBetween(String value1, String value2) {
            addCriterion("tel_no between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotBetween(String value1, String value2) {
            addCriterion("tel_no not between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andBirthDayIsNull() {
            addCriterion("birth_day is null");
            return (Criteria) this;
        }

        public Criteria andBirthDayIsNotNull() {
            addCriterion("birth_day is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDayEqualTo(String value) {
            addCriterion("birth_day =", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotEqualTo(String value) {
            addCriterion("birth_day <>", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayGreaterThan(String value) {
            addCriterion("birth_day >", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayGreaterThanOrEqualTo(String value) {
            addCriterion("birth_day >=", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayLessThan(String value) {
            addCriterion("birth_day <", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayLessThanOrEqualTo(String value) {
            addCriterion("birth_day <=", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayLike(String value) {
            addCriterion("birth_day like", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotLike(String value) {
            addCriterion("birth_day not like", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayIn(List<String> values) {
            addCriterion("birth_day in", values, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotIn(List<String> values) {
            addCriterion("birth_day not in", values, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayBetween(String value1, String value2) {
            addCriterion("birth_day between", value1, value2, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotBetween(String value1, String value2) {
            addCriterion("birth_day not between", value1, value2, "birthDay");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andWxPrivateIsNull() {
            addCriterion("wx_private is null");
            return (Criteria) this;
        }

        public Criteria andWxPrivateIsNotNull() {
            addCriterion("wx_private is not null");
            return (Criteria) this;
        }

        public Criteria andWxPrivateEqualTo(String value) {
            addCriterion("wx_private =", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateNotEqualTo(String value) {
            addCriterion("wx_private <>", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateGreaterThan(String value) {
            addCriterion("wx_private >", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateGreaterThanOrEqualTo(String value) {
            addCriterion("wx_private >=", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateLessThan(String value) {
            addCriterion("wx_private <", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateLessThanOrEqualTo(String value) {
            addCriterion("wx_private <=", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateLike(String value) {
            addCriterion("wx_private like", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateNotLike(String value) {
            addCriterion("wx_private not like", value, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateIn(List<String> values) {
            addCriterion("wx_private in", values, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateNotIn(List<String> values) {
            addCriterion("wx_private not in", values, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateBetween(String value1, String value2) {
            addCriterion("wx_private between", value1, value2, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPrivateNotBetween(String value1, String value2) {
            addCriterion("wx_private not between", value1, value2, "wxPrivate");
            return (Criteria) this;
        }

        public Criteria andWxPublicIsNull() {
            addCriterion("wx_public is null");
            return (Criteria) this;
        }

        public Criteria andWxPublicIsNotNull() {
            addCriterion("wx_public is not null");
            return (Criteria) this;
        }

        public Criteria andWxPublicEqualTo(String value) {
            addCriterion("wx_public =", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicNotEqualTo(String value) {
            addCriterion("wx_public <>", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicGreaterThan(String value) {
            addCriterion("wx_public >", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicGreaterThanOrEqualTo(String value) {
            addCriterion("wx_public >=", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicLessThan(String value) {
            addCriterion("wx_public <", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicLessThanOrEqualTo(String value) {
            addCriterion("wx_public <=", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicLike(String value) {
            addCriterion("wx_public like", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicNotLike(String value) {
            addCriterion("wx_public not like", value, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicIn(List<String> values) {
            addCriterion("wx_public in", values, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicNotIn(List<String> values) {
            addCriterion("wx_public not in", values, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicBetween(String value1, String value2) {
            addCriterion("wx_public between", value1, value2, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWxPublicNotBetween(String value1, String value2) {
            addCriterion("wx_public not between", value1, value2, "wxPublic");
            return (Criteria) this;
        }

        public Criteria andWbAcctIsNull() {
            addCriterion("wb_acct is null");
            return (Criteria) this;
        }

        public Criteria andWbAcctIsNotNull() {
            addCriterion("wb_acct is not null");
            return (Criteria) this;
        }

        public Criteria andWbAcctEqualTo(String value) {
            addCriterion("wb_acct =", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctNotEqualTo(String value) {
            addCriterion("wb_acct <>", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctGreaterThan(String value) {
            addCriterion("wb_acct >", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctGreaterThanOrEqualTo(String value) {
            addCriterion("wb_acct >=", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctLessThan(String value) {
            addCriterion("wb_acct <", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctLessThanOrEqualTo(String value) {
            addCriterion("wb_acct <=", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctLike(String value) {
            addCriterion("wb_acct like", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctNotLike(String value) {
            addCriterion("wb_acct not like", value, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctIn(List<String> values) {
            addCriterion("wb_acct in", values, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctNotIn(List<String> values) {
            addCriterion("wb_acct not in", values, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctBetween(String value1, String value2) {
            addCriterion("wb_acct between", value1, value2, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andWbAcctNotBetween(String value1, String value2) {
            addCriterion("wb_acct not between", value1, value2, "wbAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctIsNull() {
            addCriterion("git_acct is null");
            return (Criteria) this;
        }

        public Criteria andGitAcctIsNotNull() {
            addCriterion("git_acct is not null");
            return (Criteria) this;
        }

        public Criteria andGitAcctEqualTo(String value) {
            addCriterion("git_acct =", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctNotEqualTo(String value) {
            addCriterion("git_acct <>", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctGreaterThan(String value) {
            addCriterion("git_acct >", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctGreaterThanOrEqualTo(String value) {
            addCriterion("git_acct >=", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctLessThan(String value) {
            addCriterion("git_acct <", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctLessThanOrEqualTo(String value) {
            addCriterion("git_acct <=", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctLike(String value) {
            addCriterion("git_acct like", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctNotLike(String value) {
            addCriterion("git_acct not like", value, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctIn(List<String> values) {
            addCriterion("git_acct in", values, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctNotIn(List<String> values) {
            addCriterion("git_acct not in", values, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctBetween(String value1, String value2) {
            addCriterion("git_acct between", value1, value2, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andGitAcctNotBetween(String value1, String value2) {
            addCriterion("git_acct not between", value1, value2, "gitAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctIsNull() {
            addCriterion("qq_acct is null");
            return (Criteria) this;
        }

        public Criteria andQqAcctIsNotNull() {
            addCriterion("qq_acct is not null");
            return (Criteria) this;
        }

        public Criteria andQqAcctEqualTo(String value) {
            addCriterion("qq_acct =", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctNotEqualTo(String value) {
            addCriterion("qq_acct <>", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctGreaterThan(String value) {
            addCriterion("qq_acct >", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctGreaterThanOrEqualTo(String value) {
            addCriterion("qq_acct >=", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctLessThan(String value) {
            addCriterion("qq_acct <", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctLessThanOrEqualTo(String value) {
            addCriterion("qq_acct <=", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctLike(String value) {
            addCriterion("qq_acct like", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctNotLike(String value) {
            addCriterion("qq_acct not like", value, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctIn(List<String> values) {
            addCriterion("qq_acct in", values, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctNotIn(List<String> values) {
            addCriterion("qq_acct not in", values, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctBetween(String value1, String value2) {
            addCriterion("qq_acct between", value1, value2, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andQqAcctNotBetween(String value1, String value2) {
            addCriterion("qq_acct not between", value1, value2, "qqAcct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctIsNull() {
            addCriterion("ext1_acct is null");
            return (Criteria) this;
        }

        public Criteria andExt1AcctIsNotNull() {
            addCriterion("ext1_acct is not null");
            return (Criteria) this;
        }

        public Criteria andExt1AcctEqualTo(String value) {
            addCriterion("ext1_acct =", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctNotEqualTo(String value) {
            addCriterion("ext1_acct <>", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctGreaterThan(String value) {
            addCriterion("ext1_acct >", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctGreaterThanOrEqualTo(String value) {
            addCriterion("ext1_acct >=", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctLessThan(String value) {
            addCriterion("ext1_acct <", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctLessThanOrEqualTo(String value) {
            addCriterion("ext1_acct <=", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctLike(String value) {
            addCriterion("ext1_acct like", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctNotLike(String value) {
            addCriterion("ext1_acct not like", value, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctIn(List<String> values) {
            addCriterion("ext1_acct in", values, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctNotIn(List<String> values) {
            addCriterion("ext1_acct not in", values, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctBetween(String value1, String value2) {
            addCriterion("ext1_acct between", value1, value2, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt1AcctNotBetween(String value1, String value2) {
            addCriterion("ext1_acct not between", value1, value2, "ext1Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctIsNull() {
            addCriterion("ext2_acct is null");
            return (Criteria) this;
        }

        public Criteria andExt2AcctIsNotNull() {
            addCriterion("ext2_acct is not null");
            return (Criteria) this;
        }

        public Criteria andExt2AcctEqualTo(String value) {
            addCriterion("ext2_acct =", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctNotEqualTo(String value) {
            addCriterion("ext2_acct <>", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctGreaterThan(String value) {
            addCriterion("ext2_acct >", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctGreaterThanOrEqualTo(String value) {
            addCriterion("ext2_acct >=", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctLessThan(String value) {
            addCriterion("ext2_acct <", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctLessThanOrEqualTo(String value) {
            addCriterion("ext2_acct <=", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctLike(String value) {
            addCriterion("ext2_acct like", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctNotLike(String value) {
            addCriterion("ext2_acct not like", value, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctIn(List<String> values) {
            addCriterion("ext2_acct in", values, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctNotIn(List<String> values) {
            addCriterion("ext2_acct not in", values, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctBetween(String value1, String value2) {
            addCriterion("ext2_acct between", value1, value2, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt2AcctNotBetween(String value1, String value2) {
            addCriterion("ext2_acct not between", value1, value2, "ext2Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctIsNull() {
            addCriterion("ext3_acct is null");
            return (Criteria) this;
        }

        public Criteria andExt3AcctIsNotNull() {
            addCriterion("ext3_acct is not null");
            return (Criteria) this;
        }

        public Criteria andExt3AcctEqualTo(String value) {
            addCriterion("ext3_acct =", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctNotEqualTo(String value) {
            addCriterion("ext3_acct <>", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctGreaterThan(String value) {
            addCriterion("ext3_acct >", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctGreaterThanOrEqualTo(String value) {
            addCriterion("ext3_acct >=", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctLessThan(String value) {
            addCriterion("ext3_acct <", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctLessThanOrEqualTo(String value) {
            addCriterion("ext3_acct <=", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctLike(String value) {
            addCriterion("ext3_acct like", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctNotLike(String value) {
            addCriterion("ext3_acct not like", value, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctIn(List<String> values) {
            addCriterion("ext3_acct in", values, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctNotIn(List<String> values) {
            addCriterion("ext3_acct not in", values, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctBetween(String value1, String value2) {
            addCriterion("ext3_acct between", value1, value2, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andExt3AcctNotBetween(String value1, String value2) {
            addCriterion("ext3_acct not between", value1, value2, "ext3Acct");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefIsNull() {
            addCriterion("personal_brief is null");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefIsNotNull() {
            addCriterion("personal_brief is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefEqualTo(String value) {
            addCriterion("personal_brief =", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefNotEqualTo(String value) {
            addCriterion("personal_brief <>", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefGreaterThan(String value) {
            addCriterion("personal_brief >", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefGreaterThanOrEqualTo(String value) {
            addCriterion("personal_brief >=", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefLessThan(String value) {
            addCriterion("personal_brief <", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefLessThanOrEqualTo(String value) {
            addCriterion("personal_brief <=", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefLike(String value) {
            addCriterion("personal_brief like", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefNotLike(String value) {
            addCriterion("personal_brief not like", value, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefIn(List<String> values) {
            addCriterion("personal_brief in", values, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefNotIn(List<String> values) {
            addCriterion("personal_brief not in", values, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefBetween(String value1, String value2) {
            addCriterion("personal_brief between", value1, value2, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andPersonalBriefNotBetween(String value1, String value2) {
            addCriterion("personal_brief not between", value1, value2, "personalBrief");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlIsNull() {
            addCriterion("avatar_Img_Url is null");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlIsNotNull() {
            addCriterion("avatar_Img_Url is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlEqualTo(String value) {
            addCriterion("avatar_Img_Url =", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlNotEqualTo(String value) {
            addCriterion("avatar_Img_Url <>", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlGreaterThan(String value) {
            addCriterion("avatar_Img_Url >", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_Img_Url >=", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlLessThan(String value) {
            addCriterion("avatar_Img_Url <", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlLessThanOrEqualTo(String value) {
            addCriterion("avatar_Img_Url <=", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlLike(String value) {
            addCriterion("avatar_Img_Url like", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlNotLike(String value) {
            addCriterion("avatar_Img_Url not like", value, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlIn(List<String> values) {
            addCriterion("avatar_Img_Url in", values, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlNotIn(List<String> values) {
            addCriterion("avatar_Img_Url not in", values, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlBetween(String value1, String value2) {
            addCriterion("avatar_Img_Url between", value1, value2, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarImgUrlNotBetween(String value1, String value2) {
            addCriterion("avatar_Img_Url not between", value1, value2, "avatarImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlIsNull() {
            addCriterion("local_Img_Url is null");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlIsNotNull() {
            addCriterion("local_Img_Url is not null");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlEqualTo(String value) {
            addCriterion("local_Img_Url =", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlNotEqualTo(String value) {
            addCriterion("local_Img_Url <>", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlGreaterThan(String value) {
            addCriterion("local_Img_Url >", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("local_Img_Url >=", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlLessThan(String value) {
            addCriterion("local_Img_Url <", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlLessThanOrEqualTo(String value) {
            addCriterion("local_Img_Url <=", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlLike(String value) {
            addCriterion("local_Img_Url like", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlNotLike(String value) {
            addCriterion("local_Img_Url not like", value, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlIn(List<String> values) {
            addCriterion("local_Img_Url in", values, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlNotIn(List<String> values) {
            addCriterion("local_Img_Url not in", values, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlBetween(String value1, String value2) {
            addCriterion("local_Img_Url between", value1, value2, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andLocalImgUrlNotBetween(String value1, String value2) {
            addCriterion("local_Img_Url not between", value1, value2, "localImgUrl");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(String value) {
            addCriterion("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(String value) {
            addCriterion("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(String value) {
            addCriterion("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(String value) {
            addCriterion("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(String value) {
            addCriterion("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(String value) {
            addCriterion("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLike(String value) {
            addCriterion("register_date like", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotLike(String value) {
            addCriterion("register_date not like", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<String> values) {
            addCriterion("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<String> values) {
            addCriterion("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(String value1, String value2) {
            addCriterion("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(String value1, String value2) {
            addCriterion("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedIsNull() {
            addCriterion("recently_Landed is null");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedIsNotNull() {
            addCriterion("recently_Landed is not null");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedEqualTo(String value) {
            addCriterion("recently_Landed =", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedNotEqualTo(String value) {
            addCriterion("recently_Landed <>", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedGreaterThan(String value) {
            addCriterion("recently_Landed >", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedGreaterThanOrEqualTo(String value) {
            addCriterion("recently_Landed >=", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedLessThan(String value) {
            addCriterion("recently_Landed <", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedLessThanOrEqualTo(String value) {
            addCriterion("recently_Landed <=", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedLike(String value) {
            addCriterion("recently_Landed like", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedNotLike(String value) {
            addCriterion("recently_Landed not like", value, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedIn(List<String> values) {
            addCriterion("recently_Landed in", values, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedNotIn(List<String> values) {
            addCriterion("recently_Landed not in", values, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedBetween(String value1, String value2) {
            addCriterion("recently_Landed between", value1, value2, "recentlyLanded");
            return (Criteria) this;
        }

        public Criteria andRecentlyLandedNotBetween(String value1, String value2) {
            addCriterion("recently_Landed not between", value1, value2, "recentlyLanded");
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