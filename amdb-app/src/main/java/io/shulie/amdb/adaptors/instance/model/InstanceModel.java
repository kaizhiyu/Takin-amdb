/*
 * Copyright 2021 Shulie Technology, Co.Ltd
 * Email: shulie@shulie.io
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.shulie.amdb.adaptors.instance.model;


import io.shulie.amdb.adaptors.AdaptorModel;
import lombok.Data;

/**
 * agent实例模型
 *
 * @author vincent
 */
@Data
public class InstanceModel implements AdaptorModel {

    //agent编号
    private String agentId;
    //客户ID
    private String userId;
    //地址
    private String address;
    //主机名
    private String host;
    //名称
    private String name;
    //agent版本
    private String agentVersion;
    //agent语言
    private String agentLanguage;
    //jar包
    private String jars;
    //进程编号
    private String pid;
    //错误编码
    private String errorCode;
    //错误信息
    private String errorMsg;
    //md5信息
    private String md5;
    //状态
    private boolean status;
    //GC类型
    private String gcType;
    //启动时间
    private long startTime;
    //JDK版本
    private String jdkVersion;
    //扩展字段
    private String ext;
    //该字段表示探针的配置文件配置信息，是一个hashmap的json字符串
    private String simulatorFileConfigs;
    //模块加载结果 ture 加载成功
    private Boolean moduleLoadResult;
    //模块加载详情  json map
    private String moduleLoadDetail;
    // 探针状态
    private String agentStatus;
    // 探针版本
    private String simulatorVersion;
    //该字段表示agent配置文件信息，是一个hashmap的json字符串
    private String agentFileConfigs;
    //状态判断
    private String simulatorFileConfigsCheck;
}

