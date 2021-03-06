package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class MstCorporation extends MstCorporationKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.CORPORATION_NM
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String corporationNm;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.ADDRESS
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.TEL_NO
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String telNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.FAX_NO
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String faxNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.EMAIL
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.REG_USER_ID
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String regUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.REG_DATE_TIME
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private Date regDateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.UPD_USER_ID
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private String updUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_corporation.UPD_DATE_TIME
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private Date updDateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mst_corporation
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.CORPORATION_NM
     *
     * @return the value of mst_corporation.CORPORATION_NM
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getCorporationNm() {
        return corporationNm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.CORPORATION_NM
     *
     * @param corporationNm the value for mst_corporation.CORPORATION_NM
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setCorporationNm(String corporationNm) {
        this.corporationNm = corporationNm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.ADDRESS
     *
     * @return the value of mst_corporation.ADDRESS
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.ADDRESS
     *
     * @param address the value for mst_corporation.ADDRESS
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.TEL_NO
     *
     * @return the value of mst_corporation.TEL_NO
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.TEL_NO
     *
     * @param telNo the value for mst_corporation.TEL_NO
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.FAX_NO
     *
     * @return the value of mst_corporation.FAX_NO
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getFaxNo() {
        return faxNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.FAX_NO
     *
     * @param faxNo the value for mst_corporation.FAX_NO
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.EMAIL
     *
     * @return the value of mst_corporation.EMAIL
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.EMAIL
     *
     * @param email the value for mst_corporation.EMAIL
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.REG_USER_ID
     *
     * @return the value of mst_corporation.REG_USER_ID
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getRegUserId() {
        return regUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.REG_USER_ID
     *
     * @param regUserId the value for mst_corporation.REG_USER_ID
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.REG_DATE_TIME
     *
     * @return the value of mst_corporation.REG_DATE_TIME
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public Date getRegDateTime() {
        return regDateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.REG_DATE_TIME
     *
     * @param regDateTime the value for mst_corporation.REG_DATE_TIME
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setRegDateTime(Date regDateTime) {
        this.regDateTime = regDateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.UPD_USER_ID
     *
     * @return the value of mst_corporation.UPD_USER_ID
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public String getUpdUserId() {
        return updUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.UPD_USER_ID
     *
     * @param updUserId the value for mst_corporation.UPD_USER_ID
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_corporation.UPD_DATE_TIME
     *
     * @return the value of mst_corporation.UPD_DATE_TIME
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public Date getUpdDateTime() {
        return updDateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_corporation.UPD_DATE_TIME
     *
     * @param updDateTime the value for mst_corporation.UPD_DATE_TIME
     *
     * @mbg.generated Fri Aug 25 18:46:10 JST 2017
     */
    public void setUpdDateTime(Date updDateTime) {
        this.updDateTime = updDateTime;
    }
}