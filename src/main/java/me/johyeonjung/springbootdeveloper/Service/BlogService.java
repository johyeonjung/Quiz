package me.johyeonjung.springbootdeveloper.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.johyeonjung.springbootdeveloper.domain.Article;
import me.johyeonjung.springbootdeveloper.dto.AddArticleRequest;
import me.johyeonjung.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
//final이 붙거나 notnull이 붙은 필드의 생성자 추가
@Service

public class BlogService {

    private final BlogRepository quizRepository;


    //addArticleRequest 클래스에 저장된 값들을 article 데이터베이스에 저장
    public Article save(AddArticleRequest request) {
        return quizRepository.save(request.toEntity());
    }

    //데이터베이스에 저장되어 있는 글을 모두 가져옴
    public List<Article> findAll() {
        return quizRepository.findAll();
    }

    //글 하나를 조회하는 api
    public Article findById(long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:" + id) );

    }

    public void delete(long id) {
        quizRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, AddArticleRequest request) {
        Article article = quizRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:" + id) );

        article.update(request.getTitle(), request.getContent());

        return article;
    }




}
