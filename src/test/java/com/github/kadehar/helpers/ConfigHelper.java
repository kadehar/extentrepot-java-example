package com.github.kadehar.helpers;

import com.github.kadehar.config.ReportConfig;
import org.aeonbits.owner.ConfigFactory;

/**
 * Инициализация конфигурации ReportConfig.
 *
 * @author kadehar
 * @version 1.0
 * @since 12/14/2020
 */
public class ConfigHelper {
    /** Возвращает проинициализированный конфиг и выводит данные из конфига в журнал. */
    public static ReportConfig report() {
        return ConfigFactory.newInstance().create(ReportConfig.class);
    }
}
