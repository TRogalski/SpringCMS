package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
