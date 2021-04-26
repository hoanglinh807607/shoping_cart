package javaframework.demo.controller.client;

import javaframework.demo.service.impl.CategoryService;
import javaframework.demo.service.impl.ImageService;
import javaframework.demo.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @GetMapping(value = {"/","/index"})
    public String showIndexPage(Model model){
        model.addAttribute("categoryDTO", categoryService.findOne(4l));
        return "views/client/electronics/index";
    }

    @GetMapping(value = "/product/{id}/detail")
    public String showProductDetail(Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("productDTO", productService.findOne(id));
        return "views/client/electronics/product_detail";
    }
}
