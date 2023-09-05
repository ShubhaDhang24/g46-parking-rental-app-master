package se.lexicon;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.impl.CustomerDaoImpl;
import se.lexicon.model.Customer;

import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        CustomerDao customerDao = CustomerDaoImpl.getInstance();

        Customer customer = new Customer("Test Testson", "123456");
        customerDao.create(customer);
        customerDao.create(new Customer("Mehrdad", "123456"));
        System.out.println(customerDao.findAll().size()); // 2

        customerDao = CustomerDaoImpl.getInstance();
        System.out.println(customerDao.findAll().size()); // 2


    }
}
