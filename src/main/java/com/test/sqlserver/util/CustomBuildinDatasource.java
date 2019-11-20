package com.test.sqlserver.util;

import com.bstek.ureport.definition.datasource.BuildinDatasource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomBuildinDatasource implements BuildinDatasource {
    private DataSource dataSource;

    @Override
    public String name() {
        return "内置数据源DEMO";
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException s) {
            throw new RuntimeException(s);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
