package com.pmpsilva.taxapi.app.error;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject("exception", e.getMessage());
        if(e.getCause()!=null){
            model.addObject("cause", e.getCause().getMessage());
        }

        return model;
    }
}
