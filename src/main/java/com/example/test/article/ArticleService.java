package com.example.test.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getAll() {
        return this.articleRepository.findAll();
    }

    public Article create(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
        return article;
    }

    public Article getArticle(Integer id) {
        Article article = this.articleRepository.getById(id);
        return article;
    }
}
