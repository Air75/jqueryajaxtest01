package com.air.javaee.jqaj.controller;

import com.air.javaee.jqaj.dao.QueryDao;
import com.air.javaee.jqaj.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author:RenJIE(Air)
 * @Date:2021/1/11 - 7:54 下午
 * @Description:${PACKAGE_NAME}
 * @version: 1.0
 */
public class QueryProvinceServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String json = "{}";
        //        调用dao，获取所有的省份信息，是一个List集合
        QueryDao dao = new QueryDao();
        List<Province> provinces = dao.queryProvinceList();
//        把list集合转为json格式的数据，输出给ajax请求
        if (provinces != null){
//            调用jackson工具库，实现List——>json
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(provinces);
        }
//        输出json数据，响应ajax的请求，返回数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();
    }
}
