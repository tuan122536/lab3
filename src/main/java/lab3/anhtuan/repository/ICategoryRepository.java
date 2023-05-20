package lab3.anhtuan.repository;

import lab3.anhtuan.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
