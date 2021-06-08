//package com.nulp.bat.travelagency.controller;
//
//import com.nulp.bat.travelagency.dto.UserDto;
//import com.nulp.bat.travelagency.service.UserService;
//import com.nulp.bat.travelagency.service.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@RestController
//public class LoginContoller {
//    @Autowired
//    private UserServiceImpl userService;
//
//    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//
//
//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        UserDto user = new UserDto();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid UserDto user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        UserDto userExists = userService.getUser(user.getLoginUser());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("userName", "error.user",
//                            "There is already a user registered with the user name provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.createUser(user);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new UserDto());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDto user = userService.getUser(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getLoginUser() + "/" + user.getPersonalData().getFirstName() + ")");
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }
//}
