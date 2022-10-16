package com.lu.edu.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/10/13 15:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherVo implements Serializable {
    private String  name;
    private String  training_place;//培训地点
    private String  level_III_place;//三级地点
    private String  level_IV_place;//四级地点
    private String  level_VI_place;//六级地点
    private List<String>  flow_place;//流动监考地点
    private String flow_range;//流动监考范围
}
