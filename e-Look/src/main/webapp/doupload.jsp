<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%
    //��request�ǤJUploadTool��
    toolkie.UploadTool upload = new toolkie.UploadTool(request);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
    <table align="center">
<tr><td align="center"><img src="http://localhost:8080/.galleria1.jpg"></td></tr>
<tr><td align="center">����1</td></tr>
</table>

<%
    //�d�߬O�_���~
    String msg = upload.checkUpload();
    if (msg.length() > 0) {
        out.println(msg);
    } else {
        //�]�w�W�Ǹ��|
        upload.setUploadDir(this.getServletContext().getRealPath("."));
        out.println("�W�Ǩ즹���|:"
                + this.getServletContext().getRealPath(".") + "<br/>");
        
        //out.println("<img src="+this.getServletContext().getRealPath(".")+">");            
                  
      
       
        //�}�l�W��
        if (upload.isExtUpload("File1"))
            msg = upload.doUpload(upload.getUploadParameter("File1"));
        
 
        if (msg.length() > 0)
            out.println(msg);
        else
            out.println("�W�Ǧ��\" + "<br/>");
                
                
                
 
    }
%>
 
</body>
</html>



    upload.setUploadDir(this.getServletContext().getRealPath("/")+"data//");
        out.println("�W�Ǩ즹���|:"
                + this.getServletContext().getRealPath("/data") + "<br/>");
