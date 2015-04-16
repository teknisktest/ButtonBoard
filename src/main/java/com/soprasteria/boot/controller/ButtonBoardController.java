package com.soprasteria.boot.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.io.FileUtils.*;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;


@Controller
public class ButtonBoardController {



    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String displayButtons(){

        return "buttons";
    }

    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE) // Change to MediaType.IMAGE_JPEG_VALUE for image
    public byte[] testphoto() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL path = classLoader.getResource("image.jpg");
        InputStream is = path.openStream();
        return IOUtils.toByteArray(is);

    }
}

