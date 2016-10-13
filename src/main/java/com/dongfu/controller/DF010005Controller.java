package com.dongfu.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongfu.util.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DF010005Controller
 * @Description: 查询书籍详细信息
 * @author Fordring
 * @date 2016/08/28
 * @version V1.0
 */
@Controller
class DF010005Controller {
    private static final Logger logger = LoggerFactory.getLogger(DF010005Controller.class);

    @Autowired
    private SqlSessionTemplate sqlSession;

    @RequestMapping(value = "/{bookId}.html", method = {RequestMethod.GET})
    public String BookInfo(@PathVariable("bookId") String bookId, Map<String, Object> result) {
        logger.info("bookId:" + bookId);
        Map bookInfo = sqlSession.selectOne("t_book_info.findBooKInfoAndChapterByBookId", bookId);
        List<Map<String, Object>> chapters = sqlSession.selectList("t_book_chapter.findByBookIdOrderByCreateTime", bookId);
        //系统参数
        List<Map<String, Object>> sysParams = Constant.seoParams;
        //seo信息
        String title = "";
        String keywords = "";
        String description = "";

        for (int i = 0; i < sysParams.size(); i++) {
            Map<String, Object> sysParam = sysParams.get(i);
            if ("book_info_title".equals(sysParam.get("param_key") + "")) {
                title = (sysParam.get("param_value") + "").replaceAll("bookName", bookInfo.get("book_name") + "").replace("bookAuth", bookInfo.get("book_auth") + "");
            }
            if ("book_info_keywords".equals(sysParam.get("param_key") + "")) {
                keywords = (sysParam.get("param_value") + "").replaceAll("bookName", bookInfo.get("book_name") + "");
            }
            if ("book_info_description".equals(sysParam.get("param_key") + "")) {
                description = (sysParam.get("param_value") + "").replaceAll("bookName", bookInfo.get("book_name") + "");
            }
        }

        Map<String, Object> seo = new HashMap<>();
        seo.put("title", title);
        seo.put("keywords", keywords);
        seo.put("description", description);
        result.put("seo", seo);
        result.put("bookInfo", bookInfo);
        result.put("chapters", chapters);
        return "bookInfo";
    }
}
