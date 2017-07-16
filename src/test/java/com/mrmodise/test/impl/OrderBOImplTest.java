package com.mrmodise.test.impl;

import com.mrmodise.service.impl.OrderBOImpl;
import com.mrmodise.service.OrderDAO;
import com.mrmodise.domain.Order;
import com.mrmodise.exception.BOException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mrmodise on 2017/07/13.
 */
public class OrderBOImplTest {

    @Mock
    OrderDAO orderDAO;
    OrderBOImpl orderBO;
    Order order;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        orderBO = new OrderBOImpl();
        orderBO.setOrderDAO(orderDAO);
        order = new Order();
    }

    @Test
    public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
        // setup expectation
        when(orderDAO.createOrder(order)).thenReturn(new Integer(1));
        boolean result = orderBO.placeOrder(order);
        // verify the results
        assertTrue(result);
        verify(orderDAO).createOrder(order);
    }

    @Test
    public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
        // setup expectation
        when(orderDAO.createOrder(order)).thenReturn(new Integer(0));
        boolean result = orderBO.placeOrder(order);
        // verify the results
        assertFalse(result);
        verify(orderDAO).createOrder(order);
    }

    @Test(expected = BOException.class)
    public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
        // setup expectation to throw BO exception
        when(orderDAO.createOrder(order)).thenThrow(SQLException.class);
        // place an order
        orderBO.placeOrder(order);
    }

    @Test
    public void cancelOrder_Should_Cancel_Order() throws SQLException, BOException {
        // setup expectation to throw BO exception
        when(orderDAO.readOrder(123)).thenReturn(order);
        when(orderDAO.updateOrder(order)).thenReturn(1);
        boolean result = orderBO.cancelOrder(123);
        assertTrue(result);
        verify(orderDAO).readOrder(123);
        verify(orderDAO).updateOrder(order);
    }

    @Test
    public void cancelOrder_Should_Not_Cancel_Order() throws SQLException, BOException {
        // setup expectation to throw BO exception
        when(orderDAO.readOrder(123)).thenReturn(order);
        when(orderDAO.updateOrder(order)).thenReturn(0);
        boolean result = orderBO.cancelOrder(123);
        assertFalse(result);
        verify(orderDAO).readOrder(123);
        verify(orderDAO).updateOrder(order);
    }

    @Test(expected = BOException.class)
    public void cancelOrder_Should_Throw_SQL_Exception_On_Read() throws SQLException, BOException {
        // setup expectation to throw BO exception
        when(orderDAO.readOrder(123)).thenThrow(SQLException.class);
        orderBO.cancelOrder(123);
    }

    @Test(expected = BOException.class)
    public void cancelOrder_Should_Throw_SQLException_On_Update() throws SQLException, BOException {
        // setup expectation to throw BO exception
        when(orderDAO.readOrder(123)).thenReturn(order);
        when(orderDAO.updateOrder(order)).thenThrow(SQLException.class);
        orderBO.cancelOrder(123);
    }

    @Test
    public void deleteOrder_Should_Delete_An_Order() throws SQLException, BOException {
        // setup expectation
        when(orderDAO.deleteOrder(123)).thenReturn(new Integer(1));
        boolean result = orderBO.deleteOrder(123);
        // verify the results
        assertTrue(result);
        verify(orderDAO).deleteOrder(123);
    }

    @Test
    public void deleteOrder_Should_Not_Delete_An_Order() throws SQLException, BOException {
        // setup expectation
        when(orderDAO.deleteOrder(123)).thenReturn(new Integer(0));
        boolean result = orderBO.deleteOrder(123);
        // verify the results
        assertFalse(result);
        verify(orderDAO).deleteOrder(123);
    }

    @Test(expected = BOException.class)
    public void deleteOrder_Should_Throw_SQLException() throws SQLException, BOException {
        // setup expectation to throw BO exception
        when(orderDAO.deleteOrder(123)).thenThrow(SQLException.class);
        // place an order
        orderBO.deleteOrder(123);
    }
}
