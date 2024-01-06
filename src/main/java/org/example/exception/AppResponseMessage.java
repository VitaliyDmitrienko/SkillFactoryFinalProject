package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class AppResponseMessage {
    private int statusCode;
    private Date timestamp;
}
