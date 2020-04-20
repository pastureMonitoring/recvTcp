package com.ndd.bigcreate;

import com.ndd.bigcreate.dao.TcpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/20 8:59
 */
@Controller
public class ControllerTest {

    @Autowired
    TcpMapper tcpMapper;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        tcpMapper.insertCollectByTcpBean(1.0,1,1.0,1.0);
        return "success";
    }
}
