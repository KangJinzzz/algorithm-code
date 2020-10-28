package kang.mapper;

import kang.model.Dorm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dorm record);

    Dorm selectByPrimaryKey(Integer id);

    List<Dorm> selectAll();

    int updateByPrimaryKey(Dorm record);
}