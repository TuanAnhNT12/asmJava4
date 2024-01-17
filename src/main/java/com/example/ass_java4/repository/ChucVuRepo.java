package com.example.ass_java4.repository;

import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuRepo {
    public ArrayList<ChucVu> getAll(){
        ArrayList<ChucVu> lst = new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<ChucVu>) session.createQuery("from ChucVu ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themCV(ChucVu cv){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void SuaCV(ChucVu cv){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(cv);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public ChucVu getById(UUID id){
        ChucVu cv= new ChucVu();
        try(Session session= Hibernate.getFACTORY().openSession()) {
            Query query= session.createQuery("from ChucVu where id = :id");
            query.setParameter("id",id);
            cv= (ChucVu) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cv;
    }
    public void xoaCV(ChucVu chucVu){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
