package com.lu.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lu.edu.entity.*;
import com.lu.edu.entity.dto.TeacherDto;
import com.lu.edu.entity.vo.TeacherVo;
import com.lu.edu.mapper.*;
import com.lu.edu.utils.result.CommonResult;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/edu")
public class ScyTeacherController {

    @Autowired
    private ScySecurityMapper scySecurityMapper;
    @Autowired
    private ScyTeacherMapper scyTeacherMapper;
    @Autowired
    private ThreeExamMapper threeExamMapper;
    @Autowired
    private FourExamMapper fourExamMapper;
    @Autowired
    private SixExamMapper sixExamMapper;
    @Autowired
    private ExamTowerMapper examTowerMapper;

//    线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    /** 
     * @Description: 获取老师和其他工作人员
     * @Author: 雨同我
     * @DateTime: 2022/10/13 15:43
    */
    @GetMapping("/teacher/{name}")
    public CommonResult getTeacher(@PathVariable String name) throws ExecutionException, InterruptedException {
        name=name.trim();
        String test=name;
        Callable<ScyTeacher> scyTeacher1 =()-> scyTeacherMapper.selectOne(new LambdaQueryWrapper<ScyTeacher>()
                .eq(ScyTeacher::getUsername,test));

        Callable<ScySecurity> scySecurity1 =()-> scySecurityMapper.selectOne(new LambdaQueryWrapper<ScySecurity>()
                .eq(ScySecurity::getUsername,test));

        Callable<ThreeExam> threeExam1 =()-> threeExamMapper.selectOne(new LambdaQueryWrapper<ThreeExam>()
                .eq(ThreeExam::getTeacherOne, test).or().eq(ThreeExam::getTeacherTwo, test));

        Callable<FourExam> fourExam1 =()-> fourExamMapper.selectOne(new LambdaQueryWrapper<FourExam>()
                .eq(FourExam::getTeacherOne, test).or().eq(FourExam::getTeacherTwo, test));

        Callable<SixExam> sixExam1 =()-> sixExamMapper.selectOne(new LambdaQueryWrapper<SixExam>()
                .eq(SixExam::getTeacherOne, test).or().eq(SixExam::getTeacherTwo, test));

        Callable<List<ExamTower>> tower1 =()-> examTowerMapper.listTower(test);

        Future<ScyTeacher> scyTeacher = taskExecutor.submit(scyTeacher1);
        Future<ScySecurity> scySecurity = taskExecutor.submit(scySecurity1);
        Future<ThreeExam> threeExam = taskExecutor.submit(threeExam1);
        Future<FourExam> fourExam = taskExecutor.submit(fourExam1);
        Future<SixExam> sixExam = taskExecutor.submit(sixExam1);
        Future<List<ExamTower>> tower = taskExecutor.submit(tower1);

        TeacherVo result = new TeacherVo();
        result.setName(name);
        if (ObjectUtils.isNotEmpty(scySecurity.get())){
            result.setTraining_place(scySecurity.get().getSeat());
        }
        if (ObjectUtils.isNotEmpty(scyTeacher.get())){
            result.setTraining_place(scyTeacher.get().getSeat());
        }
        if (ObjectUtils.isNotEmpty(threeExam.get())){
            result.setLevel_III_place(threeExam.get().getExamSite());
        }
        if (ObjectUtils.isNotEmpty(fourExam.get())){
            result.setLevel_IV_place(fourExam.get().getExamSite());
        }
        if (ObjectUtils.isNotEmpty(sixExam.get())){
            result.setLevel_VI_place(sixExam.get().getExamSite());
        }
        if (ObjectUtils.isNotEmpty(tower.get())){
            List<String> floor = new ArrayList<>();
            List<String> range = new ArrayList<>();
            tower.get().forEach(o->{
                floor.add(o.getTower()+" "+o.getFloor());
                range.add(o.getRange());
            });
            result.setFlow_place(floor);
            result.setFlow_range(range.get(0));
        }
        return CommonResult.success(result);
    }
}

