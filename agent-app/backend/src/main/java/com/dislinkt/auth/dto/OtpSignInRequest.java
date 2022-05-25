package com.dislinkt.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OtpSignInRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String otp;
}
