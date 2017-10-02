package thymeleaf.jpa.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("message", "Hai sayang");
        return mav;
    }
}
