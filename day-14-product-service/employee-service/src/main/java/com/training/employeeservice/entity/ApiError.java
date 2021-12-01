package com.training.employeeservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private HttpStatus httpStatus;

    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date timestamp;

    private String message;

    public ApiError(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
