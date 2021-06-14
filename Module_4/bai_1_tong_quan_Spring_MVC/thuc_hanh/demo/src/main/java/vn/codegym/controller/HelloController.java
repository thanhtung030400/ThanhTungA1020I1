package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.StudentService;

@Controller
@RequestMapping(value = {"student"})
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloPage(Model model, ModelMap modelMap){
        model.addAttribute("studentName", "Nguyen Van A");
        modelMap.addAttribute("studentAge", 26);
        return "hello";
    }

    @GetMapping(value = "/edit/{id:[0-2]}", name = "showEditPage")
    public String showEditPage(@PathVariable("id") int studentId, ModelMap modelMap){
        modelMap.addAttribute("student", studentService.findById(studentId));
        return "edit";
    }

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showStudentList(){
        ModelAndView modelAndAView= new ModelAndView("list.jsp");
        modelAndAView.addObject("studentList", studentService.findAll());

        return new ModelAndView("list","studentList", studentService.findAll());

    }
    public String abc(){
        return "zzz";
    }
}
