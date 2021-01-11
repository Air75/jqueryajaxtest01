<%--
  Created by IntelliJ IDEA.
  User: airren
  Date: 2021/1/11
  Time: 1:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>使用jquery实现ajax级联查询</title>
    <script src="js/jquery-3.5.1.js" type="text/javascript"></script>
    <script>
      function initDataAjax(){
        //  做ajax请求，使用jquery的$.ajax()
        $.ajax(
                {
                  url:"queryprovince",
                  dataType:"json",
                  success:function (resp){
                    //删除旧的数据
                    $("#province").empty();
                    //alert(resp)
                    $.each(resp,function (index,element){
                      //获取select dom对象
                      $("#province").append("<option value='"+element.id+"'>"+element.name+"</option>")
                    })
                  }
                }
        )
      }

      $(function (){
        initDataAjax();

        $("#btnload").click(function () {
          initDataAjax();
        })
      //  给省份的select绑定一个change事件，当select内容发生变化时，触发事件
        $("#province").change(function () {
          var obj = $("#province>option:selected");
          // alert(obj.val())
          var provinceid = obj.val();
          //做一个ajax请求，获取省份的所有信息
          $.post("querycity",{proid:provinceid},function (resp) {
            // alert(resp);
            //删除旧的数据
            $("#city").empty();
            //alert(resp)
            $.each(resp,function (index,element){
              //获取select dom对象
              $("#city").append("<option value='"+element.id+"'>"+element.name+"</option>")
            })
          },"json")
        })
      })
    </script>
  </head>
  <body>
    <center><h1>省市级联查询，使用ajax</h1></center>
  <div>
    <table>
      <tr>
        <td>省份：</td>
        <td>
          <select id="province">
            <option value="0">请选择省份...</option>
          </select>
          <input type="button" value="加载省份" id="btnload">
        </td>

      </tr>
      <tr>
        <td>城市：</td>
        <td>
          <select id="city">
            <option value="0">请选择城市...</option>
          </select>
        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
