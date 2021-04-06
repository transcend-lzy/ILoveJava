package com.chaoyue.java;

import javax.management.InstanceAlreadyExistsException;

/**
 * @author chaoyue
 * @data2021-04-06 14:49
 */
//线程安全的单例模式
public class SingleSafeTest {

}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
