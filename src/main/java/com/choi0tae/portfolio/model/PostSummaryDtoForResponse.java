package com.choi0tae.portfolio.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class PostSummaryDtoForResponse {
    Long post_id;
    String user_string_id;
    String title;
    String summary;
    LocalDate posted_date;
    LocalTime posted_time;
}
