function initData(){
	var categoryId = $('#categoryId').val();
	$.ajax({
		type:"get",
		url:"/blog/data/getBlogCountsbyType",
		data:{"categoryId":categoryId},
		dataType:"json",
		success:function(res){
			console.log(res)
			layui.use('laypage', function() {
				var laypage = layui.laypage;
				//执行一个laypage实例
				laypage.render({
					elem : 'pageItem', 
					count : res.data, 
					jump : function(obj, first) {
						console.log('当前页数：' + obj.curr); //当前页
						console.log('每页数量：' + obj.limit); //每页显示的条数
						var str = {"categoryId":categoryId,"currentPage":obj.curr,"pageSize":obj.limit};
						
							$.ajax({
								type:"post",
								url:"/blog/data/getArticleByPageModel",
								data:JSON.stringify(str),
								contentType : 'application/json',
								dataType:"json",
								success:function(res){
									console.log(res.data);
									var data = res.data;
									$("#blogs").html("");
									scrollTo(0,0);
									for(var i= 0;i<data.length;i++){
										var item = data[i];	
										console.log(item)
									$("#blogs").append("<div class='blogs' >"+"<figure>"+"<a href='/todetailShow?articleId="+item.articleId+"' >"
											+"<img src='"+item.showImg+"'>"+"</img>"+"</a>"+"</figure>"+"<ul>"+"<h3>"+"<a href='/todetailShow?articleId="+item.articleId+"'>"+
											item.articleTitle+"</a>"+"</h3>"+"	<p class='layui-elip'>"+item.content+"</p>"+"<p class='autor'>"
											+"<span class='lm f_l'>"+"<a href='/' >"+item.categoryName+"</a>"+"</span>"+"<span class='dtime f_l' >"+item.pubdate+"</span>"
											+"<span class='viewnum f_r'>"+"浏览（"+"<a href='/' >"+item.pageView+"</a>)"+"</span>"+"	<span class='pingl f_r'>"+
											"评论("+"<a href='/'>"+item.commentCount+"</a>)"+"</span>"+"</p>"+"</ul>"+"</div>");
									}
								}
							});
						
					}
				});
			});
		}
	});
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

initData();