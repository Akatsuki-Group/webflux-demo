package com.bole.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Servlet 2.5
 * @Author: 伯乐
 * @Date: 2020/12/6 20:19
 */
@WebServlet(name = "SyncServlet", urlPatterns = "/sync")
public class SyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        doBusiness(req);
        resp.getWriter().write("Sync Servlet Response");
        System.out.println("Sync Servlet Elapse Time:" + (System.currentTimeMillis() - start));
    }

    public void doBusiness(HttpServletRequest httpServletRequest) {
        System.out.println("sync do bussiness");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
