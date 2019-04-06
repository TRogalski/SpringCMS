package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.validator.Draft;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewList(Model model) {
        model.addAttribute("articles", articleDao.findDrafts());
        return "draft/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAdd(Model model) {
        model.addAttribute("article", new Article());
        return "draft/add";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleDao.findById(id));
        return "draft/edit";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String viewRemove(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleDao.findById(id));
        return "draft/remove";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated(Draft.class) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "draft/add";
        }
        article.setDraft(true);
        article.setCreated(String.valueOf(LocalDateTime.now()));
        articleDao.save(article);
        return "redirect:list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Validated(Draft.class) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "draft/edit";
        }
        article.setUpdated(String.valueOf(LocalDateTime.now()));
        articleDao.update(article);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@ModelAttribute Article article) {
        articleDao.remove(article);
        return "redirect:list";
    }

    @RequestMapping(value = "/publish/{id}", method = RequestMethod.GET)
    public String viewPublish(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleDao.findById(id));
        return "draft/publish";
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
