<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/header.jsp">
  <jsp:param name="navigation" value="home" />
</jsp:include>
<section id="content" role="main" style="background: #f5f5f5;">
<header class="aui-page-header">
  <div class="aui-page-header">
    <div class="aui-page-header-inner">
      <h1>Jar Repository</h1>
    </div>
  </div>
</header>
<div class="aui-page-panel">
  <div class="aui-page-panel-inner">
    <aside class="aui-page-panel-sidebar sidebar-left">
      <h3>search/tags</h3>
      <c:forEach items="${tags}" var="tag">
        <p><a href="java/libs.html?tag=${tag.tag}">${tag.tag}</a></p>
      </c:forEach>
    </aside>
    <section class="aui-page-panel-content">
      <table class="aui">
        <thead>
          <tr>
            <th id="name">Name</th>
            <th id="type"></th>
            <th id="order"></th>
            <th id="action"></th>
          </tr>
        </thead>
        <tbody>
           <c:forEach items="${page.content}" var="jarFile">
             <tr>
               <td headers="name"><a href="java/jar/${jarFile.name}.html">${jarFile.name}</a></td>
               <th id="type"></th>
               <th id="order"></th>
               <th id="action"></th>
             </tr>
           </c:forEach>
         </tbody>
      </table>
    </section>
    <aside class="aui-page-panel-sidebar sidebar-right">
      <h3>most downloaded</h3>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
    </aside>
  </div>
</div>
</section>
<jsp:include page="/WEB-INF/view/footer.jsp" />