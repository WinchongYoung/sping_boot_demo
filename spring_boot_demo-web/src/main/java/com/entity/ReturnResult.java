package com.entity;

import lombok.Builder;
import lombok.Data;


@Data
public class ReturnResult {

    private Integer err;

    private Integer ret;

    private Object data;
}
