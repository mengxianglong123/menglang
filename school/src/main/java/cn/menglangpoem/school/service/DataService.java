package cn.menglangpoem.school.service;

import cn.menglangpoem.school.mapper.DataMapper;
import cn.menglangpoem.school.pojo.DataContent;
import cn.menglangpoem.school.pojo.DataName;
import cn.menglangpoem.school.pojo.DataType;
import cn.menglangpoem.school.pojo.School;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class DataService {
    @Resource
    private DataMapper dataMapper;

    /**
     * 查询所有学校
     * @return
     */
    public List<School> selAllSchool(){
        return this.dataMapper.selAllSchool();
    }

    /**
     * 查询所有信息名称
     * @return
     */
    public List<DataName> selAllDataName(){
        return this.dataMapper.selAllDataName();
    }

    /**
     * 查询该学校所有数据
     * @return
     */
    public List<String> sellAllDataBySchool(int schoolNum,List<DataName> names){
        List<String> list = new ArrayList<>();
        for (int i=0;i<names.size();i++){
            list.add(this.dataMapper.selOneData(schoolNum,names.get(i).getNum()));
        }
        return list;
    }

    public List<DataContent> selDataBySchoolNum(int schoolNum){
        return this.dataMapper.selDataBySchoolNum(schoolNum);
    }

    public School selSchoolByNum(int num){
        return this.dataMapper.selSchoolByNum(num);
    }

    public DataName selNameByNum(String num){
        return this.dataMapper.selNameByNum(num);
    }

    public List<DataContent> selDataByDataNum(String num){
        return this.dataMapper.selDataByDataNum(num);
    }


    /**
     * 判断是否可以做数字分析
     * @param list
     * @return
     */
    public boolean canAnalyseNum(List<String> list){
        boolean flag = true;
        for (String s:list){
            if (!isNumeric(s)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    /**
     * 判断是否只包含数字
     * @param str
     * @return
     */
    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 计算均值
     * @return
     */
    public double getAverage(List<Double> list){
        double sum = 0;
        int num = list.size();
        for(int i = 0;i < num;i++){
            sum += list.get(i).doubleValue();
        }
        return (double)(sum / num);
    }

    /**
     * 计算标准差
     * @return
     */
    public double getStandardDevition(List<Double> list){
        double sum = 0;
        int num = list.size();
        for(int i = 0;i < num;i++){
            sum += Math.sqrt(((double)list.get(i).doubleValue() -getAverage(list)) * (list.get(i).doubleValue() -getAverage(list)));
        }
        return (sum / (num - 1));
    }

    /**
     * 获取最大值
     * @param list
     * @return
     */
    public double getMax(List<String> list){
        double max = 0;
        for (String s:list){
            Double n = Double.parseDouble(s);
            if (max<n.doubleValue()) max = n;
        }
        return max;
    }

    /**
     * 获取最小值
     * @param list
     * @return
     */
    public double getMin(List<String> list){
        double min = Double.parseDouble(list.get(0));
        for (String s:list){
            Double n = Double.parseDouble(s);
            if (min>n.doubleValue()) min = n;
        }
        return min;
    }

    /**
     * 判断是否包含
     * @param types
     * @param type
     * @return
     */
    public List<DataType> contain(List<DataType> types,String type){
        for (DataType t:types){
            if (t.getName().equals(type)){
                t.setNum(t.getNum()+1);
                return types;
            }
        }
        DataType dataType = new DataType(type,1);
        types.add(dataType);
        return types;
    }
    /**
     * 获取最多
     * @param list
     * @return
     */
    public DataType getMost(List<String> list){
        List<DataType> types = new ArrayList<>();
        for (String s:list){
            types = contain(types,s);
        }
        DataType most = types.get(0);
        for (DataType type:types){
            if (most.getNum()<type.getNum()) most = type;
        }
        return most;
    }

    /**
     * 获取最少
     * @param list
     * @return
     */
    public DataType getLeast(List<String> list){
        List<DataType> types = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            contain(types,list.get(i));
        }
        DataType least = types.get(0);
        for (DataType type:types){
            if (least.getNum()>=type.getNum()) least=type;
        }
        return least;
    }

    public List<DataContent> selDataBydData(String data,String dataNum){
        return this.dataMapper.selDataByData(data,dataNum);
    }
}
