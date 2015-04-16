package com.soprasteria.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ButtonBoardController {
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String displayButtons(){

        return "buttons";
    }
}
