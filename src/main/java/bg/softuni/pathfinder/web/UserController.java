package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.model.enums.LevelType;
import bg.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("registerData", new UserRegisterDTO());
        model.addAttribute("levels", LevelType.values());

        return "register";
    }

    @PostMapping("/register")
    public String processRegister(UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

//        if (bindingResult.hasErrors()) {
//
//            redirectAttributes.addFlashAttribute("registerData", userRegisterDTO);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);
//
//            return "redirect:/register";
//        }

        this.userService.register(userRegisterDTO);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView viewLogin() {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("loginData", new UserLoginDTO());

        return modelAndView;
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        this.userService.logout();

        return "redirect:/";
    }
}
