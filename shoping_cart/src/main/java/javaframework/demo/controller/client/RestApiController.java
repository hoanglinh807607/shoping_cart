package javaframework.demo.controller.client;

import javaframework.demo.dto.ProductDTO;
import javaframework.demo.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
public class RestApiController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/like", consumes = "application/json", produces = "application/json")
    public ProductDTO changeLike(@RequestBody ProductDTO productDTO){

        productDTO = productService.save(productDTO);
        return productDTO;
    }
}
