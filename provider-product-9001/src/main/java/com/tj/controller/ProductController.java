package com.tj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysDeadline;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;
import com.tj.product.HappysysProduct;
import com.tj.service.CommonProblemService;
import com.tj.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommonProblemService commonProblemService;

    @Autowired
    private MongoTemplate mongoTemplate;



    @RequestMapping("/HappysysProduct/getById/{productId}")
    public HappysysProduct getById(@PathVariable Integer productId){
        System.out.println("ProductController      getProductById");

        //根据ID查询商品
        HappysysProduct product = productService.getById(productId);
        //根据ID查询期限
        product.setProductDeadlineList(productService.getDeadline(productId));
        //根据ID查询年龄
        product.setProductSectionList(productService.getSection(productId));
        //根据ID查询特色
        product.setProductFeatureList(productService.getFeature(productId));
        //根据ID查询保险
        product.setProductInsuranceList(productService.getInsurance(productId));
        //根据ID查询保险保额
        product.setProductInsuranceSumList(productService.getInsuranceSum(productId));


        Double deadlinePrice = product.getProductDeadlineList().get(0).getDeadlinePrice();
        Double insuranceSumPrice = product.getProductInsuranceSumList().get(0).getInsuranceSumPrice();
        product.setProductPrice(product.getProductPrice()+deadlinePrice+insuranceSumPrice);

        //根据ID查询常见问题
        product.setProductCommonProblemList(commonProblemService.getCommonProblemByProductId(productId));

        return product;
    }


    @RequestMapping(value = "/HappysysProduct/getCaluelatePrice",method = RequestMethod.POST)
    public Double caluelatePrice(@RequestParam Map<String,Object> map){
        return productService.calculatePrice(map);
    }


    @RequestMapping(value = "/HappysysProduct/getByMap")
    public IPage<HappysysProduct> getByMap(@RequestBody(required = false) Map<String,Object> condtions){
        System.out.println("CommentController      getListComment");

        Integer currentPage = condtions.get("currentPage") == null ? 1 : Integer.parseInt(condtions.get("currentPage")+"");
        Integer size = condtions.get("size") == null ? 2 : Integer.parseInt(condtions.get("size")+"");

        IPage<HappysysProduct> productPage = productService.getByMap(condtions,currentPage,size);

        System.out.println(condtions);

        return productPage;
    }


    @RequestMapping("/HappsysProduct/getFeature/{product_id}")
    public List<HappysysFeature> productsFeature(@PathVariable Integer product_id){
        System.out.println("nihao product_id"+product_id);
        List<HappysysFeature> feature = productService.getFeature(product_id);
        return feature;
    }

    @RequestMapping("/product/list/{productLevel3}/{pageIndex}")
    public IPage<HappysysProduct> productList2(@PathVariable Integer productLevel3,@PathVariable Integer pageIndex){

        Map<String,Object> map=new HashMap<>();
        map.put("product_level3",productLevel3);
        map.put("currentPage",pageIndex);
        IPage<HappysysProduct> byMap = getByMap(map);
        for (HappysysProduct hp:byMap.getRecords()) {
           hp.setProductFeatureList(productService.getFeature(hp.getProductId()));
           hp.setProductInsuranceList(productService.getInsurance(hp.getProductId()));
        }
       return byMap;
    }

    @RequestMapping("/product/duibi")
    public List<HappysysProduct> productDuibi(@RequestBody String productId){
        String [] productIds=productId.split(",");
        List<HappysysProduct> list=new ArrayList<>();
        for(int i=0;i<productIds.length;i++){
            System.out.println("aa:"+productIds[i]);
            if(productIds[i]!=null && !"".equals(productIds[i])) {
                HappysysProduct product_id = productService.getOne(new QueryWrapper<HappysysProduct>().eq("product_id", productIds[i]));
                product_id.setProductSectionList(productService.getSection(product_id.getProductId()));
                product_id.setProductDeadlineList(productService.getDeadline(product_id.getProductId()));
                product_id.setProductInsuranceList(productService.getInsurance(product_id.getProductId()));
                product_id.setCommentCount(productService.commentCount(product_id.getProductId()));
                product_id.setOrderCount(productService.OrderCount(product_id.getProductId()));
                list.add(product_id);
            }
        }

        return list;
    }

    @RequestMapping("/product/insurance/duibi")
    public List<HappysysInsurance> insuranceAll(@RequestBody Map<Object,String> map){
       return productService.insuranceAll(map);
    }

    @RequestMapping("/product/title/id")
    public String productbyidTitle (@RequestBody String title){
        System.out.println("............................"+title);
        HappysysProduct product_title = productService.getOne(new QueryWrapper<HappysysProduct>().eq("product_title", title));
        System.out.println("product_title:"+product_title.getProductId());
        return String.valueOf(product_title.getProductId());
    }
}
