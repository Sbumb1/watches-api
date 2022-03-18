package com.watches.watches.repository;

import com.watches.watches.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchRepository extends JpaRepository<Watch, Long> {

    @Override
    void deleteById(Long id);

    List<Watch> findAll();

    Optional<Watch> findById(Long id);
}
