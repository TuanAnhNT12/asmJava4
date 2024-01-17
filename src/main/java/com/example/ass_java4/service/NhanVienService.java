package com.example.ass_java4.service;

import com.example.ass_java4.Model.NhanVien;
import com.example.ass_java4.repository.NhanVienRepo;

import java.util.ArrayList;
import java.util.UUID;

public class NhanVienService {
    NhanVienRepo nhanVienRepo= new NhanVienRepo();
    public ArrayList<NhanVien> getAll(){
        return nhanVienRepo.getAll();
    }
    public void themNV(NhanVien nhanVien){
        nhanVienRepo.themNV(nhanVien);
    }
    public void suaNV(NhanVien nhanVien){
        nhanVienRepo.suaNV(nhanVien);
    }
    public void xoaNV(UUID id){
        NhanVien nv= nhanVienRepo.getByID(id);
        if(nv != null){
            nhanVienRepo.xoaNV(nv);
        }
    }
    public NhanVien getByID(UUID id){
        return nhanVienRepo.getByID(id);
    }
}
