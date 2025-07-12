package dev.fraporti.utfpr_dbs.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtil {
    public static ZonedDateTime now() {
        return ZonedDateTime.now(here());
    }

    private static ZoneId here() {
        return ZoneId.of("America/Sao_Paulo");
    }
}
