package com.toy.msjo.board.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    @Column(length = 16)
    private String id;

    @Column(length = 60, nullable = false)
    @NotNull
    private String password;


    public void securitySet() {
        this.password = "";
    }

}
