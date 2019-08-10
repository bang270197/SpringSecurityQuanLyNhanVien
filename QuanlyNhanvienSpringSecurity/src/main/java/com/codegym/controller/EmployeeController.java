package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.GroupMembers;
import com.codegym.service.EmployService;
import com.codegym.service.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployService employService;

    @Autowired
    private GroupMemberService groupMemberService;
    @ModelAttribute("GroupMember")
    public Iterable<GroupMembers> groupMembers(){
        return groupMemberService.showAll();
    }

    @GetMapping("/")
    public String showList() {
        return "index/index";
    }

    @GetMapping("/user")
    public ModelAndView user( Model model, Principal principal,@PageableDefault(7) Pageable pageable ) {
        ModelAndView modelAndView=new ModelAndView("employee/list");
        modelAndView.addObject("listemployee",employService.showAll(pageable));
        System.out.printf(principal.getName());
        return modelAndView;
    }

   @GetMapping("/search")
   public String  search(@RequestParam("groupMembers") Optional<Long> id,
                               @RequestParam("name") Optional<String> name, Model model){
        if (name.isPresent()){
            GroupMembers groupMembers=groupMemberService.findAllByGroupNameContaining(name.get());
            Iterable<Employee> employees=employService.findAllByGroupMembers(groupMembers);
            model.addAttribute("employee",employees);
            model.addAttribute("groupMember",groupMembers);
            return "employee/search";
      }
        if (id.isPresent()){
           GroupMembers groupMembers=groupMemberService.findById(id.get());
           Iterable<Employee> employees=employService.findAllByGroupMembers(groupMembers);
           model.addAttribute("employee",employees);
           model.addAttribute("groupMember",groupMembers);
           return "employee/search";


       }

       return "employee/search";
   }

    @GetMapping("/show-create")
    public String showCreate(Model mode) {
        mode.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create-employee")
    public String createEmployee(@ModelAttribute Employee employee, Model model ) {
        employService.save(employee);
        model.addAttribute("message", "Them thanh cong");
        return "employee/create";

    }

    @GetMapping("/show-edit/{id}")
    public String showEdit(@PathVariable Long id,Model model){
        Employee employee=employService.findById(id);
        model.addAttribute("employee",employee);
        return "employee/edit";
    }

    @PostMapping("/edit-employee")
    public String editEmployee(@ModelAttribute Employee employee,Model model){
        employService.save(employee);
        model.addAttribute("message","Sua thanh cong");
        model.addAttribute("employee",employee);
        return "employee/edit";
    }
    @GetMapping("/show-view/{id}")
    public String showView(@PathVariable Long id,Model model){
        Employee employee=employService.findById(id);
        model.addAttribute("employee",employee);
        return "employee/view";
    }
    @GetMapping("/show-delete/{id}")
    public String showDelete(@PathVariable Long id,Model model){
        Employee employee=employService.findById(id);
        model.addAttribute("employee",employee);
        return "employee/delete";
    }



}
