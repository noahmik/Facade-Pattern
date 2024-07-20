package com.example.FacadeTest.service;

import com.example.FacadeTest.domain.Book;
import com.example.FacadeTest.domain.Member;
import com.example.FacadeTest.repository.BookRepository;
import com.example.FacadeTest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LibraryService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public Book addBook(String title) {
        Book book = new Book(title);
        return bookRepository.save(book);
    }

    public Member addMember(String name) {
        Member member = new Member(name);
        return memberRepository.save(member);
    }

    public String borrowBook(Long bookId, Long memberId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (book.isPresent() && member.isPresent()) {
            return member.get().getName() + "가 " + book.get().getTitle()+"를 빌림";
        } else {
            return "책이나 사람을 찾을 수 없음 !";
        }
    }

    public String returnBook(Long bookId, Long memberId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (book.isPresent() && member.isPresent()) {
            return member.get().getName() + "가 " + book.get().getTitle()+"를 반환함";
        } else {
            return "책이나 사람을 찾을 수 없음 !";
        }
    }
}
