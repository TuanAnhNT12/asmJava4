package com.example.ass_java4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;

@Table(name="KhachHang")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    @Column(name="Ma", unique = true)
    private String Ma;
    @Column(name="Ten")
    private String Ten;
    @Column(name="TenDem")
    private String TenDem;
    @Column(name="Ho")
    private String Ho;
    @Column(name="NgaySinh")
    private Date NgaySinh;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="ThanhPho")
    private String ThanhPho;
    @Column(name="QuocGia")
    private String QuocGia;
    @Column(name="MatKhau")
    private String MatKhau;
}
