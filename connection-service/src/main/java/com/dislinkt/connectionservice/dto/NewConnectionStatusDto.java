package com.dislinkt.connectionservice.dto;

import com.dislinkt.connectionservice.model.ConnectionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewConnectionStatusDto {
    private String connectionStatus;
}
