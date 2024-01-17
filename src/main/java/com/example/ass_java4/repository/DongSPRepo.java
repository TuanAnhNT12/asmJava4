package com.example.ass_java4.repository;

import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.Model.DongSP;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class DongSPRepo {
    public ArrayList<DongSP> getAll(){
        ArrayList<DongSP> lst = new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<DongSP>) session.createQuery("from DongSP ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themDSP(DongSP dsp){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void SuaDSP(DongSP dsp){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(dsp);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public DongSP getById(UUID id){
        DongSP dsp= new DongSP();
        try(Session session= Hibernate.getFACTORY().openSession()) {
            Query query= session.createQuery("from DongSP where id = :id");
            query.setParameter("id",id);
            dsp= (DongSP) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dsp;
    }
    public void xoaDSP(DongSP dsp){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
