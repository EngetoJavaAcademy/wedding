package com.engeto.wedding.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    public String message;

    public String author;

    public LocalDateTime timestamp;

}
