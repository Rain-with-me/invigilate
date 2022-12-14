package com.lu.edu.entity.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: éšćæ
 * @Description:
 * @DateTime: 2022/10/13 15:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto implements Serializable {
    private Integer code;
    private String username;
}
