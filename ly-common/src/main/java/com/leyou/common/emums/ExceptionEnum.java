package com.leyou.common.emums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NOLL(400,"价格不能为空")
    ;
//    private static final ExceptionEnum ff = new ExceptionEnum(1,"");
    private int code;
    private String msg;

}
