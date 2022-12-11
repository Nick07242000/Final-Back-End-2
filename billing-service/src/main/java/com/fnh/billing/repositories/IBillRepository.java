package com.fnh.billing.repositories;

import com.fnh.billing.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBillRepository extends JpaRepository<Bill, String> {

  Optional<List<Bill>> findByCustomerBill(String customer);
}
