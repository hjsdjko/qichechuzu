package com.entity.model;

import com.entity.CheliangOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆出租
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 出租单号
     */
    private String cheliangOrderUuidNumber;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 租车开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zucheKaishiTime;


    /**
     * 租车结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zucheJieshuTime;


    /**
     * 租用天数
     */
    private Integer cheliangOrderNumber;


    /**
     * 花费金额
     */
    private Double cheliangOrderZongJine;


    /**
     * 订单类型
     */
    private Integer cheliangOrderTypes;


    /**
     * 订单备注
     */
    private String cheliangOrderContent;


    /**
     * 订单录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：出租单号
	 */
    public String getCheliangOrderUuidNumber() {
        return cheliangOrderUuidNumber;
    }


    /**
	 * 设置：出租单号
	 */
    public void setCheliangOrderUuidNumber(String cheliangOrderUuidNumber) {
        this.cheliangOrderUuidNumber = cheliangOrderUuidNumber;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：租车开始日期
	 */
    public Date getZucheKaishiTime() {
        return zucheKaishiTime;
    }


    /**
	 * 设置：租车开始日期
	 */
    public void setZucheKaishiTime(Date zucheKaishiTime) {
        this.zucheKaishiTime = zucheKaishiTime;
    }
    /**
	 * 获取：租车结束日期
	 */
    public Date getZucheJieshuTime() {
        return zucheJieshuTime;
    }


    /**
	 * 设置：租车结束日期
	 */
    public void setZucheJieshuTime(Date zucheJieshuTime) {
        this.zucheJieshuTime = zucheJieshuTime;
    }
    /**
	 * 获取：租用天数
	 */
    public Integer getCheliangOrderNumber() {
        return cheliangOrderNumber;
    }


    /**
	 * 设置：租用天数
	 */
    public void setCheliangOrderNumber(Integer cheliangOrderNumber) {
        this.cheliangOrderNumber = cheliangOrderNumber;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getCheliangOrderZongJine() {
        return cheliangOrderZongJine;
    }


    /**
	 * 设置：花费金额
	 */
    public void setCheliangOrderZongJine(Double cheliangOrderZongJine) {
        this.cheliangOrderZongJine = cheliangOrderZongJine;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getCheliangOrderTypes() {
        return cheliangOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setCheliangOrderTypes(Integer cheliangOrderTypes) {
        this.cheliangOrderTypes = cheliangOrderTypes;
    }
    /**
	 * 获取：订单备注
	 */
    public String getCheliangOrderContent() {
        return cheliangOrderContent;
    }


    /**
	 * 设置：订单备注
	 */
    public void setCheliangOrderContent(String cheliangOrderContent) {
        this.cheliangOrderContent = cheliangOrderContent;
    }
    /**
	 * 获取：订单录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
