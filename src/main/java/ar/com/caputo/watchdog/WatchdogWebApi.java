package ar.com.caputo.watchdog;

import ar.com.caputo.watchdog.server.ServerConfiguration;

public class WatchdogWebApi {

    private static WatchdogWebApi instance;
    private final ServerConfiguration CONFIGURATION;
    
    private WatchdogWebApi() {
        
        this.CONFIGURATION = new ServerConfiguration();

    }
    
    public static void main(String... args) {

        WatchdogWebApi.getInstance().init();

    }


    public static WatchdogWebApi getInstance() {
        if(instance == null) instance = new WatchdogWebApi();
        return instance;
    }

    public void init() {

        CONFIGURATION.apply();

    }
    
}
