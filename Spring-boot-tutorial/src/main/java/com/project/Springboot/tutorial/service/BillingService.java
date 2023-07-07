package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Billing;

import java.util.List;

public interface BillingService {
    List<Billing> getAllBilling();

    Billing getBillingById(Long id);

    Billing addBilling(Billing billing);

    Billing updateBilling(Long id, Billing billing);

    boolean deleteBilling(Long id);
}
