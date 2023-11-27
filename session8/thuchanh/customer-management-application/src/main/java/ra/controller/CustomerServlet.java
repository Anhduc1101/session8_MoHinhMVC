package ra.controller;

import ra.model.Customer;
import ra.service.CustomerServiceIMPL;
import ra.service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer-management")
public class CustomerServlet extends HttpServlet {
    ICustomerService<Customer> customerService = new CustomerServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreateCustomer(req, resp);
                break;
            case "edit":
                actionEditCustomer(req,resp);
                break;
            default:
                break;
        }
    }


    private void actionEditCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("id"));
        String editName=req.getParameter("cusName");
        String editAdd=req.getParameter("address");
        String editEmail=req.getParameter("email");
        Customer editCus=customerService.findById(idEdit);
        editCus.setName(editName);
        editCus.setAddress(editAdd);
        editCus.setEmail(editEmail);
        customerService.save(editCus);
        showListCustomers(req,resp);
    }

    private void actionCreateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = customerService.getNewId();
        String cusName = req.getParameter("cusName");
        String cusAddress = req.getParameter("address");
        String cusEmail = req.getParameter("email");
        Customer newCus = new Customer(id, cusName, cusAddress, cusEmail);
        customerService.save(newCus);
        showListCustomers(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                handleCreateCustomer(req, resp);
                break;
            case "edit":
                handleEditCustomer(req,resp);
                break;
            case "delete":
                handleDeleteCustomer(req,resp);
                break;
            case "search":
                handleSearchCustomer(req,resp);
                break;
            case "sort":
                handleSortCustomer(req,resp);
                break;
            default:
                showListCustomers(req, resp);
                break;
        }
    }

    private void handleSortCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> cus = customerService.findAll();
        cus.sort((c1,c2)->c1.getName().compareTo(c2.getName()));
        showListCustomers(req,resp);
    }

    private void handleSearchCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("search");
        List<Customer> customerList = customerService.findByName(searchName);
        req.setAttribute("customers",customerList);
        req.setAttribute("searchName",searchName);
        req.getRequestDispatcher("customer/list.jsp").forward(req,resp);
    }

    private void handleDeleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int idDel= Integer.parseInt(req.getParameter("id"));
    customerService.deleteById(idDel);
    showListCustomers(req,resp);
    }

    private void handleEditCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int idEdit = Integer.parseInt(req.getParameter("id"));
    Customer cusEdit = customerService.findById(idEdit);
    req.setAttribute("customer",cusEdit);
    req.getRequestDispatcher("customer/edit.jsp").forward(req,resp);
    }

    private void handleCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    private void showListCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = this.customerService.findAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("customer/list.jsp").forward(req, resp);
    }
}
