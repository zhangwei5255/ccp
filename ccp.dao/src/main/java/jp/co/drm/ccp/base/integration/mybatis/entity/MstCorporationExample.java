package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MstCorporationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public MstCorporationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
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
     * This method corresponds to the database table mst_corporation
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
     * This method corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_corporation
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
     * This class corresponds to the database table mst_corporation
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

        public Criteria andCorporationNoIsNull() {
            addCriterion("CORPORATION_NO is null");
            return (Criteria) this;
        }

        public Criteria andCorporationNoIsNotNull() {
            addCriterion("CORPORATION_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationNoEqualTo(String value) {
            addCriterion("CORPORATION_NO =", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoNotEqualTo(String value) {
            addCriterion("CORPORATION_NO <>", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoGreaterThan(String value) {
            addCriterion("CORPORATION_NO >", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoGreaterThanOrEqualTo(String value) {
            addCriterion("CORPORATION_NO >=", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoLessThan(String value) {
            addCriterion("CORPORATION_NO <", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoLessThanOrEqualTo(String value) {
            addCriterion("CORPORATION_NO <=", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoLike(String value) {
            addCriterion("CORPORATION_NO like", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoNotLike(String value) {
            addCriterion("CORPORATION_NO not like", value, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoIn(List<String> values) {
            addCriterion("CORPORATION_NO in", values, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoNotIn(List<String> values) {
            addCriterion("CORPORATION_NO not in", values, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoBetween(String value1, String value2) {
            addCriterion("CORPORATION_NO between", value1, value2, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andCorporationNoNotBetween(String value1, String value2) {
            addCriterion("CORPORATION_NO not between", value1, value2, "corporationNo");
            return (Criteria) this;
        }

        public Criteria andDepartCdIsNull() {
            addCriterion("DEPART_CD is null");
            return (Criteria) this;
        }

        public Criteria andDepartCdIsNotNull() {
            addCriterion("DEPART_CD is not null");
            return (Criteria) this;
        }

        public Criteria andDepartCdEqualTo(String value) {
            addCriterion("DEPART_CD =", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdNotEqualTo(String value) {
            addCriterion("DEPART_CD <>", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdGreaterThan(String value) {
            addCriterion("DEPART_CD >", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPART_CD >=", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdLessThan(String value) {
            addCriterion("DEPART_CD <", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdLessThanOrEqualTo(String value) {
            addCriterion("DEPART_CD <=", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdLike(String value) {
            addCriterion("DEPART_CD like", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdNotLike(String value) {
            addCriterion("DEPART_CD not like", value, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdIn(List<String> values) {
            addCriterion("DEPART_CD in", values, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdNotIn(List<String> values) {
            addCriterion("DEPART_CD not in", values, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdBetween(String value1, String value2) {
            addCriterion("DEPART_CD between", value1, value2, "departCd");
            return (Criteria) this;
        }

        public Criteria andDepartCdNotBetween(String value1, String value2) {
            addCriterion("DEPART_CD not between", value1, value2, "departCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdIsNull() {
            addCriterion("DIVISION_CD is null");
            return (Criteria) this;
        }

        public Criteria andDivisionCdIsNotNull() {
            addCriterion("DIVISION_CD is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionCdEqualTo(String value) {
            addCriterion("DIVISION_CD =", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdNotEqualTo(String value) {
            addCriterion("DIVISION_CD <>", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdGreaterThan(String value) {
            addCriterion("DIVISION_CD >", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdGreaterThanOrEqualTo(String value) {
            addCriterion("DIVISION_CD >=", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdLessThan(String value) {
            addCriterion("DIVISION_CD <", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdLessThanOrEqualTo(String value) {
            addCriterion("DIVISION_CD <=", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdLike(String value) {
            addCriterion("DIVISION_CD like", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdNotLike(String value) {
            addCriterion("DIVISION_CD not like", value, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdIn(List<String> values) {
            addCriterion("DIVISION_CD in", values, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdNotIn(List<String> values) {
            addCriterion("DIVISION_CD not in", values, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdBetween(String value1, String value2) {
            addCriterion("DIVISION_CD between", value1, value2, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andDivisionCdNotBetween(String value1, String value2) {
            addCriterion("DIVISION_CD not between", value1, value2, "divisionCd");
            return (Criteria) this;
        }

        public Criteria andCorporationNmIsNull() {
            addCriterion("CORPORATION_NM is null");
            return (Criteria) this;
        }

        public Criteria andCorporationNmIsNotNull() {
            addCriterion("CORPORATION_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationNmEqualTo(String value) {
            addCriterion("CORPORATION_NM =", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmNotEqualTo(String value) {
            addCriterion("CORPORATION_NM <>", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmGreaterThan(String value) {
            addCriterion("CORPORATION_NM >", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmGreaterThanOrEqualTo(String value) {
            addCriterion("CORPORATION_NM >=", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmLessThan(String value) {
            addCriterion("CORPORATION_NM <", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmLessThanOrEqualTo(String value) {
            addCriterion("CORPORATION_NM <=", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmLike(String value) {
            addCriterion("CORPORATION_NM like", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmNotLike(String value) {
            addCriterion("CORPORATION_NM not like", value, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmIn(List<String> values) {
            addCriterion("CORPORATION_NM in", values, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmNotIn(List<String> values) {
            addCriterion("CORPORATION_NM not in", values, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmBetween(String value1, String value2) {
            addCriterion("CORPORATION_NM between", value1, value2, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andCorporationNmNotBetween(String value1, String value2) {
            addCriterion("CORPORATION_NM not between", value1, value2, "corporationNm");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNull() {
            addCriterion("TEL_NO is null");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNotNull() {
            addCriterion("TEL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTelNoEqualTo(String value) {
            addCriterion("TEL_NO =", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotEqualTo(String value) {
            addCriterion("TEL_NO <>", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThan(String value) {
            addCriterion("TEL_NO >", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_NO >=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThan(String value) {
            addCriterion("TEL_NO <", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanOrEqualTo(String value) {
            addCriterion("TEL_NO <=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLike(String value) {
            addCriterion("TEL_NO like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotLike(String value) {
            addCriterion("TEL_NO not like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoIn(List<String> values) {
            addCriterion("TEL_NO in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotIn(List<String> values) {
            addCriterion("TEL_NO not in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoBetween(String value1, String value2) {
            addCriterion("TEL_NO between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotBetween(String value1, String value2) {
            addCriterion("TEL_NO not between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoIsNull() {
            addCriterion("FAX_NO is null");
            return (Criteria) this;
        }

        public Criteria andFaxNoIsNotNull() {
            addCriterion("FAX_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFaxNoEqualTo(String value) {
            addCriterion("FAX_NO =", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotEqualTo(String value) {
            addCriterion("FAX_NO <>", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoGreaterThan(String value) {
            addCriterion("FAX_NO >", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("FAX_NO >=", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoLessThan(String value) {
            addCriterion("FAX_NO <", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoLessThanOrEqualTo(String value) {
            addCriterion("FAX_NO <=", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoLike(String value) {
            addCriterion("FAX_NO like", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotLike(String value) {
            addCriterion("FAX_NO not like", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoIn(List<String> values) {
            addCriterion("FAX_NO in", values, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotIn(List<String> values) {
            addCriterion("FAX_NO not in", values, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoBetween(String value1, String value2) {
            addCriterion("FAX_NO between", value1, value2, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotBetween(String value1, String value2) {
            addCriterion("FAX_NO not between", value1, value2, "faxNo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
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
     * This class corresponds to the database table mst_corporation
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
     * This class corresponds to the database table mst_corporation
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