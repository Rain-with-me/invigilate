package com.lu.edu;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lu.edu.entity.ExamTower;
import com.lu.edu.entity.ThreeExam;
import com.lu.edu.mapper.ExamTowerMapper;
import com.lu.edu.mapper.ThreeExamMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InvigilateApplicationTests {

    @Autowired
    private ThreeExamMapper threeExamMapper;
    @Autowired
    private ExamTowerMapper examTowerMapper;
    @Test
    public void contextLoads() {
        String name="曾文英";
        ThreeExam threeExam = threeExamMapper.selectOne(new LambdaQueryWrapper<ThreeExam>()
                .eq(ThreeExam::getTeacherOne, name).or().eq(ThreeExam::getTeacherTwo, name));
        System.out.println(threeExam);
    }

    @Test
    public void ok() {
        String name="彭瑞珍";
        List<ExamTower> tower = examTowerMapper.listTower(name);
        System.out.println(tower);
    }

}
