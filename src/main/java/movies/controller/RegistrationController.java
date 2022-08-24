package movies.controller;

import movies.dto.AppUserDTO;
import movies.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/adduser")
    public String register(Model model) {
        model.addAttribute("user", new AppUserDTO());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String register(@Valid @ModelAttribute("user") AppUserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        appUserService.createUser(userDTO);
        return "redirect:adduser?success";
    }
}
