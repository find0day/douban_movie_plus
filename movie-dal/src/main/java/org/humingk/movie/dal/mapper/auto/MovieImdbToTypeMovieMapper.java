package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieImdbToTypeMovie;
import org.humingk.movie.dal.entity.MovieImdbToTypeMovieExample;

@Mapper
public interface MovieImdbToTypeMovieMapper {
    long countByExample(MovieImdbToTypeMovieExample example);

    int deleteByExample(MovieImdbToTypeMovieExample example);

    int deleteByPrimaryKey(@Param("idMovieImdb") Long idMovieImdb, @Param("idTypeMovie") Short idTypeMovie);

    int insert(MovieImdbToTypeMovie record);

    int insertSelective(MovieImdbToTypeMovie record);

    List<MovieImdbToTypeMovie> selectByExample(MovieImdbToTypeMovieExample example);

    int updateByExampleSelective(@Param("record") MovieImdbToTypeMovie record, @Param("example") MovieImdbToTypeMovieExample example);

    int updateByExample(@Param("record") MovieImdbToTypeMovie record, @Param("example") MovieImdbToTypeMovieExample example);
}