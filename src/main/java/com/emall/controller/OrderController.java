package com.emall.controller;

import com.emall.dataobject.OrderItemDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 返回所有订单信息
     * @return
     */
    @RequestMapping(value = "/getAllOrder",method = RequestMethod.GET)
    public CommonReturnType getAllOrder(){
        List<OrderDO> list = null;
        try{
            list = orderService.getAllOrder();
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create(list);
    }

    /**
     * 获得订单的详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    public CommonReturnType getOrderDetail(@RequestParam(value = "orderId") String orderId){
        List<OrderItemDO> list = null;
        try{
            list = orderService.getOrderDetail(orderId);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create(list);
    }

    /**
     * 更新订单的状态
     * @param orderId
     * @param status
     * @return
     */
    @RequestMapping(value = "/updateStatus",method = RequestMethod.GET)
    public CommonReturnType updateOrderStatus(@RequestParam(value = "orderId") String orderId,
                                              @RequestParam(value = "status") int status){
        try{
            orderService.updateOrderStatus(orderId,status);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("订单状态更新成功");
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    public CommonReturnType deleteOrder(@RequestParam(value = "orderId") String orderId){
        try{
            orderService.deleteOrder(orderId);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("订单删除成功");
    }
}
