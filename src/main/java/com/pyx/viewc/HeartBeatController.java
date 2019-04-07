package com.pyx.viewc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HeartBeatController {

    private Log log = LogFactory.getLog(HeartBeatController.class);

    @Autowired
    private HeartBeatService heartBeatService;

    @RequestMapping("/heartBeat")
    public ModelAndView heartBeat() throws Exception {
        List<HeartBeat> list = heartBeatService.findRecent();
        Map<String, Object> params = new HashMap<>();
        params.put("list", list);
        return new ModelAndView("heartBeat", params);
    }

    @ResponseBody
    @RequestMapping("/sendHeartBeat")
    public String sendHeartBeat(HttpServletRequest request) {
        try {
            String ip = request.getRemoteAddr();
            String hostName = request.getRemoteHost();

            Assert.notNull(hostName, "hostName is null");
            Assert.notNull(ip, "ip is null");

            HeartBeat heartBeat = new HeartBeat(hostName, ip);
            boolean result = heartBeatService.add(heartBeat);
            if (!result) {
                throw new Exception("update error");
            }
            return "ok:" + ip;
        } catch (Exception e) {
            log.error(e);
            return "error";
        }
    }

    @RequestMapping("/clearHeartBeat")
    public String clearHeartBeat(HttpServletRequest request) {
        heartBeatService.clear();
        return "redirect:/heartBeat";
    }
}
