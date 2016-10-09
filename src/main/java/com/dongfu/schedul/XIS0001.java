package com.dongfu.schedul;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Fordring on 2016/8/17.
 */
@Component
class XIS0001 {
    private static final Logger logger = LoggerFactory.getLogger(XIS0001.class);

    @Autowired
    private SqlSessionTemplate sqlSession;

    /**
     * 重置日阅读量(每日凌晨23:59触发)
     */
    @Scheduled(cron = "0 59 23 * * ?")
    public void resetDayCount() {
        logger.info("<-----------------------------------------重置日阅读量开始----------------------------------------->");
        sqlSession.update("t_book_info.resetDayCount");
        logger.info("<-----------------------------------------重置日阅读量结束----------------------------------------->");
    }

    /**
     * 重置周阅读量(周一凌晨00:05触发)
     */
    @Scheduled(cron = "0 5 0 ? * 1")
    public void resetWeekCount() {
        logger.info("<-----------------------------------------重置周阅读量开始----------------------------------------->");
        sqlSession.update("t_book_info.resetWeekCount");
        logger.info("<-----------------------------------------重置周阅读量结束----------------------------------------->");
    }

    /**
     * 重置月阅读量(每月的第一天的00:00触发)
     */
    @Scheduled(cron = "0 0 0 1 * ?")
    public void resetMonthCount() {
        logger.info("<-----------------------------------------重置月阅读量开始----------------------------------------->");
        sqlSession.update("t_book_info.resetMonthCount");
        logger.info("<-----------------------------------------重置月阅读量结束----------------------------------------->");
    }

}
