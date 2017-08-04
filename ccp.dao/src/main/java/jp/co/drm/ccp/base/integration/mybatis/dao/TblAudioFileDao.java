package jp.co.drm.ccp.base.integration.mybatis.dao;

import java.util.List;
import jp.co.drm.ccp.base.integration.mybatis.entity.TblAudioFile;
import jp.co.drm.ccp.base.integration.mybatis.entity.TblAudioFileExample;
import org.apache.ibatis.annotations.Param;

public interface TblAudioFileDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    long countByExample(TblAudioFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int deleteByExample(TblAudioFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int deleteByPrimaryKey(String audioFileNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int insert(TblAudioFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int insertSelective(TblAudioFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    List<TblAudioFile> selectByExample(TblAudioFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    TblAudioFile selectByPrimaryKey(String audioFileNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExampleSelective(@Param("record") TblAudioFile record, @Param("example") TblAudioFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByExample(@Param("record") TblAudioFile record, @Param("example") TblAudioFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByPrimaryKeySelective(TblAudioFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_audio_file
     *
     * @mbg.generated Wed Aug 02 19:48:22 JST 2017
     */
    int updateByPrimaryKey(TblAudioFile record);
}