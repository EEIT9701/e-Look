<%@ page contentType="text/html;charset=Big5" language="java" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 
<% 
// �ŧi�N�W�Ǥ��ɮש�m����A���� / .... /upload �ؿ��� 
String saveDirectory = "c:\\"; 
// �ŧi�Ȧs�ؿ� 
String tmpDirectory = "c:\\"; 
// �ŧi����W�Ǥ��ɮ��`�j�p��, ��쬰 byte, -1 ��ܵL���� 
int maxPostSize = 1024 * 1024; 
%> 
<% 
// �ŧi�x�s�ԭz�W���ɮפ��e���ܼ� 
String FileDescription = null; 
// �ŧi�x�s�W���ɮצW�٪��ܼ� 
String FileName = null; 
// �ŧi�x�s�W���ɮפj�p���ܼ� 
long FileSize = 0; 
// �ŧi�x�s�W���ɮ׫��A���ܼ� 
String ContentType = null; 
// �p��W���ɮפ��Ӽ� 
int count = 0 ; 
%> 
<% 
DiskFileUpload upload = new DiskFileUpload(); 
// �]�w�O����s���ƪ��j�p, �W�L�h�g�J�ɮ�, ���]�w�Ȧs�ؿ�, �Ȧs�ɸm��Ȧs�ؿ��U 
upload.setSizeThreshold(4096); 
// �]�w�`�W�Ǥj�p���� 
upload.setSizeMax(maxPostSize); 
// �]�w�Ȧs�ؿ� 
upload.setRepositoryPath(tmpDirectory); 
List /* FileItem */ items = upload.parseRequest(request); 
%> 
<body> 
<% 
Iterator iter = items.iterator(); 
int tmp = 0; 
FileItem tmpItem = null; 
while (iter.hasNext()) { 
tmp++; 
FileItem item = (FileItem) iter.next(); 
if (item.isFormField()) { 
// �p�G�O�@�����, ���o�ɮױԭz 
FileDescription = item.getString(); 
} else { 
// �_�h���o�ɮ׸�T 
FileName = item.getName(); 
// �]�����P���s�����|�y���ǻ� path + filename, ���ǫh�u�� filename 
try { 
// for wintel platform 
FileName = FileName.substring(FileName.lastIndexOf("\\")+1); 
// for unix-like platform 
FileName = FileName.substring(FileName.lastIndexOf("/")+1); 
} catch ( Exception ex ) { 
out.println(ex); 
} 
ContentType = item.getContentType(); 
FileSize = item.getSize(); 
tmpItem = item; 
} 
// �]���@���ɮ׳��O������, �CŪ��������B�z�@�� 
if (tmp == 2 && FileSize != 0) { 
count ++; 
%> 
<font color="red">�A�W�Ǫ���<%= count %>�Ӫ��ɮסG</font><br> 
�ɮצW�٬��G<%= FileName %><br> 
�ɮפj�p���G<%= FileSize %> Bytes<br> 
�ɮ׫��A���G<%= ContentType %><br> 
�ɮת��ԭz�G<%= FileDescription %><br><br> 
<% 
// �N�ɮ׼g�J�s�ɥؿ� 
try { 
out.println(FileName); 
File uploadedFile = new File(saveDirectory + FileName); 
tmpItem.write(uploadedFile); 
} catch ( Exception ex ) { 
out.println(ex); 
} 
tmp = 0; 
} else if (tmp == 2 && FileSize == 0) { 
tmp = 0; 
} // end if 
} // end while 
%> 
�z�`�@�W��<font color="red"><%= count %></font>���ɮ� 
</body> 
</html>