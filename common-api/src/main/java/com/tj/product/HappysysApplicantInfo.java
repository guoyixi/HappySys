package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysApplicantInfo implements Serializable {

    //`applicant_id`,`applicant_name`,`applicant_sex`,`applicant_identity`,`applicant_phone`
    // ,`applicant_birthday`,`applicant_email`,

    @TableId
    private Integer applicantId;
    private String applicantName;
    private String applicantSex;
    private String applicantIdentity;
    private String applicantPhone;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date applicantBirthday;
    private String applicantEmail;
    private Integer applicantUserId;


}
