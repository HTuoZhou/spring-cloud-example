package com.ywstz.cloud.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 提供表
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("provider")
public class Provider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 消费表主键
     */
    @TableField("consumer_id")
    private Long consumerId;

    /**
     * 数量
     */
    @TableField("count")
    private Integer count;

    /**
     * 版本号
     */
    @TableField("version")
    @Version
    private Integer version;

    /**
     * 开始时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 结束时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除(1、逻辑已删除 0、逻辑未删除)
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
