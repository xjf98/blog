function initData(){
	$.ajax({
		type: "get",
		url: "/adminarticle/getAllArticleCount",
		success: function (val) {
			console.log(val);
			layui.use('laypage', function() {
				var laypage = layui.laypage;
				//执行一个laypage实例
				laypage.render({
					elem : 'pageItem', 
					count : val.data, 
					jump : function(obj, first) {
						console.log(obj.curr);
						console.log(obj.limit);
						$.ajax({
							type:"get",
							url:"/adminarticle/getAllArticleByPage",
							data:{"currentPage":obj.curr,"count":obj.limit},
							success:function(res){
								console.log(res);
								$("#blogTr").html("");							
								$(res.data).each(function(){
									$("#blogTr").append("<tr>"+"<td>"+"<input type='checkbox' class='input-control' name='checkbox[]' value='' />"+
											"</td>"+"<td class='article-title'>"+this.articleTitle+"</td>"+"<td>"+this.categoryName+"</td>"+
											"<td class='hidden-sm'>"+"PHP、JavaScript"+"</td>"+"<td class='hidden-sm'>"+this.username+"</td>"+
											"<td>"+this.pubdate+"</td>"+"<td>"+
											"<a rel='6' style='margin-left:5px' onclick='delArticle(\"" + this.articleId + "\")' >"+"删除"+"</a>"+"</td>"+"</tr>"); 
								});
							}
							
						});
					}
				});
			});
		}
	});
}

/**
 * 删除一篇博客
 * @param articleId
 * @returns
 */
function delArticle(articleId){
	console.log(articleId);
	
	$.ajax({
		type : "post",
		url : "/article/deleteArticle",
		cache : false, //不缓存此页面  
		data : {
			"articleId" : articleId,
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			if(data.status == 0){
				alert("删除成功");
				window.location.reload();
			}
		}
	});
}

initData();