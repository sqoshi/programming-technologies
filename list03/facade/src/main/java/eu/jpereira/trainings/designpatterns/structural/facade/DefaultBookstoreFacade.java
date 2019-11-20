package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

public  class DefaultBookstoreFacade implements BookstoreFacade {
    private CustomerDBService customerService;
    private BookDBService bookService;
    private OrderingService orderingService;
    private WharehouseService warehouseService;
    private CustomerNotificationService customerNotificationService;

    @Override
    public void placeOrder(String customerId, String isbn) {
        Book book = bookService.findBookByISBN(isbn);
        Customer customer = customerService.findCustomerById(customerId);
        Order order = orderingService.createOrder(customer, book);
        DispatchReceipt dummyDispatchReceipt = warehouseService.dispatch(order);

        customerNotificationService.notifyClient(order);
        customerNotificationService.notifyClient(dummyDispatchReceipt);
    }

    @Override
    public void setCustomerService(CustomerDBService customerService) {
        this.customerService = customerService;

    }

    @Override
    public void setBookService(BookDBService bookService) {
        this.bookService = bookService;

    }

    @Override
    public void setOrderingService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @Override
    public void setWarehouseService(WharehouseService warehouseService) {
        this.warehouseService = warehouseService;

    }

    @Override
    public void setNotificationService(CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;

    }
}