package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllInventories();

    Inventory saveInventory(Inventory inventory);

    Inventory updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);
}
