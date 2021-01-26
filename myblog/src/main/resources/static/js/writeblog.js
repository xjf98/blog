


/**
 * 初始化分类数据
 * @returns
 */
function initCategoryData(){
	$.ajax({
		type : "POST",
		url : "/writeblog/showType",
		cache : false, //不缓存此页面  
		dataType: "json",
		success : function(data) {
			console.log(data);
			$(data).each(function(){
				$(".category-list").append($("<li>"+"<label>"+
						"<input  name='category' type='radio' value='"+this.categoryId+"'>"+this.categoryName+
						"</label>"+"</li>"));
			});
		}
	});
}

//图片上传回显
function uploadFile(file,editor,welEditable) {
	data = new FormData();
	data.append("file", file);
	$.ajax({
		data: data,
		type: "POST",
		url: '/uploadBlogImg', //此处配置后端的上传文件，PHP，JSP或者其它
		cache: false,
		contentType: false,
		processData: false,
		success: function(res) {
			console.log(res);
			editor.summernote('insertImage', res.data); //完成上传后插入图片到编辑器
		}
	});
}


	
$('.btn-primary').click(function(){
		console.log("rgergg ");
		var articleContent = $('#article-content').summernote('code');
		var categoryId = $('input:radio:checked').val();
		var articleTitle = $('#article-title').val();
		var tag = $('#tag').val();
		
		$.ajax({
			type : "POST",
			url : "/article/addblog",
			data:{"articleContent":articleContent,"categoryId":categoryId,"articleTitle":articleTitle},
			dataType: "json",
			success : function(data) {
				alert("添加成功")；
			}
	          });
	
	}



initCategoryData();