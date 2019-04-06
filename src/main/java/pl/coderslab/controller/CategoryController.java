package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewList(Model model) {
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAdd(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryDao.save(category);
        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable Long id, Model model) {
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/edit";
        }
        categoryDao.update(category);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String viewRemove(@PathVariable Long id, Model model) {
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "category/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam Long id) {
        categoryDao.remove(categoryDao.findById(id));
        return "redirect:list";
    }

}
