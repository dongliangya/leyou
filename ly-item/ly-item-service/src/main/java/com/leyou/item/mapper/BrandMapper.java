package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);
    /**
     * 删除商品分类和品牌中间表数据
     * @param bid 品牌id
     * @return
     */
    @Delete("DELETE FROM tb_category_brand  WHERE brand_id =#{bid}")
    int removeCategoryBrand(@Param("bid") Long bid);
    /**
     * 删除商品分类和品牌中间表数据
     * @param bid 品牌id
     * @return
     */
    @Select("SELECT C.ID,C.NAME,C.PARENT_ID,C.IS_PARENT,C.SORT FROM TB_CATEGORY C JOIN tb_category_brand CB ON C.ID=CB.CATEGORY_ID WHERE CB.BRAND_ID =#{bid}")
    List<Category> getCategoryBybid(@Param("bid") Long bid);
}
