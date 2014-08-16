<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="source" uri="http://www.source.com/lib" %>
<jsp:include page="/WEB-INF/view/header.jsp">
  <jsp:param name="navigation" value="home" />
</jsp:include>
<section id="content" role="main" style="background: #f5f5f5;">
<header class="aui-page-header">
  <div class="aui-page-header">
    <div class="aui-page-header-inner">
      <h1>${jarFile.name}</h1>
    </div>
  </div>
</header>
<div class="aui-page-panel">
  <div class="aui-page-panel-inner">
    <section class="aui-page-panel-content">
    	<source:jarParser jarFile="${jarFile}"/>
    </section>
  </div>
</div>
</section>
<jsp:include page="/WEB-INF/view/footer.jsp" />