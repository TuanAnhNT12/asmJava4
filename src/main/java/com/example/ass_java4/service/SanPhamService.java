package com.example.ass_java4.service;

import com.example.ass_java4.Model.SanPham;
import com.example.ass_java4.repository.SanPhamRepo;

import java.util.ArrayList;
import java.util.UUID;

public class SanPhamService {
    SanPhamRepo sanPhamRepo= new SanPhamRepo();
    public ArrayList<SanPham> getAll(){
        return sanPhamRepo.getAll();
    }
    public void ThemSP(SanPham sanPham) {
        sanPhamRepo.ThemSP(sanPham);
    }
    public void SuaSP(SanPham sanPham) {
        sanPhamRepo.SuaSP(sanPham);
    }
    public SanPham getByID(UUID id) {
        return sanPhamRepo.getByID(id);
    }
    public void XoaSP(UUID id){
        SanPham sp= sanPhamRepo.getByID(id);
        if(sp!=null){
            sanPhamRepo.XoaSP(sp);
        }
    }

}
