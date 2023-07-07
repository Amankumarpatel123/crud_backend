package com.project.Springboot.tutorial.controller;

import com.project.Springboot.tutorial.entity.Billing;
import com.project.Springboot.tutorial.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {
    private  final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }
    @GetMapping
    public List<Billing> getAllBilling() {
        return billingService.getAllBilling();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable("id") Long id) {
        Billing billing = billingService.getBillingById(id);
        if (billing != null) {
            return ResponseEntity.ok(billing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        Billing createdBilling = billingService.addBilling(billing);
        return ResponseEntity.ok(createdBilling);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable("id") Long id, @RequestBody Billing billing) {
        Billing updatedBilling = billingService.updateBilling(id, billing);
        if (updatedBilling != null) {
            return ResponseEntity.ok(updatedBilling);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBilling(@PathVariable("id") Long id) {
        boolean deleted = billingService.deleteBilling(id);
        if (deleted) {
            return ResponseEntity.ok("deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
