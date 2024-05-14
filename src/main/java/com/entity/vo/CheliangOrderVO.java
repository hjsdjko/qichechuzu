package com.entity.vo;

import com.entity.CheliangOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆出租
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cheliang_order")
public class CheliangOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 出租单号
     */

    @TableField(value = "cheliang_order_uuid_number")
    private String cheliangOrderUuidNumber;


    /**
     * 车辆
     */

    @TableField(value = "cheliang_id")
    private Integer cheliangId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 租车开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zuche_kaishi_time")
    private Date zucheKaishiTime;


    /**
     * 租车结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zuche_jieshu_time")
    private Date zucheJieshuTime;


    /**
     * 租用天数
     */

    @TableField(value = "cheliang_order_number")
    private Integer cheliangOrderNumber;


    /**
     * 花费金额
     */

    @TableField(value = "cheliang_order_zong_jine")
    private Double cheliangOrderZongJine;


    /**
     * 订单类型
     */

    @TableField(value = "cheliang_order_types")
    private Integer cheliangOrderTypes;


    /**
     * 订单备注
     */

    @TableField(value = "cheliang_order_content")
    private String cheliangOrderContent;


    /**
     * 订单录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：出租单号
	 */
    public String getCheliangOrderUuidNumber() {
        return cheliangOrderUuidNumber;
    }


    /**
	 * 获取：出租单号
	 */

    public void setCheliangOrderUuidNumber(String cheliangOrderUuidNumber) {
        this.cheliangOrderUuidNumber = cheliangOrderUuidNumber;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：租车开始日期
	 */
    public Date getZucheKaishiTime() {
        return zucheKaishiTime;
    }


    /**
	 * 获取：租车开始日期
	 */

    public void setZucheKaishiTime(Date zucheKaishiTime) {
        this.zucheKaishiTime = zucheKaishiTime;
    }
    /**
	 * 设置：租车结束日期
	 */
    public Date getZucheJieshuTime() {
        return zucheJieshuTime;
    }


    /**
	 * 获取：租车结束日期
	 */

    public void setZucheJieshuTime(Date zucheJieshuTime) {
        this.zucheJieshuTime = zucheJieshuTime;
    }
    /**
	 * 设置：租用天数
	 */
    public Integer getCheliangOrderNumber() {
        return cheliangOrderNumber;
    }


    /**
	 * 获取：租用天数
	 */

    public void setCheliangOrderNumber(Integer cheliangOrderNumber) {
        this.cheliangOrderNumber = cheliangOrderNumber;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getCheliangOrderZongJine() {
        return cheliangOrderZongJine;
    }


    /**
	 * 获取：花费金额
	 */

    public void setCheliangOrderZongJine(Double cheliangOrderZongJine) {
        this.cheliangOrderZongJine = cheliangOrderZongJine;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getCheliangOrderTypes() {
        return cheliangOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setCheliangOrderTypes(Integer cheliangOrderTypes) {
        this.cheliangOrderTypes = cheliangOrderTypes;
    }
    /**
	 * 设置：订单备注
	 */
    public String getCheliangOrderContent() {
        return cheliangOrderContent;
    }


    /**
	 * 获取：订单备注
	 */

    public void setCheliangOrderContent(String cheliangOrderContent) {
        this.cheliangOrderContent = cheliangOrderContent;
    }
    /**
	 * 设置：订单录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
