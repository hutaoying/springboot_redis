package com.zhuyi.springboot_redis.jedis.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataObject implements Serializable {
    Long id;
    String desc;
}
