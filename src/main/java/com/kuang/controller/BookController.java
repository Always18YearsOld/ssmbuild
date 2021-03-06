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


    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "toAddBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "toUpdateBook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println(books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }


    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> books = bookService.queryBookByName(queryBookName);
        model.addAttribute("bookList",books);
        return "selectedBooks";
    }
}
