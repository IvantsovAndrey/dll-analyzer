package dllchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DllCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DllCheckerApplication.class, args);
    }
}

