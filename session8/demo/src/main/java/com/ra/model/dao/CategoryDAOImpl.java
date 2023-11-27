package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.util.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        connection = ConnectionDatabase.openConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("select * from category");
            // tao ra 1 tap ket qua
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }

        return categories;
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        Connection con = null;
        if (findById(category.getCategoryId()) == null) {
            try {
                con = ConnectionDatabase.openConnection();
                String sql = "insert into category (name,status) values(?,?)";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, category.getCategoryName());
                pstm.setBoolean(2, category.isCategoryStatus());
                int check = pstm.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDatabase.closeConnection(con);
            }
        } else {
            try {
                con = ConnectionDatabase.openConnection();
                String sql = "update category set name = ?,status=? where id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, category.getCategoryName());
                ps.setBoolean(2, category.isCategoryStatus());
                ps.setInt(3,category.getCategoryId());
                int check = ps.executeUpdate();
                if (check>0){
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDatabase.closeConnection(con);
            }
        }
        return false;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        connection = ConnectionDatabase.openConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("select * from category");
            // tao ra 1 tap ket qua
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
            for (Category cat : categories) {
                if (cat.getCategoryId() == integer) {
                    return cat;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

}
