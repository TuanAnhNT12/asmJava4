package com.example.ass_java4.repository;

import com.example.ass_java4.Model.ChucVu;
import com.example.ass_java4.Model.NSX;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NSXRepo {
    public ArrayList<NSX> getAll(){
        ArrayList<NSX> lst = new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<NSX>) session.createQuery("from NSX ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themNSX(NSX nsx){
        Transaction transaction= null;
        try(Session session=Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.save(nsx);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void suaNSX(NSX nsx){
        Transaction transaction= null;
        try(Session session=Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(nsx);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NSX getByID(UUID id){
        NSX nsx= new NSX();
        try(Session session= Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from NSX where id = :id");
            query.setParameter("id",id);
            nsx=(NSX) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return nsx;
    }
    public void xoaNSX(NSX nsx){
        Transaction transaction=null;
        try(Session session= Hibernate.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
