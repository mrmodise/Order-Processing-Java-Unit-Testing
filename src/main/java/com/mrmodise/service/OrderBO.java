package com.mrmodise.service;

import com.mrmodise.domain.Order;
import com.mrmodise.exception.BOException;

/**
 * Created by mrmodise on 2017/07/13.
 */
public interface OrderBO {
    boolean placeOrder(Order order) throws BOException;
    boolean cancelOrder(int orderID) throws BOException;
    boolean deleteOrder(int orderID) throws BOException;
}
