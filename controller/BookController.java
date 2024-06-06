package cts.pepsico.Microservice_demo_GET.controller;

import cts.pepsico.Microservice_demo_GET.model.Book; //Imports Book entity class
import cts.pepsico.Microservice_demo_GET.repository.BookRepo; //I BookRepo repository interface
import org.springframework.beans.factory.annotation.Autowired; //for dependency injection
import org.springframework.http.HttpStatus; //for response handling
import org.springframework.http.ResponseEntity; //for constructing responses
import org.springframework.web.bind.annotation.*; //for request mapping

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; //for handling null values

@RestController //combines Controller & ResponseBody (JSON instead of HTML web page)
public class BookController {

    @Autowired //injects the BookRepo dependency, allowing the controller to interact with repository
    private BookRepo bookRepo;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        try{
            List<Book> bookList = new ArrayList<>(); //creates empty list of Book objects
            bookRepo.findAll().forEach(bookList::add); //iterates over each Book object and adds to the list

            if (bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //ensures request was successful, but no content
            }
            return new ResponseEntity<>(bookList, HttpStatus.OK);

        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable Long id) {

        Optional<Book> bookData =  bookRepo.findById(id); //avoid NullPointerException

        if (bookData.isPresent()) {
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) { //maps the request body to the Book object
        Book bookObj = bookRepo.save(book);

        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }

    @PostMapping("/updateBookById/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBookData){
        Optional<Book> oldBookData = bookRepo.findById(id);

        if (oldBookData.isPresent()) {
            Book updatedBookData = oldBookData.get();
            updatedBookData.setTitle(newBookData.getTitle());
            updatedBookData.setAuthor(newBookData.getAuthor());

            Book bookObj = bookRepo.save(updatedBookData);
            return new ResponseEntity<>(bookObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id){

        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
