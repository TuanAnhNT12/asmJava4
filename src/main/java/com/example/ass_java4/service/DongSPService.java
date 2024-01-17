package com.example.ass_java4.service;

import com.example.ass_java4.Model.DongSP;
import com.example.ass_java4.Uti.Hibernate;
import com.example.ass_java4.repository.DongSPRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class DongSPService {
    DongSPRepo dongSPRepo= new DongSPRepo();
    public ArrayList<DongSP> getAll(){
        return dongSPRepo.getAll();
    }
    public void themDSP(DongSP dsp){
        dongSPRepo.themDSP(dsp);
    }
    public void SuaDSP(DongSP dsp){
       dongSPRepo.SuaDSP(dsp);
    }
    public DongSP getById(UUID id){
        return dongSPRepo.getById(id);
    }
    public void xoaDSP(UUID id){
        DongSP dsp= dongSPRepo.getById(id);
        if(dsp != null){
            dongSPRepo.xoaDSP(dsp);
        }
    }
}
