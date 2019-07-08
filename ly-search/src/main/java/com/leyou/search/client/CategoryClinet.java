package com.leyou.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("item-service")
public interface CategoryClinet extends CategoryApi {

}
