package me.johyeonjung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;

import me.johyeonjung.springbootdeveloper.Service.BlogService;
import me.johyeonjung.springbootdeveloper.domain.Article;
import me.johyeonjung.springbootdeveloper.dto.AddArticleRequest;
import me.johyeonjung.springbootdeveloper.dto.ArticleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //전체글을 조호히한뒤 반환하는 메서드
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        //요청이 오면 글 전체를 조회하는 finall 메서드를 호출
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                //응답용 객체인 ArticleResponse로 파싱에 바디에 담아 클라이언트에게 전송
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }


    @GetMapping("/api/articles/{id}")
                //url 값을 가져오는 애너테이션
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody AddArticleRequest request) {

        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }

}

