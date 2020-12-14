package com.github.kadehar.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties",
        "file:~/config.properties",
        "file:./config.properties"
})
public interface ReportConfig extends Config {
    @Key("report.dir")
    String directory();
    @Key("report.name")
    String name();
}
