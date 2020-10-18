package ru.kolesnikov.bank.dao.mappers;

import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.user.User;

import java.sql.ResultSet;

public class UserMapper {

    public static void mapModelToEntity(User user, NamedParametersStatement st) {
        try {
        st.setString("login", user.getLogin());
        st.setString("password", user.getPassword());
        st.setString("firstName", user.getFirstName());
        st.setString("lastName", user.getLastName());
        st.setString("phone", user.getPhone());
        st.setString("email", user.getEmail());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static User mapEntityToModel(ResultSet rs) {
        try {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("phone"),
                rs.getString("email"));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
