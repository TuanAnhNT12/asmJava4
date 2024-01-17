package com.example.ass_java4.service;

import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.Model.MauSac;
import com.example.ass_java4.repository.MauSacRepo;

import java.util.ArrayList;
import java.util.UUID;

public class MauSacService {
    MauSacRepo mauSacRepo= new MauSacRepo();
    public ArrayList<MauSac> getAll(){
        return mauSacRepo.getAll();
    }
    public void themMS(MauSac mauSac){
        mauSacRepo.themMS(mauSac);
    }
    public void suaMS(MauSac mauSac){
        mauSacRepo.suaMS(mauSac);
    }
    public MauSac getById(UUID id){
        return  mauSacRepo.getByID(id);
    }
    public void XoaMS(UUID id){
        MauSac ms= mauSacRepo.getByID(id);
        if(ms != null){
            mauSacRepo.xoaMS(ms);
        }
    }
}
