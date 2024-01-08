package com.sampleapp.customer;

import com.sampleapp.clients.fraud.FraudCheckResponse;
import com.sampleapp.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
