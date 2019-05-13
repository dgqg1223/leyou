package item.web;

import com.leyou.item.pojo.Item;
import item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemContorller {

    @Autowired
    private ItemService itemService;


    @PostMapping
    public ResponseEntity<Item> saveItem(Item item) {
        if (item.getName()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        item = itemService.SaveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
