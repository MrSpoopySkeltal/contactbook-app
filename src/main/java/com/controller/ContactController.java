package com.controller;

import com.model.Contact;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "index"; // This resolves to src/main/resources/templates/index.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Integer id) {
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }

    @GetMapping("/details/{id}")
    public String viewDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "details";
    }
    

    }


