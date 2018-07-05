package com.hw.controller;

import com.hw.dataobject.ProductCategory;
import com.hw.dataobject.ProductInfo;
import com.hw.service.CategoryService;
import com.hw.service.ProductService;
import com.hw.utils.ResultVOUtil;
import com.hw.vo.ProductInfoVO;
import com.hw.vo.ProductVO;
import com.hw.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**json数据格式
 * Created by Administrator on 2018/6/28 0028.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
//  1.查询所有上架商品
        List <ProductInfo>  productInfoList=productService.findAll();
//  2.查询类目（一次性查询）
        List<Integer>categoryTypeLists=new ArrayList<>();
//       传统方法
/**     for (ProductInfo productInfo:productInfos) {
           categoryTypeLists.add(productInfo.getCategoryType( productInfo));
        }*/

        //精简方法(java8,lambda)
        List<Integer> categoryTypeList=productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
//  3.数据拼装
        List<ProductVO>productVOList=new ArrayList<>();
        for (ProductCategory productCategorie:productCategoryList) {
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategorie.getCategoryType());
            productVO.setCategoryName(productCategorie.getCategoryName());

            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getCategoryType().equals(productCategorie.getCategoryType())){
                     ProductInfoVO productInfoVO=new ProductInfoVO();
                     //将productInfo信息拷贝到productInfoVO中
                     BeanUtils.copyProperties(productInfo,productInfoVO);
                     productInfoVOList.add(productInfoVO);
            }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
      return ResultVOUtil.success(productVOList);
    }
}
