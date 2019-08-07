package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ApplicantInfoMapper;
import com.tj.product.HappysysApplicantInfo;
import com.tj.service.ApplicantInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ApplicantInfoServiceImpl extends ServiceImpl<ApplicantInfoMapper, HappysysApplicantInfo> implements ApplicantInfoService {
 @Override
 public List<HappysysApplicantInfo> findrecognizee() {
  return null;
 }
}
