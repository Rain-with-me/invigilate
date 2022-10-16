package com.lu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-10-16
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="SixExam对象", description="")
public class SixExam implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "监考老师1号")
      private String teacherOne;

      @ApiModelProperty(value = "监考老师2号")
      private String teacherTwo;

      @ApiModelProperty(value = "考试地点")
      private String examSite;

      @TableField(fill = FieldFill.INSERT)
      private Date gmtCreate;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date gmtModified;


}
