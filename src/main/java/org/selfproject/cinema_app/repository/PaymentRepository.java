package org.selfproject.cinema_app.repository;

import org.selfproject.cinema_app.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}