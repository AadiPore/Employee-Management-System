package com.aadi.user.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aadi.user.dto.UsersDto;
import com.aadi.user.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
    
    @GetMapping("/index")
    public String showUserList(Model model) {
    	model.addAttribute("usersDto", usersService.findAll());
        return "index";
    }
    
    @GetMapping("/signup")
    public String showSignUpForm(UsersDto usersDto) {
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid UsersDto usersDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        usersService.save(usersDto);
        return "redirect:/index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        UsersDto usersDto = usersService.findById(id);
        model.addAttribute("usersDto", usersDto);
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @Valid UsersDto usersDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            usersDto.setId(id);
            return "update-user";
        }
        usersService.save(usersDto);
        return "redirect:/index";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        usersService.delete(id);
        return "redirect:/index";
    }
}