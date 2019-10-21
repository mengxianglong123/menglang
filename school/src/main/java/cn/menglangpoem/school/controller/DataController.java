package cn.menglangpoem.school.controller;

import cn.menglangpoem.school.pojo.*;
import cn.menglangpoem.school.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class DataController {
    @Resource
    private DataService dataService;

    @RequestMapping("/")
    public String toIndex(Model model){
        List<School> schools = this.dataService.selAllSchool();
        List<DataName> names = this.dataService.selAllDataName();
        List<SchoolData> schoolDatas = new ArrayList<>();
        for (int i = 0; i < schools.size(); i++) {
            List<String> datas = this.dataService.sellAllDataBySchool(schools.get(i).getNum(),names);
            SchoolData schoolData = new SchoolData(schools.get(i).getName(),datas);
            schoolDatas.add(schoolData);
        }
        model.addAttribute("names",names);
        model.addAttribute("schoolDatas",schoolDatas);
        return "index.html";
    }

    @RequestMapping("/allSchool")
    public String allSchool(Model model){
        List<School> schools = this.dataService.selAllSchool();
        model.addAttribute("schools",schools);
        return "allSchool.html";
    }

    @RequestMapping("/allDataName")
    public String allDataName(Model model){
        List<DataName> dataNames = this.dataService.selAllDataName();
        model.addAttribute("names",dataNames);
        return "allDataName.html";
    }

    @RequestMapping("/analyse")
    public String analyse(Model model){
        List<DataName> dataNames = this.dataService.selAllDataName();
        model.addAttribute("names",dataNames);
        return "analyse.html";
    }

    @RequestMapping("/oneSchool")
    public String oneSchool(Model model,int num){
        List<DataName> names = this.dataService.selAllDataName();
        Map<String,String> map = new HashMap<>();
        School school = this.dataService.selSchoolByNum(num);
        List<DataContent> contents = this.dataService.selDataBySchoolNum(num);
        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i).getNum(),names.get(i).getName());
        }
        model.addAttribute("map",map);
        model.addAttribute("contents",contents);
        model.addAttribute("school",school);
        return "oneSchool.html";
    }


    @RequestMapping("/oneName")
    public String oneName(Model model,String num){
        List<School> schools = this.dataService.selAllSchool();
        Map<Integer,String> map = new HashMap<>();
        DataName name = this.dataService.selNameByNum(num);
        List<DataContent> contents = this.dataService.selDataByDataNum(num);
        for (School s:schools) {
            map.put(s.getNum(),s.getName());
        }
        model.addAttribute("map",map);
        model.addAttribute("contents",contents);
        model.addAttribute("name",name);
        return "oneName.html";
    }


    @RequestMapping("/analyseOne")
    public String analyseOne(Model model,String num){
        // 获取所有学校信息
        List<School> schoolList = this.dataService.selAllSchool();
        // 查询num所对应信息名称
        DataName name = this.dataService.selNameByNum(num);
        model.addAttribute("name",name);
        // 查询信息
        List<DataContent> contents = this.dataService.selDataByDataNum(num);
        List<String> datas = new ArrayList<>();
        List<Object> infos = new ArrayList();
        // 将信息的值全部存储到list中
        for (DataContent content:contents){
            datas.add(content.getData());
        }

        // 判断分析类型
        boolean canNum = true;
        if (this.dataService.canAnalyseNum(datas)){
            double max = this.dataService.getMax(datas);
            String maxNum = String.valueOf(new Double(max).intValue());
            List<DataContent> maxDatas = this.dataService.selDataBydData(maxNum,num);
            double min = this.dataService.getMin(datas);
            String minNum = String.valueOf(new Double(min).intValue());
            List<DataContent> minDatas = this.dataService.selDataBydData(minNum,num);
            // 改变类型
            List<Double> doubles = new ArrayList<>();
            for (String s:datas){
                doubles.add(Double.parseDouble(s));
            }
            double avg = this.dataService.getAverage(doubles);
            double dev = this.dataService.getStandardDevition(doubles);
            List<String> heads = new ArrayList<>();
            infos.add(avg);
            infos.add(dev);
            heads.add("最大值");
            heads.add("最小值");
            heads.add("均值");
            heads.add("标准差");
            model.addAttribute("heads",heads);
            model.addAttribute("maxDatas",maxDatas);
            model.addAttribute("minDatas",minDatas);
        }

        else {
            canNum = false;
            DataType most = this.dataService.getMost(datas);
            DataType least = this.dataService.getLeast(datas);
            List<String> heads = new ArrayList<>();
            heads.add("出现次数最多的数据");
            heads.add("出现次数最少的数据");
            model.addAttribute("heads",heads);
            List maxDatas = new ArrayList();
            List minDatas = new ArrayList();
            maxDatas.add(new DataContent());
            minDatas.add(new DataContent());
            model.addAttribute("maxDatas",maxDatas);
            model.addAttribute("minDatas",minDatas);
            infos.add(most);
            infos.add(least);
        }
        model.addAttribute("infos",infos);
        model.addAttribute("canNum",canNum);


        // 组建映射
        Map<Integer,String> map = new HashMap<>();
        for (School s:schoolList){
            map.put(s.getNum(),s.getName());
        }
        model.addAttribute("map",map);

        return "analyseOne.html";
    }
}
