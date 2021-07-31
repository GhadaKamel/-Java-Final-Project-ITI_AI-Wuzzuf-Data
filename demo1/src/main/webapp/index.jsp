<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%--<br/>
<label>1</label>
<H3><%= request.getContextPath() %></H3>
<label>2</label>
<h3><%="${pageContext.request.getContextPath()}"%></h3>
<img scr="${pageContext.request.getContextPath()}/resources/DsJ-6QHXoAI-sCX.jpg">
<img src="data:image/jpg;base64, <%=b64%>"/>--%>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/structure">Display Structure</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/summary">Display Summary</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/clean-data">Clean Data</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/jobs-freq-for-companies/5">Display Jobs freq For Companies </a>
<%--<input type="text" name="companies_limit" value="${companiesLimit}" />
<br/> <label>${companiesLimit}</label>--%>
<%--<form action="MyServlet" method="post">
    <label>Display Jobs freq For Companies </label>
    limited to: <input type="text" id="companies_limit" placeholder="type companies limit"/>
    <input type="submit" value="ok"/>
</form>--%>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/jobs-pie-chart">Display pie chart for most freq job titles</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/most-freq-job-titles/5">Display most freq job titles</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/jobs-titels-bar-chart">Display jobs titels bar chart</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/most-freq-areas/5">Display most freq areas</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/most-freq-areas-bar-chart">Display most freq areas bar chart</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/most-imp-skill/5">Display most imp skill</a>
<br/>
<a href="${pageContext.request.contextPath}/api/hello-world/factorize-years-exp">Factorize the YearsExp feature and convert it to numbers in new col</a>
</body>
</html>