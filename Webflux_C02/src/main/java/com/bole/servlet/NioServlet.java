package com.bole.servlet;

import javax.servlet.*;
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
@WebServlet(name = "NioServlet", urlPatterns = "/nio",asyncSupported = true)
public class NioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        AsyncContext asyncContext=req.startAsync();
       ServletInputStream servletInputStream= asyncContext.getRequest().getInputStream();
        servletInputStream.setReadListener(new ReadListener() {
            @Override
            public void onDataAvailable() throws IOException {
                System.out.println("读取数据");
            }

            @Override
            public void onAllDataRead() throws IOException {
                System.out.println("读取完毕");
                asyncContext.start(()->{
                    doBusiness(asyncContext.getRequest());
                    asyncContext.complete();
                });

            }
            @Override
            public void onError(Throwable t) {
                System.out.println("Error");
            }
        });

        resp.getWriter().write("Nio Servlet Response");
        System.out.println("Nio Servlet Elapse Time:" + (System.currentTimeMillis() - start));
    }

    public void doBusiness(ServletRequest servletRequest) {
        System.out.println("Nio do bussiness");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
