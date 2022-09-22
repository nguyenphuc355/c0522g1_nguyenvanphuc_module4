package book_loan_app.service;

import book_loan_app.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findById(int id);


    Book bookBorrow(Book bookManager) throws Exception;

    Book bookPay(Book bookManager);
}
