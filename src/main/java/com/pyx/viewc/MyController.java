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

    @RequestMapping("/showList")
    public ModelAndView showList() {

        List<WebSite> websites = webSiteService.findAll();

        Map<String, Object> params = new HashMap<>();
        params.put("websites", websites);

        log.info("hhahah ,log good");
        return new ModelAndView("showList", params);
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(WebSite webSite) {
        boolean addCount = webSiteService.add(webSite);
        log.info("result:" + addCount);
        return "true";
    }

    @ResponseBody
    @RequestMapping("/del")
    public String del(int id) {
        boolean delCount = webSiteService.del(id);
        log.info("result:" + delCount);
        return "true";
    }

}