package com.example.ass_java4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name="GioHang")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    @OneToOne
    @JoinColumn(name="IdCTSP")
    private ChiTietSP IdCTSP;
    @Column(name="TenSP")
    private String TenSP;
    @Column(name="Anh")
    private byte[] Anh;
    @Column(name="MauSac")
    private String MauSac;
    @Column(name="SoLuong")
    private Integer SoLuong;
    @Column(name="GiaBan")
    private BigDecimal GiaBan;
}
