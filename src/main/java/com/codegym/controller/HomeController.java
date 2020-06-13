package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    SmartphoneService smartphoneService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/smartphones", method = RequestMethod.GET)
    public ModelAndView showAll(){
        Iterable<SmartPhone> smartPhoneList = smartphoneService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("smartphones", smartPhoneList);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartPhone(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("smartphone", new SmartPhone());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone createSmartPhone(@RequestBody SmartPhone smartPhone){
        return smartphoneService.save(smartPhone);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone deleteSmartphone(@PathVariable Integer id){
        return smartphoneService.remove(id);
    }

//    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
//                consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity deletePhone(@PathVariable Integer id){
//        smartphoneService.remove(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSmartphonePage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("edit");
        SmartPhone smartphone = smartphoneService.findById(id);
        mav.addObject("smartphone", smartphone);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone editSmartphone(@PathVariable int id, @RequestBody SmartPhone smartphone) {
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }
}
