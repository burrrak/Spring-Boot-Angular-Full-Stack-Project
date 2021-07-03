package com.example.telefonrehberi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Kisi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String adi;
    private String soyadi;
    private String email;
    private String meslek;
    private String telefon;
    @Column(nullable = false,updatable = false)
    private String kisiKodu;


    public Kisi(String adi, String soyadi, String email, String meslek, String telefon, String kisiKodu) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.email = email;
        this.meslek = meslek;
        this.telefon = telefon;
        this.kisiKodu = kisiKodu;
    }

    public Kisi() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getKisiKodu() { return kisiKodu; }

    public void setKisiKodu(String kisiKodu) { this.kisiKodu = kisiKodu;
    }


}
