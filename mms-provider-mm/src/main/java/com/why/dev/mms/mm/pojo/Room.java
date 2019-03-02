/**
 * Project Name: face-recognition-mms
 * File Name: Room.java
 * Package Name: com.why.dev.mms.mm.pojo
 * Date: 2019-02-27 00:09
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName: Room
 * Description: 数据库MM_ROOM表实体类
 * Date: 2019-02-27 00:09
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    private String roomName;

    private String roomLocation;

    private Integer roomPeople;

    private String roomRemarks;
}
