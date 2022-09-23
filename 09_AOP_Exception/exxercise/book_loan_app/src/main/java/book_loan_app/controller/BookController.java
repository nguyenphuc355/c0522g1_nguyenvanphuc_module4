package book_loan_app.controller;

import book_loan_app.model.Book;
import book_loan_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {


    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrow(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));

        return "/borrowList";
    }

    @PostMapping("/saveBorrow")
    public String saveBorrowBook(Book book, RedirectAttributes redirectAttributes) throws Exception {
        bookService.borrowBook(book);
        if (book.getCount()<0){
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("mess", "Borrowing books successfully !!!");
        return "redirect:/";
    }


    @GetMapping("/savePay")
    public String savePayBook(Book book, RedirectAttributes redirectAttributes) throws Exception {
        bookService.payBook(book);
        if (book.getCount()>book.getTotal()){
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("message", "Returned the book !!!");
        return "redirect:/";
    }
}
