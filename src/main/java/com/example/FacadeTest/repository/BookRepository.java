package com.example.FacadeTest.repository;

import com.example.FacadeTest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}

