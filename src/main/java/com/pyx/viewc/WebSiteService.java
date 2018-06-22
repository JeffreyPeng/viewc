package com.pyx.viewc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

    public List<WebSite> findAll() {
        String sql = "SELECT * FROM WEBSITE";
        List<WebSite> cities = jtm.query(sql, new BeanPropertyRowMapper(WebSite.class));
        return cities;
    }
}
