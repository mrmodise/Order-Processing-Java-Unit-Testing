package com.mrmodise.exception;

import java.sql.SQLException;

/**
 * Created by mrmodise on 2017/07/13.
 */
public class BOException extends Exception {

    public BOException(SQLException e) {
        super(e);
    }
}
