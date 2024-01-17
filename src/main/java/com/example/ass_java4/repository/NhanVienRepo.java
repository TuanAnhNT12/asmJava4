package com.example.ass_java4.repository;

import com.example.ass_java4.Model.NhanVien;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NhanVienRepo {
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> lst= new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst=(ArrayList<NhanVien>) session.createQuery("from NhanVien").list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themNV(NhanVien nhanVien){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void suaNV(NhanVien nhanVien){
        Transaction transaction=null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(nhanVien);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void xoaNV(NhanVien nhanVien){
        Transaction transaction=null;
        try(Session session =Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NhanVien getByID(UUID id){
        NhanVien nv= new NhanVien();
        try(Session session= Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from NhanVien where id = :id");
            query.setParameter("id",id);
            nv= (NhanVien) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();

        }
        return nv;
    }
}
