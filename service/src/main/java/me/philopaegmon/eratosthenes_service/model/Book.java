package me.philopaegmon.eratosthenes_service.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity(name = Book.ENTITY_NAME)
@Table(name = Book.TABLE_NAME)
public class Book {
    public static final String ENTITY_NAME = "Book";
    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name="book_generator", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    @Column(name = "book_name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "book_author",
         joinColumns = { 
            @JoinColumn(name = "book_id") 
        }, 
        inverseJoinColumns = {
            @JoinColumn(name = "author_id") 
        }
    )
    @ToString.Exclude
    Set<Author> authors;

    @ManyToMany
    @JoinTable(
        name = "book_genre",
         joinColumns = { 
            @JoinColumn(name = "book_id") 
        }, 
        inverseJoinColumns = {
            @JoinColumn(name = "genre_id") 
        }
    )
    @ToString.Exclude
    Set<LiteraryGenre> genres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    @ToString.Exclude
    private Language language;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book that = (Book) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
