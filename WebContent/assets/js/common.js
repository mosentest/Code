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

//关闭灰色 jQuery 遮罩
function closeLogin() {
	$("#fullbg,#login").hide();
} 