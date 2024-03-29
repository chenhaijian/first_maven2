package com.dalu.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chj
 */
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping(value="{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }
}
