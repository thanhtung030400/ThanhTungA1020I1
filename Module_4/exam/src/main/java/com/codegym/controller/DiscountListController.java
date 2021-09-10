package com.codegym.controller;


import com.codegym.model.DiscountList;
import com.codegym.service.DiscountListService;
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
@RequestMapping("discountlist")
public class DiscountListController {
    @Autowired
    private DiscountListService discountListService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/discountlist/create");
        modelAndView.addObject("discountlist", new DiscountList());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("discountlist") DiscountList discountList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/discountlist/create");
            modelAndView.addObject("discountlist", discountList);
            return modelAndView;
        }
        discountListService.save(discountList);
        ModelAndView modelAndView = new ModelAndView("/discountlist/create");
        modelAndView.addObject("discountlist", new DiscountList());
        modelAndView.addObject("message", "New discount was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam("searchKey") Optional<String> searchKey, @PageableDefault(size = 5) Pageable pageable) {
        Page<DiscountList> discountLists;
        if (searchKey.isPresent()) {
            discountLists = discountListService.findAllByNameContaining(searchKey.get(), pageable);
        } else {
            discountLists = discountListService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("discountlist/list");
        modelAndView.addObject("discountLists", discountLists);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id){
        DiscountList discountlist = discountListService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/discountlist/delete");
        modelAndView.addObject("discountlist", discountlist);
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/discountlist/list");
        discountListService.remove(id);
        Page<DiscountList> discountLists = discountListService.findAll(pageable);
        modelAndView.addObject("discountLists", discountLists);
        return modelAndView;
    }


}
