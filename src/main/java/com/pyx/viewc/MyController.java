package com.pyx.viewc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MyController {

    private Log log = LogFactory.getLog(MyController.class);

    @Autowired
    private WebSiteService webSiteService;

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/home")
    public ModelAndView home() throws Exception {
        List<WebSiteForm> websites = webSiteService.findAll();
        Map<String, Object> params = new HashMap<>();
        params.put("websites", websites);
        return new ModelAndView("home", params);
    }

    @RequestMapping("/manage")
    public ModelAndView manage() throws Exception {
        List<WebSiteForm> websites = webSiteService.findAll();
        Map<String, Object> params = new HashMap<>();
        params.put("websites", websites);
        return new ModelAndView("manage", params);
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "toAdd";
    }

    @RequestMapping("/add")
    public String add(WebSite webSite) {
        log.info("add param :" + webSite.toString());
        boolean addCount = webSiteService.add(webSite);
        log.info("add result:" + addCount);
        return "redirect:/manage";
    }

    @RequestMapping("/del")
    public String del(int id) {
        log.info("del param :" + id);
        boolean delCount = webSiteService.del(id);
        log.info("del result:" + delCount);
        return "redirect:/manage";
    }

    @ResponseBody
    @RequestMapping("/addView")
    public String addView(int id) {
        log.info("addView param :" + id);
        boolean updateCount = webSiteService.addView(id);
        log.info("addView result:" + updateCount);
        return updateCount + "";
    }

}