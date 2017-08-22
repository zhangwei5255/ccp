package jp.co.drm.ccp.base.integration.mybatis.dao;

import java.util.List;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstRole;
import jp.co.drm.ccp.base.integration.mybatis.entity.MstRoleExample;
import org.apache.ibatis.annotations.Param;

public interface MstRoleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    long countByExample(MstRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int deleteByExample(MstRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int deleteByPrimaryKey(String roleCd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int insert(MstRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int insertSelective(MstRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    List<MstRole> selectByExample(MstRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    MstRole selectByPrimaryKey(String roleCd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByExampleSelective(@Param("record") MstRole record, @Param("example") MstRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByExample(@Param("record") MstRole record, @Param("example") MstRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByPrimaryKeySelective(MstRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mst_role
     *
     * @mbg.generated Fri Aug 18 19:42:30 JST 2017
     */
    int updateByPrimaryKey(MstRole record);
}