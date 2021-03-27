package io.lunit.exam.domain;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Slide {


    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column(length = 60)
    @NotNull
    private String fileName;

    @Column(length = 300)
    @NotNull
    private String filePath;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;


    public Slide(String filename, String path, Account account) {
        this.fileName = filename;
        this.filePath = path;
        this.account = account;
    }

    public void securitySet() {
        this.id = 0;
        this.filePath = "";
        this.account.setPassword("");
    }
}
