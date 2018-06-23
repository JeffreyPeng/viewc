package com.pyx.viewc;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebSiteService {

    @Autowired
    private JdbcTemplate jtm;

    public boolean add(WebSite webSite) {
        String sql = "INSERT INTO WEBSITE(NAME, URL, TIME_MARGIN, LAST_SEEN) VALUES(?, ?, ?, ?)";
        int updateCount = jtm.update(sql, webSite.getName(), webSite.getUrl(), webSite.getTimeMargin(), webSite.getLastSeen());
        if (updateCount == 1) {
            return true;
        }
        return false;
    }

    public boolean del(long id) {
        String sql = "DELETE FROM WEBSITE WHERE ID = ?";
        int updateCount = jtm.update(sql, id);
        if (updateCount == 1) {
            return true;
        }
        return false;
    }

    public List<WebSiteForm> findAll() throws InvocationTargetException, IllegalAccessException {
        String sql = "SELECT * FROM WEBSITE";
        List<WebSite> list = jtm.query(sql, new BeanPropertyRowMapper(WebSite.class));
        List<WebSiteForm> newList = new ArrayList<>();
        for (WebSite webSite : list) {
            WebSiteForm form = new WebSiteForm();
            BeanUtils.copyProperties(form, webSite);
            newList.add(form);
        }
        return newList;
    }

    public boolean addView(int id) {
        String sql = "UPDATE WEBSITE SET LAST_SEEN = NOW() WHERE ID = ?";
        int updateCount = jtm.update(sql, id);
        if (updateCount == 1) {
            return true;
        }
        return false;
    }
}
