package net.orekyuu.todo;

import net.orekyuu.moco.core.ConnectionManager;
import net.orekyuu.moco.core.DataSourceType;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class MocoInitializer {

    private DataSource dataSource;

    public MocoInitializer(DataSource dataSource) {
        this.dataSource = new TransactionAwareDataSourceProxy(dataSource);
    }

    @PostConstruct
    public void initialize() {
        ConnectionManager.initialize(dataSource, DataSourceType.SQLITE);
    }
}
