package com.example.telefonrehberi.resource;


import com.example.telefonrehberi.model.Kisi;
import com.example.telefonrehberi.service.KisiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/kisi")
public class KisiResource {
    private final KisiService kisiService;

    public KisiResource(KisiService kisiService) {
        this.kisiService = kisiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Kisi>> getAllKisi () {
        List<Kisi> kisis = kisiService.findAllKisi();
        return new ResponseEntity<>(kisis, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Kisi> getKisiById (@PathVariable("id") Long id) {
        Kisi kisi = kisiService.findKisiById(id);
        return new ResponseEntity<>(kisi, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Kisi> addKisi(@RequestBody Kisi kisi) {
        Kisi newKisi = kisiService.addKisi(kisi);
        return new ResponseEntity<>(newKisi, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Kisi> updateKisi(@RequestBody Kisi kisi) {
        Kisi updateKisi = kisiService.updateKisi(kisi);
        return new ResponseEntity<>(updateKisi, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKisi (@PathVariable("id") Long id) {
        kisiService.deleteKisi(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


