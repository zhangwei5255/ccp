package jp.co.drm.ccp.base.integration.mybatis.dao;

import java.util.List;
import jp.co.drm.ccp.base.integration.mybatis.entity.TblExpression2;
import jp.co.drm.ccp.base.integration.mybatis.entity.TblExpression2Example;
import org.apache.ibatis.annotations.Param;

public interface TblExpression2Dao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    long countByExample(TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int deleteByExample(TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int deleteByPrimaryKey(String expId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int insert(TblExpression2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int insertSelective(TblExpression2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    List<TblExpression2> selectByExampleWithBLOBs(TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    List<TblExpression2> selectByExample(TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    TblExpression2 selectByPrimaryKey(String expId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExampleSelective(@Param("record") TblExpression2 record, @Param("example") TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") TblExpression2 record, @Param("example") TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExample(@Param("record") TblExpression2 record, @Param("example") TblExpression2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByPrimaryKeySelective(TblExpression2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByPrimaryKeyWithBLOBs(TblExpression2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_expression2
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByPrimaryKey(TblExpression2 record);
}