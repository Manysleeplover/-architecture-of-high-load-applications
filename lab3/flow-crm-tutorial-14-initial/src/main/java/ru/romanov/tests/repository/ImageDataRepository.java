package ru.romanov.tests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanov.tests.entity.ImageData;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String name);
}