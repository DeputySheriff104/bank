package ru.kolesnikov.bank.dao.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NamedParametersStatement {

    private PreparedStatement prepStmt;
    private List<String> fields = new ArrayList<>();

    public NamedParametersStatement(Connection conn, String sql) throws SQLException {
        int pos;
        while((pos = sql.indexOf(":")) != -1) {
            int end = getEnd(pos, sql);
            if (end == -1)
                end = sql.length();
            else
                end += pos;
            fields.add(sql.substring(pos+1,end));
            sql = sql.substring(0, pos) + "?" + sql.substring(end);
        }
        prepStmt = conn.prepareStatement(sql);
    }

    private int getEnd(int pos, String sql) {
        List<Integer> ends = new ArrayList<>();
        if (sql.substring(pos).contains(" "))
            ends.add(sql.substring(pos).indexOf(" "));
        if (sql.substring(pos).contains(","))
            ends.add(sql.substring(pos).indexOf(","));
        if (sql.substring(pos).contains(")"))
            ends.add(sql.substring(pos).indexOf(")"));
        if (sql.substring(pos).contains(";"))
            ends.add(sql.substring(pos).indexOf(";"));
        return Collections.min(ends);
    }

    public PreparedStatement getPreparedStatement() {
        return prepStmt;
    }


    public ResultSet executeQuery() throws SQLException {
        return prepStmt.executeQuery();
    }

    public int executeUpdate() throws SQLException {
        return prepStmt.executeUpdate();
    }

    public void close() throws SQLException {
        prepStmt.close();
    }

    public void setInt(String name, int value) throws SQLException {
        prepStmt.setInt(getIndex(name), value);
    }

    public void setString(String name, String value) throws SQLException {
        prepStmt.setString(getIndex(name), value);
    }

    public void setObject(String name, Object value) throws SQLException {
        prepStmt.setObject(getIndex(name), value);
    }
    private int getIndex(String name) {
        return fields.indexOf(name)+1;
    }
}
