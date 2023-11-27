package ra.service;

import ra.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService<Customer> {
    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "John", "john@rikkei.academy", "Hanoi"));
        customerList.add(new Customer(2, "Bill", "bill@rikkei.academy", "Danang"));
        customerList.add(new Customer(3, "Alex", "alex@rikkei.academy", "Saigon"));
        customerList.add(new Customer(4, "Adam", "adam@rikkei.academy", "Beijin"));
        customerList.add(new Customer(5, "Sophia", "sophia@rikkei.academy", "Miami"));
        customerList.add(new Customer(6, "Rose", "rose@rikkei.academy", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) == null) {
            customerList.add(customer);
        } else {
            customerList.set(customerList.indexOf(customer), customer);
        }
    }

    @Override
    public Customer findById(int id) {
        for (Customer cus : customerList) {
            if (cus.getId() == id) {
                return cus;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Customer cus : customerList) {
            if (cus.getId() > idMax) {
                idMax = cus.getId();
            }
        }
        return idMax + 1;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerSearch = new ArrayList<>();
        for (Customer cus : customerList) {
            if (cus.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                customerSearch.add(cus);
            }
        }
        return customerSearch;
    }

    @Override
    public void deleteById(int id) {
        customerList.remove(findById(id));
    }

}
