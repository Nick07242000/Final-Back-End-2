package com.fnh.billing.controller;

import com.fnh.billing.models.Bill;
import com.fnh.billing.models.dto.BillDTO;
import com.fnh.billing.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

  private final BillService service;

  @GetMapping("/all")
  public ResponseEntity<List<Bill>> getAll() {
    return ResponseEntity.ok().body(service.getAllBill());
  }

  @PostMapping()
  @PreAuthorize(("hasAuthority('SCOPE_facturacion:gestion') AND hasRole('ROLE_PROVIDER')"))
  public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
    return ResponseEntity.ok().body(service.saveBill(bill));
  }

  @GetMapping("/findBy")
  public ResponseEntity<List<Bill>> findByCustomer(@RequestParam String customer) {
    List<Bill> bills = service.findByCustomer(customer);
    if (bills.size() != 0) {
      return ResponseEntity.ok().body(bills);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/detail/{username}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
  public ResponseEntity<BillDTO> findBillsByUsername(@PathVariable String username) {
    return ResponseEntity.ok().body(service.findBillsByUsername(username));
  }

}
