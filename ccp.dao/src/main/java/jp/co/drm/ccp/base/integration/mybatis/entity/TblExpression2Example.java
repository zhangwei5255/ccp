package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblExpression2Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public TblExpression2Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
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

        public Criteria andExpIdIsNull() {
            addCriterion("exp_id is null");
            return (Criteria) this;
        }

        public Criteria andExpIdIsNotNull() {
            addCriterion("exp_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpIdEqualTo(String value) {
            addCriterion("exp_id =", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdNotEqualTo(String value) {
            addCriterion("exp_id <>", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdGreaterThan(String value) {
            addCriterion("exp_id >", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdGreaterThanOrEqualTo(String value) {
            addCriterion("exp_id >=", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdLessThan(String value) {
            addCriterion("exp_id <", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdLessThanOrEqualTo(String value) {
            addCriterion("exp_id <=", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdLike(String value) {
            addCriterion("exp_id like", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdNotLike(String value) {
            addCriterion("exp_id not like", value, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdIn(List<String> values) {
            addCriterion("exp_id in", values, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdNotIn(List<String> values) {
            addCriterion("exp_id not in", values, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdBetween(String value1, String value2) {
            addCriterion("exp_id between", value1, value2, "expId");
            return (Criteria) this;
        }

        public Criteria andExpIdNotBetween(String value1, String value2) {
            addCriterion("exp_id not between", value1, value2, "expId");
            return (Criteria) this;
        }

        public Criteria andExpTopicIsNull() {
            addCriterion("exp_topic is null");
            return (Criteria) this;
        }

        public Criteria andExpTopicIsNotNull() {
            addCriterion("exp_topic is not null");
            return (Criteria) this;
        }

        public Criteria andExpTopicEqualTo(String value) {
            addCriterion("exp_topic =", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicNotEqualTo(String value) {
            addCriterion("exp_topic <>", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicGreaterThan(String value) {
            addCriterion("exp_topic >", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicGreaterThanOrEqualTo(String value) {
            addCriterion("exp_topic >=", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicLessThan(String value) {
            addCriterion("exp_topic <", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicLessThanOrEqualTo(String value) {
            addCriterion("exp_topic <=", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicLike(String value) {
            addCriterion("exp_topic like", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicNotLike(String value) {
            addCriterion("exp_topic not like", value, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicIn(List<String> values) {
            addCriterion("exp_topic in", values, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicNotIn(List<String> values) {
            addCriterion("exp_topic not in", values, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicBetween(String value1, String value2) {
            addCriterion("exp_topic between", value1, value2, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpTopicNotBetween(String value1, String value2) {
            addCriterion("exp_topic not between", value1, value2, "expTopic");
            return (Criteria) this;
        }

        public Criteria andExpSizeIsNull() {
            addCriterion("exp_size is null");
            return (Criteria) this;
        }

        public Criteria andExpSizeIsNotNull() {
            addCriterion("exp_size is not null");
            return (Criteria) this;
        }

        public Criteria andExpSizeEqualTo(Long value) {
            addCriterion("exp_size =", value, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeNotEqualTo(Long value) {
            addCriterion("exp_size <>", value, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeGreaterThan(Long value) {
            addCriterion("exp_size >", value, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("exp_size >=", value, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeLessThan(Long value) {
            addCriterion("exp_size <", value, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeLessThanOrEqualTo(Long value) {
            addCriterion("exp_size <=", value, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeIn(List<Long> values) {
            addCriterion("exp_size in", values, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeNotIn(List<Long> values) {
            addCriterion("exp_size not in", values, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeBetween(Long value1, Long value2) {
            addCriterion("exp_size between", value1, value2, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpSizeNotBetween(Long value1, Long value2) {
            addCriterion("exp_size not between", value1, value2, "expSize");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgIsNull() {
            addCriterion("exp_del_flg is null");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgIsNotNull() {
            addCriterion("exp_del_flg is not null");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgEqualTo(String value) {
            addCriterion("exp_del_flg =", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgNotEqualTo(String value) {
            addCriterion("exp_del_flg <>", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgGreaterThan(String value) {
            addCriterion("exp_del_flg >", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgGreaterThanOrEqualTo(String value) {
            addCriterion("exp_del_flg >=", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgLessThan(String value) {
            addCriterion("exp_del_flg <", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgLessThanOrEqualTo(String value) {
            addCriterion("exp_del_flg <=", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgLike(String value) {
            addCriterion("exp_del_flg like", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgNotLike(String value) {
            addCriterion("exp_del_flg not like", value, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgIn(List<String> values) {
            addCriterion("exp_del_flg in", values, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgNotIn(List<String> values) {
            addCriterion("exp_del_flg not in", values, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgBetween(String value1, String value2) {
            addCriterion("exp_del_flg between", value1, value2, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andExpDelFlgNotBetween(String value1, String value2) {
            addCriterion("exp_del_flg not between", value1, value2, "expDelFlg");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNull() {
            addCriterion("upd_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNotNull() {
            addCriterion("upd_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdEqualTo(String value) {
            addCriterion("upd_user_id =", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotEqualTo(String value) {
            addCriterion("upd_user_id <>", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThan(String value) {
            addCriterion("upd_user_id >", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("upd_user_id >=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThan(String value) {
            addCriterion("upd_user_id <", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThanOrEqualTo(String value) {
            addCriterion("upd_user_id <=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLike(String value) {
            addCriterion("upd_user_id like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotLike(String value) {
            addCriterion("upd_user_id not like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIn(List<String> values) {
            addCriterion("upd_user_id in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotIn(List<String> values) {
            addCriterion("upd_user_id not in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdBetween(String value1, String value2) {
            addCriterion("upd_user_id between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotBetween(String value1, String value2) {
            addCriterion("upd_user_id not between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_expression2
     *
     * @mbg.generated do_not_delete_during_merge Wed Aug 02 19:48:22 JST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
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