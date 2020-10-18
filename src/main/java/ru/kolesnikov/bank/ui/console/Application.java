package ru.kolesnikov.bank.ui.console;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import ru.kolesnikov.bank.dao.connection.ConnectionDataModel;
import ru.kolesnikov.bank.ui.console.initializers.MainMenuInitializer;
import ru.kolesnikov.bank.ui.console.utils.BootUtils;
import ru.kolesnikov.bank.web.JettyServer;

import java.io.File;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() throws Exception {
        /*JettyServer server = new JettyServer();
        server.start();*/

        BootUtils.createDefaultData();
        MainMenuInitializer mainMenuInitializer = new MainMenuInitializer();
        mainMenuInitializer.initialize();

    }
}
