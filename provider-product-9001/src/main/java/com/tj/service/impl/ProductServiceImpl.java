package com.tj.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ProductMapper;
import com.tj.product.*;
import com.tj.service.ProductService;
import com.tj.vo.HappysysProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, HappysysProduct> implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<HappysysPayment> getPayment(Integer productId) {
        return null;
    }

    @Override
    public  Integer commentCount(Integer productId) {
        return productMapper.commentCount(productId);
    }

    @Override
    public List<HappysysInsurance> insuranceAll(Map<Object, String> map) {
        return productMapper.insuranceAll(map);
    }

    @Override
    public  Integer OrderCount(Integer productId) {
        return productMapper.OrderCount(productId);
    }

    @Override
    public IPage<HappysysProduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size){
        IPage page = new Page<>(currentPage,size);

        IPage<HappysysProduct> resultPage = new Page<>();
        resultPage = page;
        resultPage.setRecords(productMapper.getByMap(conditons,page));
        return resultPage;
    }


    @Override
    public List<HappysysDeadline> getDeadline(Integer productId) {
        return productMapper.getDeadline(productId);
    }
    @Override
    public List<HappysysSection> getSection(Integer productId) {
        return productMapper.getSection(productId);
    }
    @Override
    public List<HappysysFeature> getFeature(Integer productId){
       return productMapper.getFeature(productId);
    }
    @Override
    public List<HappysysInsurance> getInsurance(Integer productId){
       return productMapper.getInsurance(productId);
    }
    @Override
    public List<HappysysInsuranceSum> getInsuranceSum(Integer productId) {
        return productMapper.getInsuranceSum(productId);
    }

    @Override
    public Double calculatePrice(Map<String, Object> map) {
        return productMapper.calculatePrice(map);
    }

    @Override
    public List<HappysysSection> findListidSection(Integer sectionListid) {
        return productMapper.findListidSection(sectionListid);
    }

    @Override
    public List<HappysysDeadline> findListidDeadline(Integer deadlineListid) {
        return productMapper.findListidDeadline(deadlineListid);
    }

    @Override
    public List<HappysysFeature> findFeatureListid(Integer findfeaturelistid) {
        return productMapper.findFeatureListid(findfeaturelistid);
    }

    @Override
    public List<HappysysInsuranceList> showAllInsuranceList() {
        return productMapper.showAllInsuranceList();
    }

    @Override
    public List<HappysysInsuranceSum> findinsurancesum(Integer insurancesumListid) {
        return productMapper.findinsurancesum(insurancesumListid);
    }

    @Override
    public List<HappysysInsurance> findInsuranceListid(Integer findinsurancetListid) {
        return productMapper.findInsuranceListid(findinsurancetListid);
    }

    @Override
    public boolean productinsert(HappysysProductVo productvo) {
            return productMapper.productinsert(productvo);
    }
}
