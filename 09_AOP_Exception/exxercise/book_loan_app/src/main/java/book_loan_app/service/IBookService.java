package book_loan_app.service;

import book_loan_app.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findById(int id);


    Book borrowBook(Book bookManager) throws Exception;

    Book payBook(Book bookManager);
}
