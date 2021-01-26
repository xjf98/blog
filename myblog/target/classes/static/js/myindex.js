/**
 * 跳转博客详情
 * @param val
 * @returns
 */
function todetail(val){
	var url = "/todetailShow?articleId="+val;
    window.location.href = url;
}


/**
 * 切换卡
 */
window.onload = function() {
		var oLi = document.getElementById("tab")
			.getElementsByTagName("li");
	var oUl = document.getElementById("ms-main")
			.getElementsByTagName("div");

	for (var i = 0; i < oLi.length; i++) {
		oLi[i].index = i;
		oLi[i].onmouseover = function() {
			for (var n = 0; n < oLi.length; n++)
				oLi[n].className = "";
			this.className = "cur";
			for (var n = 0; n < oUl.length; n++)
				oUl[n].style.display = "none";
			oUl[this.index].style.display = "block"
		}
	}					
}

/**
 * 首页导航图
 */
if (!window.slider) {
	var slider = {};
}
slider.data = [ {
	"id" : "slide-img-1", // 与slide-runner中的img标签id对应
	"client" : "",
	"desc" : "" //这里修改描述
}, {
	"id" : "slide-img-2",
	"client" : "",
	"desc" : ""
}, ];