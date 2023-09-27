package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {

      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getlistUsers() {

      return userDao.getlistUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> findUserByCar(String model,int series) {
      return userDao.findUserByCar(model,series);

   }
}