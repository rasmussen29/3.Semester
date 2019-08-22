/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        BookFacade facade = BookFacade.getBookFacade(emf);
        
        facade.addBook("Learn JavaScript Part 1");
        facade.addBook("Learn JavaScript Part 2");
        facade.addBook("Learn JavaScript Part 3");
        
        List<Book> books = facade.getAllBooks();
        for(Book b : books){
            System.out.println("Book: " + b.toString());
        }
        
        
    }
}
