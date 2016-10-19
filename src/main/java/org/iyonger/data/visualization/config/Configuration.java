package org.iyonger.data.visualization.config;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

/**
 * Created by yongfu on 10/13/2016.
 */
@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

    @Autowired
    DvProperties dvProperties;

    @Bean
    InfluxDB influxDB(){
        InfluxDB influxDB= InfluxDBFactory.connect("http://" + dvProperties.getInfluxdbServer() + ":" + dvProperties.getInfluxdbPort(), dvProperties.getInfluxdbUserName(), dvProperties.getInfluxdbPassword());
        //influxDB.createDatabase(dvProperties.getDatabase());
        return influxDB;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

}
