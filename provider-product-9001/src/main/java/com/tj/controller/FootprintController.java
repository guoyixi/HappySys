package com.tj.controller;

import com.tj.product.HappysysFootprint;
import com.tj.product.HappysysProduct;
import com.tj.service.FootprintService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FootprintController {

    @Autowired
    private FootprintService footprintService;

    @RabbitListener(queues = "queue.insert_foot_print")
    public void queueInsertFootprint(HappysysFootprint footPrint){
        System.out.println("FootprintController      queueInsertFootprint，消息队列：");
        System.out.println(footPrint);
        footprintService.save(footPrint);
    }

    @RequestMapping("/HappysysFootprint/getFootprintProductByUserId/{userId}")
    public List<HappysysProduct> getFootprintProductByUserId(@PathVariable("userId") Integer userId){
        System.out.println("FootprintController      getFootprintProductByUserId");

        return footprintService.getFootprintProductByUserId(userId);
    }


}
