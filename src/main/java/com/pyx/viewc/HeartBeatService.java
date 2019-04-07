package com.pyx.viewc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HeartBeatService {

    private Log log = LogFactory.getLog(HeartBeatService.class);

    @Autowired
    private JdbcTemplate jtm;

    public boolean add(HeartBeat heartBeat) {
        String sql = "INSERT INTO HEARTBEAT(HOST_NAME, IP, RECV_TIME) VALUES(?, ?, ?)";
        int updateCount = jtm.update(sql, heartBeat.getHostName(), heartBeat.getIp(), heartBeat.getRecvTime());
        if (updateCount == 1) {
            return true;
        }
        return false;
    }

    public List<HeartBeat> findRecent() {
        String sql = "SELECT * FROM HEARTBEAT order by id desc limit 100";
        return jtm.query(sql, new BeanPropertyRowMapper(HeartBeat.class));
    }

    public boolean clear() {
        String sql = "DELETE FROM HEARTBEAT";
        jtm.update(sql);
        return true;
    }
}
