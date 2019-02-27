/**
 * Project Name: face-recognition-mms
 * File Name: MeetingService
 * Package Name: com.why.dev.mms.mm.service
 * Date: 2019-02-28 00:33
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.service;

import com.why.dev.mms.mm.dao.MeetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: MeetingService
 * Description: TODO
 * Date: 2019-02-28 00:33
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Service
public class MeetingService {

    @Autowired
    private MeetingMapper meetingMapper;
}
