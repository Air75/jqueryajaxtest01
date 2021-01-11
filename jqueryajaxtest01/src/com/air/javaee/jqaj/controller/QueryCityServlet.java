package com.air.javaee.jqaj.controller;

import com.air.javaee.jqaj.dao.QueryDao;
import com.air.javaee.jqaj.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author:RenJIE(Air)
 * @Date:2021/1/11 - 9:13 下午
 * @Description:${PACKAGE_NAME}
 * @version: 1.0
 */
public class QueryCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        //        获取请求传过来的省份id
        String strProvinceid = request.getParameter("proid");
        if (strProvinceid != null && !"".equals(strProvinceid.trim())) {
            QueryDao dao = new QueryDao();
            List<City> list = dao.queryCityList(Integer.valueOf(strProvinceid));
            //把list转为json
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(list);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
