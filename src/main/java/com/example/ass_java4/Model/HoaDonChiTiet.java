package com.example.ass_java4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name="HoaDonChiTiet")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTiet {
    @Id
    @Column(name="Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    @ManyToOne
    @JoinColumn(name="IdHoaDon")
    private HoaDon IdHoaDon;
    @ManyToOne
    @JoinColumn(name="IdChiTietSP")
    private ChiTietSP IdChiTietSP;
    @Column(name="SoLuong")
    private Integer SoLuong;
    @Column(name="DonGia")
    private BigDecimal DonGia;
}
