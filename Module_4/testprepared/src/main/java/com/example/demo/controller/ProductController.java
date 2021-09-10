package com.example.demo.controller;

import com.example.demo.model.DiscountList;
import com.example.demo.service.DiscountListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("discount")
public class ProductController {
    @Autowired
    private DiscountListService productService;


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/discount/create");
        modelAndView.addObject("discount", new DiscountList());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("discount") DiscountList discountList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/discount/create");
            modelAndView.addObject("discount", discountList);
            return modelAndView;
        }
        productService.save(discountList);
        ModelAndView modelAndView = new ModelAndView("/discount/create");
        modelAndView.addObject("discount", new DiscountList());
        modelAndView.addObject("message", "New disount was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam("searchKey") Optional<String> searchKey, @PageableDefault(size = 5) Pageable pageable) {
        Page<DiscountList> discounts;
        if (searchKey.isPresent()) {
            discounts = productService.findAllByNameContaining(searchKey.get(), pageable);
        } else {
            discounts = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("discount/list");
        modelAndView.addObject("discounts", discounts);
        return modelAndView;
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showDelete(@PathVariable("id") Long id){
//        Product product = productService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/product/delete");
//        modelAndView.addObject("product", product);
//        return modelAndView;
//    }
//
//    @PostMapping("/delete/{id}")
//    public ModelAndView delete(@PathVariable("id") Long id, Pageable pageable){
//        ModelAndView modelAndView = new ModelAndView("/product/list");
//        productService.remove(id);
//        Page<Product> products = productService.findAll(pageable);
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }
}
