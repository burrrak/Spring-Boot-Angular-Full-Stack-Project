package com.example.telefonrehberi.service;

import com.example.telefonrehberi.exception.KullaniciBulunamadi;
import com.example.telefonrehberi.model.Kisi;
import com.example.telefonrehberi.repository.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KisiService {
    private final KisiRepository kisiRepository;

    @Autowired
    public KisiService(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

    public Kisi addKisi(Kisi kisi) {
        kisi.setKisiKodu(UUID.randomUUID().toString());
        return kisiRepository.save(kisi);
    }

    public List<Kisi> findAllKisi() {
        return kisiRepository.findAll();
    }

    public Kisi updateKisi(Kisi kisi) {
        return kisiRepository.save(kisi);
    }

    public Kisi findKisiById(Long id) {
        return kisiRepository.findKisiById(id).orElseThrow(() -> new KullaniciBulunamadi("Kullanici" + id + "Bulunamadi"));
    }

   public void deleteKisi(Long id) {
        kisiRepository.deleteKisiById(id);
    }
}
