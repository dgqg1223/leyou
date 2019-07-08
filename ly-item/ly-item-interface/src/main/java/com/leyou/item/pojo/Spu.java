package com.leyou.item.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "tb_spu")
public class Spu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private Long cid1;// 1级类目
    private Long cid2;// 2级类目
    private Long cid3;// 3级类目
    private String title;// 标题
    private String subTitle;// 子标题
    private Boolean saleable;// 是否上架

    //@JsonIgnore 表示当返回页面时候忽略此字段
    @JsonIgnore
    private Boolean valid;// 是否有效，逻辑删除用
    private Date createTime;// 创建时间
    @JsonIgnore
    private Date lastUpdateTime;// 最后修改时间

    //在正式开发中应建立SpuVO对象 用于业务层之间的数据传递而不是在持久层的POJO对象中 此时我们为了便捷 加入到Spu POJO对象中
    //@Transient 使用是让通用Mapper不识别为表中的字段，在操作表时忽略(声明该字段与数据库无关)
    @Transient
    private String cname;
    @Transient
    private String bname;

    @Transient
    private List<Sku> skus;

    @Transient
    private SpuDetail spuDetail;
}