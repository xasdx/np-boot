package io.asdx.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    private String firstName;
    private String lastName;
    private String country;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
