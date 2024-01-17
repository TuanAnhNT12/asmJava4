package com.example.ass_java4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name="ChiTietSP")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP {
    @Id
    @Column(name="Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    @ManyToOne
    @JoinColumn(name="IdSP")
    private SanPham IdSP;
    @ManyToOne
    @JoinColumn(name="IdNsx")
    private NSX IdNsx;
    @ManyToOne
    @JoinColumn(name="IdMauSac")
    private MauSac IdMauSac;
    @ManyToOne
    @JoinColumn(name="IdDongSP")
    private DongSP IdDongSP;
    @Column(name="NamBH")
    private Integer NamBH;
    @Column(name="MoTa")
    private String MoTa;
    @Column(name="SoLuongTon")
    private Integer SoLuongTon;
    @Column(name="GiaNhap")
    private BigDecimal GiaNhap;
    @Column(name="GiaBan")
    private BigDecimal GiaBan;


}
