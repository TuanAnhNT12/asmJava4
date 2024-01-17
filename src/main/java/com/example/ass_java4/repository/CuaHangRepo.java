package com.example.ass_java4.repository;

import com.example.ass_java4.Model.CuaHang;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangRepo {
    public ArrayList<CuaHang> getAll(){
        ArrayList<CuaHang> lst= new ArrayList<>();
        try (Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<CuaHang>) session.createQuery("from CuaHang ").list();
        }
        return lst;
    }
    public void themCH(CuaHang cuaHang){
        Transaction transaction= null;
        try (Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void suaCH(CuaHang cuaHang){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(cuaHang);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public CuaHang getByID(UUID id){
        CuaHang ch= new CuaHang();
        try (Session session = Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from CuaHang where id= :id");
            query.setParameter("id",id);
            ch= (CuaHang) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ch;
    }
    public void XoaCH(CuaHang ch){
        Transaction transaction= null;
        try (Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(ch);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
