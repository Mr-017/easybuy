package com.hisoft.easybuy.javabeen.util;


import com.hisoft.easybuy.javabeen.entity.Order;
import com.hisoft.easybuy.javabeen.entity.OrderDetail;

import java.io.Serializable;
import java.util.List;


/**
 * Created by wlg on 2018/4/23.
 */
public class OrderVo implements Serializable {
    private Order order;
    private List<OrderDetail> orderDetailList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
