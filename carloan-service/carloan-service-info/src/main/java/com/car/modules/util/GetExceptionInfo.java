package com.car.modules.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GetExceptionInfo {
	
    
    public static String getExceptionInfo(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        return buffer.toString();
    }


}
