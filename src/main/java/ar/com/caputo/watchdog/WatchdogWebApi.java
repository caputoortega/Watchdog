package ar.com.caputo.watchdog;

import ar.com.caputo.watchdog.server.ServerConfiguration;

public class WatchdogWebApi {

    private static WatchdogWebApi instance;
    private ServerConfiguration configuration;
    
    private WatchdogWebApi() {}
    
    public static void main(String... args) {

        if(args.length < 1) {
            System.err.println("You must provide an authentication secret!");
            return;
        }

        WatchdogWebApi.getInstance().init(args[0]);

    }


    public static WatchdogWebApi getInstance() {
        if(instance == null) instance = new WatchdogWebApi();
        return instance;
    }

    public void init(String secret) {

        if(this.configuration == null) {
            this.configuration = new ServerConfiguration(secret);
        }

        this.configuration.apply();

    }
    
}
