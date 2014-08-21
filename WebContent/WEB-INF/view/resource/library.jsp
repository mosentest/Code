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
      <div class="embedded-panel" id="chart">
      <script>
  //http://bl.ocks.org/anupsavvy/raw/9513382/#
  //http://www.ourd3js.com/wordpress/?p=100
  var width = 300;
  var height = 300;
  var dataset = [];
  var num = 6; //数组的数量

  for (var i = 0; i < num; i++) {
    var tempnum = Math.floor(Math.random() * 50); // 返回 0~50 整数
    dataset.push(tempnum);
  }

  var svg = d3.select("#chart").append("svg").attr("width", width).attr(
      "height", height);

  var xAxisScale = d3.scale.ordinal().domain(d3.range(dataset.length))
      .rangeRoundBands([ 0, 50 ]);

  var yAxisScale = d3.scale.linear().domain([ 0, d3.max(dataset) ]).range(
      [ 230, 0 ]);

  var xAxis = d3.svg.axis().scale(xAxisScale).orient("bottom");

  var yAxis = d3.svg.axis().scale(yAxisScale).orient("left");

  var xScale = d3.scale.ordinal().domain(d3.range(dataset.length))
      .rangeRoundBands([ 0, 500 ], 0.05);

  var yScale = d3.scale.linear().domain([ 0, d3.max(dataset) ]).range(
      [ 0, 500 ]);

  svg.selectAll("rect").data(dataset).enter().append("rect").attr("x",
      function(d, i) {
        return 30 + xScale(i);
      }).attr("y", function(d, i) {
    return 50 + 500 - yScale(d);
  }).attr("width", function(d, i) {
    return xScale.rangeBand();
  }).attr("height", yScale).attr("fill", "red").on("click", function(d, i) {
    d3.select(this).attr("fill", "green");
  }).on("mouseover", function(d, i) {
    d3.select(this).attr("fill", "yellow");
  }).on("mouseout", function(d, i) {
    d3.select(this).transition().duration(500).attr("fill", "red");
  });

  svg.selectAll("text").data(dataset).enter().append("text").attr("x",
      function(d, i) {
        return 30 + xScale(i);
      }).attr("y", function(d, i) {
    return 50 + 500 - yScale(d);
  }).attr("dx", function(d, i) {
    return xScale.rangeBand() / 3;
  }).attr("dy", 15).attr("text-anchor", "begin").attr("font-size", 14).attr(
      "fill", "white").text(function(d, i) {
    return d;
  });

  svg.append("g").attr("class", "axis")
      .attr("transform", "translate(30,550)").call(xAxis);

  svg.append("g").attr("class", "axis").attr("transform", "translate(30,50)")
      .call(yAxis);
</script>
      </div>
    </aside>
  </div>
</div>
</section>
<jsp:include page="/WEB-INF/view/footer.jsp" />