package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.product.HappysysComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentMapper extends BaseMapper<HappysysComment> {

    List<Map<String,Object>> getCommentAndUserByProductId(@Param("productId") Integer productId, IPage page);

}
