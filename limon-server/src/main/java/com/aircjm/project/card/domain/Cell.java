package com.aircjm.project.card.domain;


import com.aircjm.common.vo.DbBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author aircjm
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "细胞 最小单元 卡片")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "cell_card")
public class Cell extends DbBaseEntity<Cell> {

    @TableId(type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "细胞标题")
    private String cellTitle;

    @ApiModelProperty(value = "细胞内容类型，支持html，markdown")
    private String descType;

    private String cellDesc;

    private String descHtml;

    private Integer status;
}
