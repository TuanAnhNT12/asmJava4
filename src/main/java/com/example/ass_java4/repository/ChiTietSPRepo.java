package com.example.ass_java4.repository;

import com.example.ass_java4.Model.ChiTietSP;
import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChiTietSPRepo {
    public ArrayList<ChiTietSP> getAll(){
        ArrayList<ChiTietSP> lst = new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<ChiTietSP>) session.createQuery("from ChiTietSP ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themCTSP(ChiTietSP ctsp){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void SuaCTSP(ChiTietSP ctsp){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(ctsp);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public ChiTietSP getById(UUID id){
        ChiTietSP ctsp= new ChiTietSP();
        try(Session session= Hibernate.getFACTORY().openSession()) {
            Query query= session.createQuery("from ChiTietSP where id = :id");
            query.setParameter("id",id);
            ctsp= (ChiTietSP) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ctsp;
    }
    public void xoaCTSP(ChiTietSP ctsp){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void  UpdateSL(UUID id, Integer sl){
        Transaction transaction=null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            Query query= session.createQuery("update ChiTietSP set SoLuongTon = :sl where Id = :id");
            query.setParameter("id",id);
            query.setParameter("sl",sl);
            int kq= query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
