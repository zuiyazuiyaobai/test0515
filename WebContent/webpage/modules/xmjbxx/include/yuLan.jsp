<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="java.io.File"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileInputStream"%>

<%

	String filepath = (String) request.getParameter("filepath");
%>

<html>
	<head>
		<title>河南省投资项目在线审批监管平台系统</title>
		<style>
		* {
			margin: 0px;
			padding: 0px;
		}
		</style>

	</head>
	<body>

		<div>

			<%
				System.out.println("filepath=====" + filepath);
				
				out.clear();
				out = pageContext.pushBody();
				response.setContentType("application/pdf");

				try {
					String strPdfPath = new String(filepath);
					//判断该路径下的文件是否存在 
					File file = new File(strPdfPath);
					if (file.exists()) {
						DataOutputStream temps = new DataOutputStream(response
								.getOutputStream());
						DataInputStream in = new DataInputStream(
								new FileInputStream(strPdfPath));

						byte[] b = new byte[2048];
						while ((in.read(b)) != -1) {
							temps.write(b);
							temps.flush();
						}

						in.close();
						temps.close();
					} else {
						out.print(strPdfPath + " 文件不存在!");
					}

				} catch (Exception e) {
					out.println(e.getMessage());
				}
			%>

		</div>

	</body>
</html>






