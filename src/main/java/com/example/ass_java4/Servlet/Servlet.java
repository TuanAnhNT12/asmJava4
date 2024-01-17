package com.example.ass_java4.Servlet;

import com.example.ass_java4.Model.*;
import com.example.ass_java4.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.annotation.MultipartConfig;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet(name = "Servlet", value = {"/chuc-vu/hien-thi","/chuc-vu/chi-tiet","/chuc-vu/them","/chuc-vu/sua","/chuc-vu/xoa",
        "/cua-hang/hien-thi","/cua-hang/chi-tiet","/cua-hang/them","/cua-hang/sua","/cua-hang/xoa",
        "/nhan-vien/hien-thi","/nhan-vien/chi-tiet","/nhan-vien/them","/nhan-vien/sua","/nhan-vien/xoa",
        "/khach-hang/hien-thi","/khach-hang/chi-tiet","/khach-hang/them","/khach-hang/sua","/khach-hang/xoa",
        "/san-pham/hien-thi","/san-pham/chi-tiet","/san-pham/them","/san-pham/sua","/san-pham/xoa",
        "/nsx/hien-thi","/nsx/chi-tiet","/nsx/them","/nsx/sua","/nsx/xoa",
        "/mau-sac/hien-thi","/mau-sac/chi-tiet","/mau-sac/them","/mau-sac/sua","/mau-sac/xoa",
        "/dongsp/hien-thi","/dongsp/chi-tiet","/dongsp/them","/dongsp/sua","/dongsp/xoa",
        "/chi-tiet-sp/hien-thi","/chi-tiet-sp/chi-tiet","/chi-tiet-sp/them","/chi-tiet-sp/sua","/chi-tiet-sp/xoa",
        "/ban-hang/trang-chu","/ban-hang/san-pham","/ban-hang/chi-tiet","/ban-hang/them-gio-hang","/ban-hang/hien-thi-gio-hang","/ban-hang/sua-gio-hang",
        "/gio-hang/xoa","/chi-tiet-san-pham/thanh-toan","/gio-hang/thanh-toan",
        "/hoa-don/hien-thi","/hoa-don/chi-tiet"
        })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // Kích thước tối thiểu cho bộ nhớ tạm thời (2MB)
        maxFileSize = 1024 * 1024 * 10,       // Kích thước tối đa cho một file (10MB)
        maxRequestSize = 1024 * 1024 * 50    // Kích thước tối đa cho request (50MB)
)
public class Servlet extends HttpServlet {
    ChucVuService chucVuService = new ChucVuService();
    CuaHangService cuaHangService= new CuaHangService();
    NhanVienService nhanVienService= new NhanVienService();
    KhachHangService khachHangService= new KhachHangService();
    SanPhamService sanPhamService= new SanPhamService();
    NSXService nsxService= new NSXService();
    MauSacService mauSacService= new MauSacService();
    DongSPService dongSPService= new DongSPService();
    ChiTietSPService chiTietSPService= new ChiTietSPService();
    GioHangService gioHangService= new GioHangService();
    HoaDonService hoaDonService= new HoaDonService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        //CHỨC VỤ
        if(uri.contains("/chuc-vu/hien-thi")){
            ArrayList<ChucVu> lst = chucVuService.getAll();
            request.setAttribute("lstCV",lst);
            request.getRequestDispatcher("/ChucVu.jsp").forward(request,response);
        }else if(uri.contains("/chuc-vu/chi-tiet")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu cv =chucVuService.getById(id);
            request.setAttribute("cv",cv);
            request.getRequestDispatcher("/ChucVuXemChiTiet.jsp").forward(request,response);

        }else if(uri.contains("/chuc-vu/xoa")){
            UUID id = UUID.fromString(request.getParameter("id"));
            chucVuService.XoaCV(id);
            response.sendRedirect("/chuc-vu/hien-thi");
        }

        //CỬA HÀNG
        if(uri.contains("/cua-hang/hien-thi")){
            ArrayList<CuaHang> lst= cuaHangService.getAll();
            request.setAttribute("lstCH",lst);
            request.getRequestDispatcher("/CuaHang.jsp").forward(request,response);
        }else if(uri.contains("/cua-hang/chi-tiet")){
            UUID id= UUID.fromString(request.getParameter("id"));
            CuaHang ch= cuaHangService.getByID(id);
            request.setAttribute("ch",ch);
            request.getRequestDispatcher("/CuaHangXemChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/cua-hang/xoa")){
            UUID id= UUID.fromString(request.getParameter("id"));
            cuaHangService.XoaCH(id);
            response.sendRedirect("/cua-hang/hien-thi");
        }

        //NHÂN VIÊN
        if(uri.contains("/nhan-vien/hien-thi")){
            ArrayList<NhanVien> lst= nhanVienService.getAll();
            ArrayList<CuaHang> lstCH= cuaHangService.getAll();
            ArrayList<ChucVu> lstCV= chucVuService.getAll();
            request.setAttribute("lstNV", lst);
            request.setAttribute("lstCH", lstCH);
            request.setAttribute("lstCV", lstCV);
            request.getRequestDispatcher("/NhanVien.jsp").forward(request,response);
        }else if(uri.contains("/nhan-vien/chi-tiet")){
            UUID id= UUID.fromString(request.getParameter("id"));
            NhanVien nv= nhanVienService.getByID(id);
            ArrayList<CuaHang> lstCH= cuaHangService.getAll();
            ArrayList<ChucVu> lstCV= chucVuService.getAll();
            request.setAttribute("nv",nv);
            request.setAttribute("lstCH", lstCH);
            request.setAttribute("lstCV", lstCV);
            request.getRequestDispatcher("/NhanVienXemChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/nhan-vien/xoa")){
            UUID id= UUID.fromString(request.getParameter("id"));
            nhanVienService.xoaNV(id);
            response.sendRedirect("/nhan-vien/hien-thi");
        }

        //KHÁCH HÀNG
        if(uri.contains("/khach-hang/hien-thi")){
            ArrayList<KhachHang> lst= khachHangService.getAll();
            request.setAttribute("lstKH",lst);
            request.getRequestDispatcher("/KhachHang.jsp").forward(request,response);
        }else if(uri.contains("/khach-hang/chi-tiet")){
            UUID id= UUID.fromString(request.getParameter("id"));
            KhachHang kh=khachHangService.getById(id);
            request.setAttribute("kh",kh);
            request.getRequestDispatcher("/KhachHangXemChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/khach-hang/xoa")){
            UUID id= UUID.fromString(request.getParameter("id"));
            khachHangService.xoaKH(id);
            response.sendRedirect("/khach-hang/hien-thi");
        }

        //SẢN PHẨM
        if(uri.contains("/san-pham/hien-thi")){
            Map<UUID, String> DoiAnh = new HashMap<>();
            ArrayList<SanPham> lst= sanPhamService.getAll();
            for(SanPham sp :lst){
                String base64Image = Base64.getEncoder().encodeToString(sp.getAnh());
                DoiAnh.put(sp.getId(),base64Image);
            }
            request.setAttribute("doi",DoiAnh);
            request.setAttribute("lstSP",lst);
            request.getRequestDispatcher("/SanPham.jsp").forward(request,response);
        }else if(uri.contains("/san-pham/chi-tiet")){
            UUID id=UUID.fromString(request.getParameter("id"));
            SanPham sp= sanPhamService.getByID(id);
            String anh = Base64.getEncoder().encodeToString(sp.getAnh());
            request.setAttribute("sp",sp);
            request.setAttribute("anh",anh);
            request.getRequestDispatcher("/SanPhamXemChiTiet.jsp").forward(request,response);

        }else if(uri.contains("/san-pham/xoa")){
            UUID id=UUID.fromString(request.getParameter("id"));
            sanPhamService.XoaSP(id);
            response.sendRedirect("/san-pham/hien-thi");
        }

        //NHÀ SẢN XUẤT
        if(uri.contains("/nsx/hien-thi")){
            ArrayList<NSX> lst = nsxService.getAll();
            request.setAttribute("lstNSX",lst);
            request.getRequestDispatcher("/NSX.jsp").forward(request,response);
        }else if(uri.contains("/nsx/chi-tiet")){
            UUID id= UUID.fromString(request.getParameter("id"));
            NSX nsx=nsxService.getByID(id);
            request.setAttribute("nsx",nsx);
            request.getRequestDispatcher("/NSXXemChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/nsx/xoa")){
            UUID id= UUID.fromString(request.getParameter("id"));
            nsxService.xoaNSX(id);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Xóa NSX thành công!");
            response.sendRedirect("/nsx/hien-thi");

        }

        //MÀU SẮC
        if(uri.contains("/mau-sac/hien-thi")){
            ArrayList<MauSac> lst = mauSacService.getAll();
            request.setAttribute("lstMS",lst);
            request.getRequestDispatcher("/MauSac.jsp").forward(request,response);
        }else if(uri.contains("/mau-sac/chi-tiet")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac ms= mauSacService.getById(id);
            request.setAttribute("ms",ms);
            request.getRequestDispatcher("/MauSacXemChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/mau-sac/xoa")){
            UUID id = UUID.fromString(request.getParameter("id"));
            mauSacService.XoaMS(id);
            HttpSession session= request.getSession();
            session.setAttribute("successMessage","Xóa thành công!");
            response.sendRedirect("/mau-sac/hien-thi");
        }

        //DÒNG SẢN PHẨM
        if(uri.contains("/dongsp/hien-thi")){
            ArrayList<DongSP> lst= dongSPService.getAll();
            request.setAttribute("lstDSP",lst);
            request.getRequestDispatcher("/DongSP.jsp").forward(request,response);
        }else if(uri.contains("/dongsp/chi-tiet")){
            UUID id= UUID.fromString(request.getParameter("id"));
            DongSP dsp= dongSPService.getById(id);
            request.setAttribute("dsp",dsp);
            request.getRequestDispatcher("/DongSPXemChiTiet.jsp").forward(request,response);
        } else if (uri.contains("/dongsp/xoa")) {
            UUID id= UUID.fromString(request.getParameter("id"));
            dongSPService.xoaDSP(id);
            HttpSession session= request.getSession();
            session.setAttribute("successMessage","Xóa thành công!");
            response.sendRedirect("/dongsp/hien-thi");
        }
        //CHI TIẾT SẢN PHẨM
        if(uri.contains("/chi-tiet-sp/hien-thi")){
            ArrayList<ChiTietSP> lst= chiTietSPService.getAll();
            ArrayList<SanPham> lstSP= sanPhamService.getAll();
            ArrayList<NSX> lstNSX= nsxService.getAll();
            ArrayList<MauSac> lstMS= mauSacService.getAll();
            ArrayList<DongSP> lstDSP= dongSPService.getAll();

            request.setAttribute("lstCTSP",lst);
            request.setAttribute("lstSP",lstSP);
            request.setAttribute("lstNSX",lstNSX);
            request.setAttribute("lstMS",lstMS);
            request.setAttribute("lstDSP",lstDSP);

            request.getRequestDispatcher("/ChiTietSP.jsp").forward(request,response);

        }else if(uri.contains("/chi-tiet-sp/chi-tiet")){
            UUID id= UUID.fromString(request.getParameter("id"));
            ChiTietSP ctsp= chiTietSPService.getById(id);
            ArrayList<SanPham> lstSP= sanPhamService.getAll();
            ArrayList<NSX> lstNSX= nsxService.getAll();
            ArrayList<MauSac> lstMS= mauSacService.getAll();
            ArrayList<DongSP> lstDSP= dongSPService.getAll();

            request.setAttribute("ctsp",ctsp);
            request.setAttribute("lstSP",lstSP);
            request.setAttribute("lstNSX",lstNSX);
            request.setAttribute("lstMS",lstMS);
            request.setAttribute("lstDSP",lstDSP);

            request.getRequestDispatcher("/ChiTietSPXemChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/chi-tiet-sp/xoa")){
            UUID id= UUID.fromString(request.getParameter("id"));
            chiTietSPService.XoaCTSP(id);

            HttpSession session= request.getSession();
            session.setAttribute("successMessage","Xóa thành công!");

            response.sendRedirect("/chi-tiet-sp/hien-thi");

        }

        //BÁN HÀNG
        if(uri.contains("/ban-hang/trang-chu")){
            ArrayList<SanPham> lstSP= sanPhamService.getAll();
            Map<UUID, String> DoiAnh = new HashMap<>();
            for(SanPham sp :lstSP){
                String base64Image = Base64.getEncoder().encodeToString(sp.getAnh());
                DoiAnh.put(sp.getId(),base64Image);
            }
            int size= lstSP.size();
            List<SanPham> subList1= lstSP.subList(0,4);
            List<SanPham> subList2= lstSP.subList(size-4,size);
            ArrayList<SanPham> top4dau= new ArrayList<>(subList1);
            ArrayList<SanPham> top4cuoi=new ArrayList<>(subList2);
            Map<UUID,BigDecimal> giaMin= new HashMap<>();
            ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
            for(ChiTietSP ct : lstCTSP){
                UUID idsp= ct.getIdSP().getId();
                BigDecimal gia= ct.getGiaBan();
                if(!giaMin.containsKey(idsp)){
                    giaMin.put(idsp,gia);
                }else{
                    BigDecimal giaHienTai= giaMin.get(idsp);
                    if(gia.doubleValue() <= giaHienTai.doubleValue()){
                        giaMin.put(idsp,gia);
                    }
                }

            }
            request.setAttribute("doiAnh",DoiAnh);
            request.setAttribute("top4dau",top4dau);
            request.setAttribute("top4cuoi",top4cuoi);
            request.setAttribute("lstSP",lstSP);
            request.setAttribute("giaMin",giaMin);
            request.getRequestDispatcher("/TrangChuBanHang.jsp").forward(request,response);
        }else if(uri.contains("/ban-hang/san-pham")){
            ArrayList<SanPham> lstSP= sanPhamService.getAll();
            Map<UUID, String> DoiAnh = new HashMap<>();
            for(SanPham sp :lstSP){
                String base64Image = Base64.getEncoder().encodeToString(sp.getAnh());
                DoiAnh.put(sp.getId(),base64Image);
            }
            Map<UUID,BigDecimal> giaMin= new HashMap<>();
            ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
            for(ChiTietSP ct : lstCTSP){
                UUID idsp= ct.getIdSP().getId();
                BigDecimal gia= ct.getGiaBan();
                if(!giaMin.containsKey(idsp)){
                    giaMin.put(idsp,gia);
                }else{
                    BigDecimal giaHienTai= giaMin.get(idsp);
                    if(gia.doubleValue() <= giaHienTai.doubleValue()){
                        giaMin.put(idsp,gia);
                    }
                }

            }
            ArrayList<DongSP> lstDSP=dongSPService.getAll();

            request.setAttribute("doiAnh",DoiAnh);
            request.setAttribute("lstSP",lstSP);
            request.setAttribute("giaMin",giaMin);
            request.setAttribute("lstDSP",lstDSP);
            request.getRequestDispatcher("/SanPhamBanHang.jsp").forward(request,response);
        }else if(uri.contains("/ban-hang/chi-tiet")){
            String dauVao= request.getParameter("mauSP");
            if(dauVao !=null && !dauVao.isEmpty()){
                Integer sl = 0;
                BigDecimal gia = new BigDecimal(0);
                UUID idCTSP= UUID.fromString(dauVao);
                ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
                UUID id=null;
                String mau= null;
                for(ChiTietSP ct :lstCTSP){
                    if(idCTSP.equals(ct.getId())){
                        sl=ct.getSoLuongTon();
                        gia=ct.getGiaBan();
                        id=ct.getIdSP().getId();
                        mau=ct.getIdMauSac().getTen();
                    }
                }
                SanPham sp= sanPhamService.getByID(id);
                String anh = Base64.getEncoder().encodeToString(sp.getAnh());

                Map<UUID,ChiTietSP> ctsp= new HashMap<>();
                for(ChiTietSP ct :lstCTSP){
                    if(id.equals(ct.getIdSP().getId())){
                        ctsp.put(ct.getId(),ct);
                    }
                }
                request.setAttribute("idCTSP",idCTSP);
                request.setAttribute("mau",mau);
                request.setAttribute("sl",sl);
                request.setAttribute("gia",gia);
                request.setAttribute("ctsp",ctsp);
                request.setAttribute("anh",anh);
                request.setAttribute("sp",sp);
                request.getRequestDispatcher("/SanPhamChiTietBanHang.jsp").forward(request,response);
            }else{
                UUID id= UUID.fromString(request.getParameter("id"));
                SanPham sp= sanPhamService.getByID(id);
                String anh = Base64.getEncoder().encodeToString(sp.getAnh());
                ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
                Map<UUID,ChiTietSP> ctsp= new HashMap<>();
                for(ChiTietSP ct :lstCTSP){
                    if(id.equals(ct.getIdSP().getId())){
                        ctsp.put(ct.getId(),ct);
                    }
                }
                Map.Entry<UUID,ChiTietSP> firstEntry = ctsp.entrySet().iterator().next();
                UUID idCTSP= firstEntry.getKey();
                Integer sl = firstEntry.getValue().getSoLuongTon();
                BigDecimal gia = firstEntry.getValue().getGiaBan();
                String mau= firstEntry.getValue().getIdMauSac().getTen();

                request.setAttribute("idCTSP",idCTSP);
                request.setAttribute("mau",mau);
                request.setAttribute("sl",sl);
                request.setAttribute("gia",gia);
                request.setAttribute("ctsp",ctsp);
                request.setAttribute("anh",anh);
                request.setAttribute("sp",sp);
                request.getRequestDispatcher("/SanPhamChiTietBanHang.jsp").forward(request,response);
            }
        }else if(uri.contains("/ban-hang/hien-thi-gio-hang")){
                ArrayList<GioHang> lstGH= gioHangService.getAll();
                Integer size= lstGH.size();
                Map<UUID,String> mapAnh= new HashMap<>();
                ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
                Map<UUID,BigDecimal> mapTong= new HashMap<>();
                BigDecimal tong= new BigDecimal(0);
                for(GioHang gh :lstGH){
                    String anh = Base64.getEncoder().encodeToString(gh.getAnh());
                    mapAnh.put(gh.getId(),anh);
                    tong= new BigDecimal(gh.getSoLuong().intValue() * gh.getGiaBan().doubleValue());
                    mapTong.put(gh.getId(),tong);
                }
                BigDecimal tongt= new BigDecimal(0);
                Collection<BigDecimal> tongtien= mapTong.values();
                for(BigDecimal tt : tongtien){
                    tongt = new BigDecimal(tongt.doubleValue() + tt.doubleValue());
                }
                request.setAttribute("size",size);
                request.setAttribute("tongTien",tongt);
                request.setAttribute("tong",mapTong);
                request.setAttribute("lstCTSP",lstCTSP);
                request.setAttribute("anh",mapAnh);
                request.setAttribute("lstGH",lstGH);
                request.getRequestDispatcher("/GioHangBanHang.jsp").forward(request,response);

       }else if(uri.contains("/gio-hang/xoa")){
            UUID id= UUID.fromString(request.getParameter("idGH"));
            gioHangService.xoaGH(id);
            HttpSession session= request.getSession();
            session.setAttribute("successMessage","Xóa thành công!");
            response.sendRedirect("/ban-hang/hien-thi-gio-hang");
        }
        //QUẢN TRỊ HÓA ĐƠN
        if(uri.contains("/hoa-don/hien-thi")){
            ArrayList<HoaDon> lst= hoaDonService.getHDAll();
            request.setAttribute("lstHD",lst);
            request.getRequestDispatcher("/HoaDon.jsp").forward(request,response);
        }else if(uri.contains("hoa-don/chi-tiet")){
            UUID idHD= UUID.fromString(request.getParameter("id"));
            HoaDon hd= hoaDonService.getByIDHD(idHD);
            ArrayList<HoaDonChiTiet> lst= hoaDonService.getChiTietHDAll();
            ArrayList<HoaDonChiTiet> lstHDCT= new ArrayList<>();
            Map<UUID,String> anh = new HashMap<>();
            Map<UUID,String> ten= new HashMap<>();;
            Map<UUID,String> mau= new HashMap<>();;
            BigDecimal tong= new BigDecimal(0);
            for(HoaDonChiTiet ct : lst){
                if(ct.getIdHoaDon().getId().equals(idHD)){
                    lstHDCT.add(ct);
                    anh.put(ct.getId(),Base64.getEncoder().encodeToString(ct.getIdChiTietSP().getIdSP().getAnh()));
                    ten.put(ct.getId(),ct.getIdChiTietSP().getIdSP().getTen());
                    mau.put(ct.getId(),ct.getIdChiTietSP().getIdMauSac().getTen());
                    tong = new BigDecimal(tong.doubleValue()+(ct.getSoLuong().intValue() * ct.getDonGia().doubleValue()));
                }
            }


            request.setAttribute("tong",tong);
            request.setAttribute("hd",hd);
            request.setAttribute("lstHDCT",lstHDCT);
            request.setAttribute("anh",anh);
            request.setAttribute("ten",ten);
            request.setAttribute("mau",mau);
            request.getRequestDispatcher("/HoaDonXemChiTiet.jsp").forward(request,response);



        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();

        //CHỨC VỤ
        if(uri.contains("/chuc-vu/them")){
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            ChucVu cv= new ChucVu();
            cv.setMa(ma);
            cv.setTen(ten);

            chucVuService.themCV(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("/chuc-vu/sua")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            ChucVu cv= new ChucVu();
            cv.setId(id);
            cv.setMa(ma);
            cv.setTen(ten);

            chucVuService.suaCV(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }

        //CỬA HÀNG
        if(uri.contains("/cua-hang/them")){
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");
            String dc= request.getParameter("dc");
            String tp= request.getParameter("tp");
            String qg= request.getParameter("qg");

            CuaHang ch= new CuaHang();

            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(dc);
            ch.setThanhPho(tp);
            ch.setQuocGia(qg);

            cuaHangService.themCH(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        }else if(uri.contains("/cua-hang/sua")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");
            String dc= request.getParameter("dc");
            String tp= request.getParameter("tp");
            String qg= request.getParameter("qg");
            CuaHang ch= new CuaHang();

            ch.setId(id);
            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(dc);
            ch.setThanhPho(tp);
            ch.setQuocGia(qg);

            cuaHangService.suaCH(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        }

        //NHÂN VIÊN
        if(uri.contains("/nhan-vien/them")){
            String ma= request.getParameter("ma");
            String ho= request.getParameter("ho");
            String tenDem= request.getParameter("tenDem");
            String ten= request.getParameter("ten");
            String gioiTinh= request.getParameter("gioiTinh");
            Date ngaySinh= Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi= request.getParameter("diaChi");
            String sdt= request.getParameter("sdt");
            String mk= request.getParameter("mk");
            UUID cuaHang= UUID.fromString(request.getParameter("cuaHang")) ;
            UUID chucVu= UUID.fromString(request.getParameter("chucVu")) ;
            Integer trangThai= Integer.parseInt(request.getParameter("trangThai"));

            NhanVien nv= new NhanVien();
            CuaHang ch= new CuaHang();
            ChucVu cv= new ChucVu();
            nv.setMa(ma);
            nv.setHo(ho);
            nv.setTenDem(tenDem);
            nv.setTen(ten);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setDiaChi(diaChi);
            nv.setSdt(sdt);
            nv.setMatKhau(mk);
            ch.setId(cuaHang);
            nv.setIdCH(ch);
            cv.setId(chucVu);
            nv.setIdCV(cv);
            nv.setTrangThai(trangThai);

            nhanVienService.themNV(nv);
            response.sendRedirect("/nhan-vien/hien-thi");


        }else if(uri.contains("/nhan-vien/sua")){
            UUID id= UUID.fromString(request.getParameter("id")) ;
            String ma= request.getParameter("ma");
            String ho= request.getParameter("ho");
            String tenDem= request.getParameter("tenDem");
            String ten= request.getParameter("ten");
            String gioiTinh= request.getParameter("gioiTinh");
            Date ngaySinh= Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi= request.getParameter("diaChi");
            String sdt= request.getParameter("sdt");
            String mk= request.getParameter("mk");
            UUID cuaHang= UUID.fromString(request.getParameter("cuaHang")) ;
            UUID chucVu= UUID.fromString(request.getParameter("chucVu")) ;
            Integer trangThai= Integer.parseInt(request.getParameter("trangThai"));

            NhanVien nv= new NhanVien();
            CuaHang ch= new CuaHang();
            ChucVu cv= new ChucVu();
            nv.setId(id);
            nv.setMa(ma);
            nv.setHo(ho);
            nv.setTenDem(tenDem);
            nv.setTen(ten);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setDiaChi(diaChi);
            nv.setSdt(sdt);
            nv.setMatKhau(mk);
            ch.setId(cuaHang);
            nv.setIdCH(ch);
            cv.setId(chucVu);
            nv.setIdCV(cv);
            nv.setTrangThai(trangThai);

            nhanVienService.suaNV(nv);
            response.sendRedirect("/nhan-vien/hien-thi");
        }

        //KHÁCH HÀNG
        if(uri.contains("khach-hang/them")){
            String ma= request.getParameter("ma");
            String ho= request.getParameter("ho");
            String tenDem= request.getParameter("tenDem");
            String ten= request.getParameter("ten");
            String sdt= request.getParameter("sdt");
            Date ngaySinh= Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi= request.getParameter("diaChi");
            String thanhPho= request.getParameter("thanhPho");
            String quocGia= request.getParameter("quocGia");
            String mk= request.getParameter("mk");

            KhachHang kh= new KhachHang();

            kh.setMa(ma);
            kh.setHo(ho);
            kh.setTenDem(tenDem);
            kh.setTen(ten);
            kh.setNgaySinh(ngaySinh);
            kh.setSdt(sdt);
            kh.setDiaChi(diaChi);
            kh.setThanhPho(thanhPho);
            kh.setQuocGia(quocGia);
            kh.setMatKhau(mk);

            khachHangService.themKH(kh);
            response.sendRedirect("/khach-hang/hien-thi");

        }else if(uri.contains("/khach-hang/sua")){
            UUID id= UUID.fromString(request.getParameter("id"));
            String ma= request.getParameter("ma");
            String ho= request.getParameter("ho");
            String tenDem= request.getParameter("tenDem");
            String ten= request.getParameter("ten");
            String sdt= request.getParameter("sdt");
            Date ngaySinh= Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi= request.getParameter("diaChi");
            String thanhPho= request.getParameter("thanhPho");
            String quocGia= request.getParameter("quocGia");
            String mk= request.getParameter("mk");

            KhachHang kh= new KhachHang();

            kh.setId(id);
            kh.setMa(ma);
            kh.setHo(ho);
            kh.setTenDem(tenDem);
            kh.setTen(ten);
            kh.setSdt(sdt);
            kh.setNgaySinh(ngaySinh);
            kh.setDiaChi(diaChi);
            kh.setThanhPho(thanhPho);
            kh.setQuocGia(quocGia);
            kh.setMatKhau(mk);

            khachHangService.suaKH(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }

        //SẢN PHẨM
        if(uri.contains("/san-pham/them")){
            Part filePart = request.getPart("anh");
            if (filePart != null) {
                InputStream fileContent = filePart.getInputStream();
                byte[] fileBytes = convertInputStreamToByteArray(fileContent);
                String ma= request.getParameter("ma");
                String ten= request.getParameter("ten");

                SanPham sp= new SanPham();

                sp.setAnh(fileBytes);
                sp.setMa(ma);
                sp.setTen(ten);

                sanPhamService.ThemSP(sp);
                response.sendRedirect("/san-pham/hien-thi");
            }
        }else if(uri.contains("/san-pham/sua")){
            Part filePart = request.getPart("anh");
            if (filePart != null && filePart.getSize() > 0) {
                InputStream fileContent = filePart.getInputStream();
                byte[] fileBytes = convertInputStreamToByteArray(fileContent);
                UUID id = UUID.fromString(request.getParameter("id"));
                String ma= request.getParameter("ma");
                String ten= request.getParameter("ten");

                SanPham sp= new SanPham();

                sp.setId(id);
                sp.setAnh(fileBytes);
                sp.setMa(ma);
                sp.setTen(ten);

                sanPhamService.SuaSP(sp);
                response.sendRedirect("/san-pham/hien-thi");
            }else{
                UUID id = UUID.fromString(request.getParameter("id"));
                SanPham sp= sanPhamService.getByID(id);
                byte[] anh= sp.getAnh();
                String ma= request.getParameter("ma");
                String ten= request.getParameter("ten");

                SanPham sp1= new SanPham();

                sp1.setId(id);
                sp1.setAnh(anh);
                sp1.setMa(ma);
                sp1.setTen(ten);

                sanPhamService.SuaSP(sp1);
                response.sendRedirect("/san-pham/hien-thi");
            }
        }

        //NƠI SẢN XUẤT
        if(uri.contains("/nsx/them")){
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            NSX nsx= new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);

            nsxService.themNSX(nsx);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Thêm NSX thành công!");
            response.sendRedirect("/nsx/hien-thi");

        }else if(uri.contains("/nsx/sua")){
            UUID id= UUID.fromString(request.getParameter("id"));
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            NSX nsx= new NSX();

            nsx.setId(id);
            nsx.setMa(ma);
            nsx.setTen(ten);

            nsxService.suaNSX(nsx);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Cập nhật NSX thành công!");
            response.sendRedirect("/nsx/hien-thi");
        }

        //MÀU SẮC
        if(uri.contains("/mau-sac/them")){
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            MauSac ms= new MauSac();
            ms.setMa(ma);
            ms.setTen(ten);
           mauSacService.themMS(ms);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Thêm thành công!");
            response.sendRedirect("/mau-sac/hien-thi");

        }else if(uri.contains("/mau-sac/sua")){
            UUID id= UUID.fromString(request.getParameter("id"));
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            MauSac ms= new MauSac();
            ms.setId(id);
            ms.setMa(ma);
            ms.setTen(ten);

            mauSacService.suaMS(ms);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Cập nhật thành công!");
            response.sendRedirect("/mau-sac/hien-thi");
        }

        //DÒNG SẢN PHẨM
        if(uri.contains("/dongsp/them")){
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

           DongSP dsp= new DongSP();
           dsp.setMa(ma);
           dsp.setTen(ten);

           dongSPService.themDSP(dsp);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Thêm thành công!");
            response.sendRedirect("/dongsp/hien-thi");

        }else if(uri.contains("/dongsp/sua")){
            UUID id= UUID.fromString(request.getParameter("id"));
            String ma= request.getParameter("ma");
            String ten= request.getParameter("ten");

            DongSP dsp= new DongSP();
            dsp.setId(id);
            dsp.setMa(ma);
            dsp.setTen(ten);

            dongSPService.SuaDSP(dsp);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Cập nhật thành công!");
            response.sendRedirect("/dongsp/hien-thi");
        }
        //CHI TIẾT SẢN PHẨM
        if(uri.contains("/chi-tiet-sp/them")){
            UUID sp= UUID.fromString(request.getParameter("sp"));
            UUID ms= UUID.fromString(request.getParameter("ms"));
            UUID nsx= UUID.fromString(request.getParameter("nsx"));
            UUID dsp= UUID.fromString(request.getParameter("dsp"));
            Integer nbh= Integer.parseInt(request.getParameter("nbh"));
            String mt= request.getParameter("mt");
            Integer slt= Integer.parseInt(request.getParameter("slt"));
            BigDecimal gn= BigDecimal.valueOf(Double.valueOf(request.getParameter("gn")));
            BigDecimal gb= BigDecimal.valueOf(Double.valueOf(request.getParameter("gb")));

            SanPham sp1= new SanPham();
            sp1.setId(sp);

            MauSac ms1= new MauSac();
            ms1.setId(ms);

            NSX nsx1= new NSX();
            nsx1.setId(nsx);

            DongSP dsp1= new DongSP();
            dsp1.setId(dsp);

            ChiTietSP ctsp= new ChiTietSP();
            ctsp.setIdSP(sp1);
            ctsp.setIdNsx(nsx1);
            ctsp.setIdMauSac(ms1);
            ctsp.setIdDongSP(dsp1);
            ctsp.setMoTa(mt);
            ctsp.setSoLuongTon(slt);
            ctsp.setNamBH(nbh);
            ctsp.setGiaNhap(gn);
            ctsp.setGiaBan(gb);

            chiTietSPService.themCTSP(ctsp);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Thêm thành công!");
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }else if(uri.contains("/chi-tiet-sp/sua")){
            UUID id= UUID.fromString(request.getParameter("id"));
            UUID sp= UUID.fromString(request.getParameter("sp"));
            UUID ms= UUID.fromString(request.getParameter("ms"));
            UUID nsx= UUID.fromString(request.getParameter("nsx"));
            UUID dsp= UUID.fromString(request.getParameter("dsp"));
            Integer nbh= Integer.parseInt(request.getParameter("nbh"));
            String mt= request.getParameter("mt");
            Integer slt= Integer.parseInt(request.getParameter("slt"));
            BigDecimal gn= BigDecimal.valueOf(Double.valueOf(request.getParameter("gn")));
            BigDecimal gb= BigDecimal.valueOf(Double.valueOf(request.getParameter("gb")));

            SanPham sp1= new SanPham();
            sp1.setId(sp);

            MauSac ms1= new MauSac();
            ms1.setId(ms);

            NSX nsx1= new NSX();
            nsx1.setId(nsx);

            DongSP dsp1= new DongSP();
            dsp1.setId(dsp);

            ChiTietSP ctsp= new ChiTietSP();
            ctsp.setId(id);
            ctsp.setIdSP(sp1);
            ctsp.setIdNsx(nsx1);
            ctsp.setIdMauSac(ms1);
            ctsp.setIdDongSP(dsp1);
            ctsp.setMoTa(mt);
            ctsp.setSoLuongTon(slt);
            ctsp.setNamBH(nbh);
            ctsp.setGiaNhap(gn);
            ctsp.setGiaBan(gb);

            chiTietSPService.suaCTSP(ctsp);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Cập nhật thành công!");
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
        //BÁN HÀNG
        if(uri.contains("/ban-hang/them-gio-hang")){
            String dauVao= request.getParameter("mauSPPost");
            if(dauVao != null && !dauVao.isEmpty()){
                UUID idCTSP= UUID.fromString(dauVao);
                ChiTietSP ct11= chiTietSPService.getById(idCTSP);
                if(ct11.getSoLuongTon()==0){
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessag", " Sản phẩm đã hết hàng!");
                    response.sendRedirect("/ban-hang/chi-tiet?id="+ ct11.getIdSP().getId());
                }else{
                    ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
                    UUID idSP= null;
                    BigDecimal gia= new BigDecimal(0);
                    String mau=null;
                    for(ChiTietSP ct :lstCTSP){
                        if(idCTSP.equals(ct.getId())){
                            idSP= ct.getIdSP().getId();
                            gia=ct.getGiaBan();
                            mau=ct.getIdMauSac().getTen();
                        }
                    }

                    SanPham sp1 = sanPhamService.getByID(idSP);
                    String ten= sp1.getTen();
                    byte[] anh= sp1.getAnh();

                    GioHang gh= new GioHang();
                    ChiTietSP ctsp= new ChiTietSP();
                    ctsp.setId(idCTSP);

                    gh.setAnh(anh);
                    gh.setTenSP(ten);
                    gh.setMauSac(mau);
                    gh.setGiaBan(gia);
                    gh.setIdCTSP(ctsp);
                    gh.setSoLuong(1);

                    gioHangService.themGH(gh);
                    // Thêm thông báo thành công vào session
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessage", "Thêm vào giỏ hàng thành công!");
                    response.sendRedirect("/ban-hang/chi-tiet?id="+idSP);
                }


            }else{

                UUID idSP= UUID.fromString(request.getParameter("aabb"));
                SanPham sp1 = sanPhamService.getByID(idSP);
                String ten= sp1.getTen();
                byte[] anh= sp1.getAnh();
                ArrayList<ChiTietSP> lstCTSP= chiTietSPService.getAll();
                Map<UUID,ChiTietSP> ctsp= new HashMap<>();
                for(ChiTietSP ct :lstCTSP){
                    if(idSP.equals(ct.getIdSP().getId())){
                        ctsp.put(ct.getId(),ct);
                    }
                }
                Map.Entry<UUID,ChiTietSP> firstEntry = ctsp.entrySet().iterator().next();
                UUID idCTSP= firstEntry.getKey();
                ChiTietSP ct11= chiTietSPService.getById(idCTSP);
                String mau = firstEntry.getValue().getIdMauSac().getTen();
                BigDecimal gia = firstEntry.getValue().getGiaBan();
                if(ct11.getSoLuongTon()==0){
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessag", " Sản phẩm đã hết hàng!");
                    response.sendRedirect("/ban-hang/chi-tiet?id="+ ct11.getIdSP().getId());
                }else{
                    GioHang gh= new GioHang();
                    ChiTietSP ctsp1= new ChiTietSP();
                    ctsp1.setId(idCTSP);

                    gh.setIdCTSP(ctsp1);
                    gh.setTenSP(ten);
                    gh.setAnh(anh);
                    gh.setSoLuong(1);
                    gh.setMauSac(mau);
                    gh.setGiaBan(gia);
                    gioHangService.themGH(gh);
                    // Thêm thông báo thành công vào session
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessage", "Thêm vào giỏ hàng thành công!");
                    response.sendRedirect("/ban-hang/chi-tiet?id="+idSP);
                }

            }
        }else if(uri.contains("/ban-hang/sua-gio-hang")){

            UUID idGH= UUID.fromString(request.getParameter("id"));
            GioHang cu= gioHangService.getById(idGH);
            String ten=cu.getTenSP();
            byte[] anh= cu.getAnh();
            UUID idCTSP= UUID.fromString(request.getParameter("mau"));
            ChiTietSP ctsp= chiTietSPService.getById(idCTSP);
            String mau= ctsp.getIdMauSac().getTen();
            BigDecimal gia= ctsp.getGiaBan();
            Integer sl= Integer.parseInt(request.getParameter("sl"));

                GioHang gh= new GioHang();

                gh.setId(idGH);
                gh.setAnh(anh);
                gh.setTenSP(ten);
                gh.setMauSac(mau);
                gh.setGiaBan(gia);
                gh.setSoLuong(sl);
                ChiTietSP ctsp1= new ChiTietSP();
                ctsp1.setId(idCTSP);
                gh.setIdCTSP(ctsp1);

                gioHangService.suaGH(gh);

                response.sendRedirect("/ban-hang/hien-thi-gio-hang");


        }else if(uri.contains("/chi-tiet-san-pham/thanh-toan")){
            UUID idCTSP= UUID.fromString(request.getParameter("idCTSP"));
            Integer sl= Integer.parseInt(request.getParameter("slTT"));

            ChiTietSP ctsp= chiTietSPService.getById(idCTSP);
            Integer slMoi= ctsp.getSoLuongTon()-sl;
            UUID idSP= ctsp.getIdSP().getId();
            BigDecimal gia= ctsp.getGiaBan();
            KhachHang kh= new KhachHang();
            NhanVien nv= new NhanVien();
            String a="6D82FBDF-B2B6-8B44-8E27-DD80E676B004";
            String b="B6706616-D579-4548-AA67-263F3547DECE";
            UUID idKH= UUID.fromString(a);
            UUID idNV= UUID.fromString(b);


            kh.setId(idKH);

            nv.setId(idNV);

            LocalDateTime time= LocalDateTime.now();

            HoaDon hd= new HoaDon();
            hd.setIdKH(kh);
            hd.setIdNV(nv);
            hd.setNgayTao(time);
            hoaDonService.themHoaDon(hd);

            HoaDon hdMoi = hoaDonService.getHDMoiNhat();
            System.out.println(hdMoi);
            UUID idHDMoi= hdMoi.getId();


            HoaDon hd1= new HoaDon();
            hd1.setId(idHDMoi);
            ChiTietSP ctsp1= new ChiTietSP();
            ctsp1.setId(idCTSP);

            HoaDonChiTiet cthd= new HoaDonChiTiet();
            cthd.setSoLuong(sl);
            cthd.setDonGia(gia);
            cthd.setIdHoaDon(hd1);
            cthd.setIdChiTietSP(ctsp1);

            hoaDonService.themCTHoaDon(cthd);
            chiTietSPService.UpdateSL(idCTSP,slMoi);
            // Thêm thông báo thành công vào session
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Thanh toán thành công!");
            response.sendRedirect("/ban-hang/chi-tiet?id="+idSP);

        }else if(uri.contains("/gio-hang/thanh-toan")){
            Integer trong= Integer.parseInt(request.getParameter("trong"));
            if(trong==0){
                HttpSession session = request.getSession();
                session.setAttribute("chuachon", "*Vui lòng chọn sản phẩm muốn thanh toán!");
                response.sendRedirect("/ban-hang/hien-thi-gio-hang");
            }else{
                ArrayList<UUID> lstUUID= new ArrayList<>();
                java.util.Enumeration<String> tatCa = request.getParameterNames();

                // Duyệt qua tất cả các tham số
                while (tatCa.hasMoreElements()) {
                    String tenTC = tatCa.nextElement();

                    // Kiểm tra nếu tên tham số bắt đầu bằng "chon"
                    if (tenTC.startsWith("chon")) {
                        String giaTri = request.getParameter(tenTC);
                        lstUUID.add(UUID.fromString(giaTri));
                    }
                }

                //Thêm hóa đơn
                KhachHang kh= new KhachHang();
                NhanVien nv= new NhanVien();
                String a="6D82FBDF-B2B6-8B44-8E27-DD80E676B004";
                String b="B6706616-D579-4548-AA67-263F3547DECE";
                UUID idKH= UUID.fromString(a);
                UUID idNV= UUID.fromString(b);

                kh.setId(idKH);
                nv.setId(idNV);
                LocalDateTime time= LocalDateTime.now();

                HoaDon hd= new HoaDon();
                hd.setIdKH(kh);
                hd.setIdNV(nv);
                hd.setNgayTao(time);
                hoaDonService.themHoaDon(hd);
                //Kết thúc thêm hóa đơn

                //Thêm chi tiết hóa đơn
                for(UUID idGH :lstUUID){
                    GioHang gh= gioHangService.getById(idGH);
                    UUID idCTSP= gh.getIdCTSP().getId();
                    HoaDon hdMoi = hoaDonService.getHDMoiNhat();
                    UUID idHDMoi= hdMoi.getId();

                    ChiTietSP ctsp= chiTietSPService.getById(idCTSP);
                    Integer slMoi= ctsp.getSoLuongTon()-gh.getSoLuong();

                    HoaDon hd1= new HoaDon();
                    hd1.setId(idHDMoi);
                    ChiTietSP ctsp1= new ChiTietSP();
                    ctsp1.setId(idCTSP);

                    HoaDonChiTiet cthd= new HoaDonChiTiet();
                    cthd.setSoLuong(gh.getSoLuong());
                    cthd.setDonGia(gh.getGiaBan());
                    cthd.setIdHoaDon(hd1);
                    cthd.setIdChiTietSP(ctsp1);

                    hoaDonService.themCTHoaDon(cthd);
                    chiTietSPService.UpdateSL(idCTSP,slMoi);

                    gioHangService.xoaGH(idGH);
                }

                // Thêm thông báo thành công vào session
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "Thanh toán thành công!");
                response.sendRedirect("/ban-hang/hien-thi-gio-hang");

            }


        }

        //QUẢN TRỊ HÓA ĐƠN



    }

    public byte[] convertInputStreamToByteArray(InputStream fileContent) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];

        while ((nRead = fileContent.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }
}
