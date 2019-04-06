package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.validator.None;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value="test",method = RequestMethod.GET)
    @ResponseBody
    public String getTopFiveArticles(){
        return articleRepository.customGetAll().toString();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewList(Model model) {
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles", articles);
        return "article/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAdd(Model model) {
        model.addAttribute("article", new Article());
        return "article/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated({None.class, Default.class}) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/add";
        }
        article.setDraft(false);
        article.setCreated(String.valueOf(LocalDateTime.now()));
        articleDao.update(article);
        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable Long id, Model model) {
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "article/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/edit";
        }
        article.setUpdated(String.valueOf(LocalDateTime.now()));
        articleDao.update(article);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String viewRemove(@PathVariable Long id, Model model) {
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "article/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam Long id) {
        Article article = articleDao.findById(id);
        articleDao.remove(article);
        return "redirect:list";
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }
}
