package com.example.ass_java4.repository;

import com.example.ass_java4.Model.MauSac;
import com.example.ass_java4.Model.NSX;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class MauSacRepo {
    public ArrayList<MauSac> getAll(){
        ArrayList<MauSac> lst = new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<MauSac>) session.createQuery("from MauSac ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themMS(MauSac ms){
        Transaction transaction= null;
        try(Session session=Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.save(ms);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void suaMS(MauSac ms){
        Transaction transaction= null;
        try(Session session=Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(ms);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public MauSac getByID(UUID id){
        MauSac mauSac= new MauSac();
        try(Session session= Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from MauSac where id = :id");
            query.setParameter("id",id);
            mauSac=(MauSac) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }
    public void xoaMS(MauSac mauSac){
        Transaction transaction=null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
