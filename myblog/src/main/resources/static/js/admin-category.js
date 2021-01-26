function initData(){
	$.ajax({
		type: "get",
		url:"/admin/getCategoryData",
		cache: false, //不缓存此页面   
		success: function (val) {
			$("#categoryCount").html(val.data.length);
			$(val.data).each(function(){
				$("#categoryui").append($("<tr>"+
						"<td>"+this.categoryName+"</td>"+
						"<td>"+this.otherName+"</td>"+
						"<td>"+
						"<a href='update-category.html' style='margin-right:5px'>"+"修改"+
						"</a>"+"|"+
						'<a style="margin-left:5px"  onclick="deleteCategory(\' ' + this.categoryId + ' \')">'+"删除"+
						"</a>"+
						"</td>"+
						"</tr>"));
			});
		}
	});
}

/**
 * 删除分类
 * @param val
 * @returns
 */
function deleteCategory(val){
	var id = val.replace(/(^\s*)|(\s*$)/g, "");
	if (event.srcElement.outerText === "删除") 
	{
		if(window.confirm("此操作不可逆，是否确认？"))
		{
			$.ajax({
				type: "POST",
				url:"/admin/deleteCategory",
				data: "id=" + id,
				cache: false, //不缓存此页面   
				success: function (data) {
					if(data.status == 0){
						window.location.reload();
					}
			
				}
			});
		};
	};
};

/**
 * 添加分类
 * @returns
 */
function addCategory(){
	$.ajax({
		type: "POST",
		url:"/admin/addcategory",
		data: $("#addCategoryForm").serialize(),
		cache: false, //不缓存此页面   
		success: function (data) {
			console.log(data);
			//window.location.reload();
		}
	});
}


initData();