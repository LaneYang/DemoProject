package com.os.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author youyuan.lv
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    private long itemId;

    private String itemName;

    private int itemPrice;

}
