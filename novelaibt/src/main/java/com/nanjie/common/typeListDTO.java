package com.nanjie.common;

import com.nanjie.entity.Typelist;
import lombok.Data;

import java.util.List;

@Data
public class typeListDTO {
    private String typename;
    private List<Typelist> list;
    private int page;//当前页
}
