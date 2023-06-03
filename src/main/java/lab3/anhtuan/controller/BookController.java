package lab3.anhtuan.controller;

import jakarta.validation.Valid;
import lab3.anhtuan.entity.Book;
import lab3.anhtuan.services.BookServices;
import lab3.anhtuan.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServices bookService;

    @Autowired
    private CategoryServices categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books    = bookService.getALlBooks();
        model.addAttribute("books",books);
        return "Book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "Book/add";
    }

    @PostMapping("/add")
    public  String addBook(@ModelAttribute("book") Book book,BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAllCategories());
            return "books/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book editBook = bookService.getBookById(id);
        if (editBook != null) {
            model.addAttribute("book", editBook);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook) {
        bookService.updateBook(updatedBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public  String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
