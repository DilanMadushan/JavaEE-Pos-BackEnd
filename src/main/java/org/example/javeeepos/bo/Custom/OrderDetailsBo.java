package org.example.javeeepos.bo.Custom;

import org.example.javeeepos.bo.SuperBo;
import org.example.javeeepos.dto.OrderDetailsDto;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderDetailsBo extends SuperBo {
    boolean saveOrderDetails(OrderDetailsDto orderDetailsDto) throws SQLException, NamingException;
}
