package com.example.entities;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private FinancialAdvisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    public Client() {}

    public Client(String name, String email, String phoneNumber, FinancialAdvisor advisor) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.advisor = advisor;
    }

    public Long getClientId() { return clientId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public Portfolio getPortfolio() { return portfolio; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
