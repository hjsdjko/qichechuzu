package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 检查单
 *
 * @author 
 * @email
 */
@TableName("cheliang_jiancha")
public class CheliangJianchaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheliangJianchaEntity() {

	}

	public CheliangJianchaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 车辆出租
     */
    @TableField(value = "cheliang_order_id")

    private Integer cheliangOrderId;


    /**
     * 检查单号
     */
    @TableField(value = "cheliang_jiancha_uuid_number")

    private String cheliangJianchaUuidNumber;


    /**
     * 检查结果
     */
    @TableField(value = "cheliang_jiancha_types")

    private Integer cheliangJianchaTypes;


    /**
     * 存在问题
     */
    @TableField(value = "cheliang_order_wenti_content")

    private String cheliangOrderWentiContent;


    /**
     * 赔付金额
     */
    @TableField(value = "cheliang_jiancha_peifu_jine")

    private Double cheliangJianchaPeifuJine;


    /**
     * 备注
     */
    @TableField(value = "cheliang_order_content")

    private String cheliangOrderContent;


    /**
     * 检查录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：车辆出租
	 */
    public Integer getCheliangOrderId() {
        return cheliangOrderId;
    }
    /**
	 * 获取：车辆出租
	 */

    public void setCheliangOrderId(Integer cheliangOrderId) {
        this.cheliangOrderId = cheliangOrderId;
    }
    /**
	 * 设置：检查单号
	 */
    public String getCheliangJianchaUuidNumber() {
        return cheliangJianchaUuidNumber;
    }
    /**
	 * 获取：检查单号
	 */

    public void setCheliangJianchaUuidNumber(String cheliangJianchaUuidNumber) {
        this.cheliangJianchaUuidNumber = cheliangJianchaUuidNumber;
    }
    /**
	 * 设置：检查结果
	 */
    public Integer getCheliangJianchaTypes() {
        return cheliangJianchaTypes;
    }
    /**
	 * 获取：检查结果
	 */

    public void setCheliangJianchaTypes(Integer cheliangJianchaTypes) {
        this.cheliangJianchaTypes = cheliangJianchaTypes;
    }
    /**
	 * 设置：存在问题
	 */
    public String getCheliangOrderWentiContent() {
        return cheliangOrderWentiContent;
    }
    /**
	 * 获取：存在问题
	 */

    public void setCheliangOrderWentiContent(String cheliangOrderWentiContent) {
        this.cheliangOrderWentiContent = cheliangOrderWentiContent;
    }
    /**
	 * 设置：赔付金额
	 */
    public Double getCheliangJianchaPeifuJine() {
        return cheliangJianchaPeifuJine;
    }
    /**
	 * 获取：赔付金额
	 */

    public void setCheliangJianchaPeifuJine(Double cheliangJianchaPeifuJine) {
        this.cheliangJianchaPeifuJine = cheliangJianchaPeifuJine;
    }
    /**
	 * 设置：备注
	 */
    public String getCheliangOrderContent() {
        return cheliangOrderContent;
    }
    /**
	 * 获取：备注
	 */

    public void setCheliangOrderContent(String cheliangOrderContent) {
        this.cheliangOrderContent = cheliangOrderContent;
    }
    /**
	 * 设置：检查录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：检查录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CheliangJiancha{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", cheliangOrderId=" + cheliangOrderId +
            ", cheliangJianchaUuidNumber=" + cheliangJianchaUuidNumber +
            ", cheliangJianchaTypes=" + cheliangJianchaTypes +
            ", cheliangOrderWentiContent=" + cheliangOrderWentiContent +
            ", cheliangJianchaPeifuJine=" + cheliangJianchaPeifuJine +
            ", cheliangOrderContent=" + cheliangOrderContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
