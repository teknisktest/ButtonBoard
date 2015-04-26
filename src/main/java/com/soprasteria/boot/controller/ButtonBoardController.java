package com.soprasteria.boot.controller;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.coyote.ErrorState;
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
import java.rmi.ServerError;


@Controller
public class ButtonBoardController {



    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String displayButtons(){

        return "buttons";
    }

    @RequestMapping(value = "/maketrouble")
    public String makeTrouble() {

        // Komplisert kode. Så komplisert at vi kan like gjerne kaste en slik en:

        throw new IllegalStateException();
    }

    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE) // Change to MediaType.IMAGE_JPEG_VALUE for image
    public byte[] testphoto() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL path = classLoader.getResource("image.jpg");
        InputStream is = path.openStream();
        return IOUtils.toByteArray(is);

    }

    @ResponseBody
    @RequestMapping(value = "/noetekst", method = RequestMethod.GET, produces = "text/plain;charset=ASCII") // Change to MediaType.IMAGE_JPEG_VALUE for image
    public String noetekst(HttpServletResponse response){
        response.setContentType("text/plain;charset=ASCII");
        return "Hei på deg jeg heter Åge Amundsen og jeg er 19 år.";

    }
}

