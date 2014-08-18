<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="source" uri="http://www.source.com/lib" %>
<jsp:include page="/WEB-INF/view/header.jsp">
  <jsp:param name="navigation" value="home" />
</jsp:include>
<section id="content" role="main" style="background: #f5f5f5;">
<div class="aui-page-panel">
  <div class="aui-page-panel-inner">
    <section class="aui-page-panel-content">
      <div class="embedded-panel">
        <div class="embedded-panel-title">
          <h2>${jarFile.name}</h2>
        </div>
        <a href="#">Download ${jarFile.name}</a>
        <div class="embedded-panel-content">
          <table class="aui info">
          	<thead>
          	  <tr>
          	  	<th colspan="4">JarFile Information</th>
          	  </tr>
          	</thead>
          	<tbody>
          	  <tr>
          	  	<td class="key">Category</td>
          	  	<td class="value" colspan="3">
          	  	  <c:forEach items="${jarFile.category}" var="category">
          	  	  	<span class="aui-lozenge aui-lozenge-subtle">
          	  	  	  <a href="#">${category}</a>
          	  	  	</span>
          	  	  </c:forEach>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td class="key">Description</td>
          	  	<td class="value" colspan="3"><small>${jarFile.description}</small></td>
          	  </tr>
          	  <tr>
          	  	<td class="key">Git Repository</td>
          	  	<td class="value"><a href="https://github.com/Zimuuu/Code">https://github.com/Zimuuu/Code</a></td>
          	  	<td class="key">Git Owner</td>
          	  	<td class="value">Springframework</td>
          	  </tr>
          	  <tr>
          	  	<td class="key">Uploaded</td>
          	  	<td class="value"></td>
          	  	<td class="value" colspan="2">
          	  	  <a href="#">See download statistics</a>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td class="key">Downloads Weekly</td>
          	  	<td class="value">${jarFile.downloads}</td>
          	  	<td class="key">Downloads Total</td>
          	  	<td class="value">${jarFile.downloads}</td>
          	  </tr>
          	  <tr>
          	  	<td class="key">Downloads</td>
          	  	<td class="value" colspan="3">
          	  	  Source: <a href="#">${jarFile.name}</a><br/>
          	  	  JavaDoc: <a href="#">${jarFile.name}</a>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td class="key">Tags</td>
          	  	<td class="value" colspan="3">
          	  	  <c:forEach items="${jarFile.tags}" var="tag">
          	  	  	<span class="aui-lozenge aui-lozenge-complete aui-lozenge-subtle">${tag}</span>
          	  	  </c:forEach>
          	  	</td>
          	  </tr>
          	</tbody>
          </table>
          <source:jarParser jarFile="${jarFile}"/>
        </div>
      </div>
    </section>
    <aside class="aui-page-panel-sidebar">
      <table class="aui info">
        <thead>
       	  <tr>
        	<th colspan="2">Project Information</th>
          </tr>
        </thead>
        <tbody>
          <tr>
           	<td class="key">Project</td>
           	<td class="value">Source Community</td>
          </tr>
          <tr>
           	<td class="key">Project Homepage</td>
           	<td class="value"><a href="https://github.com/Zimuuu/Code">https://github.com/Zimuuu/Code</a></td>
          </tr>
          <tr>
           	<td class="key">Version</td>
           	<td class="value">0.0.1-SNAPSHOT</td>
          </tr>
          <tr>
           	<td class="key">Maven Repository</td>
           	<td class=""></td>
          </tr>
        </tbody>
      </table>
    </aside>
  </div>
</div>
</section>
<jsp:include page="/WEB-INF/view/footer.jsp" />