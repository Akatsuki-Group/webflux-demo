package com.bole.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Servlet 3.0
 * @Author: 伯乐
 * @Date: 2020/12/6 20:19
 */
@WebServlet(name = "AsyncServlet", urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            doBusiness(asyncContext.getRequest());
            try {
                asyncContext.getResponse().getWriter().write("Async Servlet Response");
            } catch (IOException e) {
                e.printStackTrace();
            }
            asyncContext.complete();
        });

        System.out.println("Sync Servlet Elapse Time:" + (System.currentTimeMillis() - start));
    }

    public void doBusiness(ServletRequest servletRequest) {
        System.out.println("sync do bussiness");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
