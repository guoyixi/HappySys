package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.product.HappysysInsurance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsuranceMapper extends BaseMapper<HappysysInsurance> {

    List<HappysysInsurance> getInsuranceByOrderId(@Param("orderId") Integer orderId);


}
