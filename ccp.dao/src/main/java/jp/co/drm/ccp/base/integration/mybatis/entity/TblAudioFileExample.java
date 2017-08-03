package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblAudioFileExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public TblAudioFileExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
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
     * This method corresponds to the database table tbl_audio_file
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
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
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
     * This class corresponds to the database table tbl_audio_file
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

        public Criteria andAudioFileNoIsNull() {
            addCriterion("audio_file_no is null");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoIsNotNull() {
            addCriterion("audio_file_no is not null");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoEqualTo(String value) {
            addCriterion("audio_file_no =", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoNotEqualTo(String value) {
            addCriterion("audio_file_no <>", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoGreaterThan(String value) {
            addCriterion("audio_file_no >", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoGreaterThanOrEqualTo(String value) {
            addCriterion("audio_file_no >=", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoLessThan(String value) {
            addCriterion("audio_file_no <", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoLessThanOrEqualTo(String value) {
            addCriterion("audio_file_no <=", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoLike(String value) {
            addCriterion("audio_file_no like", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoNotLike(String value) {
            addCriterion("audio_file_no not like", value, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoIn(List<String> values) {
            addCriterion("audio_file_no in", values, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoNotIn(List<String> values) {
            addCriterion("audio_file_no not in", values, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoBetween(String value1, String value2) {
            addCriterion("audio_file_no between", value1, value2, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileNoNotBetween(String value1, String value2) {
            addCriterion("audio_file_no not between", value1, value2, "audioFileNo");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlIsNull() {
            addCriterion("audio_file_url is null");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlIsNotNull() {
            addCriterion("audio_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlEqualTo(String value) {
            addCriterion("audio_file_url =", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlNotEqualTo(String value) {
            addCriterion("audio_file_url <>", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlGreaterThan(String value) {
            addCriterion("audio_file_url >", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("audio_file_url >=", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlLessThan(String value) {
            addCriterion("audio_file_url <", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlLessThanOrEqualTo(String value) {
            addCriterion("audio_file_url <=", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlLike(String value) {
            addCriterion("audio_file_url like", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlNotLike(String value) {
            addCriterion("audio_file_url not like", value, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlIn(List<String> values) {
            addCriterion("audio_file_url in", values, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlNotIn(List<String> values) {
            addCriterion("audio_file_url not in", values, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlBetween(String value1, String value2) {
            addCriterion("audio_file_url between", value1, value2, "audioFileUrl");
            return (Criteria) this;
        }

        public Criteria andAudioFileUrlNotBetween(String value1, String value2) {
            addCriterion("audio_file_url not between", value1, value2, "audioFileUrl");
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
     * This class corresponds to the database table tbl_audio_file
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
     * This class corresponds to the database table tbl_audio_file
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