package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.repositories.OrdersRepository;
import restorder.orderproduk.service.interfaces.IOrderService;

@Service
public class OrdersService implements IOrderService {
    private final OrdersRepository ordersRepository;

    @Autowired
    private OrderItemRepository orderItemsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private AddressService addressesService;
    //private final UsersService usersService;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
        //this.usersService = usersService;
    }

}
