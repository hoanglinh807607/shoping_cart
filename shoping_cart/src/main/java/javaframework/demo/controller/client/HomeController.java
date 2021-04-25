package javaframework.demo.controller.client;

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

    @GetMapping(value = {"/","/index"})
    public String showIndexPage(){
        return "views/client/index";
    }

    @GetMapping(value = "/product/{id}/detail")
    public String showProductDetail(Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("productDTO", productService.findOne(id));
        return "views/client/product_detail";
    }
}
