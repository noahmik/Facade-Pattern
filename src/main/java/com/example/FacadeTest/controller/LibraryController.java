package com.example.FacadeTest.controller;

import com.example.FacadeTest.domain.Book;
import com.example.FacadeTest.domain.Member;
import com.example.FacadeTest.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> addBook(@RequestParam String title) {
        Book book = libraryService.addBook(title);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/members")
    public ResponseEntity<Member> addMember(@RequestParam String name) {
        Member member = libraryService.addMember(name);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        String message = libraryService.borrowBook(bookId, memberId);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        String message = libraryService.returnBook(bookId, memberId);
        return ResponseEntity.ok(message);
    }
}
