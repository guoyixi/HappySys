package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysPoduct;
import net.sf.jsqlparser.expression.operators.relational.OldOracleJoinBinaryExpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper extends BaseMapper<HappysysPoduct> {


    List<HappysysPoduct> getByMap(@Param("conditions") Map<String, Object> conditions, IPage page);

}
