package com.entity.model;

import com.entity.CheliangJianchaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 检查单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangJianchaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 车辆出租
     */
    private Integer cheliangOrderId;


    /**
     * 检查单号
     */
    private String cheliangJianchaUuidNumber;


    /**
     * 检查结果
     */
    private Integer cheliangJianchaTypes;


    /**
     * 存在问题
     */
    private String cheliangOrderWentiContent;


    /**
     * 赔付金额
     */
    private Double cheliangJianchaPeifuJine;


    /**
     * 备注
     */
    private String cheliangOrderContent;


    /**
     * 检查录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：车辆出租
	 */
    public Integer getCheliangOrderId() {
        return cheliangOrderId;
    }


    /**
	 * 设置：车辆出租
	 */
    public void setCheliangOrderId(Integer cheliangOrderId) {
        this.cheliangOrderId = cheliangOrderId;
    }
    /**
	 * 获取：检查单号
	 */
    public String getCheliangJianchaUuidNumber() {
        return cheliangJianchaUuidNumber;
    }


    /**
	 * 设置：检查单号
	 */
    public void setCheliangJianchaUuidNumber(String cheliangJianchaUuidNumber) {
        this.cheliangJianchaUuidNumber = cheliangJianchaUuidNumber;
    }
    /**
	 * 获取：检查结果
	 */
    public Integer getCheliangJianchaTypes() {
        return cheliangJianchaTypes;
    }


    /**
	 * 设置：检查结果
	 */
    public void setCheliangJianchaTypes(Integer cheliangJianchaTypes) {
        this.cheliangJianchaTypes = cheliangJianchaTypes;
    }
    /**
	 * 获取：存在问题
	 */
    public String getCheliangOrderWentiContent() {
        return cheliangOrderWentiContent;
    }


    /**
	 * 设置：存在问题
	 */
    public void setCheliangOrderWentiContent(String cheliangOrderWentiContent) {
        this.cheliangOrderWentiContent = cheliangOrderWentiContent;
    }
    /**
	 * 获取：赔付金额
	 */
    public Double getCheliangJianchaPeifuJine() {
        return cheliangJianchaPeifuJine;
    }


    /**
	 * 设置：赔付金额
	 */
    public void setCheliangJianchaPeifuJine(Double cheliangJianchaPeifuJine) {
        this.cheliangJianchaPeifuJine = cheliangJianchaPeifuJine;
    }
    /**
	 * 获取：备注
	 */
    public String getCheliangOrderContent() {
        return cheliangOrderContent;
    }


    /**
	 * 设置：备注
	 */
    public void setCheliangOrderContent(String cheliangOrderContent) {
        this.cheliangOrderContent = cheliangOrderContent;
    }
    /**
	 * 获取：检查录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：检查录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
