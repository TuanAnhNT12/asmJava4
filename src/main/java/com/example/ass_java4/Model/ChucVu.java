package com.example.ass_java4.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Table(name="ChucVu")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ChucVu {
    @Id
    @Column(name="Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    @Column(name="Ma", unique = true)
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    @Override
    public String toString() {
        return "ChucVu{" +
                "Id=" + Id +
                ", Ma='" + Ma + '\'' +
                ", Ten='" + Ten + '\'' +
                '}';
    }
}
