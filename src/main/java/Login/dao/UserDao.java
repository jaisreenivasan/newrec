package Login.dao;
import java.util.List;

import Login.model.Change;
import Login.model.Login;
import Login.model.User;
public interface UserDao {
  boolean register(User user);
  boolean deleteUser(Login login);
  User validateUser(Login login);
  User validateUser(Change change);
  List<User> viewemployees(Login login);
}