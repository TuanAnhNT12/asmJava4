package com.example.ass_java4.service;

import com.example.ass_java4.Model.KhachHang;
import com.example.ass_java4.repository.KhachHangRepo;

import java.util.ArrayList;
import java.util.UUID;

public class KhachHangService {
    KhachHangRepo khachHangRepo= new KhachHangRepo();
    public ArrayList<KhachHang> getAll(){
        return khachHangRepo.getAll();
    }
    public void themKH(KhachHang khachHang){
        khachHangRepo.themKH(khachHang);
    }
    public void suaKH(KhachHang khachHang){
        khachHangRepo.suaKH(khachHang);
    }
    public KhachHang getById(UUID id){
        return khachHangRepo.getById(id);
    }
    public void xoaKH(UUID id){
        KhachHang kh= khachHangRepo.getById(id);
        if(kh != null){
            khachHangRepo.xoaKH(kh);
        }
    }
}
