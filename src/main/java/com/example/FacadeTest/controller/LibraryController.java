package com.example.FacadeTest.controller;

import com.example.FacadeTest.domain.Book;
import com.example.FacadeTest.domain.Member;
import com.example.FacadeTest.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/books")
    public Book addBook(@RequestParam String title) {
        return libraryService.addBook(title);
    }

    @PostMapping("/members")
    public Member addMember(@RequestParam String name) {
        return libraryService.addMember(name);
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        return libraryService.borrowBook(bookId, memberId);
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        return libraryService.returnBook(bookId, memberId);
    }
}
