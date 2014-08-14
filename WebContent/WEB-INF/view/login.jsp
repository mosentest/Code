<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx}/resources/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext/ext-lang-zh_CN.js"></script>
<style type="text/css">
body {
	margin: 0px;
	font-size: 13px;
}

.top {
	/* background: url(${ctx}/resources/images/back/login_top_bk.png) repeat; */
}

.bottom {
	/* background: url(${ctx}/resources/images/back/login_bottom_bk.png) repeat; */
}

.main {
	/* background: url(${ctx}/resources/images/back/login_bk.png) repeat-x; */
	height: 620px;
}

.light {
	/* background: url(${ctx}/resources/images/back/login.png) no-repeat; */
	width: 1003px;
	height: 620px;
	margin: 0px auto;
}

.login {
	padding: 240px 370px 116px 390px;
}

.bs-docs-example {
	position: relative;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

.control-group {
	height: 30px;
	margin: 5px 0px;
}

.error {
	height: 10px;
	margin: 0px 0px 0px 65px;
}

.check {
	height: 10px;
	margin: 20px 0px 0px 0px;
}

.form-horizontal .control-label {
	float: left;
	width: 60px;
	height: 20px;
	line-height: 20px;
}

input {
	display: inline-block;
	margin-bottom: 0;
	vertical-align: middle;
	background-color: #fff;
	border: 1px solid #ccc;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	height: 20px;
	line-height: 20px;
	color: #555;
}

label {
	display: block;
	font-size: 14px;
	font-weight: normal;
	line-height: 20px;
}

.btn {
	display: inline-block;
	padding: 4px 12px;
	width: 70px;
	font-size: 14px;
	line-height: 20px;
	color: #333;
	text-align: center;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
	vertical-align: middle;
	cursor: pointer;
	background-color: #f5f5f5;
	background-image: -moz-linear-gradient(top, #fff, #e6e6e6);
	background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#fff),
		to(#e6e6e6) );
	background-image: -webkit-linear-gradient(top, #fff, #e6e6e6);
	background-image: -o-linear-gradient(top, #fff, #e6e6e6);
	background-image: linear-gradient(to bottom, #fff, #e6e6e6);
	background-repeat: repeat-x;
	border: 1px solid #ccc;
	border-color: #e6e6e6 #e6e6e6 #bfbfbf;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	border-bottom-color: #b3b3b3;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff',
		endColorstr='#ffe6e6e6', GradientType=0 );
	filter: progid:DXImageTransform.Microsoft.gradient(enabled=false );
	-webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	-moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px
		rgba(0, 0, 0, 0.05);
	font-size: 14px;
	margin-left: 10px
}
</style>
<title>泓德物流业务系统V1.0</title>
<!-- <script type="text/javascript">
	Ext.onReady(function() {
		var msg = Ext.get("msg");
		if (!(Ext.isChrome)) {
			msg.update("为了更好的使用系统，建议您使用<a href=\"javascript:window.location.href='loginPage/downloadchrome'\"><span>谷歌浏览器</span></a>");
			msg.setVisible(true);
			return;
		}
	});
</script> -->
</head>
<body>
	<div class="container">
		<div class="top"></div>
		<div class="main" id="center">
			<div class="light">
				<div class="login">
					<div class="error">
						<font color="red"> <c:if test="${error!=null }">${error }</c:if>
						</font>
					</div>
					<form class="bs-docs-example form-horizontal" action="${pageContext.request.contextPath}/s/login"
						method="post">

						<div class="control-group">
							<label class="control-label" for="username">用户名：</label>
							<div class="controls">
								<input type="text" id="username" name="username"
									placeholder="请输入用户名" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="password">密 码：</label>
							<div class="controls">
								<input type="password" name="password" id="password"
									placeholder="请输入密码" />
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								记住我：<input type="checkbox" name="rememberMe" />
								<button type="submit" class="btn">登录</button>
							</div>
						</div>
					</form>
					<div id="msg" class="check"
						style="width: 100%; text-align: center; color: red; font-size: 12px; display: none;">
					</div>
				</div>
			</div>
		</div>
		<div class="bottom"></div>
	</div>
	<script type="text/javascript">
		var height = (document.body.scrollHeight - $(".main").height()) / 2;
		$(".top").height(height);
		$(".bottom").height(height);
	</script>
</body>
</html>