package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Inventory;
import com.project.Springboot.tutorial.entity.Pharmacy;
import com.project.Springboot.tutorial.repository.InventoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }


    @Override
    public Inventory updateInventory(Long id, Inventory inventory)
    {
        Inventory InvDb=inventoryRepository.findById(id).get();

        if(Objects.nonNull(inventory.getCategory())&&
                !"".equalsIgnoreCase(inventory.getCategory()))
        {
            InvDb.setCategory(inventory.getCategory());
        }
        if(Objects.nonNull(inventory.getName())&&
                !"".equalsIgnoreCase(inventory.getName()))
        {
            InvDb.setName(inventory.getName());
        }
        if(Objects.nonNull(inventory.getSupplier())&&
                !"".equalsIgnoreCase(inventory.getSupplier())){
            InvDb.setSupplier(inventory.getSupplier());
        }
        if(Objects.nonNull(inventory.getPrice()))
        {
            InvDb.setPrice(inventory.getPrice());
        }
        if(Objects.nonNull(inventory.getQuantity()))
        {
            InvDb.setQuantity(inventory.getQuantity());
        }
        return  inventoryRepository.save(InvDb);
    }


    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
