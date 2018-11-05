package id.tokoonderdil.study.springmysql.controller;

import id.tokoonderdil.study.springmysql.exception.ResourceNotFoundException;
import id.tokoonderdil.study.springmysql.model.Article;
import id.tokoonderdil.study.springmysql.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/article")
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @PostMapping("/article")
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }

    @GetMapping("/article/{id}")
    public Article getArticleById(@PathVariable(value = "id") Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", articleId));
    }

    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable(value = "id") Long articleId, @Valid @RequestBody Article articleDetails) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", articleId));
        article.setTitle(articleDetails.getTitle());
        article.setCategory(articleDetails.getCategory());

        Article updateArticle = articleRepository.save(article);
        return updateArticle;
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", articleId));

        articleRepository.delete(article);

        return ResponseEntity.ok().build();
    }
}
