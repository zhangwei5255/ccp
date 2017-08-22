package jp.co.drm.ccp.base.integration.mybatis.dao;

import java.util.List;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstModule;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstModuleExample;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstModuleKey;
import org.apache.ibatis.annotations.Param;

public interface MstModuleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    long countByExample(MstModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int deleteByExample(MstModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int deleteByPrimaryKey(MstModuleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int insert(MstModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int insertSelective(MstModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    List<MstModule> selectByExample(MstModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    MstModule selectByPrimaryKey(MstModuleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByExampleSelective(@Param("record") MstModule record, @Param("example") MstModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByExample(@Param("record") MstModule record, @Param("example") MstModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByPrimaryKeySelective(MstModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_module
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByPrimaryKey(MstModule record);
}