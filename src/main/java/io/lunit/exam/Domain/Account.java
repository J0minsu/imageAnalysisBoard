package io.lunit.exam.Domain;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(length = 16, nullable = false)
    @NotNull
    private String password;
}
