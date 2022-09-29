package com.MinTicCiclo3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MinTicCiclo3.Model.Category;
import com.MinTicCiclo3.Service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> obtenerCategoryCompleta(){
        return categoryService.obtenerCategoryCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Category> obtenerCategoryId(@PathVariable("id") Integer identificador){
        return categoryService.obtenerCategoryId (identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category salvarCategory(@RequestBody Category category){
        return categoryService.salvarCategory(category);

    }
    // Consultas personalizadas
    @GetMapping("/scorecompleta/jpql")
    public List<Category> obtenerCategoryCompletaJPQL() {
        return categoryService.obtenerCategoryCompletaJPQL();
    }
}
