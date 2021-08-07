package com.codegym.demo.controller;


import com.codegym.demo.model.Contract;
import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Employee;
import com.codegym.demo.model.Service;
import com.codegym.demo.service.ContractService;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.EmployeeService;
import com.codegym.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ContractService contractService;

    @ModelAttribute("employees")
    public Iterable<Employee> getAllEmployee(Pageable pageable){
        return employeeService.findAll(pageable);
    }
    @ModelAttribute("customers")
    public Iterable<Customer> getAllCustomer(Pageable pageable){
        return customerService.findAll(pageable);
    }
    @ModelAttribute("services")
    public Iterable<Service> getAllService(){
        return serviceService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveContract(@ModelAttribute("contract") Contract contract){
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("message", "New contract was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listContract(){
        List<Contract> contracts = contractService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("/delete/{contractId}")
    public String deleteContract(@PathVariable Long contractId){
        contractService.delete(contractId);
        return "redirect:/contract/list";
    }
}
