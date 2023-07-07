package com.project.Springboot.tutorial.controller;

import com.project.Springboot.tutorial.entity.Inventory;
import com.project.Springboot.tutorial.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }

    @PutMapping("/inventory/{id}")
    public Inventory updateInventory(@PathVariable("id") Long id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id,inventory);
    }


    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return "Deleted";
    }
}
