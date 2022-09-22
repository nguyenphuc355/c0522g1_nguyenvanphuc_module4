package book_loan_app.controller;

import book_loan_app.model.Book;
import book_loan_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("borrow/{id}")
    public String showBookBorrow(@PathVariable int id, Model model) {
        model.addAttribute("bookList", bookService.findById(id));
        return "borrowList";
    }

    @PostMapping("/borrowBook")
    public String borrowBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) throws Exception {
        book.setCount(book.getCount() - 1);
        if (book.getCount() < 0) {
            throw new Exception();
        }
        bookService.borrowBook(book);
        redirectAttributes.addFlashAttribute("mess", "mượn sách thành công");
        return "redirect:/";
    }

    @GetMapping("/payBook/{id}")
    public String payBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws Exception {
        Book book = bookService.findById(id);
        book.setCount(book.getCount() + 1);
        if (book.getCount()>book.getTotal()){
            throw new Exception();
        }
        bookService.payBook(book);
        redirectAttributes.addFlashAttribute("message", "trả sách thành công");
        return "redirect:/";
    }
}
