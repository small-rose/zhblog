package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class PictureQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PictureQuery() {
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

        public Criteria andPicNameIsNull() {
            addCriterion("pic_name is null");
            return (Criteria) this;
        }

        public Criteria andPicNameIsNotNull() {
            addCriterion("pic_name is not null");
            return (Criteria) this;
        }

        public Criteria andPicNameEqualTo(String value) {
            addCriterion("pic_name =", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotEqualTo(String value) {
            addCriterion("pic_name <>", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameGreaterThan(String value) {
            addCriterion("pic_name >", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_name >=", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameLessThan(String value) {
            addCriterion("pic_name <", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameLessThanOrEqualTo(String value) {
            addCriterion("pic_name <=", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameLike(String value) {
            addCriterion("pic_name like", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotLike(String value) {
            addCriterion("pic_name not like", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameIn(List<String> values) {
            addCriterion("pic_name in", values, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotIn(List<String> values) {
            addCriterion("pic_name not in", values, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameBetween(String value1, String value2) {
            addCriterion("pic_name between", value1, value2, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotBetween(String value1, String value2) {
            addCriterion("pic_name not between", value1, value2, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameIsNull() {
            addCriterion("pic_new_name is null");
            return (Criteria) this;
        }

        public Criteria andPicNewNameIsNotNull() {
            addCriterion("pic_new_name is not null");
            return (Criteria) this;
        }

        public Criteria andPicNewNameEqualTo(String value) {
            addCriterion("pic_new_name =", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotEqualTo(String value) {
            addCriterion("pic_new_name <>", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameGreaterThan(String value) {
            addCriterion("pic_new_name >", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_new_name >=", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameLessThan(String value) {
            addCriterion("pic_new_name <", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameLessThanOrEqualTo(String value) {
            addCriterion("pic_new_name <=", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameLike(String value) {
            addCriterion("pic_new_name like", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotLike(String value) {
            addCriterion("pic_new_name not like", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameIn(List<String> values) {
            addCriterion("pic_new_name in", values, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotIn(List<String> values) {
            addCriterion("pic_new_name not in", values, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameBetween(String value1, String value2) {
            addCriterion("pic_new_name between", value1, value2, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotBetween(String value1, String value2) {
            addCriterion("pic_new_name not between", value1, value2, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressIsNull() {
            addCriterion("pic_local_address is null");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressIsNotNull() {
            addCriterion("pic_local_address is not null");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressEqualTo(String value) {
            addCriterion("pic_local_address =", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressNotEqualTo(String value) {
            addCriterion("pic_local_address <>", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressGreaterThan(String value) {
            addCriterion("pic_local_address >", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pic_local_address >=", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressLessThan(String value) {
            addCriterion("pic_local_address <", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressLessThanOrEqualTo(String value) {
            addCriterion("pic_local_address <=", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressLike(String value) {
            addCriterion("pic_local_address like", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressNotLike(String value) {
            addCriterion("pic_local_address not like", value, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressIn(List<String> values) {
            addCriterion("pic_local_address in", values, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressNotIn(List<String> values) {
            addCriterion("pic_local_address not in", values, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressBetween(String value1, String value2) {
            addCriterion("pic_local_address between", value1, value2, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLocalAddressNotBetween(String value1, String value2) {
            addCriterion("pic_local_address not between", value1, value2, "picLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressIsNull() {
            addCriterion("abs_local_address is null");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressIsNotNull() {
            addCriterion("abs_local_address is not null");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressEqualTo(String value) {
            addCriterion("abs_local_address =", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressNotEqualTo(String value) {
            addCriterion("abs_local_address <>", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressGreaterThan(String value) {
            addCriterion("abs_local_address >", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("abs_local_address >=", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressLessThan(String value) {
            addCriterion("abs_local_address <", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressLessThanOrEqualTo(String value) {
            addCriterion("abs_local_address <=", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressLike(String value) {
            addCriterion("abs_local_address like", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressNotLike(String value) {
            addCriterion("abs_local_address not like", value, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressIn(List<String> values) {
            addCriterion("abs_local_address in", values, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressNotIn(List<String> values) {
            addCriterion("abs_local_address not in", values, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressBetween(String value1, String value2) {
            addCriterion("abs_local_address between", value1, value2, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andAbsLocalAddressNotBetween(String value1, String value2) {
            addCriterion("abs_local_address not between", value1, value2, "absLocalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressIsNull() {
            addCriterion("original_address is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressIsNotNull() {
            addCriterion("original_address is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressEqualTo(String value) {
            addCriterion("original_address =", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressNotEqualTo(String value) {
            addCriterion("original_address <>", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressGreaterThan(String value) {
            addCriterion("original_address >", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("original_address >=", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressLessThan(String value) {
            addCriterion("original_address <", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressLessThanOrEqualTo(String value) {
            addCriterion("original_address <=", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressLike(String value) {
            addCriterion("original_address like", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressNotLike(String value) {
            addCriterion("original_address not like", value, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressIn(List<String> values) {
            addCriterion("original_address in", values, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressNotIn(List<String> values) {
            addCriterion("original_address not in", values, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressBetween(String value1, String value2) {
            addCriterion("original_address between", value1, value2, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andOriginalAddressNotBetween(String value1, String value2) {
            addCriterion("original_address not between", value1, value2, "originalAddress");
            return (Criteria) this;
        }

        public Criteria andPicLengthIsNull() {
            addCriterion("pic_length is null");
            return (Criteria) this;
        }

        public Criteria andPicLengthIsNotNull() {
            addCriterion("pic_length is not null");
            return (Criteria) this;
        }

        public Criteria andPicLengthEqualTo(Long value) {
            addCriterion("pic_length =", value, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthNotEqualTo(Long value) {
            addCriterion("pic_length <>", value, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthGreaterThan(Long value) {
            addCriterion("pic_length >", value, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthGreaterThanOrEqualTo(Long value) {
            addCriterion("pic_length >=", value, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthLessThan(Long value) {
            addCriterion("pic_length <", value, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthLessThanOrEqualTo(Long value) {
            addCriterion("pic_length <=", value, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthIn(List<Long> values) {
            addCriterion("pic_length in", values, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthNotIn(List<Long> values) {
            addCriterion("pic_length not in", values, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthBetween(Long value1, Long value2) {
            addCriterion("pic_length between", value1, value2, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicLengthNotBetween(Long value1, Long value2) {
            addCriterion("pic_length not between", value1, value2, "picLength");
            return (Criteria) this;
        }

        public Criteria andPicSuffixIsNull() {
            addCriterion("pic_suffix is null");
            return (Criteria) this;
        }

        public Criteria andPicSuffixIsNotNull() {
            addCriterion("pic_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andPicSuffixEqualTo(String value) {
            addCriterion("pic_suffix =", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixNotEqualTo(String value) {
            addCriterion("pic_suffix <>", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixGreaterThan(String value) {
            addCriterion("pic_suffix >", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("pic_suffix >=", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixLessThan(String value) {
            addCriterion("pic_suffix <", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixLessThanOrEqualTo(String value) {
            addCriterion("pic_suffix <=", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixLike(String value) {
            addCriterion("pic_suffix like", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixNotLike(String value) {
            addCriterion("pic_suffix not like", value, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixIn(List<String> values) {
            addCriterion("pic_suffix in", values, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixNotIn(List<String> values) {
            addCriterion("pic_suffix not in", values, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixBetween(String value1, String value2) {
            addCriterion("pic_suffix between", value1, value2, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andPicSuffixNotBetween(String value1, String value2) {
            addCriterion("pic_suffix not between", value1, value2, "picSuffix");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("upload_Date is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("upload_Date is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(String value) {
            addCriterion("upload_Date =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(String value) {
            addCriterion("upload_Date <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(String value) {
            addCriterion("upload_Date >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(String value) {
            addCriterion("upload_Date >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(String value) {
            addCriterion("upload_Date <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(String value) {
            addCriterion("upload_Date <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLike(String value) {
            addCriterion("upload_Date like", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotLike(String value) {
            addCriterion("upload_Date not like", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<String> values) {
            addCriterion("upload_Date in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<String> values) {
            addCriterion("upload_Date not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(String value1, String value2) {
            addCriterion("upload_Date between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(String value1, String value2) {
            addCriterion("upload_Date not between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andLikesIsNull() {
            addCriterion("likes is null");
            return (Criteria) this;
        }

        public Criteria andLikesIsNotNull() {
            addCriterion("likes is not null");
            return (Criteria) this;
        }

        public Criteria andLikesEqualTo(Integer value) {
            addCriterion("likes =", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotEqualTo(Integer value) {
            addCriterion("likes <>", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThan(Integer value) {
            addCriterion("likes >", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("likes >=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThan(Integer value) {
            addCriterion("likes <", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThanOrEqualTo(Integer value) {
            addCriterion("likes <=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesIn(List<Integer> values) {
            addCriterion("likes in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotIn(List<Integer> values) {
            addCriterion("likes not in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesBetween(Integer value1, Integer value2) {
            addCriterion("likes between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("likes not between", value1, value2, "likes");
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