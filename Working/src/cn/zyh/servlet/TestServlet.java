package cn.zyh.servlet;

import cn.zyh.entity.Working;
import cn.zyh.service.WorkingService;
import cn.zyh.service.impl.WorkingServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String opr=request.getParameter("opr");
        if (opr==null){
            opr="list";
        }
        WorkingService workingService=new WorkingServiceImpl();
        if ("list".equals(opr)){
            List<Working>list=workingService.getAllWorking();
            request.getSession().setAttribute("wlist",list);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("jy".equals(opr)){
            String title=request.getParameter("title");
            int nub=workingService.countByType(title);
            if (nub==1){
                out.print(JSON.toJSONString(1));
            }else {
                out.print(JSON.toJSONString(0));
            }
        }else if("add".equals(opr)){
           String title =request.getParameter("title");
           String content =request.getParameter("content");
           int type =Integer.parseInt(request.getParameter("type"));
           Working working=new Working();
           working.setTitle(title);
           working.setContent(content);
           working.setType(type);
           Integer nub=workingService.addWorking(working);
           if (nub==1){
               out.print("<script>alert('添加成功！'); location.href='/index.jsp';</script>");
           }else {
               out.print("<script>alert('添加失败！'); location.href='/add.jsp';</script>");
           }
        }else if ("ck".equals(opr)){
            int id =Integer.parseInt(request.getParameter("id"));
            Working working=new Working();
            working=workingService.getWorkingByID(id);
            request.getSession().setAttribute("working",working);
            request.getRequestDispatcher("infoWorking.jsp").forward(request,response);
        }
    }
}
