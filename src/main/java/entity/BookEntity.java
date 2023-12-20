package entity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "name")
    private String name;
    @Column(name = "authur")
    private String authur;
    @Column(name="category")
    private String category;
    @Column(name = "isbn")
    private String isbn;
    @Column(name ="price")
    private double price;
    @Column(name = "numberPage")
    private int numberOfPage;
    @Column(name = "publishDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

    public BookEntity(){

    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authur='" + authur + '\'' +
                ", category='" + category + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", numberOfPage=" + numberOfPage +
                ", publishDate=" + publishDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthur() {
        return authur;
    }

    public void setAuthur(String authur) {
        this.authur = authur;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
