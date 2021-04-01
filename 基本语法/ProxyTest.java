package com.chaoyue.java;

import java.lang.reflect.Proxy;

/**
 * @author chaoyue
 * @data2021-04-01 20:10
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.browse();
    }
}

interface NetWork{
    public void browse();
}

class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("true server");
    }
}

class ProxyServer implements NetWork{
    private NetWork work;

    public ProxyServer(NetWork work){
        this.work = work;
    }

    public void check(){
        System.out.println("check network");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}
