package com.mrmodise.service;

import com.mrmodise.domain.Order;
import java.sql.SQLException;

/**
 * Created by mrmodise on 2017/07/13.
 */
public interface OrderDAO {
    int createOrder(Order order) throws SQLException;
    Order readOrder(int orderID) throws SQLException;
    int updateOrder(Order order) throws SQLException;
    int deleteOrder(int orderID) throws SQLException;
}
