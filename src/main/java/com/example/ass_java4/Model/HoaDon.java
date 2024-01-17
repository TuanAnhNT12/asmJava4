package com.example.ass_java4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="HoaDon")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @jakarta.persistence.Id
    @Column(name="Id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID Id;
    @ManyToOne
    @JoinColumn(name="IdKH")
    private KhachHang IdKH;
    @ManyToOne
    @JoinColumn(name="IdNV")
    private NhanVien IdNV;
    @Column(name="NgayTao")
    private LocalDateTime NgayTao;
    @Column(name="NgayThanhToan")
    private Date NgayThanhToan;
    @Column(name="NgayShip")
    private Date NgayShip;
    @Column(name="NgayNhan")
    private Date NgayNhan;
    @Column(name="TinhTrang")
    private Integer TinhTrang;
    @Column(name="TenNguoiNhan")
    private String TenNguoiNhan;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="Sdt")
    private String Sdt;

    @Override
    public String toString() {
        return "HoaDon{" +
                "Id=" + Id +
                ", IdKH=" + IdKH +
                ", IdNV=" + IdNV +
                ", NgayTao=" + NgayTao +
                ", NgayThanhToan=" + NgayThanhToan +
                ", NgayShip=" + NgayShip +
                ", NgayNhan=" + NgayNhan +
                ", TinhTrang=" + TinhTrang +
                ", TenNguoiNhan='" + TenNguoiNhan + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Sdt='" + Sdt + '\'' +
                '}';
    }
}
