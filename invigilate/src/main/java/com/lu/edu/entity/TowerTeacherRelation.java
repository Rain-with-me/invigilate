package com.lu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @ApiModel(value="TowerTeacherRelation对象", description="")
public class TowerTeacherRelation implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long teacherId;

    private Long towerId;


}
