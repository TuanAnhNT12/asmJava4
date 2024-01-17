package com.example.ass_java4.service;

import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.repository.ChucVuRepo;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuService {
    ChucVuRepo repo= new ChucVuRepo();
    public ArrayList<ChucVu> getAll(){
        return repo.getAll();
    }
    public void themCV(ChucVu chucVu){
        repo.themCV(chucVu);
    }
    public void suaCV(ChucVu chucVu){
        repo.SuaCV(chucVu);
    }
    public ChucVu getById(UUID id){
        return  repo.getById(id);
    }
    public void XoaCV(UUID id){
        ChucVu cv= repo.getById(id);
        if(cv != null){
            repo.xoaCV(cv);
        }
    }
}
