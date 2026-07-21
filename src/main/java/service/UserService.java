package service;

import dao.UserDAO;

import entity.User;

public class UserService {

    private UserDAO userDAO;

    public UserService() {

        userDAO = new UserDAO();

    }

    // Đăng nhập

    public User login(String email, String password) {

        User user = userDAO.findByEmail(email);

        if (user == null) {

            return null;

        }

        if (!user.getPassword().equals(password)) {

            return null;

        }

        return user;

    }

    // Đăng ký

    public boolean register(User user) {

        User check = userDAO.findByEmail(user.getEmail());

        if (check != null) {

            return false;

        }

        userDAO.create(user);

        return true;

    }

    // Tìm user theo email

    public User findByEmail(String email) {

        return userDAO.findByEmail(email);

    }

}