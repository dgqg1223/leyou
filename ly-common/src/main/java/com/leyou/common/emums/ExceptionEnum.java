package com.leyou.common.emums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOND(404,"商品分类没有查到"),
    BRAND_BOT_FOUND(404,"品牌不存在"),
    BRAND_SAVE_ERROD(500,"新增品牌失败"),
    UPLOAD_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(400,"无效的文件类型"),
    ;
//    private static final ExceptionEnum ff = new ExceptionEnum(1,"");
    private int code;
    private String msg;
}
