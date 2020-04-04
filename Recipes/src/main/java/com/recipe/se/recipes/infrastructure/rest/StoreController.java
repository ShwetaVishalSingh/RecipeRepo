package com.recipe.se.recipes.infrastructure.rest;

import com.recipe.se.recipes.service.StoreService;
import com.recipe.se.recipes.infrastructure.store.Store;
import com.recipe.se.recipes.infrastructure.store.StorePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store/")
public class StoreController {
    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(value = "addStores")
    public ResponseEntity addStore(@RequestBody StorePayload storePayload) {
        {
            storeService.addStore(storePayload);
            return ResponseEntity.ok().body("Store has been added");
        }


    }
    @GetMapping
    public ResponseEntity fetchAllStores()
    { List<Store> storesList;
         storesList = storeService.fetchAllStores();
        return ResponseEntity.ok(storesList);

    }
    @DeleteMapping(value="{storeId}")
    public ResponseEntity deleteStoreById(@PathVariable  String storeId)
    {
        storeService.deleteStoreById(storeId);
        return ResponseEntity.ok().body("Store has been deleted");
    }

    @PostMapping(value ="{storeId}")
    public ResponseEntity updateStoreById(@PathVariable String storeId, @RequestBody  StorePayload  storePayload ){
        storeService.updateStoreById(storeId,storePayload);
        return ResponseEntity.ok().body("");
    }
}
