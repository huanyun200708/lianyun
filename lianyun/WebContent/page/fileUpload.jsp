<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <script type="text/javascript" src="../js/lib/jquery.js"></script>
        <script type="text/javascript" src="../js/lib/ajaxfileupload.js"></script>
        <script type="text/javascript">
        var basePath = "${pageContext.request.contextPath}";
    function ajaxFileUpload()
    {
        
        $("#loading").ajaxStart(function(){
            $(this).show();
        })//开始上传文件时显示一个图片
        .ajaxComplete(function(){
            $(this).hide();
        });//文件上传完成将图片隐藏起来
        
        $.ajaxFileUpload
        (
            {
                url:'upload_fileUpload.action',//用于文件上传的服务器端请求地址
                secureuri:false,//一般设置为false
                fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
                dataType: 'json',//返回值类型 一般设置为json
                success: function (data, status)  //服务器成功响应处理函数
                {
                    alert(data.message);//从服务器返回的json中取出message中的数据,其中message为在struts2中action中定义的成员变量
                    $("#fileImg").attr("src",basePath+'/'+data.imgDir);
                    if(typeof(data.error) != 'undefined')
                    {
                        if(data.error != '')
                        {
                            alert(data.error);
                        }else
                        {
                            alert(data.message);
                        }
                    }
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            }
        )
        
        return false;

    }
    </script>
    </head>
    <body>
        <input type="file" id="file" name="file" />
        <br />
        <input type="button" value="上传" onclick="return ajaxFileUpload();">
        <img alt="" id="fileImg" src="">
    </body>
</html>