package org.iyonger.data.visualization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.iyonger.data.visualization.config.DvProperties;
import org.iyonger.data.visualization.model.Chart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yongfu on 10/13/2016.
 */
@Service
public class QueryHandler {
    private static final Logger logger = LoggerFactory.getLogger(QueryHandler.class);

    @Autowired
    InfluxDB influxDB;

    @Autowired
    DvProperties dvProperties;

    public List<QueryResult.Series> queryBySql(String q) throws Throwable {
        Query query = new Query(q, dvProperties.getDatabase());
        QueryResult result = influxDB.query(query);

        logger.debug(new ObjectMapper().writeValueAsString(result.getResults().get(0).getSeries()));

        return result.getResults().get(0).getSeries();
    }

}
