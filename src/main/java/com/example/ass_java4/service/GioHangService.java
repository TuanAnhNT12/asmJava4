package com.example.ass_java4.service;

import com.example.ass_java4.Model.GioHang;
import com.example.ass_java4.Uti.Hibernate;
import com.example.ass_java4.repository.GioHangRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class GioHangService {
    GioHangRepo gioHangRepo= new GioHangRepo();
    public ArrayList<GioHang> getAll(){
        return gioHangRepo.getAll();
    }
    public void themGH(GioHang gh){
        gioHangRepo.themGH(gh);
    }
    public void suaGH(GioHang gh){
        gioHangRepo.suaGH(gh);
    }
    public GioHang getById(UUID id){
        return gioHangRepo.getById(id);
    }
    public void xoaGH(UUID id){
        GioHang gh= gioHangRepo.getById(id);
        if(gh != null){
            gioHangRepo.xoaGH(gh);
        }
    }
}
