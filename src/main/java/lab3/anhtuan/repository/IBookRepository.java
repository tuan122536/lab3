package lab3.anhtuan.repository;

import lab3.anhtuan.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
