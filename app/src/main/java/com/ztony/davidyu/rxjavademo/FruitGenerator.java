package com.ztony.davidyu.rxjavademo;

import java.util.Random;

/**
 * Created by davidyu on 7/13/18.
 */

public class FruitGenerator implements Generator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {

        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
