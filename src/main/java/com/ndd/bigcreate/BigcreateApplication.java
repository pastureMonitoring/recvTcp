package com.ndd.bigcreate;

import com.ndd.bigcreate.dao.TcpMapper;
import com.ndd.bigcreate.tcp.Testtvp;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BigcreateApplication {


    public static void main(String[] args) {
        SpringApplication.run(BigcreateApplication.class, args);
        Testtvp testtvp=new Testtvp();
    }

}
