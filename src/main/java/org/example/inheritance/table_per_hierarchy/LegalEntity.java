package org.example.inheritance.table_per_hierarchy;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("legal_entity")
public class LegalEntity extends Customer {

    @Column(name="register_number")
    private int registerNumber;

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public LegalEntity() {
    }
}
