package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.List;
import java.util.Set;

@Controller
public class HomePageController {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    CategoryDao categoryDao;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("articles", articleDao.findLastFew());
        model.addAttribute("categories", categoryDao.findAll());
        return "main/index";
    }

    @GetMapping("/category/{id}")
    public String categoryArticles(@PathVariable Long id, Model model) {
        Set<Article> articles = categoryDao.findById(id).getArticles();
        model.addAttribute("articles", articles);

        return "main/category";

    }


    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }

}
