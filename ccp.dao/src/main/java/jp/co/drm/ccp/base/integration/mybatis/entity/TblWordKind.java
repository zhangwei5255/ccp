package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.io.Serializable;

public class TblWordKind implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_word_kind.word_kind_id
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private String wordKindId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_word_kind.word_kind_name
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private String wordKindName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_word_kind
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_word_kind.word_kind_id
     *
     * @return the value of tbl_word_kind.word_kind_id
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public String getWordKindId() {
        return wordKindId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_word_kind.word_kind_id
     *
     * @param wordKindId the value for tbl_word_kind.word_kind_id
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setWordKindId(String wordKindId) {
        this.wordKindId = wordKindId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_word_kind.word_kind_name
     *
     * @return the value of tbl_word_kind.word_kind_name
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public String getWordKindName() {
        return wordKindName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_word_kind.word_kind_name
     *
     * @param wordKindName the value for tbl_word_kind.word_kind_name
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setWordKindName(String wordKindName) {
        this.wordKindName = wordKindName;
    }
}