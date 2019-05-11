/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.exception;

/**
 * The Exception for parsing
 *
 * @author Leon
 * @version 2019/5/10 13:45
 */
public class ParseException extends RuntimeException{

    public ParseException() {
        super();
    }

    public ParseException(String msg) {
        super(msg);
    }

    public ParseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ParseException(Throwable cause) {
        super(cause);
    }
}
