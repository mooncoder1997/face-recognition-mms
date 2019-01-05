/**
 * Project Name: mms-provider-face
 * File Name: FaceEngineFactory.java
 * Package Name: com.why.dev.mms.face.util
 * Date: 2018/12/24 9:38 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.util;

import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * ClassName: FaceEngineFactory
 * Description: SDK操作工厂类
 * Date: 2018/12/24 9:38 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
public class FaceEngineFactory extends BasePooledObjectFactory<FaceEngine> {
    private String appId;
    private String sdkKey;
    private FunctionConfiguration functionConfiguration;
    private Integer detectFaceMaxNum=10;
    private Integer detectFaceScaleVal=16;
    private DetectMode detectMode= DetectMode.ASF_DETECT_MODE_IMAGE;
    private DetectOrient detectFaceOrientPriority= DetectOrient.ASF_OP_0_HIGHER_EXT;

    public FaceEngineFactory(String appId, String sdkKey, FunctionConfiguration functionConfiguration) {
        this.appId = appId;
        this.sdkKey = sdkKey;
        this.functionConfiguration = functionConfiguration;
    }

    /**
     * create: 初始化引擎
     *
     * @return
     */
    @Override
    public FaceEngine create() {
        EngineConfiguration engineConfiguration= EngineConfiguration.builder()
                .functionConfiguration(functionConfiguration)
                .detectFaceMaxNum(detectFaceMaxNum)
                .detectFaceScaleVal(detectFaceScaleVal)
                .detectMode(detectMode)
                .detectFaceOrientPriority(detectFaceOrientPriority)
                .build();
        FaceEngine faceEngine =new FaceEngine();
        faceEngine.active(appId,sdkKey);
        faceEngine.init(engineConfiguration);
        log.info("[FaceEngineFactory] create() 激活并初始化引擎");
        return faceEngine;
    }

    @Override
    public PooledObject<FaceEngine> wrap(FaceEngine faceEngine) {
        return new DefaultPooledObject<>(faceEngine);
    }

    /**
     * destroyObject: 销毁引擎
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void destroyObject(PooledObject<FaceEngine> p) throws Exception {
        FaceEngine faceEngine = p.getObject();
        faceEngine.unInit();
        super.destroyObject(p);
        log.info("[FaceEngineFactory] destroyObject() 销毁引擎");
    }
}
