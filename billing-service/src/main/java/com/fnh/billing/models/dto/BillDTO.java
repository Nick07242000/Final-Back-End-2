package com.fnh.billing.models.dto;

import com.fnh.billing.models.Bill;

import java.util.List;

public class BillDTO {

    private UserDTO user;
    private List<Bill> bills;

    public BillDTO() {
    }

    public BillDTO(UserDTO user, List<Bill> bills) {
        this.user = user;
        this.bills = bills;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

}
