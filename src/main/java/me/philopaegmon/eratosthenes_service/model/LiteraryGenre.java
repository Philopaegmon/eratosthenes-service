package me.philopaegmon.eratosthenes_service.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@NamedQuery(name = "LiteraryGenre.getByIds", query = "from LiteraryGenre lg where lg.id in :ids")
@Entity(name = LiteraryGenre.ENTITY_NAME)
@Table(name = LiteraryGenre.TABLE_NAME)
public class LiteraryGenre {
    public static final String ENTITY_NAME = "LiteraryGenre";
    public static final String TABLE_NAME = "literary_genres";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "literary_genre_generator")
    @SequenceGenerator(name="literary_genre_generator", sequenceName = "literary_genre_seq", allocationSize = 1)
    private Long id;

    @Column(name = "genre_name", nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LiteraryGenre that = (LiteraryGenre) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
