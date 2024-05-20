package com.library.management.system.repositories;

import com.library.management.system.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PatronRepository extends JpaRepository<Patron, Integer> {
}
