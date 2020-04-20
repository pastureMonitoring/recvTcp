package com.ndd.bigcreate.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/1 22:48
 */
@Mapper
public interface TcpMapper {
    @Insert("insert into collect(temperature,foot,latitude,longtitude) values(#{temperature},#{foot},#{latitude},#{longtitude})")
    public void insertCollectByTcpBean(double temperature,int foot,double latitude,double longtitude);
}
