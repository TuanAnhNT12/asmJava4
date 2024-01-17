package com.example.ass_java4.service;

import com.example.ass_java4.Model.HoaDonChiTiet;
import com.example.ass_java4.Model.HoaDon;
import com.example.ass_java4.repository.HoaDonRepo;

import java.util.ArrayList;
import java.util.UUID;

public class HoaDonService {
    HoaDonRepo hoaDonRepo= new HoaDonRepo();
    public void themHoaDon(HoaDon hd){
        hoaDonRepo.themHoaDon(hd);
    }
    public void themCTHoaDon(HoaDonChiTiet ct){
        hoaDonRepo.themCTHoaDon(ct);
    }
    public HoaDon getHDMoiNhat(){
        return hoaDonRepo.getHDMoiNhat();
    }
    public ArrayList<HoaDon> getHDAll(){
        return hoaDonRepo.getHDAll();
    }
    public ArrayList<HoaDonChiTiet> getChiTietHDAll(){
        return hoaDonRepo.getChiTietHDAll();
    }
    public HoaDon getByIDHD(UUID id){
        return hoaDonRepo.getByIDHD(id);
    }
}
