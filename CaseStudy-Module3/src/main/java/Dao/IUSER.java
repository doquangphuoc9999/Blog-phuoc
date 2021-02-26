package Dao;

import java.sql.SQLException;
import java.util.List;

public interface IUSER<T> {
    List<T> selectAll() throws SQLException;

    void insert(T object) throws SQLException;
    void Save(T object) throws SQLException;
    T findById(int id) throws SQLException;
    T finByUserNamePassword(String userName, String password);
    boolean delete(int id) throws SQLException;

    boolean update(T object) throws SQLException;
}
