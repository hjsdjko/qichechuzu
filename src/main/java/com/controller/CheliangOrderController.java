
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 车辆出租
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheliangOrder")
public class CheliangOrderController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangOrderController.class);

    @Autowired
    private CheliangOrderService cheliangOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CheliangService cheliangService;
    @Autowired
    private KehuService kehuService;
    @Autowired
    private YuangongService yuangongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        else if("客户".equals(role))
            params.put("kehuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = cheliangOrderService.queryPage(params);

        //字典表数据转换
        List<CheliangOrderView> list =(List<CheliangOrderView>)page.getList();
        for(CheliangOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheliangOrderEntity cheliangOrder = cheliangOrderService.selectById(id);
        if(cheliangOrder !=null){
            //entity转view
            CheliangOrderView view = new CheliangOrderView();
            BeanUtils.copyProperties( cheliangOrder , view );//把实体数据重构到view中

                //级联表
                CheliangEntity cheliang = cheliangService.selectById(cheliangOrder.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                }
                //级联表
                KehuEntity kehu = kehuService.selectById(cheliangOrder.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(cheliangOrder.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangOrderEntity cheliangOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliangOrder:{}",this.getClass().getName(),cheliangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            cheliangOrder.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("客户".equals(role))
            cheliangOrder.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


        CheliangEntity cheliangEntity = cheliangService.selectById(cheliangOrder.getCheliangId());
        if(cheliangEntity == null || cheliangEntity.getCheliangNewJiage() == null){
            return R.error("查不到车辆或者查不到车辆租赁价格");
        }

        Date zucheKaishiTime = cheliangOrder.getZucheKaishiTime();
        Date zucheJieshuTime = cheliangOrder.getZucheJieshuTime();
        if((zucheJieshuTime.getTime()-zucheKaishiTime.getTime()) <1){
            cheliangOrder.setCheliangOrderNumber(1);
        }else{
            Long l = (zucheJieshuTime.getTime() - zucheKaishiTime.getTime()) / (1000L * 3600L * 24L);
            cheliangOrder.setCheliangOrderNumber(l.intValue()+1);
        }
        cheliangOrder.setCheliangOrderZongJine(cheliangOrder.getCheliangOrderNumber() *cheliangEntity.getCheliangNewJiage());
        cheliangOrder.setCheliangOrderTypes(1);

        cheliangOrder.setInsertTime(new Date());
        cheliangOrder.setCreateTime(new Date());
        cheliangOrderService.insert(cheliangOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangOrderEntity cheliangOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,cheliangOrder:{}",this.getClass().getName(),cheliangOrder.toString());



        CheliangEntity cheliangEntity = cheliangService.selectById(cheliangOrder.getCheliangId());
        if(cheliangEntity == null || cheliangEntity.getCheliangNewJiage() == null){
            return R.error("查不到车辆或者查不到车辆租赁价格");
        }

        Date zucheKaishiTime = cheliangOrder.getZucheKaishiTime();
        Date zucheJieshuTime = cheliangOrder.getZucheJieshuTime();
        if((zucheJieshuTime.getTime()-zucheKaishiTime.getTime()) <1){
            cheliangOrder.setCheliangOrderNumber(1);
        }else{
            Long l = (zucheJieshuTime.getTime() - zucheKaishiTime.getTime()) / (1000L * 3600L * 24L);
            cheliangOrder.setCheliangOrderNumber(l.intValue()+1);
        }
        cheliangOrder.setCheliangOrderZongJine(cheliangOrder.getCheliangOrderNumber() *cheliangEntity.getCheliangNewJiage());

            cheliangOrderService.updateById(cheliangOrder);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        cheliangOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<CheliangOrderEntity> cheliangOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            CheliangOrderEntity cheliangOrderEntity = new CheliangOrderEntity();
//                            cheliangOrderEntity.setCheliangOrderUuidNumber(data.get(0));                    //出租单号 要改的
//                            cheliangOrderEntity.setCheliangId(Integer.valueOf(data.get(0)));   //车辆 要改的
//                            cheliangOrderEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            cheliangOrderEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            cheliangOrderEntity.setZucheKaishiTime(sdf.parse(data.get(0)));          //租车开始日期 要改的
//                            cheliangOrderEntity.setZucheJieshuTime(sdf.parse(data.get(0)));          //租车结束日期 要改的
//                            cheliangOrderEntity.setCheliangOrderNumber(Integer.valueOf(data.get(0)));   //租用天数 要改的
//                            cheliangOrderEntity.setCheliangOrderZongJine(data.get(0));                    //花费金额 要改的
//                            cheliangOrderEntity.setCheliangOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            cheliangOrderEntity.setCheliangOrderContent("");//详情和图片
//                            cheliangOrderEntity.setInsertTime(date);//时间
//                            cheliangOrderEntity.setCreateTime(date);//时间
                            cheliangOrderList.add(cheliangOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //出租单号
                                if(seachFields.containsKey("cheliangOrderUuidNumber")){
                                    List<String> cheliangOrderUuidNumber = seachFields.get("cheliangOrderUuidNumber");
                                    cheliangOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheliangOrderUuidNumber = new ArrayList<>();
                                    cheliangOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheliangOrderUuidNumber",cheliangOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出租单号
                        List<CheliangOrderEntity> cheliangOrderEntities_cheliangOrderUuidNumber = cheliangOrderService.selectList(new EntityWrapper<CheliangOrderEntity>().in("cheliang_order_uuid_number", seachFields.get("cheliangOrderUuidNumber")));
                        if(cheliangOrderEntities_cheliangOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheliangOrderEntity s:cheliangOrderEntities_cheliangOrderUuidNumber){
                                repeatFields.add(s.getCheliangOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出租单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheliangOrderService.insertBatch(cheliangOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
     * 退款
     */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        CheliangOrderEntity cheliangOrder = cheliangOrderService.selectById(id);



        cheliangOrder.setCheliangOrderTypes(2);//设置订单状态为退款
        cheliangOrderService.updateById(cheliangOrder);//根据id更新
        return R.ok();
    }


    /**
     * 提车
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        CheliangOrderEntity  cheliangOrderEntity = new  CheliangOrderEntity();;
        cheliangOrderEntity.setId(id);
        cheliangOrderEntity.setCheliangOrderTypes(3);
        boolean b =  cheliangOrderService.updateById( cheliangOrderEntity);
        if(!b){
            return R.error("提车出错");
        }
        return R.ok();
    }














    /**
     * 还车
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        CheliangOrderEntity  cheliangOrderEntity = new  CheliangOrderEntity();
        cheliangOrderEntity.setId(id);
        cheliangOrderEntity.setCheliangOrderTypes(4);
        boolean b =  cheliangOrderService.updateById( cheliangOrderEntity);
        if(!b){
            return R.error("还车出错");
        }
        return R.ok();
    }







}
