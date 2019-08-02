package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysInsurance;

import java.util.List;

public interface InsuranceService extends IService<HappysysInsurance> {

    List<HappysysInsurance> getInsuranceByOrderId(Integer orderId);


}
