package com.elghallali.ebook.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.elghallali.ebook.model.Book;
import com.elghallali.ebook.model.CartItem;
import com.elghallali.ebook.model.ShoppingCart;
import com.elghallali.ebook.model.User;
import com.elghallali.ebook.service.BookService;
import com.elghallali.ebook.service.CartItemService;
import com.elghallali.ebook.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;
    @Autowired
    private CartItemService cartItemService;

    @GetMapping(value = "/book/add")
    public String addBook(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("user", user);
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("classActiveBookManager", true);
        model.addAttribute("classActiveAddNewBook", true);
        return "admin/addBook";
    }

    @PostMapping(value = "/book/add")
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        try {
            byte[] bytes = bookImage.getBytes();
            String name = "book_" + book.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:bookList";
    }

    @RequestMapping("/book/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("user", user);
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        model.addAttribute("classActiveBookManager", true);

        return "admin/bookInfo";
    }

    @RequestMapping("/book/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("user", user);
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        model.addAttribute("classActiveBookManager", true);

        return "admin/updateBook";
    }

    @PostMapping(value = "/book/updateBook")
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        if (!bookImage.isEmpty()) {
            try {
                byte[] bytes = bookImage.getBytes();
                String name = "book_" + book.getId() + ".png";

                Files.delete(Paths.get("src/main/resources/static/image/book/" + name));

                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/book/bookInfo?id=" + book.getId();
    }

    @RequestMapping("/book/bookList")
    public String bookList(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("user", user);
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        model.addAttribute("classActiveBookManager", true);
        model.addAttribute("classActiveBookList", true);
        return "admin/bookList";

    }

    @PostMapping(value = "/book/remove")
    public String remove(@ModelAttribute("id") String id, Model model) {
        bookService.removeOne(Long.parseLong(id.substring(8)));
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);

        return "redirect:/admin/book/bookList";
    }
}
