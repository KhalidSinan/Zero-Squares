package com.company.jproject.Utils;

import java.util.logging.*;

public class LogFormatter extends Formatter{
    @Override
    public String format(LogRecord record) {
        return record.getMessage() + "\n=-=-=-=-=-=\n";
    }
}
