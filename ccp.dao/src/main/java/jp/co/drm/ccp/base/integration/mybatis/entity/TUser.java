package jp.co.drm.ccp.base.integration.mybatis.entity;

import java.io.Serializable;

public class TUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_id
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_name
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_age
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private String userAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_id
     *
     * @return the value of t_user.user_id
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_id
     *
     * @param userId the value for t_user.user_id
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_name
     *
     * @return the value of t_user.user_name
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_name
     *
     * @param userName the value for t_user.user_name
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_age
     *
     * @return the value of t_user.user_age
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public String getUserAge() {
        return userAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_age
     *
     * @param userAge the value for t_user.user_age
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
}