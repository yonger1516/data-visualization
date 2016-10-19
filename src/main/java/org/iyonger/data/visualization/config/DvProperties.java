package org.iyonger.data.visualization.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yongfu on 10/13/2016.
 */
@Component
public class DvProperties {

    @Value("${influxdb.server}")
    private String influxdbServer;

    @Value("${influxdb.port}")
    private String influxdbPort;

    @Value("${influxdb.username}")
    private String influxdbUserName;

    @Value("${influxdb.password}")
    private String influxdbPassword;

    @Value("${influxdb.database}")
    private String database;

    public String getInfluxdbServer() {
        return influxdbServer;
    }

    public void setInfluxdbServer(String influxdbServer) {
        this.influxdbServer = influxdbServer;
    }

    public String getInfluxdbPort() {
        return influxdbPort;
    }

    public void setInfluxdbPort(String influxdbPort) {
        this.influxdbPort = influxdbPort;
    }

    public String getInfluxdbUserName() {
        return influxdbUserName;
    }

    public void setInfluxdbUserName(String influxdbUserName) {
        this.influxdbUserName = influxdbUserName;
    }

    public String getInfluxdbPassword() {
        return influxdbPassword;
    }

    public void setInfluxdbPassword(String influxdbPassword) {
        this.influxdbPassword = influxdbPassword;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
