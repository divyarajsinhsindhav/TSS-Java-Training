package com.tss.test;

import com.tss.model.Order;
import com.tss.model.OrderStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderTest {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, "Jayesh", "Electronics", 2, 25000.0, OrderStatus.DELIVERED));
        orders.add(new Order(2, "Jayesh", "Clothing", 5, 1200.0, OrderStatus.PENDING));
        orders.add(new Order(3, "Amit", "Electronics", 1, 55000.0, OrderStatus.SHIPPED));
        orders.add(new Order(4, "Rohit", "Clothing", 3, 1500.0, OrderStatus.DELIVERED));
        orders.add(new Order(5, "Neha", "Books", 10, 500.0, OrderStatus.DELIVERED));
        orders.add(new Order(6, "Amit", "Electronics", 4, 30000.0, OrderStatus.DELIVERED));
        orders.add(new Order(7, "Jayesh", "Books", 2, 800.0, OrderStatus.SHIPPED));
        orders.add(new Order(8, "Neha", "Clothing", 1, 2000.0, OrderStatus.PENDING));
        orders.add(new Order(9, "Rohit", "Electronics", 3, 40000.0, OrderStatus.DELIVERED));
        orders.add(new Order(10, "Amit", "Clothing", 8, 1000.0, OrderStatus.DELIVERED));

        System.out.println("Order for customer Jayesh: ");
        getOrderByName(orders, "Jayesh");

        System.out.println("\nDelivered Order: ");
        getOrderByStatus(orders, OrderStatus.DELIVERED);

        System.out.println("\nList of Categories");
        getAllCategories(orders);

        System.out.println();
        totalRevenuOfItemByStatus(orders, OrderStatus.SHIPPED);

        System.out.println();
        averageQuantityOrderedByCategory(orders, "Electronics");

        System.out.println();
        getOrderWithHighestTotalValue(orders);

        System.out.println("\nNumber of orders for every status: ");
        groupOrderByStatus(orders);

        System.out.println("\nGet customer who has more than 2 orders: ");
        filterByNumberOfOrderOfSingleCustomer(orders, 2);

        System.out.println("\nSort order by total value in descending order and print top 3 order: ");
        orderDescByTotalValue(orders);

        checkAllOrdersInCategoryLessThan(orders, 10, "Clothing");

    }

    public static void getOrderByName(List<Order> orders, String name) {
        orders.stream()
                .filter(order ->
                    order.getCustomerName().equals(name))
                .forEach(System.out::println);
    }

    public static void getOrderByStatus(List<Order> orders, OrderStatus status) {
        orders.stream()
                .filter(order -> order.getStatus() == status)
                .forEach(System.out::println);
    }

    public static void getAllCategories(List<Order> orders) {
        orders.stream()
                .map(order -> order.getProductCategory())
                .distinct()
                .forEach(System.out::println);
    }

    public static void totalRevenuOfItemByStatus(List<Order> orders, OrderStatus status) {
        double total = orders.stream()
                .filter(order -> order.getStatus() == status)
                .map(order -> order.getTotalValue())
                .reduce(0.0, Double::sum);
        System.out.println("Total Revenue for the " + status + " Order: " + total);
    }

    public static void averageQuantityOrderedByCategory(List<Order> orders, String category) {
        double average = orders.stream()
                .filter(order -> order.getProductCategory().equals(category))
                .mapToInt(order -> order.getQuantity())
                .average()
                .orElse(0.0);
        System.out.println("Average quantity of items ordered for " + category + " category: " + average);
    }

    public static void getOrderWithHighestTotalValue(List<Order> orders) {
        orders.stream()
                .max(Comparator.comparingDouble(order -> order.getTotalValue()))
                .ifPresent(System.out::println);
    }

    public static void groupOrderByStatus(List<Order> orders) {
        orders.stream()
                .collect(Collectors.groupingBy(order -> order.getStatus()))
                .forEach((status, orderCount) -> {
                    System.out.println(status + " -> " + orderCount.size());
                });
    }

    public static void filterByNumberOfOrderOfSingleCustomer(List<Order> orders, int numberOfOrders) {
        orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName))
                .entrySet()
                .stream()
                .filter(item -> item.getValue().size() > numberOfOrders)
                .forEach(orderOfCustomer -> {
                    System.out.println(orderOfCustomer.getKey() + " -> " + orderOfCustomer.getValue().size());
                });

    }

    public static void orderDescByTotalValue(List<Order> orders) {
        orders.stream()
                .sorted(Comparator.comparing(Order::getTotalValue).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    public static void checkAllOrdersInCategoryLessThan(List<Order> orders, int quantity, String category) {
        boolean flag = orders.stream()
                .filter(order -> order.getProductCategory().equals(category))
                .allMatch(order -> order.getQuantity() < quantity);
        System.out.println("\nIs all orders in Clothing category has quantity less than 10? " + flag);
    }

}
