<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
  <%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
  %>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="UTF-8">
  <title>Source Community</title>
  <link rel="icon" type="image/png" href="assets/img/core/favicon.png">
  <link rel="stylesheet" href="assets/css/aui.css" media="all">
  <link rel="stylesheet" href="assets/css/aui-experimental.css" media="all">
  <link rel="stylesheet" href="assets/css/aui-design.css" media="all">
  <link rel="stylesheet" href="assets/css/source.css" media="all">
  <!--自定义样式-->
  <link rel="stylesheet" type="text/css" href="assets/css/ziqi.css"/>
  <script src="assets/js/jquery-2.0.3.js"></script>
  <script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script> 
  <script src="assets/js/hunter.js"></script>
  <script src="assets/js/aui.js"></script>
  <script src="assets/js/aui-experimental.js"></script>
  <!--自定义javascript-->
  <script src="assets/js/ziqi.js" type="text/javascript" charset="utf-8"></script>
</head>
<body class="aui-layout aui-theme-default" data-aui-version="5.5.1">
<jsp:include page="login.jsp"></jsp:include>
<header id="header" role="banner">
  <nav class="aui-header aui-dropdown2-trigger-group" role="navigation">
    <div class="aui-header-inner">
      <div class="aui-header-before">
        <a class="aui-dropdown2-trigger app-switcher-trigger" aria-owns="app-switcher" id="flatpack-app-switcher-trigger" aria-controls="app-switcher">
          <span class="aui-icon aui-icon-small aui-iconfont-appswitcher">Design/AUI</span>
        </a>
        <div class="aui-dropdown2 aui-style-default aui-dropdown2-in-header" id="app-switcher" style="left: 10px; top: 40px; display: none;" data-dropdown2-alignment="left" aria-hidden="true">
          <ul role="radiogroup">
            <li><a class="aui-dropdown2-radio interactive checked" role="radio" aria-checked="true">Source</a></li>
            <li><a href="#" class="aui-dropdown2-radio interactive" role="radio" aria-checked="false">BlogSpot</a></li>
            <li><a href="#" class="aui-dropdown2-radio interactive" role="radio" aria-checked="false">Open Source</a></li>
            <li><a href="#" class="aui-dropdown2-radio interactive" role="radio" aria-checked="false">Discussion</a></li>
            <li><a href="#" class="aui-dropdown2-radio interactive" role="radio" aria-checked="false">Ask</a></li>
            <li><a href="#" class="aui-dropdown2-radio interactive" role="radio" aria-checked="false">Hunter</a></li>
          </ul>
        </div>
      </div>
      <div class="aui-header-primary">
        <h1 id="logo" class="aui-header-logo aui-header-logo-confluence"><a href="#"><span class="aui-header-logo-device">Hunter</span></a></h1>
          <ul class="aui-nav" style="width: auto;">
            <li><a href="java/libs.html">Java</a></li>
            <li><a href="hunter.html">C++</a></li>
            <li><a href="hunter.html">Python</a></li>
            <li><a href="hunter.html">Scala</a></li>
            <li><a href="hunter.html">Erlang</a></li>
            <li style="display: inline-block;"><a id="aui-responsive-header-dropdown-trigger-more-2" class="aui-dropdown2-trigger" aria-owns="aui-responsive-header-dropdown-content-more-2" aria-haspopup="true" href="#">More<span class="icon aui-icon-dropdown"></span></a><div id="aui-responsive-header-dropdown-content-more-2" class="aui-dropdown2 aui-style-default"><div class="aui-dropdown2-section"><ul id="aui-responsive-header-dropdown-list-more-2"><li><a href="#">DROPDOWN</a></li></ul></div></div></li><li><a class="aui-button aui-style aui-button-primary" href="#">TEST</a></li>
          </ul>
      </div>
      <div class="aui-header-secondary">
        <ul class="aui-nav">
          <li>
            <form action="/foo" method="post" class="aui-quicksearch">
              <label for="quicksearchid" class="assistive">Search</label>
              <input id="quicksearchid" class="search" type="text" placeholder="Search" name="quicksearchname">
            </form>
          </li>
          <c:if test="${sessionScope.online}">
            <li><a href="#"><span class="aui-icon aui-icon-small aui-iconfont-configure">Configure</span></a></li>
            <li><a href="#dropdown2-header-conf-admin" aria-owns="dropdown2-header-conf-admin" aria-haspopup="true" class="aui-dropdown2-trigger" aria-controls="dropdown2-header-conf-admin">
              <div class="aui-avatar aui-avatar-small">
                <div class="aui-avatar-inner">
                  <img src="assets/img/core/default-avatar.png" alt="Username">
                </div>
              </div>
              </a>
              <div class="aui-dropdown2 aui-style-default aui-dropdown2-in-header" id="dropdown2-header-conf-admin" style="display: none; top: 40px; min-width: 160px; left: 1213px;" aria-hidden="true">
                <div class="aui-dropdown2-section">
                  <ul>
                    <li><a href="#" class="active">Update status…</a></li>
                  </ul>
                </div>
                <div class="aui-dropdown2-section">
                  <ul>
                    <li><a href="#">Personal Space</a></li>
                    <li><a href="#">Recently viewed</a></li>
                  </ul>
                </div>
                <div class="aui-dropdown2-section">
                  <ul>
                    <li><a href="#">Profile</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="#">Network</a></li>
                    <li><a href="#">Status updates</a></li>
                    <li><a href="#">Favourites</a></li>
                    <li><a href="#">Watches</a></li>
                    <li><a href="#">Drafts</a></li>
                    <li><a href="#">Atlassian Marketplace</a></li>
                    <li><a href="#">Extensions</a></li>
                  </ul>
                </div>
                <div class="aui-dropdown2-section">
                  <ul>
                    <li><a href="#">Log out</a></li>
                  </ul>
                </div>
              </div>
            </li>
          </c:if>
          <c:if test="${not sessionScope.online}">
            <li><a href="javascript:openLogin();">Login</a></li>
          </c:if>
          <li style="display: none;"><a href="#" id="aui-responsive-header-layer-trigger-2" class="aui-responsive-header-layer-trigger" tabindex="0"><span class="aui-icon aui-icon aui-icon-small aui-iconfont-appswitcher">menu </span></a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>