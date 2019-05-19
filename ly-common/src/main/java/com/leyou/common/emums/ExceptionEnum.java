package com.leyou.common.emums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NOLL(400,"价格不能为空"),
    CATEGORY_NOT_FOND(404,"商品分类没有查到"),
    ;
//    private static final ExceptionEnum ff = new ExceptionEnum(1,"");
    private int code;
    private String msg;
}
