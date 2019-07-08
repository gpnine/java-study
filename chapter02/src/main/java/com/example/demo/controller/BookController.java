package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-22 .
 */
@RestController
@RequestMapping("/book")
public class BookController {
	@GetMapping("/books")
	public ModelAndView books() {
		List<Book> books = new ArrayList<>();
		Book b1 = new Book();
		b1.setId(1);
		b1.setAuthor("罗贯中");
		b1.setName("西游记");
		b1.setPrice(30f);
		Book b2 = new Book();
		b2.setId(2);
		b2.setAuthor("曹雪芹");
		b2.setName("红楼梦");
		books.add(b1);
		books.add(b2);
		ModelAndView mv = new ModelAndView();
		mv.addObject("books", books);
		mv.setViewName("books");
		return mv;
	}

	@GetMapping("/bookInfo")
	public Book bookInfo() {
		Book book = new Book();
		book.setAuthor("罗贯中");
		book.setName("三国演义");
		book.setPrice(30f);
		book.setPublicationDate(new Date());
		return book;
	}

	@GetMapping("/book")
	public String book(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
		return book.toString() + ">>>" + author.toString();
	}

	@PostMapping("/")
	public String addBook(String name) {
		return "receive:" + name;
	}

	@DeleteMapping("/{id}")
	public String deleteBookById(@PathVariable Long id) {
		return String.valueOf(id);
	}
}
