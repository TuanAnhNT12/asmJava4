package com.example.ass_java4.service;

import com.example.ass_java4.Model.ChiTietSP;
import com.example.ass_java4.repository.ChiTietSPRepo;

import java.util.ArrayList;
import java.util.UUID;

public class ChiTietSPService {
    ChiTietSPRepo chiTietSPRepo= new ChiTietSPRepo();
    public ArrayList<ChiTietSP> getAll(){
        return chiTietSPRepo.getAll();
    }
    public void themCTSP(ChiTietSP ctsp){
        chiTietSPRepo.themCTSP(ctsp);
    }
    public void suaCTSP(ChiTietSP ctsp){
        chiTietSPRepo.SuaCTSP(ctsp);
    }
    public ChiTietSP getById(UUID id){
        return  chiTietSPRepo.getById(id);
    }
    public void XoaCTSP(UUID id){
        ChiTietSP ctsp= chiTietSPRepo.getById(id);
        if(ctsp != null){
            chiTietSPRepo.xoaCTSP(ctsp);
        }
    }
    public void  UpdateSL(UUID id, Integer sl){
        chiTietSPRepo.UpdateSL(id,sl);
    }
}
