package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import com.ra.model.service.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/danh-muc")
public class CategoryController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            showListCategory(request,response);
        }

        switch (action) {
            case "add":
                response.sendRedirect("views/addCategory.jsp");
                break;
            case "edit":
                response.sendRedirect("views/editCategory.jsp");
                break;
            case "delete":
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            // lay du lieu
            Category cat = new Category();
            cat.setCategoryName(request.getParameter("categoryName"));
            cat.setCategoryStatus(Boolean.parseBoolean(request.getParameter("categoryStatus")));
            if (categoryService.saveOrUpdate(cat)) {
                showListCategory(request,response);
            }
            response.sendRedirect("views/addCategory.jsp?err");
        }
    }

    public void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = this.categoryService.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("views/category.jsp").forward(request,response);
    }
}