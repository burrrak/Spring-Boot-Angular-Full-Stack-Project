package com.example.telefonrehberi.repository;

import com.example.telefonrehberi.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface KisiRepository extends JpaRepository<Kisi, Long> {
    void deleteKisiById(Long id);

    Optional<Kisi> findKisiById(Long id);
}
