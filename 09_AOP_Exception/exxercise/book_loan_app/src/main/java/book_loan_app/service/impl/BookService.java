package book_loan_app.service.impl;

import book_loan_app.model.Book;
import book_loan_app.repository.IBookRepository;
import book_loan_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book borrowBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book payBook(Book book) {
        return bookRepository.save(book);
    }
}
