package com.fnh.billing.service;

import com.fnh.billing.models.Bill;
import com.fnh.billing.models.dto.BillDTO;
import com.fnh.billing.models.dto.UserDTO;
import com.fnh.billing.repositories.IBillRepository;
import com.fnh.billing.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

  private final IBillRepository billRepository;
  private final UserRepository userRepository;

  public BillService(IBillRepository billRepository, UserRepository userRepository) {
    this.billRepository = billRepository;
    this.userRepository = userRepository;
  }

  public List<Bill> getAllBill() {
    return billRepository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return billRepository.save(bill);
  }

  public List<Bill> findByCustomer(String customer) {
    return billRepository.findByCustomerBill(customer).orElse(null);
  }

  public BillDTO findBillsByUsername(String username) {
    BillDTO billDTO = new BillDTO();
    List<Bill> bills = getAllBill().stream().filter(b -> b.getCustomerBill().equals(username)).collect(Collectors.toList());
    UserDTO userDTO = userRepository.findByUsername(username);
    if (userDTO != null)
      billDTO.setUser(userDTO);

    billDTO.setBills(bills);
    return billDTO;
  }

}
