package com.library.management.system.repositories;

import com.library.management.system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(name = "SELECT B.ID FROM BOOk B WHERE B.STATUS: =  A", nativeQuery = true)
    public Integer findBookIdByBookStatus();
    @Query(name = "SELECT B.ID FROM BOOk B WHERE B.STATUS: =  A", nativeQuery = true)
    public List<Integer> findBookIdsByBookStatus();
}
