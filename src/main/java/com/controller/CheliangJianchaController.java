
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
 * 检查单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheliangJiancha")
public class CheliangJianchaController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangJianchaController.class);

    @Autowired
    private CheliangJianchaService cheliangJianchaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CheliangOrderService cheliangOrderService;
    @Autowired
    private YuangongService yuangongService;

    @Autowired
    private KehuService kehuService;


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
        PageUtils page = cheliangJianchaService.queryPage(params);

        //字典表数据转换
        List<CheliangJianchaView> list =(List<CheliangJianchaView>)page.getList();
        for(CheliangJianchaView c:list){
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
        CheliangJianchaEntity cheliangJiancha = cheliangJianchaService.selectById(id);
        if(cheliangJiancha !=null){
            //entity转view
            CheliangJianchaView view = new CheliangJianchaView();
            BeanUtils.copyProperties( cheliangJiancha , view );//把实体数据重构到view中

                //级联表
                CheliangOrderEntity cheliangOrder = cheliangOrderService.selectById(cheliangJiancha.getCheliangOrderId());
                if(cheliangOrder != null){
                    BeanUtils.copyProperties( cheliangOrder , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangOrderId(cheliangOrder.getId());
                    view.setCheliangOrderYuangongId(cheliangOrder.getYuangongId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(cheliangJiancha.getYuangongId());
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
    public R save(@RequestBody CheliangJianchaEntity cheliangJiancha, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliangJiancha:{}",this.getClass().getName(),cheliangJiancha.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            cheliangJiancha.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<CheliangJianchaEntity> queryWrapper = new EntityWrapper<CheliangJianchaEntity>()
            .eq("cheliang_order_id", cheliangJiancha.getCheliangOrderId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangJianchaEntity cheliangJianchaEntity = cheliangJianchaService.selectOne(queryWrapper);
        if(cheliangJianchaEntity==null){
            cheliangJiancha.setInsertTime(new Date());
            cheliangJiancha.setCreateTime(new Date());
            cheliangJianchaService.insert(cheliangJiancha);
            return R.ok();
        }else {
            return R.error(511,"该订单已经检查过了");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangJianchaEntity cheliangJiancha, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,cheliangJiancha:{}",this.getClass().getName(),cheliangJiancha.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            cheliangJiancha.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<CheliangJianchaEntity> queryWrapper = new EntityWrapper<CheliangJianchaEntity>()
            .notIn("id",cheliangJiancha.getId())
            .andNew()
            .eq("cheliang_order_id", cheliangJiancha.getCheliangOrderId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangJianchaEntity cheliangJianchaEntity = cheliangJianchaService.selectOne(queryWrapper);
        if(cheliangJianchaEntity==null){
            cheliangJianchaService.updateById(cheliangJiancha);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该订单已经检查过了");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        cheliangJianchaService.deleteBatchIds(Arrays.asList(ids));
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
            List<CheliangJianchaEntity> cheliangJianchaList = new ArrayList<>();//上传的东西
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
                            CheliangJianchaEntity cheliangJianchaEntity = new CheliangJianchaEntity();
//                            cheliangJianchaEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            cheliangJianchaEntity.setCheliangOrderId(Integer.valueOf(data.get(0)));   //车辆出租 要改的
//                            cheliangJianchaEntity.setCheliangJianchaUuidNumber(data.get(0));                    //检查单号 要改的
//                            cheliangJianchaEntity.setCheliangJianchaTypes(Integer.valueOf(data.get(0)));   //检查结果 要改的
//                            cheliangJianchaEntity.setCheliangOrderWentiContent("");//详情和图片
//                            cheliangJianchaEntity.setCheliangJianchaPeifuJine(data.get(0));                    //赔付金额 要改的
//                            cheliangJianchaEntity.setCheliangOrderContent("");//详情和图片
//                            cheliangJianchaEntity.setInsertTime(date);//时间
//                            cheliangJianchaEntity.setCreateTime(date);//时间
                            cheliangJianchaList.add(cheliangJianchaEntity);


                            //把要查询是否重复的字段放入map中
                                //检查单号
                                if(seachFields.containsKey("cheliangJianchaUuidNumber")){
                                    List<String> cheliangJianchaUuidNumber = seachFields.get("cheliangJianchaUuidNumber");
                                    cheliangJianchaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheliangJianchaUuidNumber = new ArrayList<>();
                                    cheliangJianchaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheliangJianchaUuidNumber",cheliangJianchaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //检查单号
                        List<CheliangJianchaEntity> cheliangJianchaEntities_cheliangJianchaUuidNumber = cheliangJianchaService.selectList(new EntityWrapper<CheliangJianchaEntity>().in("cheliang_jiancha_uuid_number", seachFields.get("cheliangJianchaUuidNumber")));
                        if(cheliangJianchaEntities_cheliangJianchaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheliangJianchaEntity s:cheliangJianchaEntities_cheliangJianchaUuidNumber){
                                repeatFields.add(s.getCheliangJianchaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [检查单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheliangJianchaService.insertBatch(cheliangJianchaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
