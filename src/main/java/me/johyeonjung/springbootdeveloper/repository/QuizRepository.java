package me.johyeonjung.springbootdeveloper.repository;

import me.johyeonjung.springbootdeveloper.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
   List<Quiz> findByCategoryId(Long categoryId);
}
