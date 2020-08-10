package com.os.model;


import java.util.HashMap;
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
public class ShoppingCart {

    private HashMap<String, Integer> items;

    private long cost;

    private long totalCost;

}
