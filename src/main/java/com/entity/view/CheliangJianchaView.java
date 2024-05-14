package com.entity.view;

import com.entity.CheliangJianchaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 检查单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cheliang_jiancha")
public class CheliangJianchaView extends CheliangJianchaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 检查结果的值
		*/
		private String cheliangJianchaValue;



		//级联表 cheliang_order
			/**
			* 出租单号
			*/
			private String cheliangOrderUuidNumber;
			/**
			* 车辆出租 的 员工
			*/
			private Integer cheliangOrderYuangongId;
			/**
			* 车辆出租 的 客户
			*/
			private Integer cheliangOrderKehuId;
			/**
			* 租车开始日期
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
			@DateTimeFormat
			private Date zucheKaishiTime;
			/**
			* 租车结束日期
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
				* 订单类型的值
				*/
				private String cheliangOrderValue;
			/**
			* 订单备注
			*/
			private String cheliangOrderContent;

		//级联表 yuangong
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工头像
			*/
			private String yuangongPhoto;
			/**
			* 员工地址
			*/
			private String yuangongAddress;
			/**
			* 电子邮箱
			*/
			private String yuangongEmail;

	public CheliangJianchaView() {

	}

	public CheliangJianchaView(CheliangJianchaEntity cheliangJianchaEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangJianchaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 检查结果的值
			*/
			public String getCheliangJianchaValue() {
				return cheliangJianchaValue;
			}
			/**
			* 设置： 检查结果的值
			*/
			public void setCheliangJianchaValue(String cheliangJianchaValue) {
				this.cheliangJianchaValue = cheliangJianchaValue;
			}











				//级联表的get和set cheliang_order

					/**
					* 获取： 出租单号
					*/
					public String getCheliangOrderUuidNumber() {
						return cheliangOrderUuidNumber;
					}
					/**
					* 设置： 出租单号
					*/
					public void setCheliangOrderUuidNumber(String cheliangOrderUuidNumber) {
						this.cheliangOrderUuidNumber = cheliangOrderUuidNumber;
					}


					/**
					* 获取：车辆出租 的 员工
					*/
					public Integer getCheliangOrderYuangongId() {
						return cheliangOrderYuangongId;
					}
					/**
					* 设置：车辆出租 的 员工
					*/
					public void setCheliangOrderYuangongId(Integer cheliangOrderYuangongId) {
						this.cheliangOrderYuangongId = cheliangOrderYuangongId;
					}


					/**
					* 获取：车辆出租 的 客户
					*/
					public Integer getCheliangOrderKehuId() {
						return cheliangOrderKehuId;
					}
					/**
					* 设置：车辆出租 的 客户
					*/
					public void setCheliangOrderKehuId(Integer cheliangOrderKehuId) {
						this.cheliangOrderKehuId = cheliangOrderKehuId;
					}


					/**
					* 获取： 租车开始日期
					*/
					public Date getZucheKaishiTime() {
						return zucheKaishiTime;
					}
					/**
					* 设置： 租车开始日期
					*/
					public void setZucheKaishiTime(Date zucheKaishiTime) {
						this.zucheKaishiTime = zucheKaishiTime;
					}

					/**
					* 获取： 租车结束日期
					*/
					public Date getZucheJieshuTime() {
						return zucheJieshuTime;
					}
					/**
					* 设置： 租车结束日期
					*/
					public void setZucheJieshuTime(Date zucheJieshuTime) {
						this.zucheJieshuTime = zucheJieshuTime;
					}

					/**
					* 获取： 租用天数
					*/
					public Integer getCheliangOrderNumber() {
						return cheliangOrderNumber;
					}
					/**
					* 设置： 租用天数
					*/
					public void setCheliangOrderNumber(Integer cheliangOrderNumber) {
						this.cheliangOrderNumber = cheliangOrderNumber;
					}

					/**
					* 获取： 花费金额
					*/
					public Double getCheliangOrderZongJine() {
						return cheliangOrderZongJine;
					}
					/**
					* 设置： 花费金额
					*/
					public void setCheliangOrderZongJine(Double cheliangOrderZongJine) {
						this.cheliangOrderZongJine = cheliangOrderZongJine;
					}

					/**
					* 获取： 订单类型
					*/
					public Integer getCheliangOrderTypes() {
						return cheliangOrderTypes;
					}
					/**
					* 设置： 订单类型
					*/
					public void setCheliangOrderTypes(Integer cheliangOrderTypes) {
						this.cheliangOrderTypes = cheliangOrderTypes;
					}


						/**
						* 获取： 订单类型的值
						*/
						public String getCheliangOrderValue() {
							return cheliangOrderValue;
						}
						/**
						* 设置： 订单类型的值
						*/
						public void setCheliangOrderValue(String cheliangOrderValue) {
							this.cheliangOrderValue = cheliangOrderValue;
						}

					/**
					* 获取： 订单备注
					*/
					public String getCheliangOrderContent() {
						return cheliangOrderContent;
					}
					/**
					* 设置： 订单备注
					*/
					public void setCheliangOrderContent(String cheliangOrderContent) {
						this.cheliangOrderContent = cheliangOrderContent;
					}








				//级联表的get和set yuangong

					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}

					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}

					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}

					/**
					* 获取： 员工头像
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工头像
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}

					/**
					* 获取： 员工地址
					*/
					public String getYuangongAddress() {
						return yuangongAddress;
					}
					/**
					* 设置： 员工地址
					*/
					public void setYuangongAddress(String yuangongAddress) {
						this.yuangongAddress = yuangongAddress;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYuangongEmail() {
						return yuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYuangongEmail(String yuangongEmail) {
						this.yuangongEmail = yuangongEmail;
					}




}
