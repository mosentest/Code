//login.jsp
//显示灰色 jQuery 遮罩层
function openLogin() {
	var bh = $("body").height();
	var bw = $("body").width();
	$("#fullbg").css({
		height : bh,
		width : bw,
		display : "block"
	});
	$("#login").show();
}

// 关闭灰色 jQuery 遮罩
function closeLogin() {
	$("#fullbg,#login").hide();
}

// admin/index.jsp
//DataGrid 数据表格
/*dateGrid指代table*/
//<script language="javascript">
//<!--
// //senfe("表格名称","奇数行背景","偶数行背景","鼠标经过背景","点击后背景");
// senfe("dateGrid","#fff","#fff","#cfc","#fff");
//-->
//</script>
function senfe(o, a, b, c, d) {
	var t = document.getElementById(o).getElementsByTagName("tr");
	for (var i = 0; i < t.length; i++) {
		t[i].style.backgroundColor = (t[i].sectionRowIndex % 2 == 0) ? a : b;
		t[i].onclick = function() {
			if (this.x != "1") {
				this.x = "1";// 本来打算直接用背景色判断，FF获取到的背景是RGB值，不好判断
				this.style.backgroundColor = d;
			} else {
				this.x = "0";
				this.style.backgroundColor = (this.sectionRowIndex % 2 == 0) ? a
						: b;
			}
		}
		t[i].onmouseover = function() {
			if (this.x != "1")
				this.style.backgroundColor = c;
		}
		t[i].onmouseout = function() {
			if (this.x != "1")
				this.style.backgroundColor = (this.sectionRowIndex % 2 == 0) ? a
						: b;
		}
	}
}