/**
 * Project Name: face-recognition-mms
 * File Name: AvaliableTimeVO.java
 * Package Name: com.why.dev.mms.mm.vo
 * Date: 2019-03-02 12:09
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: AvaliableTimeVO
 * Description: TODO
 * Date: 2019-03-02 12:09
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AvaliableTimeVO {

    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date endTime;
}
