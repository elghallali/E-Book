package com.elghallali.ebook.controller;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/searchByCategory")
    public String searchByCategory(@RequestParam("category") String category, Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            ShoppingCart shoppingCart = user.getShoppingCart();
            List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
            model.addAttribute("cartItemList", cartItemList);
            model.addAttribute("user", user);
        }

        String classActiveCategory = "active" + category;
        classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
        classActiveCategory = classActiveCategory.replaceAll("&", "");
        model.addAttribute(classActiveCategory, true);

        List<Book> bookList = bookService.findByCategory(category);

        if (bookList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "bookshelf";
        }

        model.addAttribute("bookList", bookList);

        return "bookshelf";
    }

    @RequestMapping("/searchBook")
    public String searchBook(@ModelAttribute("keyword") String keyword, Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            ShoppingCart shoppingCart = user.getShoppingCart();
            List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
            model.addAttribute("cartItemList", cartItemList);
            model.addAttribute("user", user);
        }

        List<Book> bookList = bookService.blurrySearch(keyword);

        if (bookList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "bookshelf";
        }

        model.addAttribute("bookList", bookList);

        return "bookshelf";
    }

}
