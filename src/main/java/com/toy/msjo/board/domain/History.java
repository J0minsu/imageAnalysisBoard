package io.lunit.exam.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    @NotNull
    private LocalDateTime analysisDate;

    @Column
    @NonNull
    private Boolean isSuccess;

    @Column(columnDefinition = "TEXT")
    private String result;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "slideId")
    private Slide slide;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;


    @PrePersist
    public void createdAt() {
        this.analysisDate = LocalDateTime.now();
    }


}
