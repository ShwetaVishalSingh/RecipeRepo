package com.recipe.se.recipes.infrastructure.rest;

import com.recipe.se.recipes.application.SellerService;
import com.recipe.se.recipes.infrastructure.seller.SellerDetails;
import com.recipe.se.recipes.infrastructure.seller.SellerModel;
import com.recipe.se.recipes.infrastructure.seller.SellerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller/")
public class SellerController {
    private SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping(value = "addSeller")
    public ResponseEntity addSeller(@RequestBody SellerDetails sellerDetails) {
        {
            sellerService.addSeller(sellerDetails);
            return ResponseEntity.ok().body("Seller has been added");
        }


    }

    @GetMapping
    public ResponseEntity<SellerResponse> fetchAllSeller() {
        SellerResponse response = new SellerResponse();
        List<SellerModel> sellers = sellerService.fetchAllSeller();
        response.setSellers(sellers);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping(value = "{sellerId}")
    public ResponseEntity deleteSellerById(@PathVariable String sellerId) {
        sellerService.deleteSellerById(sellerId);
        return ResponseEntity.ok().body("Seller has been deleted");
    }

    @PostMapping(value = "{sellerId}")
    public ResponseEntity updateSellerById(@PathVariable String sellerId, @RequestBody SellerDetails sellerDetails) {
        sellerService.updateSellerById(sellerId, sellerDetails);
        return ResponseEntity.ok().body("Seller has been updated");
    }
}
