package com.example.vo;

import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Fatal
 * @date 2020/7/6 8:19
 */
@Data
@Accessors(chain = true)
public class HeaderVO {

    private Map<String, String> headers;

}
