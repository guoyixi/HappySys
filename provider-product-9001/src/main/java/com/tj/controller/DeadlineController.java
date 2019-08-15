package com.tj.controller;

import com.tj.product.HappysysDeadline;
import com.tj.service.DeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeadlineController {

    @Autowired
    private DeadlineService deadlineService;

    @RequestMapping("/HappysysDeadline/getAllDeadline")
    public List<HappysysDeadline> getAllDeadline(){

        return deadlineService.list();
    }

}
