package org.wcci.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;


@Controller
public class CategoryController {
    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/categories")
    public String displayCategory(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "categories-view";
    }

    @RequestMapping("/categories/{categoryType}")
    public String displaySingleCategory(@PathVariable String categoryType, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryByType(categoryType);
        model.addAttribute("category", retrieveCategory);
        return "category-view";
    }
}




