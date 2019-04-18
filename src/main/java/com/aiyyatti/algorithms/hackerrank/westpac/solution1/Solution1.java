package com.aiyyatti.algorithms.hackerrank.westpac.solution1;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution1 {
    public static void main(String args[]) throws Exception {
        String str = "111 AAPL BUY 10000\n" +
                "222 AAPL BUY 20000\n" +
                "333 AAPL SELL 100000";
        Scanner scanner = new Scanner(new ByteArrayInputStream(str.getBytes()));
        ArrayList<Order> orders = new ArrayList<>();
        String output = "";
        while (scanner.hasNext()) {
            String[] parts = scanner.nextLine().split(" ");
            Order newOrder = new Order(parts);
            long diff = newOrder.getSide();
            List<Order> markedForRemoval = new ArrayList<>();
            List<Order> matches = new LinkedList<>();
            order_match:
            for (int i = 0; i < orders.size(); i++) {
                Order oldOrder = orders.get(i);
                if (oldOrder.product.equals(newOrder.product) && oldOrder.customerSide != newOrder.customerSide) {
                    matches.add(oldOrder);
                    diff -= oldOrder.side;
                    if (diff < 0) {
                        oldOrder.setSide(-1 * diff);
                        break order_match;
                    } else if (diff >= 0) {
                        markedForRemoval.add(oldOrder);
                    }
                }
            }
            for (int i = 0; i < markedForRemoval.size(); i++) orders.remove(markedForRemoval.get(i));
            if (diff > 0) {
                newOrder.setSide(diff);
                orders.add(newOrder);
            }
            output += matches.size() + " matches: " + matches.stream().map(n -> n.getOrderId().toString()).collect(Collectors.joining(",")) + "\n";
        }
        System.out.println(output);
    }

    static class Order {
        Long orderId;
        String product;
        CustomerSide customerSide;
        Long side;

        public Order(long orderId, String product, CustomerSide customerSide, long side) {
            this.orderId = orderId;
            this.product = product;
            this.customerSide = customerSide;
            this.side = side;
        }

        public Order(String[] input) {
            this.orderId = Long.valueOf(input[0]);
            this.product = input[1];
            this.customerSide = CustomerSide.valueOf(input[2]);
            this.side = Long.valueOf(input[3]);
        }

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public CustomerSide getCustomerSide() {
            return customerSide;
        }

        public void setCustomerSide(CustomerSide customerSide) {
            this.customerSide = customerSide;
        }

        public Long getSide() {
            return side;
        }

        public void setSide(Long side) {
            this.side = side;
        }

        @Override
        public String toString() {
            return "\nOrder{" +
                    "orderId=" + orderId +
                    ", product='" + product + '\'' +
                    ", customerSide=" + customerSide +
                    ", side=" + side +
                    '}';
        }
    }

    enum CustomerSide {
        BUY, SELL
    }
}

