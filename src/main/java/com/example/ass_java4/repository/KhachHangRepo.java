package com.example.ass_java4.repository;

import com.example.ass_java4.Model.KhachHang;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class KhachHangRepo {
    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> lst= new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst=(ArrayList<KhachHang>) session.createQuery("from KhachHang ").list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themKH(KhachHang khachHang){
        Transaction transaction= null;
        try(Session session=Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void suaKH(KhachHang khachHang){
        Transaction transaction= null;
        try(Session session=Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(khachHang);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public KhachHang getById(UUID id){
        KhachHang khachHang= new KhachHang();
        try(Session session= Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from KhachHang where id= :id");
            query.setParameter("id",id);
            khachHang=(KhachHang) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();

        }
        return khachHang;
    }
    public void xoaKH(KhachHang khachHang){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
