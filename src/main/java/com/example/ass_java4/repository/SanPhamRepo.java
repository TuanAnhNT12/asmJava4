package com.example.ass_java4.repository;

import com.example.ass_java4.Model.SanPham;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class SanPhamRepo {
    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> lst= new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst=(ArrayList<SanPham>) session.createQuery("from SanPham").list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void ThemSP(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void SuaSP(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public SanPham getByID(UUID id){
        SanPham sp = new SanPham();
        try(Session session= Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from SanPham where id = :id");
            query.setParameter("id",id);
            sp=(SanPham) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return sp;
    }
    public void XoaSP(SanPham sanPham){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()){
           transaction= session.beginTransaction();
           session.delete(sanPham);
           transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
