package Login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Login.model.Change;
import Login.model.Login;
import Login.model.User;
public class UserDaoImpl implements UserDao{
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
 
  public boolean register(User user) {
	  String sql="DROP TABLE MYDB.users;";
	  jdbcTemplate.execute(sql);
			  sql="CREATE SCHEMA IF NOT EXISTS MYDB;"+"CREATE TABLE IF NOT EXISTS MYDB.users ( userid  VARCHAR(45) NOT NULL, password  VARCHAR(45) NULL,firstname VARCHAR(45) NOT NULL,lastname  VARCHAR(45) NULL,  email     VARCHAR(45) NULL,  desig  VARCHAR(45) NULL,  phone     varchar(10) NULL,PRIMARY KEY (userid));";
	    jdbcTemplate.execute(sql);
    sql = "select * from  MYDB.users where userid='" + user.getUserid() + "' and password='" + user.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    if(users.size()>0)
    	return false;
    sql = "insert into MYDB.users values(?,?,?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getUserid(), user.getPassword(), user.getFirstname(),
    user.getLastname(), user.getEmail(), user.getDesig(), user.getPhone() });
    return true;
    }
  public boolean deleteUser(Login login) {
	 String sql = "delete  from  MYDB.users where userid='" + login.getUserid() + "' and password='" + login.getPassword()
    + "'";
    jdbcTemplate.update(sql);
    return true;
    }
    public User validateUser(Login login) {
    	String sql="CREATE SCHEMA IF NOT EXISTS MYDB;"+"CREATE TABLE IF NOT EXISTS MYDB.users ( userid  VARCHAR(45) NOT NULL, password  VARCHAR(45) NULL,firstname VARCHAR(45) NOT NULL,lastname  VARCHAR(45) NULL,  email     VARCHAR(45) NULL,  desig  VARCHAR(45) NULL,  phone  varchar(10) NULL,PRIMARY KEY (userid));";
	    jdbcTemplate.execute(sql);
    sql = "select * from  MYDB.users where userid='" + login.getUserid() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
    public User validateUser(Change change) {
    	String sql="CREATE SCHEMA IF NOT EXISTS MYDB;"+"CREATE TABLE IF NOT EXISTS MYDB.users ( userid  VARCHAR(45) NOT NULL, password  VARCHAR(45) NULL,firstname VARCHAR(45) NOT NULL,lastname  VARCHAR(45) NULL,  email     VARCHAR(45) NULL,  desig  VARCHAR(45) NULL,  phone  varchar(10) NULL,PRIMARY KEY (userid));";
	    jdbcTemplate.execute(sql);
        sql = "select * from  MYDB.users where userid='" + change.getUserid() + "' and password='" + change.getPassword()
        + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        if(users.size() > 0 )
        {   	 users.get(0).setPassword(change.getNewPassword());
    	sql="UPDATE MYDB.users SET password ='"+change.getNewPassword()+"' where userid='"+change.getUserid()+"'";
	    jdbcTemplate.execute(sql);
             return users.get(0);
    }
        	 else
        		 return null;
        }
    public List<User> viewemployees(Login login)
    {String sql="CREATE SCHEMA IF NOT EXISTS MYDB;"+"CREATE TABLE IF NOT EXISTS MYDB.users ( userid  VARCHAR(45) NOT NULL, password  VARCHAR(45) NULL,firstname VARCHAR(45) NOT NULL,lastname  VARCHAR(45) NULL,  email     VARCHAR(45) NULL,  desig  VARCHAR(45) NULL,  phone  varchar(10) NULL,PRIMARY KEY (userid));";
    jdbcTemplate.execute(sql);
    sql = "select * from  MYDB.users where userid='" + login.getUserid() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    if(users.size() <= 0 )
    	return null;
    else
    { sql = "select * from  MYDB.users;";
     users = jdbcTemplate.query(sql, new UserMapper());
    	return users;
    }
    	
    	
    }

  }
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUserid(rs.getString("userid"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setDesig(rs.getString("desig"));
    user.setPhone(rs.getString("phone"));
    return user;
  }
 
}
