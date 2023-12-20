package demoJPA;

import config.Springconfig;
import entity.BookEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.time.LocalDate;

public class MainTest {
 static ApplicationContext context = new AnnotationConfigApplicationContext(Springconfig.class);
 static BookRepository bookRepository =(BookRepository) context.getBean("bookRepository");

 private static  void createNewBook(){
     BookEntity bookEntity = new BookEntity();
     bookEntity.setName("Java");
     bookEntity.setAuthur("Thuan");
     bookEntity.setCategory("IT books");
     bookEntity.setIsbn("ISNDĐ12133");
     bookEntity.setNumberOfPage(342);
     bookEntity.setPrice(20.5);
     bookEntity.setPublishDate(LocalDate.parse("2023-09-21"));

     BookEntity result = bookRepository.save(bookEntity);
     if(result!= null){
         System.out.println("Book thêm thành công, bookID="+bookEntity.getId());
     }
 }

    public static void main(String[] args) {
      createNewBook();
    }
}
