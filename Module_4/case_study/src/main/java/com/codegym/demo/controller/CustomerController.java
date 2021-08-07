package com.codegym.demo.controller;


import com.codegym.demo.model.Customer;
import com.codegym.demo.model.CustomerType;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes(){
        return customerTypeService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam("searchKey") Optional<String> searchKey, Pageable pageable){
        Page<Customer> customers;
        if(searchKey.isPresent()){
            customers = customerService.findAllByFirstNameContaining(searchKey.get(), pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{customerId}")
    public ModelAndView showEditForm(@PathVariable Long customerId){
        Customer customer = customerService.findById(customerId);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successful");
        return modelAndView;
    }

    @GetMapping("/delete/{customerId}")
    public ModelAndView showDelete(@PathVariable("customerId") Long customerId){
        Customer customer = customerService.findById(customerId);
        ModelAndView modelAndView = new ModelAndView("/customer/delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/delete-customer/{customerId}")
    public ModelAndView delete(@PathVariable("customerId") Long customerId, Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        customerService.remove(customerId);
        Page<Customer> customers = customerService.findAll(pageable);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
