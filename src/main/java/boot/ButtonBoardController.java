package boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
public class ButtonBoardController {
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String displayButtons(HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");

        return "buttons";
    }
}
