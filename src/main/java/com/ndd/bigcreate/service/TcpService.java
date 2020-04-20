package com.ndd.bigcreate.service;

import com.ndd.bigcreate.dao.TcpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/1 22:32
 */
@Service
//@Component
public class TcpService {

    @Autowired
    TcpMapper tcpMapper;

    static List<TcpBean> lists=new ArrayList<>();
    public void store(String data){
        if(lists.size()==10){
            //计算数据
            System.out.println("到达十个数据");
            double temperature=0.0;
            double foot1=0.0,foot2=0.0;
            double latitude=0.0,longtitude=0.0;
            for(int i=0;i<lists.size();i++){
                temperature+=lists.get(i).getTemperature()/10;
                if(i<5){
                    foot1+=(double) lists.get(i).getFoot()/5;
                }else {
                    foot2+=(double) lists.get(i).getFoot()/5;
                }
                latitude+=lists.get(i).getLatitude()/10;
                longtitude+=lists.get(i).getLongtitude()/10;
            }
            int foot= (int) ((foot2-foot1)/10000);
            if(foot<=0) foot=0;
            //格式化数据
            temperature=exchange(temperature);
            latitude=exchange(latitude);
            longtitude=exchange(longtitude);
            //存数据库
            tcpMapper.insertCollectByTcpBean(temperature,foot,latitude,longtitude);
            //移出数据
            for(int i=0;i<lists.size();i++)
                lists.remove(i);
            dataStore(data);//存储数据
        }else {
            dataStore(data);
        }
    }

    /**
     * 保留两位有效数字
     * @param f
     * @return
     */
    public double exchange(double f){
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
    public  void dataStore(String data){
        TcpBean tcpBean=new TcpBean();
        String[] number=data.split(" ");
        tcpBean.setFoot(Integer.parseInt(number[1]));
        tcpBean.setTemperature(Double.parseDouble(number[0]));
        tcpBean.setLongtitude(Double.parseDouble(number[2]));
        tcpBean.setLatitude(Double.parseDouble(number[3]));
        System.out.println("还未达到10个数据：");
        System.out.println(tcpBean);
        lists.add(tcpBean);
        System.out.println("当前数据个数为："+lists.size());
    }
}
