package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ：ltb
 * @date ：2020/7/21
 */
@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    //查询全部的书籍并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String bookList(Model model) {
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list", books);
        return "allBook";

    }
}
