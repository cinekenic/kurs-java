package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(InformationService informationService, OrderService orderService, OrderRepository orderRepository){
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(User user, Product product){
        boolean isOrdered = orderService.order(user, product);
        if(isOrdered){
            informationService.inform(user);
            orderRepository.createOrder(user, product);
            return new OrderDto(user, true);
        }else {
            return new OrderDto(user, false);
        }
    }
}
