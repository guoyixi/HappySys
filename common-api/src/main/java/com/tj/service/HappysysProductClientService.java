package com.tj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.*;
import com.tj.vo.HappysysProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient("HAPPY-PRODUCT")
public interface HappysysProductClientService {

    /**
     * @param productId     商品id
     * @return              根据商品id查询商品
     */
    @RequestMapping("/HappysysProduct/getById/{productId}")
    HappysysProduct getProductById(@PathVariable("productId") Integer productId);


    /**
     * @param productId
     * @return              根据productId商品的所有常见问题
     */
    @RequestMapping("/HappysysCommonProblem/getByProductId/{productId}")
    List<HappysysCommonProblem> getCommonProblemByProductId(@PathVariable("productId") Integer productId);


    /**
     * @param productId     商品id
     * @param currentPage   当前页
     * @param size          显示数量（ps：pageSize）
     * @return              返回page信息，和评论+用户的Map<String,Object>
     */
    @RequestMapping("/HappysysComment/getList/{productId}/{currentPage}/{size}")
    Page<Map<String,Object>> getCommentAndUserByProductId(
            @PathVariable("productId") Integer productId,
            @PathVariable(value = "currentPage") Integer currentPage,
            @PathVariable(value = "size") Integer size);

    @RequestMapping("/HappysysComment/addComment")
    @ResponseBody
    boolean addComment(@RequestBody HappysysComment comment);



    /* *
     * @param condtions     条件map 要加条件把键值put即可 然后就去product_mapper.xml中加条件
     *                       (ps：现已有：product_level1、product_level2、product_level3、shopping_cart_user_id
     *                                  、currentPage:默认为1、size:默认为6、  )
     * @return              返回page信息，和商品list
     */
    @RequestMapping(value = "/HappysysProduct/getByMap")
    Page<HappysysProduct> getProductByMap(@RequestBody(required = false) Map<String,Object> condtions);


    /**
     *
     * @param categoryId 分类ID
     * @return 返回子集
     */
    @RequestMapping(value = "/HappysysCategory/get/{id}",method = RequestMethod.GET)
    List<HappysysCategory> getCategoryById(@PathVariable("id") Integer categoryId);

    /**
     *
     * @return 递归查询所有分类
     */
    @RequestMapping(value = "/HappysysCategory/list",method = RequestMethod.GET)
    List<HappysysCategory> getCategoryAll();

    /**
     *
     * @param happysysCategory 需要添加的对象
     * @return 是否添加成功
     */
    @RequestMapping(value = "/HappysysCategory/add",method = RequestMethod.POST)
    boolean addCategory(HappysysCategory happysysCategory);

    /**
     *-
     * @param map 价格条件集合
     * @return 用户选择不同标签计算后的价格
     */
    @RequestMapping(value = "/HappysysProduct/getCaluelatePrice",method = RequestMethod.POST)
    public Double calculatePrice(@RequestBody Map<String,Object> map);


    /**
     *
     * @return 保险快选分类
     */
    @RequestMapping("/classify/list")
    List<HappysysClassify> classifyList();

    /**
     *
     * @param product_id
     * @return 保险特色集合
     */
    @RequestMapping(value = "/HappsysProduct/getFeature/{product_id}")
    List<HappysysFeature> productFeature(@PathVariable("product_id") Integer product_id);

    /**
     *
     * @param productLevel3
     * @param pageIndex
     * @return 查询所有商品列表
     */
    @RequestMapping("/product/list/{productLevel3}/{pageIndex}")
    Page<HappysysProduct> productList2(@PathVariable("productLevel3") Integer productLevel3,@PathVariable("pageIndex") Integer pageIndex);
    /**
     *                          根据购物车id删除单条购物车记录
     * @param shoppingCartId    购物车id
     * @return                  返回是否成功
     */
    @RequestMapping(value = "/HappysysShoppingCart/delShoppingCartByShoppingCartId/{shoppingCartId}")
    boolean delShoppingCartByShoppingCartId(@PathVariable("shoppingCartId") Integer shoppingCartId);

    /**
     *                      根据productId和userId删除购物车
     * @param productId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/HappysysShoppingCart/delShoppingCartByProductIdAndUserId/{productId}/{userId}")
    boolean delShoppingCartByProductIdAndUserId(@PathVariable("productId") Integer productId,@PathVariable("userId") Integer userId);


    /**
     *                      检测用户是否已经把此商品加入了购物车
     * @param productId
     * @param userId
     * @return              返回是否成功
     */
    @RequestMapping("/HappysysShoppingCart/getShoppingCartByProductIdAndUserId/{productId}/{userId}")
    HappysysShoppingCart getShoppingCartByProductIdAndUserId(@PathVariable("productId")Integer productId,@PathVariable("userId") Integer userId);

    /**
     *                          用户加入购物车（插入数据库）
     * @param shoppingCart
     * @return                  返回是否成功
     */
    @RequestMapping("/HappysysShoppingCart/addShoppingCart")
    boolean addShoppingCart(HappysysShoppingCart shoppingCart);
    /**
     * 获取一级和三级名称
     * @param productLevel3
     * @return
     */
    @RequestMapping(value = "/category/yi/er/{productLevel3}")
    HashMap<String,Object> categoryOneTow(@PathVariable("productLevel3") Integer productLevel3);

    /**
     * @param orderId
     * @return              根据orderId查询order详情
     */
    @RequestMapping("/HappysysOrder/getOrderByOrderId/{orderId}")
    Map<String,Object> getOrderByOrderId(@PathVariable("orderId") Integer orderId);


    /**
     * @param productId
     * @return              根据productId查询销量
     */
    @RequestMapping("/HappysysOrder/getOrderCountByProductId/{productId}")
    Integer getOrderCountByProductId(@PathVariable("productId") Integer productId);
    
    /**
     * --------------------------------投保人/被保人-------------------------------
     */

    /**
     * @param applicantIds
     * @return                  根据applicantId 列表查询list
     */
    @RequestMapping("/HappysysApplicantInfo/getApplicantByIds")
    List<HappysysApplicantInfo> getApplicantByIds(List<Integer> applicantIds);

    /**
     *查询此用户的所有被保人
     * @param userId
     * @return
     */
    @RequestMapping("/HappysysApplicantInfo/getApplicantByUserId")
    List<HappysysApplicantInfo> getApplicantByUserId(@RequestParam("userId") Integer userId);

    /**
     *查询投保人 Just One
     * @param applicantId
     * @return
     */
    @RequestMapping("/HappysysApplicantInfo/getApplicantByApplicatnId")
    HappysysApplicantInfo getApplicantByApplicatnId(@RequestParam("applicantId") Integer applicantId);

    /**
     *                          根据id删除投保人或被保人
     * @param applicantId
     * @return
     */
    @RequestMapping("/HappysysApplicantInfo/delApplicantById")
    Boolean delApplicantById(@RequestParam("applicantId") Integer applicantId);


    /**
     *  ApplicantInfo的插改操作
     * @param happysysApplicantInfoModel
     * @return
     */
    @RequestMapping(value = "/HappysysApplicantInfo/operationApplicationInfo",method = RequestMethod.POST)
    Integer[] operationApplicationInfo(@RequestBody HappysysApplicantInfoModel happysysApplicantInfoModel);


    /**
     * --------------------------------订单-------------------------------
     */

    /**
     * 根据订单Id查询订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("/HappysysOrder/getInsuranceByOrderId/{orderId}")
    List<HappysysInsurance> getInsuranceByOrderId(@PathVariable("orderId") Integer orderId);

    /**
     * @param userId
     * @return              返回指定user的：（总订单数、待支付、待生效、生效中、即将过期、已过期、待评论） 各项的数量
     */
    @RequestMapping("/HappysysOrder/getAllOrderStatusNumByUserId/{userId}")
    Map<String,Object> getAllOrderStatusNumByUserId(@PathVariable("userId") Integer userId);

    /**
     * @return              根据userId查询所有订单list
     */
    @RequestMapping("/HappysysOrder/getOrderByMap")
    List<Map<String,Object>> getOrderByMap(@RequestParam Map<String,Object> conditions);

    /**
     * 添加订单
     * @param order
     * @return
     */
    @RequestMapping(value = "/HappysysOrder/insertOrder",method = RequestMethod.POST)
    Integer insertOrder(@RequestBody HappysysOrder order);

    /**
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/HappysysOrder/updateOrder",method = RequestMethod.POST)
    boolean updateOrder(@RequestBody HappysysOrder order);

    /**
     * 插入订单详情
     * @param happysysOrderDetails
     * @return
     */
    @RequestMapping(value = "/HappysysOrder/insertOrderDetails",method = RequestMethod.POST)
    Boolean insertOrderDetails(@RequestBody Collection<HappysysOrderDetails> happysysOrderDetails);

    @RequestMapping(value = "/HappysysOrder/loadOrderList",method = RequestMethod.POST)
    Page<HappysysOrder> loadOrderList(@RequestBody Map<String,Object> map,@RequestParam("currentPage") Integer currentPage,@RequestParam("size")  Integer size);



    /**
     * 商品对比
     * @param productId
     * @return
     */
    @RequestMapping(value="/product/duibi")
    List<HappysysProduct> productDuibi(@RequestBody String productIds);
    /**
     * 查询多个商品的保障去重复值
     * @param map
     * @return
     */
    @RequestMapping("/product/insurance/duibi")
    List<HappysysInsurance> insuranceAll(@Param("conditions") Map<Object,String> map);

    @RequestMapping("/product/title/id")
    String productbyidTitle (String title);


     /**
     * @param userId
     * @return              根据userId查询此用户的访问商品足迹
     */
    @RequestMapping("/HappysysFootprint/getFootprintProductByUserId/{userId}")
    List<HappysysProduct> getFootprintProductByUserId(@PathVariable("userId") Integer userId);





    @RequestMapping("/ajax/productlist/{pageIndex}/{productnamelike}")
    Page<Map<String,Object>> showProductAll(@PathVariable(value = "pageIndex") Integer pageIndex,@PathVariable(value = "productnamelike") String productnamelike);

    /**
     * 查sectionlist表
     * @return
     */
    @RequestMapping("/ajax/section")
    List<HappysysSectionList> showSectionAll();


    @RequestMapping("/ajax/findsectionListId")
    List<HappysysSection> findlistidSection(@Param("SectionListid") Integer SectionListid);

    @RequestMapping("/ajax/sectionList")
    List<HappysysDeadlineList> showalldealineList();
    @RequestMapping("/ajax/findlistiddeadline")
    List<HappysysDeadline> findlistiddeadline(Integer deadlineListid);
    @RequestMapping("/ajax/findlistshowInsuranceSumList")
    List<HappysysInsuranceSumList> showAllInsuranceSumList();
    @RequestMapping("/findinsurancesumlistid")
    List<HappysysInsuranceSum> findInsurancesSum(Integer findinsurancesumlistid);
    @RequestMapping("/ajax/showAllFeatureList")
    List<HappysysFeatureList> showAllFeatureList();
    @RequestMapping("/findfeatureListId")
    List<HappysysFeature> findfeaturelistid(Integer featruelistid);
    @RequestMapping("/showAllInsuranceSumList")
    List<HappysysInsuranceList> showAllInsuranceList();
    @RequestMapping("/findinsurancetListid")
    List<HappysysInsurance> findinsurancetid(Integer findinsurancetListid);
    @RequestMapping("/findcategory/parentid/{parentid}")
    List<HappysysCategory> findcategoryparentId(@PathVariable(value="parentid") Integer parentid);
    @RequestMapping("/add/product")
    boolean addproduct( HappysysProductVo hprodouct);


    @RequestMapping("/HappysysSection/getAllSection")
    List<HappysysSection> getAllSection();
    @RequestMapping("/HappysysSection/addSection")
    Boolean addSection(@RequestBody HappysysSection section);

    @RequestMapping("/HappysysDeadline/getAllDeadline")
    List<HappysysDeadline> getAllDeadline();

    @RequestMapping("/HappysysOrder/getAllInsuranceSum")
    List<HappysysInsuranceSum> getAllInsuranceSum();

    @RequestMapping("/HappysysDeadline/getAllFeature")
    List<HappysysFeature> getAllFeature();

    @RequestMapping("/HappysysOrder/addInsuranceList")
    Boolean addInsuranceList(@RequestBody HappysysInsuranceList insurance);
    @RequestMapping("/HappysysOrder/getAllInsurance")
    List<HappysysInsurance> getAllInsurance();
    @RequestMapping("/HappysysOrder/addInsurance")
    Boolean addInsurance(@RequestBody HappysysInsurance insurance);

}
