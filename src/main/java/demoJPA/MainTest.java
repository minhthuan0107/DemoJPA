package demoJPA;

import config.Springconfig;
import entity.OrderDetails;
import entity.Orders;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrdersRepository;
import repository.OrdertailsRepository;

import javax.persistence.criteria.Order;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class MainTest {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Springconfig.class);
    static OrdersRepository ordersRepository = (OrdersRepository) context.getBean("ordersRepository");
    static OrdertailsRepository ordertailsRepository = (OrdertailsRepository) context.getBean("ordertailsRepository");

    private static Orders createNewOders() {
        Orders orders = new Orders();
        orders.setOrderDate(LocalDate.parse("2023-12-21"));
        orders.setCustomerName("Minh Thuan ");
        orders.setCustomerAddress("Ha Noi");

        Orders result = ordersRepository.save(orders);
        if (result != null) {
            System.out.println(" Orders thêm thành công, ID=" + orders.getId());
        }
        return orders;
    }

    private static OrderDetails createNewOdersDetails() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProductName("Ao");
        orderDetails.setQuantity(2);
        orderDetails.setUnitPrice(30000.0);
        OrderDetails result = ordertailsRepository.save(orderDetails);
        if (result != null) {
            System.out.println(" orderDetails thêm thành cong, ID=" + orderDetails.getId());
        }
        return orderDetails;
    }

    public static void createNewOrderDetailWithNewOrder() {
        Orders orders = createNewOders();
        ordersRepository.save(orders);
        System.out.println("A new order saved successfully,order ID = " + orders.getId());

        OrderDetails orderDetails = createNewOdersDetails();
        orderDetails.setOrders(orders);
        ordertailsRepository.save(orderDetails);
        System.out.println("A new order details saved successfully,order details ID = " + orderDetails.getId());
    }

    public static void findAllOrders() {
        List<Orders> orders = (List<Orders>) ordersRepository.findAll();
        if (orders != null) {
            System.out.println("Find All order:");
            for (Orders orders1 : orders) {
                System.out.println(orders1.toString());
            }
        }
    }
        public static void findAllOrdersDetails() {
            List<OrderDetails> ordersDetails = (List<OrderDetails>) ordertailsRepository.findAll();
            if (ordersDetails != null) {
                System.out.println("Find All orderdertails:");
                for (OrderDetails orderrdetail : ordersDetails) {
                    System.out.println(orderrdetail.toString());
                }
            }
        }
    public static void getAllOrdersInCurrentMonth() {
        // Lấy ngày đầu tháng
        LocalDate startOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        // Lấy ngày cuối tháng
        LocalDate endOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        List<Orders> order1 = (List<Orders>) ordersRepository.findByOrderDateBetween(startOfMonth,endOfMonth);
        if (order1 != null) {
            System.out.println("Find All order in currentmonth:");
            for (Orders order : order1) {
                System.out.println(order.toString());
            }
        }
    }
    public static void getAllOrdersTotalAmount() {
        double amountThreshold = 1000.0;
        List<OrderDetails> orderDetails2 = (List<OrderDetails>) ordertailsRepository.findByUnitPriceGreaterThan(amountThreshold);
        if (orderDetails2 != null) {
            System.out.println("Find All order in TotalAmount:");
            for (OrderDetails orderDetails : orderDetails2) {
                System.out.println(orderDetails.toString());
            }
        }
    }
    public static void getOrdersContainingQuan(){
        String javaName = "Quan";
        List<OrderDetails> orderDetails3 = (List<OrderDetails>) ordertailsRepository.findByProductNameContaining(javaName);
        if (orderDetails3 != null) {
            System.out.println("Find All orders in name Quan:");
            for (OrderDetails orderDetails : orderDetails3) {
                System.out.println(orderDetails.toString());
            }
        }
    }
    public  static  void getOderId(){
        Orders orders = (Orders)  ordersRepository.findById(2);
        if (orders != null) {
            System.out.println(orders.getOrderDetails());

        }
    }
    public static void main(String[] args) {
        //createNewOrderDetailWithNewOrder();
        //findAllOrders();
        //findAllOrdersDetails();
        //getAllOrdersInCurrentMonth();
        //getAllOrdersTotalAmount();
        //getOrdersContainingQuan();
        getOderId();
    }
}
