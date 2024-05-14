package com.dao;

import com.entity.CheliangOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangOrderView;

/**
 * 车辆出租 Dao 接口
 *
 * @author 
 */
public interface CheliangOrderDao extends BaseMapper<CheliangOrderEntity> {

   List<CheliangOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
