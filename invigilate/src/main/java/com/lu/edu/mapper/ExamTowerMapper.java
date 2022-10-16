package com.lu.edu.mapper;

import com.lu.edu.entity.ExamTower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-10-16
 */
@Repository
public interface ExamTowerMapper extends BaseMapper<ExamTower> {

    List<ExamTower> listTower(String name);
}
