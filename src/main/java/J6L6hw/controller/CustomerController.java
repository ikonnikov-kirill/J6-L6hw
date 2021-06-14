package J6L6hw.controller;

import J6L6hw.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @GetMapping()
    public String showProducts(Model model) {
        model.addAttribute("customers", repository.findAll());
        log.info("/customers");
        return "customers/showAll";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", repository.getById(id));
        log.info(":/id: " + id);
        return "customers/show";
    }
}
