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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mrmodise on 2017/07/13.
 */
public class OrderBOImplTest {

    @Mock
    OrderDAO orderDAO;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
        OrderBOImpl orderBO = new OrderBOImpl();
        orderBO.setOrderDAO(orderDAO);

        Order order = new Order();
        // setup expectation
        when(orderDAO.createOrder(order)).thenReturn(new Integer(1));

        boolean result = orderBO.placeOrder(order);

        // verify the results
        assertTrue(result);
        verify(orderDAO).createOrder(order);
    }
}
