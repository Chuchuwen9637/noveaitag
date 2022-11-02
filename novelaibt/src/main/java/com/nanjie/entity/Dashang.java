package com.nanjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2022-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dashang")
public class Dashang implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String momey;

    private String thinklanger;


}
