package com.example.ass_java4.service;

import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.Model.NSX;
import com.example.ass_java4.repository.ChucVuRepo;
import com.example.ass_java4.repository.NSXRepo;

import java.util.ArrayList;
import java.util.UUID;

public class NSXService {
    NSXRepo repo= new NSXRepo();
    public ArrayList<NSX> getAll(){
        return repo.getAll();
    }
    public void themNSX(NSX nsx){
        repo.themNSX(nsx);
    }
    public void suaNSX(NSX nsx){
        repo.suaNSX(nsx);
    }
    public NSX getByID(UUID id){
        return repo.getByID(id);
    }
    public void xoaNSX(UUID id){
        NSX nsx= repo.getByID(id);
        if(nsx !=null){
            repo.xoaNSX(nsx);
        }
    }
}
