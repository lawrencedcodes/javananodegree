import java.time.LocalDateTime;

@Service
public class DeliveryService {
    DeliveryMapper deliveryMapper;
    OrderService orderService;

    public DeliveryService(DeliveryMapper deliveryMapper, OrderService orderService) {
        this.deliveryMapper = deliveryMapper;
        this.orderService = orderService;
    }

    public Delivery scheduleDelivery(LocalDateTime time, Integer orderId) {
        if(time.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot schedule a delivery in the past");
        }
        if(orderService.getTacos(orderId).size() <= 0) {
            throw new IllegalArgumentException("Cannot schedule a delivery for 0 tacos. Why would you do that??");
        }
        System.out.println("Scheduling a Delivery");
        Delivery delivery = new Delivery();
        delivery.setTime(Timestamp.valueOf(time));
        delivery.setOrderId(orderId);
        Integer id = deliveryMapper.insert(delivery);
        delivery.setOrderId(id);
        return delivery;
    }

    public Delivery findDelivery(Integer deliveryId) {
        return deliveryMapper.findDelivery(deliveryId);
    }

    public List<TacoOrder> findTacos(Integer deliveryId) {
        return deliveryMapper.findTacosForDelivery(deliveryId);
    }
}

    @Test
    void testScheduleDelivery() {
        TacoOrder tacos = new TacoOrder();
        tacos.setTacoName("Fish Fiesta");
        tacos.setCount(3);
        tacos.setTacoPrice(3.33);
        orderService.addItemToOrder(tacos, ORDER_ID);

        deliveryService.scheduleDelivery(LocalDateTime.now().plusHours(1), ORDER_ID);
        Delivery delivery = deliveryService.findDelivery(ORDER_ID);

        Assertions.assertEquals(ORDER_ID, delivery.getOrderId());
        Assertions.assertArrayEquals(new TacoOrder[]{tacos},
                deliveryService.findTacos(delivery.getOrderId()).toArray());
    }