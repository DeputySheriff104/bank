package ru.kolesnikov.bank.dao.connection;

import ru.kolesnikov.bank.dao.utils.ConnectionFromYAML;

public class ConnectionPools {

    public static final BasicConnectionPool BANK_POOL = BasicConnectionPool.create(
            ConnectionFromYAML.readConnectionFromYAML(
                    "src/main/resources/db/bank.yaml"));
}
