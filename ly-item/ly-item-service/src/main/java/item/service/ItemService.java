package item.service;

import com.leyou.item.pojo.Item;

import java.util.Random;

public class ItemService {
    public Item SaveItem(Item item){
        int id = new Random().nextInt(100);
        item.setId(id);
        return item;
    }
}
