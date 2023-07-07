package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Billing;
import com.project.Springboot.tutorial.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService{
    private  final BillingRepository billingRepository;

    @Autowired
    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }


    @Override
    public List<Billing> getAllBilling() {
        return billingRepository.findAll();
    }

    @Override
    public Billing getBillingById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    @Override
    public Billing addBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    @Override
    public Billing updateBilling(Long id, Billing billing) {
        Billing existingBilling = billingRepository.findById(id).orElse(null);
        if (existingBilling != null) {
            existingBilling.setDate(billing.getDate());
            existingBilling.setAmount(billing.getAmount());
            existingBilling.setTreatment_descrption(billing.getTreatment_descrption());
            existingBilling.setPatient_id(billing.getPatient_id());

            return billingRepository.save(existingBilling);
        }
        return null;
    }

    @Override
    public boolean deleteBilling(Long id) {
        if (billingRepository.existsById(id)) {
            billingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
