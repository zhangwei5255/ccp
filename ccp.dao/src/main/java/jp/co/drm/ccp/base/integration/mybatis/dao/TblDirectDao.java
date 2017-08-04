package jp.co.drm.ccp.base.integration.mybatis.dao;

import java.util.List;
import jp.co.drm.ccp.base.integration.mybatis.entity.TblDirectExample;
import jp.co.drm.ccp.base.integration.mybatis.entity.TblDirectKey;
import org.apache.ibatis.annotations.Param;

public interface TblDirectDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    long countByExample(TblDirectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int deleteByExample(TblDirectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int deleteByPrimaryKey(TblDirectKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int insert(TblDirectKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int insertSelective(TblDirectKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    List<TblDirectKey> selectByExample(TblDirectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExampleSelective(@Param("record") TblDirectKey record, @Param("example") TblDirectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_direct
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExample(@Param("record") TblDirectKey record, @Param("example") TblDirectExample example);
}