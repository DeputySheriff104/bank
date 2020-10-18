package ru.kolesnikov.bank.dao.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.kolesnikov.bank.dao.connection.ConnectionDataModel;

import java.io.File;
import java.io.IOException;

public class ConnectionFromYAML {

    public static ConnectionDataModel readConnectionFromYAML(String pathConnectionDataYAML) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            return mapper.readValue(
                    new File(pathConnectionDataYAML), ConnectionDataModel.class);
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
