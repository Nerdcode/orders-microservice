package com.vedantu.ordersmicroservice.Controllers;

import com.vedantu.ordersmicroservice.Entities.StockInventory;
import com.vedantu.ordersmicroservice.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author durgaprasad.kusuma
 */
@RestController
@RequestMapping("/inventory")
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

        //TODO Put a check if fields like mrp, itemname are null before saving
        //TODO check if stockinventory is a empty object

        //save list of stock inventory
        if(stockInventory.size() > 0) {
            List<StockInventory> savedInventories = inventoryService.addInventory(stockInventory);
            return new ResponseEntity<>(savedInventories, HttpStatus.OK);
        } else {
            String msg = "No inventories found to add";
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }

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

    @GetMapping("/show")
    private ResponseEntity<?> showStockInventoryById(@RequestParam String inventoryId) {

        StockInventory stockInventory = inventoryService.getStockInventory(inventoryId);
        if(stockInventory != null) {
            return new ResponseEntity<>(stockInventory, HttpStatus.OK);
        } else {
            String msg = "Inventory not found, Try with valid inventory ID";
            return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * API to remove/delete from stocked inventory
     * @param stockInventory
     * @return
     */
    @PutMapping("/remove")
    private ResponseEntity<?> removeInventory(@RequestBody List<StockInventory> stockInventory) {

        //TODO : need to be implemeneted
        String msg = "Not Implemented, See you soon";
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
    }
}