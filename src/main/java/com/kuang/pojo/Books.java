package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：ltb
 * @date ：2020/7/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private Integer bookId;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
