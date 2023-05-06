package org.example.inheritance.table_per_class;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="legal_entity")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="amount", column=@Column(name="amount"))
})
public class LegalEntity extends Customer {

    @Column(name="register_number")
    private int registerNumber;

    public int getRegisterNumber() {
        return registerNumber;
    }

    public LegalEntity() {
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

}
