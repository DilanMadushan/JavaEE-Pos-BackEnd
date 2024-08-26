package org.example.javeeepos.bo;

import org.example.javeeepos.dto.OrderDetailsDto;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderDetailsBo {
    boolean saveOrderDetails(OrderDetailsDto orderDetailsDto) throws SQLException, NamingException;
}
