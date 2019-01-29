/**
 * Project Name: face-recognition-mms
 * File Name: SMFeign
 * Package Name: com.why.dev.mms.face.feign
 * Date: 2019-01-29 10:23
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.feign;

import com.why.dev.mms.face.dto.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: SMFeign
 * Description: TODO
 * Date: 2019-01-29 10:23
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@FeignClient(name = "mms-provider-sm")
public interface SMFeign {

    @RequestMapping(value = "/api/v1/user/user/{userId}", method = RequestMethod.GET)
    ResponseResult getUserInfoByUserId(@PathVariable("userId") String userId);
}
