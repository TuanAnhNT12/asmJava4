package com.example.ass_java4.repository;

import com.example.ass_java4.Model.CuaHang;
import com.example.ass_java4.Model.DongSP;
import com.example.ass_java4.Model.GioHang;
import com.example.ass_java4.Model.HoaDon;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class GioHangRepo {

    public ArrayList<GioHang> getAll(){
        ArrayList<GioHang> lst= new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<GioHang>) session.createQuery("from GioHang ").list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themGH(GioHang gh){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void suaGH(GioHang gh){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public GioHang getById(UUID id){
        GioHang gh= new GioHang();
        try(Session session= Hibernate.getFACTORY().openSession()) {
            Query query= session.createQuery("from GioHang where id = :id");
            query.setParameter("id",id);
            gh= (GioHang) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return gh;
    }
    public void xoaGH(GioHang gh){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

}
