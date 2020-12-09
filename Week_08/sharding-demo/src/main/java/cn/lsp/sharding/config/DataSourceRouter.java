package cn.lsp.sharding.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("======current dbtype connection is ===: {}",DbContextHolder.getDbType());
        return DbContextHolder.getDbType();
    }
}
