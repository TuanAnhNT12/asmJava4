package com.example.ass_java4.service;

import com.example.ass_java4.Model.CuaHang;
import com.example.ass_java4.repository.CuaHangRepo;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangService {
    CuaHangRepo repo= new CuaHangRepo();
    public ArrayList<CuaHang> getAll(){
        return repo.getAll();
    }
    public void themCH(CuaHang cuaHang){
        repo.themCH(cuaHang);
    }
    public void suaCH(CuaHang cuaHang){
        repo.suaCH(cuaHang);
    }
    public CuaHang getByID(UUID id){
        return repo.getByID(id);
    }
    public void XoaCH(UUID id){
        CuaHang cuaHang= repo.getByID(id);
        if(cuaHang != null){
            repo.XoaCH(cuaHang);
        }
    }
}
