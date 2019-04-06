package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewList(Model model) {
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "author/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAdd(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Author author, BindingResult result) {
        if(result.hasErrors()){
            return "author/add";
        }
        authorDao.save(author);
        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "author/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid Author author, BindingResult result) {
        if(result.hasErrors()){
            return "author/edit";
        }
        authorDao.update(author);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String viewRemove(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "author/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam Long id) {
        Author author =authorDao.findById(id);
        authorDao.remove(author);
        return "redirect:list";
    }
}
