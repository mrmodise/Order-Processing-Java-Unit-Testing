package com.mrmodise.service.impl;

import com.mrmodise.domain.Order;
import com.mrmodise.service.OrderBO;
import com.mrmodise.service.OrderDAO;
import com.mrmodise.exception.BOException;

import java.sql.SQLException;

/**
 * Created by mrmodise on 2017/07/13.
 */
public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO;

    public boolean placeOrder(Order order) throws BOException {
        try {
            int result = orderDAO.createOrder(order);

            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    public boolean cancelOrder(int orderID) throws BOException {
        try {
            Order order = orderDAO.readOrder(orderID);
            order.setStatus("cancelled");
            int result = orderDAO.updateOrder(order);

            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    public boolean deleteOrder(int orderID) throws BOException {
        try {
            int result = orderDAO.deleteOrder(orderID);

            if (result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
