package com.github.jowiees.CafeteriaEPSEVG.entity.client;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "client_type")
public abstract class Client {
    @Id
    @GeneratedValue
    private Integer memberId;

    public Client() {
    }

    public Client(String client_type) {
    }

    public Integer getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(memberId, client.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    @Override
    public String toString() {
        return "Client{" +
                "member_id=" + memberId +
                '}';
    }
}
