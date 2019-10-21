package cn.menglangpoem.school.mapper;

import cn.menglangpoem.school.pojo.DataContent;
import cn.menglangpoem.school.pojo.DataName;
import cn.menglangpoem.school.pojo.School;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {
    /**
     * 查询所有学校
     * @return
     */
    @Select("select * from school")
    List<School> selAllSchool();

    @Select("select * from school where num = #{num}")
    School selSchoolByNum(@Param("num") int num);
    /**
     * 查询所有信息名称
     * @return
     */
    @Select("select * from data_name")
    List<DataName> selAllDataName();

    @Select("select * from data_name where num = #{num}")
    DataName selNameByNum(@Param("num") String num);

    /**
     * 精确查找单条信息
     * @param schoolNum
     * @param dataNum
     * @return
     */
    @Select("select data from data_content where schoolNum=#{schoolNum} and dataNum=#{dataNum}")
    String selOneData(@Param("schoolNum") int schoolNum,@Param("dataNum") String dataNum);

    @Select("select * from data_content where schoolNum = #{schoolNum}")
    List<DataContent> selDataBySchoolNum(@Param("schoolNum") int schoolNum);

    @Select("select * from data_content where dataNum = #{num}")
    List<DataContent> selDataByDataNum(@Param("num") String num);

    @Select("select * from data_content where dataNum=#{dataNum} and data=#{data}")
    List<DataContent> selDataByData(@Param("data") String data,@Param("dataNum") String dataNum);
}
