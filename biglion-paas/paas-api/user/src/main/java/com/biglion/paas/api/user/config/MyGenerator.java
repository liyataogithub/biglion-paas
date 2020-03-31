package com.biglion.paas.api.user.config;

import java.sql.SQLException;
import java.util.Date;

import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.util.EntityInfoUtil;
import com.github.mybatis.fl.util.Generator;
import com.github.mybatis.fl.util.MySqlToJavaUtil;

/**
 *
 * mysql8+mybatis-plus3.1自动生成带lombok和swagger和增删改查接口
 * https://my.oschina.net/bianxin/blog/3035352?nocache=1554967026459
 *
 * Copyright: Copyright (c) 2019
 *
 * <p>说明： 自动生成工具</P>
 * <p>源码地址：https://gitee.com/flying-cattle/mybatis-dsc-generator</P>
 */
public class MyGenerator {
    // 基础信息：项目名、作者、版本
    public static final String PROJECT = "biglion-paas";
    public static final String AUTHOR = "liyt";
    public static final String VERSION = "V1.0";
    // 数据库连接信息：连接URL、用户名、秘密、数据库名
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/biglion_paas?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String NAME = "root";
    public static final String PASS = "password";
    public static final String DATABASE = "biglion_paas";
    // 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
    public static final String CLASSNAME = "User";
    public static final String TABLE = "user";
    public static final String CLASSCOMMENT = "用户";
    public static final String TIME = "2020年3月15日";
    public static final String AGILE = new Date().getTime() + "";
    // 路径信息，分开路径方便聚合工程项目，微服务项目
    public static final String ENTITY_URL = "com.biglion.paas.api.user.model";
    public static final String DAO_URL = "com.biglion.paas.api.user.mapper";
    public static final String XML_URL = "com.biglion.paas.api.user.impl";
    public static final String SERVICE_URL = "com.biglion.paas.api.user.service";
    public static final String SERVICE_IMPL_URL = "com.biglion.paas.api.user.service.impl";
    public static final String CONTROLLER_URL = "com.biglion.paas.api.user.controller";
    //是否是Swagger配置
    public static final String IS_SWAGGER = "true";

    public static void main(String[] args) {
        BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, CLASSNAME, AGILE, ENTITY_URL, DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
        bi.setTable(TABLE);
        bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
        bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
        bi.setEntityComment(CLASSCOMMENT);
        try {
            bi = EntityInfoUtil.getInfo(bi);
            String fileUrl = "D:\\liyatao\\mybatis-gen-code\\";// 生成文件存放位置
            //开始生成文件
            String aa1 = Generator.createEntity(fileUrl, bi).toString();
            String aa2 = Generator.createDao(fileUrl, bi).toString();
            String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
            String aa4 = Generator.createService(fileUrl, bi).toString();
            String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
            String aa6 = Generator.createController(fileUrl, bi).toString();

            System.out.println(aa1);
            System.out.println(aa2);
            System.out.println(aa3);
            System.out.println(aa4);
            System.out.println(aa5);
            System.out.println(aa6);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}