package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class AppErrorMessage {
    private int statusCode;
    private String message;
    private Date timestamp;
}