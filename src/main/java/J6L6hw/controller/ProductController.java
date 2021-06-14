package J6L6hw.controller;

import J6L6hw.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @GetMapping()
    public String showProducts(Model model) {
        model.addAttribute("products", repository.findAll());
        log.info("/products");
        return "products/showAll";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", repository.getById(id));
        log.info(":/id: " + id);
        return "products/show";
    }


}
