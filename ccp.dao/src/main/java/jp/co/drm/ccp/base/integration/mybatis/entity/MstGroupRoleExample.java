package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MstGroupRoleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public MstGroupRoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
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
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
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

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("GROUP_ID like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("GROUP_ID not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andModuleCdIsNull() {
            addCriterion("MODULE_CD is null");
            return (Criteria) this;
        }

        public Criteria andModuleCdIsNotNull() {
            addCriterion("MODULE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andModuleCdEqualTo(String value) {
            addCriterion("MODULE_CD =", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdNotEqualTo(String value) {
            addCriterion("MODULE_CD <>", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdGreaterThan(String value) {
            addCriterion("MODULE_CD >", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_CD >=", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdLessThan(String value) {
            addCriterion("MODULE_CD <", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdLessThanOrEqualTo(String value) {
            addCriterion("MODULE_CD <=", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdLike(String value) {
            addCriterion("MODULE_CD like", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdNotLike(String value) {
            addCriterion("MODULE_CD not like", value, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdIn(List<String> values) {
            addCriterion("MODULE_CD in", values, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdNotIn(List<String> values) {
            addCriterion("MODULE_CD not in", values, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdBetween(String value1, String value2) {
            addCriterion("MODULE_CD between", value1, value2, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andModuleCdNotBetween(String value1, String value2) {
            addCriterion("MODULE_CD not between", value1, value2, "moduleCd");
            return (Criteria) this;
        }

        public Criteria andRegUserIdIsNull() {
            addCriterion("REG_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegUserIdIsNotNull() {
            addCriterion("REG_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegUserIdEqualTo(String value) {
            addCriterion("REG_USER_ID =", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdNotEqualTo(String value) {
            addCriterion("REG_USER_ID <>", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdGreaterThan(String value) {
            addCriterion("REG_USER_ID >", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("REG_USER_ID >=", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdLessThan(String value) {
            addCriterion("REG_USER_ID <", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdLessThanOrEqualTo(String value) {
            addCriterion("REG_USER_ID <=", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdLike(String value) {
            addCriterion("REG_USER_ID like", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdNotLike(String value) {
            addCriterion("REG_USER_ID not like", value, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdIn(List<String> values) {
            addCriterion("REG_USER_ID in", values, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdNotIn(List<String> values) {
            addCriterion("REG_USER_ID not in", values, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdBetween(String value1, String value2) {
            addCriterion("REG_USER_ID between", value1, value2, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegUserIdNotBetween(String value1, String value2) {
            addCriterion("REG_USER_ID not between", value1, value2, "regUserId");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeIsNull() {
            addCriterion("REG_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeIsNotNull() {
            addCriterion("REG_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeEqualTo(Date value) {
            addCriterion("REG_DATE_TIME =", value, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeNotEqualTo(Date value) {
            addCriterion("REG_DATE_TIME <>", value, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeGreaterThan(Date value) {
            addCriterion("REG_DATE_TIME >", value, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REG_DATE_TIME >=", value, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeLessThan(Date value) {
            addCriterion("REG_DATE_TIME <", value, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("REG_DATE_TIME <=", value, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeIn(List<Date> values) {
            addCriterion("REG_DATE_TIME in", values, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeNotIn(List<Date> values) {
            addCriterion("REG_DATE_TIME not in", values, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeBetween(Date value1, Date value2) {
            addCriterion("REG_DATE_TIME between", value1, value2, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andRegDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("REG_DATE_TIME not between", value1, value2, "regDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNull() {
            addCriterion("UPD_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNotNull() {
            addCriterion("UPD_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdEqualTo(String value) {
            addCriterion("UPD_USER_ID =", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotEqualTo(String value) {
            addCriterion("UPD_USER_ID <>", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThan(String value) {
            addCriterion("UPD_USER_ID >", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPD_USER_ID >=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThan(String value) {
            addCriterion("UPD_USER_ID <", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThanOrEqualTo(String value) {
            addCriterion("UPD_USER_ID <=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLike(String value) {
            addCriterion("UPD_USER_ID like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotLike(String value) {
            addCriterion("UPD_USER_ID not like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIn(List<String> values) {
            addCriterion("UPD_USER_ID in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotIn(List<String> values) {
            addCriterion("UPD_USER_ID not in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdBetween(String value1, String value2) {
            addCriterion("UPD_USER_ID between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotBetween(String value1, String value2) {
            addCriterion("UPD_USER_ID not between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeIsNull() {
            addCriterion("UPD_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeIsNotNull() {
            addCriterion("UPD_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeEqualTo(Date value) {
            addCriterion("UPD_DATE_TIME =", value, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeNotEqualTo(Date value) {
            addCriterion("UPD_DATE_TIME <>", value, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeGreaterThan(Date value) {
            addCriterion("UPD_DATE_TIME >", value, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPD_DATE_TIME >=", value, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeLessThan(Date value) {
            addCriterion("UPD_DATE_TIME <", value, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPD_DATE_TIME <=", value, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeIn(List<Date> values) {
            addCriterion("UPD_DATE_TIME in", values, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeNotIn(List<Date> values) {
            addCriterion("UPD_DATE_TIME not in", values, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeBetween(Date value1, Date value2) {
            addCriterion("UPD_DATE_TIME between", value1, value2, "updDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPD_DATE_TIME not between", value1, value2, "updDateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mst_group_role
     *
     * @mbg.generated do_not_delete_during_merge Fri Aug 25 18:46:10 JST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mst_group_role
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
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