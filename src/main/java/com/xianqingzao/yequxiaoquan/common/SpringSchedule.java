package com.xianqingzao.yequxiaoquan.common;

import com.xianqingzao.yequxiaoquan.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringSchedule {

    @Autowired
    private OrderDao orderDao;

    @Scheduled(cron = "0 5 0 * * ?")
    public void orderOverdue() {
        orderDao.setOverdue();
    }
}
