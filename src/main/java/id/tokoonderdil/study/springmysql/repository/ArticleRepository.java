package id.tokoonderdil.study.springmysql.repository;

import id.tokoonderdil.study.springmysql.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Annotation to tell Spring
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
