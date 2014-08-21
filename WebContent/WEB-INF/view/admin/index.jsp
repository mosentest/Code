<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/header.jsp">
  <jsp:param name="navigation" value="home" />
</jsp:include>
<section id="content" role="main" style="background: #f5f5f5;">
  <header class="aui-page-header">
    <div class="aui-page-header">
      <div class="aui-page-header-inner">
        <h1>index</h1>
      </div>
    </div>
  </header>
  <div class="aui-page-panel">
    <div class="aui-page-panel-inner">
      <div class="aui-page-panel-sidebar sidebar-left adg-sidebar">
        <nav class="aui-navgroup aui-navgroup-vertical"
          style="margin-top: 0px;">
          <div class="aui-navgroup-inner stalking-position">
            <div class="aui-navgroup-primary">
              <ul class="aui-nav __skate">
                <li><a href="javascript;;">item</a></li>
                <li><a href="javascript;;">item</a></li>
                <li><a href="javascript;;">item</a></li>
                <li><a href="javascript;;">item</a></li>
                <li><a href="javascript;;">item</a></li>
              </ul>
            </div>
            <!--.aui-navgroup-primary  -->
          </div>
          <!--.aui-navgroup-inner  -->
        </nav>
      </div>
      <!--.aui-page-panel-sidebar  -->
      <section class="aui-page-panel-content">
        <div id="chart" ></div>
      </section>
    </div>
  </div>
</section>
<jsp:include page="/WEB-INF/view/footer.jsp" />