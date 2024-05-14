package com.entity.view;

import com.entity.CheliangOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆出租
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cheliang_order")
public class CheliangOrderView extends CheliangOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单类型的值
		*/
		private String cheliangOrderValue;



		//级联表 cheliang
			/**
			* 车辆编号
			*/
			private String cheliangUuidNumber;
			/**
			* 车辆名称
			*/
			private String cheliangName;
			/**
			* 车辆照片
			*/
			private String cheliangPhoto;
			/**
			* 车辆类型
			*/
			private Integer cheliangTypes;
				/**
				* 车辆类型的值
				*/
				private String cheliangValue;
			/**
			* 车辆颜色
			*/
			private String cheliangYanse;
			/**
			* 车牌号
			*/
			private String cheliangChepai;
			/**
			* 车辆状态
			*/
			private Integer cheliangZhuangtaiTypes;
				/**
				* 车辆状态的值
				*/
				private String cheliangZhuangtaiValue;
			/**
			* 车辆价格
			*/
			private Double cheliangJiage;
			/**
			* 所需押金
			*/
			private Double cheliangYajinJiage;
			/**
			* 现价/天
			*/
			private Double cheliangNewJiage;
			/**
			* 车辆介绍
			*/
			private String cheliangContent;
			/**
			* 逻辑删除
			*/
			private Integer cheliangDelete;

		//级联表 kehu
			/**
			* 客户姓名
			*/
			private String kehuName;
			/**
			* 客户手机号
			*/
			private String kehuPhone;
			/**
			* 客户身份证号
			*/
			private String kehuIdNumber;
			/**
			* 客户头像
			*/
			private String kehuPhoto;
			/**
			* 客户地址
			*/
			private String kehuAddress;
			/**
			* 客户职业
			*/
			private String kehuZhiye;
			/**
			* 地区
			*/
			private Integer diquTypes;
				/**
				* 地区的值
				*/
				private String diquValue;
			/**
			* 电子邮箱
			*/
			private String kehuEmail;

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

	public CheliangOrderView() {

	}

	public CheliangOrderView(CheliangOrderEntity cheliangOrderEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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




				//级联表的get和set cheliang

					/**
					* 获取： 车辆编号
					*/
					public String getCheliangUuidNumber() {
						return cheliangUuidNumber;
					}
					/**
					* 设置： 车辆编号
					*/
					public void setCheliangUuidNumber(String cheliangUuidNumber) {
						this.cheliangUuidNumber = cheliangUuidNumber;
					}

					/**
					* 获取： 车辆名称
					*/
					public String getCheliangName() {
						return cheliangName;
					}
					/**
					* 设置： 车辆名称
					*/
					public void setCheliangName(String cheliangName) {
						this.cheliangName = cheliangName;
					}

					/**
					* 获取： 车辆照片
					*/
					public String getCheliangPhoto() {
						return cheliangPhoto;
					}
					/**
					* 设置： 车辆照片
					*/
					public void setCheliangPhoto(String cheliangPhoto) {
						this.cheliangPhoto = cheliangPhoto;
					}

					/**
					* 获取： 车辆类型
					*/
					public Integer getCheliangTypes() {
						return cheliangTypes;
					}
					/**
					* 设置： 车辆类型
					*/
					public void setCheliangTypes(Integer cheliangTypes) {
						this.cheliangTypes = cheliangTypes;
					}


						/**
						* 获取： 车辆类型的值
						*/
						public String getCheliangValue() {
							return cheliangValue;
						}
						/**
						* 设置： 车辆类型的值
						*/
						public void setCheliangValue(String cheliangValue) {
							this.cheliangValue = cheliangValue;
						}

					/**
					* 获取： 车辆颜色
					*/
					public String getCheliangYanse() {
						return cheliangYanse;
					}
					/**
					* 设置： 车辆颜色
					*/
					public void setCheliangYanse(String cheliangYanse) {
						this.cheliangYanse = cheliangYanse;
					}

					/**
					* 获取： 车牌号
					*/
					public String getCheliangChepai() {
						return cheliangChepai;
					}
					/**
					* 设置： 车牌号
					*/
					public void setCheliangChepai(String cheliangChepai) {
						this.cheliangChepai = cheliangChepai;
					}

					/**
					* 获取： 车辆状态
					*/
					public Integer getCheliangZhuangtaiTypes() {
						return cheliangZhuangtaiTypes;
					}
					/**
					* 设置： 车辆状态
					*/
					public void setCheliangZhuangtaiTypes(Integer cheliangZhuangtaiTypes) {
						this.cheliangZhuangtaiTypes = cheliangZhuangtaiTypes;
					}


						/**
						* 获取： 车辆状态的值
						*/
						public String getCheliangZhuangtaiValue() {
							return cheliangZhuangtaiValue;
						}
						/**
						* 设置： 车辆状态的值
						*/
						public void setCheliangZhuangtaiValue(String cheliangZhuangtaiValue) {
							this.cheliangZhuangtaiValue = cheliangZhuangtaiValue;
						}

					/**
					* 获取： 车辆价格
					*/
					public Double getCheliangJiage() {
						return cheliangJiage;
					}
					/**
					* 设置： 车辆价格
					*/
					public void setCheliangJiage(Double cheliangJiage) {
						this.cheliangJiage = cheliangJiage;
					}

					/**
					* 获取： 所需押金
					*/
					public Double getCheliangYajinJiage() {
						return cheliangYajinJiage;
					}
					/**
					* 设置： 所需押金
					*/
					public void setCheliangYajinJiage(Double cheliangYajinJiage) {
						this.cheliangYajinJiage = cheliangYajinJiage;
					}

					/**
					* 获取： 现价/天
					*/
					public Double getCheliangNewJiage() {
						return cheliangNewJiage;
					}
					/**
					* 设置： 现价/天
					*/
					public void setCheliangNewJiage(Double cheliangNewJiage) {
						this.cheliangNewJiage = cheliangNewJiage;
					}

					/**
					* 获取： 车辆介绍
					*/
					public String getCheliangContent() {
						return cheliangContent;
					}
					/**
					* 设置： 车辆介绍
					*/
					public void setCheliangContent(String cheliangContent) {
						this.cheliangContent = cheliangContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getCheliangDelete() {
						return cheliangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setCheliangDelete(Integer cheliangDelete) {
						this.cheliangDelete = cheliangDelete;
					}


















				//级联表的get和set kehu

					/**
					* 获取： 客户姓名
					*/
					public String getKehuName() {
						return kehuName;
					}
					/**
					* 设置： 客户姓名
					*/
					public void setKehuName(String kehuName) {
						this.kehuName = kehuName;
					}

					/**
					* 获取： 客户手机号
					*/
					public String getKehuPhone() {
						return kehuPhone;
					}
					/**
					* 设置： 客户手机号
					*/
					public void setKehuPhone(String kehuPhone) {
						this.kehuPhone = kehuPhone;
					}

					/**
					* 获取： 客户身份证号
					*/
					public String getKehuIdNumber() {
						return kehuIdNumber;
					}
					/**
					* 设置： 客户身份证号
					*/
					public void setKehuIdNumber(String kehuIdNumber) {
						this.kehuIdNumber = kehuIdNumber;
					}

					/**
					* 获取： 客户头像
					*/
					public String getKehuPhoto() {
						return kehuPhoto;
					}
					/**
					* 设置： 客户头像
					*/
					public void setKehuPhoto(String kehuPhoto) {
						this.kehuPhoto = kehuPhoto;
					}

					/**
					* 获取： 客户地址
					*/
					public String getKehuAddress() {
						return kehuAddress;
					}
					/**
					* 设置： 客户地址
					*/
					public void setKehuAddress(String kehuAddress) {
						this.kehuAddress = kehuAddress;
					}

					/**
					* 获取： 客户职业
					*/
					public String getKehuZhiye() {
						return kehuZhiye;
					}
					/**
					* 设置： 客户职业
					*/
					public void setKehuZhiye(String kehuZhiye) {
						this.kehuZhiye = kehuZhiye;
					}

					/**
					* 获取： 地区
					*/
					public Integer getDiquTypes() {
						return diquTypes;
					}
					/**
					* 设置： 地区
					*/
					public void setDiquTypes(Integer diquTypes) {
						this.diquTypes = diquTypes;
					}


						/**
						* 获取： 地区的值
						*/
						public String getDiquValue() {
							return diquValue;
						}
						/**
						* 设置： 地区的值
						*/
						public void setDiquValue(String diquValue) {
							this.diquValue = diquValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getKehuEmail() {
						return kehuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setKehuEmail(String kehuEmail) {
						this.kehuEmail = kehuEmail;
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
