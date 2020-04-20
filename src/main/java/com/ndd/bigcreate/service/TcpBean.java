package com.ndd.bigcreate.service;

import lombok.Data;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/1 22:35
 */
@Data
public class TcpBean {
    /*温度*/
    private double temperature;
    /*步数*/
    private int foot;
    /*纬度*/
    private double latitude;
    /*经度*/
    private double longtitude;
}
