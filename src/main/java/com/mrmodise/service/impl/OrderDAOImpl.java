package com.mrmodise.service.impl;

import com.mrmodise.domain.Order;
import com.mrmodise.service.OrderDAO;

import java.sql.SQLException;

/**
 * Created by mrmodise on 2017/07/13.
 */
public class OrderDAOImpl implements OrderDAO {

    private OrderDAO orderDAO;

    public int createOrder(Order order) throws SQLException {
        orderDAO.createOrder(order);
        return 1;
    }

    public Order readOrder(int orderID) throws SQLException {
        return null;
    }

    public int updateOrder(Order order) throws SQLException {
        return 0;
    }

    public int deleteOrder(int orderID) throws SQLException {
        return 0;
    }
}
