function initCommentData(){
	var articleId = $("#articleId").val();
	
	$.ajax({
		type : "POST",
		url:"/comment/getBlogAllComments",
		data:{"articleId":articleId},
		dataType : "json",
		success:function(val){
		$(val.data).each(function(){
				$("#commentli").append("<li>"+"<div class='common-box-row layui-row'>"+"<div class='common-headimg layui-col-md1 layui-col-xs2'>"+
						"<div class='commonimg-box'>"+
						"<img src='../img/02.jpg'>"+
						"</div>"+
						"</div>"+
						"<div class='common-info-row layui-col-md11 layui-col-xs10'>"+
						"<div class='common-nickname layui-row'>"+
						"<span>"+this.commentDate+"</span>"+
						"<span>" +this.username+":"+
						"</span>"+
						'<a onclick="showReply(\' '+this.answerId+'\',\' '+this.commentId+'\',\' '+this.username+'\')"  style="float: right;" >'+"回复"+
						"</a>"+
						"</div>"+
						"<div class='common-text layui-row'>"+this.commentContent+
						"</div>"+
						"</div>"+
						"<ul>"+
						"<li id='"+this.commentId+"'>"+
						"</li>"+
						"<ul>"+
						"</div>"+
						"</li>");
			});
		
		$(val.data).each(function(){
			$(this.replyList).each(function(){
				$("#"+this.commentId).append("<li>"+"<div class='common-box-row layui-row'>"+
						"<div class='common-headimg layui-col-md1 layui-col-xs2'>"+
						"<div class='commonimg-box'>"+
						"<img src='../img/a1.jpg'>"+"</div>"+"</div>"+
						"<div class='common-info-row layui-col-md11 layui-col-xs10'>"+
						"<div class='common-nickname layui-row' >"+
						"<span>"+this.replyDate+
						"</span>"+
						"<span>"+this.username+
						"</span>"+":"+
						"<span style='color: #66CCFF; font-size: 14px;'>"+"回复"+
						"</span> "+
						"<span>"+this.answerName+
						"</span>"+
						'<a onclick="showReplymid(\' '  +this.replyerId+'\',\' '+this.answerId+'\',\' '+this.username+'\',\' '+this.commentId+'\')" style="float: right;" >'+
						"回复"+"</a>"+
						"</div>"+
						"<div class='common-text layui-row'>"+this.replyContent+
						"</div>"+
						"</div>"+
						"</div>"
				);
			});
		});
		
		
		}
	});
}

initCommentData();