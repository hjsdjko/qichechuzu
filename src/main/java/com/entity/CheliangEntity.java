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
 * 车辆
 *
 * @author 
 * @email
 */
@TableName("cheliang")
public class CheliangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheliangEntity() {

	}

	public CheliangEntity(T t) {
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
     * 车辆编号
     */
    @TableField(value = "cheliang_uuid_number")

    private String cheliangUuidNumber;


    /**
     * 车辆名称
     */
    @TableField(value = "cheliang_name")

    private String cheliangName;


    /**
     * 车辆照片
     */
    @TableField(value = "cheliang_photo")

    private String cheliangPhoto;


    /**
     * 车辆类型
     */
    @TableField(value = "cheliang_types")

    private Integer cheliangTypes;


    /**
     * 车辆颜色
     */
    @TableField(value = "cheliang_yanse")

    private String cheliangYanse;


    /**
     * 车牌号
     */
    @TableField(value = "cheliang_chepai")

    private String cheliangChepai;


    /**
     * 车辆状态
     */
    @TableField(value = "cheliang_zhuangtai_types")

    private Integer cheliangZhuangtaiTypes;


    /**
     * 车辆价格
     */
    @TableField(value = "cheliang_jiage")

    private Double cheliangJiage;


    /**
     * 所需押金
     */
    @TableField(value = "cheliang_yajin_jiage")

    private Double cheliangYajinJiage;


    /**
     * 现价/天
     */
    @TableField(value = "cheliang_new_jiage")

    private Double cheliangNewJiage;


    /**
     * 车辆介绍
     */
    @TableField(value = "cheliang_content")

    private String cheliangContent;


    /**
     * 逻辑删除
     */
    @TableField(value = "cheliang_delete")

    private Integer cheliangDelete;


    /**
     * 录入时间
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
	 * 设置：车辆编号
	 */
    public String getCheliangUuidNumber() {
        return cheliangUuidNumber;
    }
    /**
	 * 获取：车辆编号
	 */

    public void setCheliangUuidNumber(String cheliangUuidNumber) {
        this.cheliangUuidNumber = cheliangUuidNumber;
    }
    /**
	 * 设置：车辆名称
	 */
    public String getCheliangName() {
        return cheliangName;
    }
    /**
	 * 获取：车辆名称
	 */

    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 设置：车辆照片
	 */
    public String getCheliangPhoto() {
        return cheliangPhoto;
    }
    /**
	 * 获取：车辆照片
	 */

    public void setCheliangPhoto(String cheliangPhoto) {
        this.cheliangPhoto = cheliangPhoto;
    }
    /**
	 * 设置：车辆类型
	 */
    public Integer getCheliangTypes() {
        return cheliangTypes;
    }
    /**
	 * 获取：车辆类型
	 */

    public void setCheliangTypes(Integer cheliangTypes) {
        this.cheliangTypes = cheliangTypes;
    }
    /**
	 * 设置：车辆颜色
	 */
    public String getCheliangYanse() {
        return cheliangYanse;
    }
    /**
	 * 获取：车辆颜色
	 */

    public void setCheliangYanse(String cheliangYanse) {
        this.cheliangYanse = cheliangYanse;
    }
    /**
	 * 设置：车牌号
	 */
    public String getCheliangChepai() {
        return cheliangChepai;
    }
    /**
	 * 获取：车牌号
	 */

    public void setCheliangChepai(String cheliangChepai) {
        this.cheliangChepai = cheliangChepai;
    }
    /**
	 * 设置：车辆状态
	 */
    public Integer getCheliangZhuangtaiTypes() {
        return cheliangZhuangtaiTypes;
    }
    /**
	 * 获取：车辆状态
	 */

    public void setCheliangZhuangtaiTypes(Integer cheliangZhuangtaiTypes) {
        this.cheliangZhuangtaiTypes = cheliangZhuangtaiTypes;
    }
    /**
	 * 设置：车辆价格
	 */
    public Double getCheliangJiage() {
        return cheliangJiage;
    }
    /**
	 * 获取：车辆价格
	 */

    public void setCheliangJiage(Double cheliangJiage) {
        this.cheliangJiage = cheliangJiage;
    }
    /**
	 * 设置：所需押金
	 */
    public Double getCheliangYajinJiage() {
        return cheliangYajinJiage;
    }
    /**
	 * 获取：所需押金
	 */

    public void setCheliangYajinJiage(Double cheliangYajinJiage) {
        this.cheliangYajinJiage = cheliangYajinJiage;
    }
    /**
	 * 设置：现价/天
	 */
    public Double getCheliangNewJiage() {
        return cheliangNewJiage;
    }
    /**
	 * 获取：现价/天
	 */

    public void setCheliangNewJiage(Double cheliangNewJiage) {
        this.cheliangNewJiage = cheliangNewJiage;
    }
    /**
	 * 设置：车辆介绍
	 */
    public String getCheliangContent() {
        return cheliangContent;
    }
    /**
	 * 获取：车辆介绍
	 */

    public void setCheliangContent(String cheliangContent) {
        this.cheliangContent = cheliangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getCheliangDelete() {
        return cheliangDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setCheliangDelete(Integer cheliangDelete) {
        this.cheliangDelete = cheliangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
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
        return "Cheliang{" +
            "id=" + id +
            ", cheliangUuidNumber=" + cheliangUuidNumber +
            ", cheliangName=" + cheliangName +
            ", cheliangPhoto=" + cheliangPhoto +
            ", cheliangTypes=" + cheliangTypes +
            ", cheliangYanse=" + cheliangYanse +
            ", cheliangChepai=" + cheliangChepai +
            ", cheliangZhuangtaiTypes=" + cheliangZhuangtaiTypes +
            ", cheliangJiage=" + cheliangJiage +
            ", cheliangYajinJiage=" + cheliangYajinJiage +
            ", cheliangNewJiage=" + cheliangNewJiage +
            ", cheliangContent=" + cheliangContent +
            ", cheliangDelete=" + cheliangDelete +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
