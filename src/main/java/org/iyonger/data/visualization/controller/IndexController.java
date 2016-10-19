package org.iyonger.data.visualization.controller;

import org.influxdb.dto.QueryResult;
import org.iyonger.data.visualization.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by yongfu on 10/13/2016.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    QueryHandler handler;

    @GetMapping
    public String index() {
        return "index";
    }

    @RequestMapping(value = "query/{query:.+}")
    @ResponseBody
    public Object query(@PathVariable("query") String query)throws Throwable {
        logger.debug("query:" + query);
        List<QueryResult.Series> series=handler.queryBySql(query);

        ModelMap maps=new ModelMap();
        maps.put("charts",series);
        maps.put("success",true);
        return maps;
    }
}
