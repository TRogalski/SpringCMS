package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Article entity) {
        entityManager.persist(entity);
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article entity) {
        entityManager.merge(entity);
    }

    public void remove(Article entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Article> findAll() {
        Query query = entityManager.createQuery("SELECT A FROM Article A WHERE A.draft=FALSE");
        List<Article> articles = query.getResultList();
        return articles;
    }

    public List<Article> findLastFiveArticles() {
        Query query = entityManager.createQuery("SELECT A FROM Article A WHERE A.draft=FALSE ORDER BY A.created");
        return query.setMaxResults(5).getResultList();
    }

    public List<Article> findDrafts(){
        Query query = entityManager.createQuery("SELECT A FROM Article A WHERE A.draft=TRUE");
        return query.getResultList();
    }
}

