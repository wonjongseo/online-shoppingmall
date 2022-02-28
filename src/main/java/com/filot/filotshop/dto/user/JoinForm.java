package com.filot.filotshop.dto.user;


import lombok.*;

@Builder
@Getter @Setter
@ToString
@AllArgsConstructor
public class JoinForm {

    private String email;
    private String name;
    private String password;
    private String detailAddress;
    private String phoneNumber;
    private String roadAddress;
    private String authorities;



}
