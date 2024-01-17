package com.example.ass_java4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;

@Table(name="NhanVien")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
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
    @Column(name="GioiTinh")
    private String GioiTinh;
    @Column(name="NgaySinh")
    private Date NgaySinh;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="MatKhau")
    private String MatKhau;
    @ManyToOne
    @JoinColumn(name="IdCH")
    private CuaHang IdCH;
    @ManyToOne
    @JoinColumn(name="IdCV")
    private ChucVu IdCV;
    @Column(name="TrangThai")
    private Integer TrangThai;

    @Override
    public String toString() {
        return "NhanVien{" +
                "Id=" + Id +
                ", Ma='" + Ma + '\'' +
                ", Ten='" + Ten + '\'' +
                ", TenDem='" + TenDem + '\'' +
                ", Ho='" + Ho + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", NgaySinh=" + NgaySinh +
                ", DiaChi='" + DiaChi + '\'' +
                ", Sdt='" + Sdt + '\'' +
                ", MatKhau='" + MatKhau + '\'' +
                ", IdCH=" + IdCH +
                ", IdCV=" + IdCV +
                ", TrangThai=" + TrangThai +
                '}';
    }
}
