package com.apihack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ClientId;
    @Column
    private String ConsentId;
    @Column
    @Enumerated(value = EnumType.STRING)
    private ConsentType type;
    public Consent(String clientId, String consentId, ConsentType type) {
        this.ClientId = clientId;
        this.ConsentId = consentId;
        this.type = type;
    }
}
