package com.choi0tae.portfolio.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class PostDtoForResponse {
    String user_string_id;
    String title;
    String content;
    LocalDate created_date;
    LocalTime created_time;
}
