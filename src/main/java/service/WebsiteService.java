package service;

import java.util.List;

import dao.WebsiteDAO;

import entity.User;

import entity.Website;

public class WebsiteService {

    private WebsiteDAO websiteDAO;

    public WebsiteService() {

        websiteDAO = new WebsiteDAO();

    }

    // Lấy tất cả website của 1 user

    public List<Website> getByUser(User user) {

        return websiteDAO.findByUser(user);

    }

    // Tạo website mới

    public void create(Website website) {

        websiteDAO.create(website);

    }

    // Cập nhật website

    public void update(Website website) {

        websiteDAO.update(website);

    }

    // Xóa website

    public void delete(Integer id) {

        websiteDAO.delete(id);

    }

    // Tìm theo ID

    public Website findById(Integer id) {

        return websiteDAO.findById(id);

    }

}
