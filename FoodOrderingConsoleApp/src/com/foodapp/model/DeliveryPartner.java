package com.foodapp.model;

public class DeliveryPartner extends User {
    private String phone;
    private DeliveryPartnerStatus status;

    public DeliveryPartner(int id, String name, String email, String password, String phone) {
        super(id, name, email, password, UserType.DELIVERY_PARTNER);
        this.phone = phone;
        this.status = DeliveryPartnerStatus.INACTIVE;
    }

    public void setStatus(DeliveryPartnerStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DeliveryPartnerStatus getStatus() {
        return status;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public UserType getRole() {
        return super.getRole();
    }

    @Override
    public String toString() {
        return String.format(
                "+----+----------------+----------------------+\n" +
                        "| ID | Name           | Email                |\n" +
                        "+----+----------------+----------------------+\n" +
                        "| %-2d | %-14s | %-20s |\n" +
                        "+----+----------------+----------------------+",
                id, name, email
        );
    }
}