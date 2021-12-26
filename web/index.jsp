<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>首页-练习</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            //添加省份的select组件
            getProvinceList();

            //查询按钮的单击事件
            $("#queryCity").click(function(){
                //选中的下拉列表的值
                var pid=$("#province>option:selected").val();

                $.get("city/queryCity.do",{pid:pid},
                     function(resp){
                         if(resp.code==0){
                             alert(resp.msg);

                             $("#cityInfo").empty();
                             $.each(resp.data,function(i,n){
                                $("#cityInfo").append("<tr><td>"+n.id+"</td><td>"+n.name+"</td></tr>");
                             })
                         } else {
                             alert(resp.msg)
                         }
                     },
                    "json")
            })

            //添加城市
            $("#addCity").on("click",function(){
                var pid=$("#province>option:selected").val();
                var name = $(":text").val();

                $.post("city/addCity.do",{name:name,provinceId:pid},
                        function(resp){
                          if( resp.code ==0){
                              //连接到查询业务，或者查看城市列表的其他页面
                              alert(resp.msg);
                          } else {
                              // 重新添加数据
                              alert(resp.msg);
                          }

                        },
                        "json")
            })

        })



        function getProvinceList(){
            $.ajax({
                url:"queryProvince.do",
                dataType:"json",
                success:function(resp){
                    $("#province").empty();
                    $.each(resp.data,function(i,n){
                        $("#province").append("<option value='"+n.id+"'>"+n.name+"</option>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <tr>
                <td>省份列表：</td>
                <td>
                    <select id="province">
                        <option value="0">请选择...</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>城市名称</td>
                <td><input type="text" id="cityname"></td>
            </tr>
            <tr>
                <td>
                    <input type="button" id="addCity" value="添加城市">
                </td>
                <td>
                    <input type="button" id="queryCity" value="查询省份的城市">
                </td>
            </tr>
        </table>
        <br/>
        <div id="dataDiv">
            <table border="1">
                <thead>
                 <tr>
                     <td>城市id</td>
                     <td>城市名称</td>
                 </tr>

                </thead>
                <tbody id="cityInfo">

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
