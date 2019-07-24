package com.tj.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysCategory;

import java.util.List;

public interface CategoryService extends IService<HappysysCategory> {

 public List<HappysysCategory> findCategoryAndChild(Integer parentId);

}
