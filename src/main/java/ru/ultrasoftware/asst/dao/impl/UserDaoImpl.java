package ru.ultrasoftware.asst.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.ultrasoftware.asst.dao.UserDao;
import ru.ultrasoftware.asst.domain.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    public void setDS(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM \"user\"";
        List<User> result = new ArrayList<>();
        for(Map<String, Object> row : getJdbcTemplate().queryForList(sql)){
            User user = new User();
            user.setId((Integer)row.get("id"));
            user.setName((String)row.get("name"));
            result.add(user);
        }
        return result;
    }
}
