package com.vedantu.ordersmicroservice.Controllers;

import com.vedantu.ordersmicroservice.Entities.StockInventory;
import com.vedantu.ordersmicroservice.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    /**
     * API to add new Inventory into stock
     *
     * @param stockInventory List of stock Inventories
     * @return all saved inventories
     */
    @PostMapping("/add")
    private ResponseEntity<?> addNewInventory(@RequestBody List<StockInventory> stockInventory) {

        List<StockInventory> savedInventories = inventoryService.addInventory(stockInventory);

        return new ResponseEntity<>(savedInventories, HttpStatus.OK);
    }


    /**
     * Note : this API is only created assuming inventory db has less data
     * Alternative: APIs has to be created taking filters as parameters in order to fetch only required items
     *
     * API to get all inventory which are in stock
     *
     * @return List of StockInventory
     */
    @GetMapping("/showAll")
    private ResponseEntity<?> showAllStockInventory() {

        List<StockInventory> allStockInventory = inventoryService.getAllStockInventory();
        return new ResponseEntity<>(allStockInventory, HttpStatus.OK);
    }

    /**
     * API to remove/delete from stocked inventory
     * @param stockInventory
     * @return
     */
    @PutMapping("/remove")
    private ResponseEntity<?> removeInventory(@RequestBody List<StockInventory> stockInventory) {

        //TODO : need to be implemeneted
        String msg = "Not Implemented";
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
    }
}