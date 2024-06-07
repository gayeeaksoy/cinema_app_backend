package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.model.PaymentEntity;
import org.selfproject.cinema_app.repository.PaymentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping("/api/payment")
    public ResponseEntity<PaymentEntity> postPayment(@RequestBody PaymentEntity paymentEntity) {
        return new ResponseEntity<>(paymentRepository.save(paymentEntity), HttpStatus.CREATED);
    }
}
