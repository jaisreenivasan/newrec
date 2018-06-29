package Login.dao;
import java.util.List;

import Login.model.Change;
import Login.model.Login;
import Login.model.User;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
  User validateUser(Change change);
  List<User> viewemployees(Login login);
}