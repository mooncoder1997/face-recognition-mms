/**
 * Project Name: face-recognition-mms
 * File Name: QueryAvaliableTimeDto
 * Package Name: com.why.dev.mms.mm.dto
 * Date: 2019-03-01 00:10
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: QueryAvaliableTimeDto
 * Description: TODO
 * Date: 2019-03-01 00:10
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QueryAvaliableTimeDto {

    private String roomName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date roomDate;
}
