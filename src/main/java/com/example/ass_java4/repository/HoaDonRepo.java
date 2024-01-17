package com.example.ass_java4.repository;

import com.example.ass_java4.Model.HoaDonChiTiet;
import com.example.ass_java4.Model.HoaDon;
import com.example.ass_java4.Uti.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class HoaDonRepo {

    public ArrayList<HoaDon> getHDAll(){
        ArrayList<HoaDon> lst= new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<HoaDon>) session.createQuery("from HoaDon order by NgayTao desc").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public ArrayList<HoaDonChiTiet> getChiTietHDAll(){
        ArrayList<HoaDonChiTiet> lst= new ArrayList<>();
        try(Session session= Hibernate.getFACTORY().openSession()){
            lst= (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lst;
    }
    public void themHoaDon(HoaDon hd){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void themCTHoaDon(HoaDonChiTiet ct){
        Transaction transaction= null;
        try(Session session= Hibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public HoaDon getHDMoiNhat(){
        HoaDon hd= null;
        try (Session session= Hibernate.getFACTORY().openSession()){
            hd= (HoaDon) session.createQuery("from HoaDon order by NgayTao desc ").setMaxResults(1).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return hd;
    }
    public HoaDon getByIDHD(UUID id){
        HoaDon ch= new HoaDon();
        try (Session session = Hibernate.getFACTORY().openSession()){
            Query query= session.createQuery("from HoaDon where id= :id");
            query.setParameter("id",id);
            ch= (HoaDon) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ch;
    }
}
