package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.RateImdb;
import org.humingk.common.entity.RateImdbExample;

@Mapper
public interface RateImdbMapper {
    long countByExample(RateImdbExample example);

    int deleteByExample(RateImdbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RateImdb record);

    int insertSelective(RateImdb record);

    List<RateImdb> selectByExample(RateImdbExample example);

    RateImdb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RateImdb record, @Param("example") RateImdbExample example);

    int updateByExample(@Param("record") RateImdb record, @Param("example") RateImdbExample example);

    int updateByPrimaryKeySelective(RateImdb record);

    int updateByPrimaryKey(RateImdb record);
}