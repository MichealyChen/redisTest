package com.example.myproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * YangPH
 * @author 样例VO
 *
 */
@Data
public class TestVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
    @NotNull(message = "password 不能为空")
	private String password;

    @JsonFormat(pattern = "yyyy-MM-dd ", timezone ="GMT+8")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8")
    private Date endDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate1;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8")
	private LocalDate endDate1;


}
