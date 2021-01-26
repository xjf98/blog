var globalAnswerId;
var globalCommentId;
var globalAnswerName;

/**
 * 增加评论
 * @param articleId
 * @returns
 */
function addComment(articleId) {
	var commentContent = document.getElementById("commentContent").value;
	var uid = document.getElementById("uidVal").innerText;
	
	$	.ajax({
				type : "post",
				url : "/comment/addComment",
				cache : false, //不缓存此页面  
				data : {
					"articleId" : articleId,
					"commentContent" : commentContent,
					"answerId" : uid
				},
				dataType : "json",
				success : function(data) {
					$("#commentli")
							.append(
									$("<li>"
											+ "<div class='common-box-row layui-row'>"
											+ "<div class='common-headimg layui-col-md1 layui-col-xs2'>"
											+ "<div class='commonimg-box'>"
											+ "<img src='../img/02.jpg'/>"
											+ "</div>"
											+ "</div>"
											+ "<div class='common-info-row layui-col-md11 layui-col-xs10'>"
											+ "<div class='common-nickname layui-row'>"
											+ data.commentDate
											+ "<span>"
											+ data.username
											+ "<a  href='javascript:void(0)'	style='float: right' onclick='showReply("+data.answerId+","+data.commentId+")'>回复"
											+ "</a>"
											+ "</span>"
											+ "</div>"
											+ "<div class='common-text layui-row'>"
											+ data.commentContent
											+ "</div>" + "</div>"
											+ "</div>" + "</li>"));

				}
			});
}




/**
 * 在回复框中显示内容
 * @param answerId
 * @param commentId
 * @returns
 */
function showReply(answerId,commentId,username){
	globalAnswerId = answerId;
	globalCommentId = commentId;
	globalAnswerName = username;
 $("#replyContent").attr("placeholder", "回复 :"+username);
}

function showReplymid(replyerId,answerId,username,commentId){
	globalAnswerId = answerId;
	globalCommentId = commentId;
	globalAnswerName = username;
 $("#replyContent").attr("placeholder", "回复 :"+username);
}

/**
 * 未登录提示
 * @returns
 */
function alertLoginHip(){
	alert("请先登录");
}

/**
 * 回复
 * @param val
 * @returns
 */
function sendReply(articleId){
	
	var replyContent = document.getElementById("replyContent").value;
	var replyerId = document.getElementById("uidVal").innerText;
	
	//若是回复者id为空，则视作评论
	if(globalAnswerId == null){
		$	.ajax({
			type : "post",
			url : "/comment/addComment",
			cache : false, //不缓存此页面  
			data : {
				"articleId" : articleId.split(' ')[1],
				"commentContent" : replyContent,
				"answerId" : replyerId
			},
			dataType : "json",
			success : function(data) {
				$("#commentli")
						.append(
								$("<li>"
										+ "<div class='common-box-row layui-row'>"
										+ "<div class='common-headimg layui-col-md1 layui-col-xs2'>"
										+ "<div class='commonimg-box'>"
										+ "<img src='../img/02.jpg'/>"
										+ "</div>"
										+ "</div>"
										+ "<div class='common-info-row layui-col-md11 layui-col-xs10'>"
										+ "<div class='common-nickname layui-row'>"
										+ data.commentDate
										+ "<span>"
										+ data.username
										+ "<a  href='javascript:void(0)'	style='float: right' onclick='showReply("+data.answerId+","+data.commentId+")'>回复"
										+ "</a>"
										+ "</span>"
										+ "</div>"
										+ "<div class='common-text layui-row'>"
										+ data.commentContent
										+ "</div>" + "</div>"
										+ "</div>" + "</li>"));

			}
		});
		
		return;
	}
	
	//不为空为回复
	var answerId = globalAnswerId.split(' ')[1];
	var commentId = globalCommentId.split(' ')[1];
	var requestData = {
			"answerId":answerId,
			"commentId":commentId,
			"replyContent":replyContent,
			"replyerId":replyerId,
			"answerName":globalAnswerName
	}
	var rdata = JSON.stringify(requestData);
	console.log(requestData);
	$.ajax({
		type : "POST",
		processData : false,
		url:"/reply/writeReply",
		cache : false, //不缓存此页面  ,
		contentType:"application/json;charset=UTF-8",
		data:rdata,
		dataType : "json",
		success:function(data){
			console.log(data.data);
			var tag ="#"+data.data.commentId;
			$(tag).append("<li>"+"<div class='common-box-row layui-row'>"+"<div class='common-headimg layui-col-md1 layui-col-xs2'>"+
					"<div class='commonimg-box'>"+"<img src='../img/02.jpg'>"+"</div>"+"</div>"+"	<div class='common-info-row layui-col-md11 layui-col-xs10'>"+
					"<div class='common-nickname layui-row'>"+"<span>"+data.data.replyDate+"</span>"+"<span>"+data.data.username+": "+"</span"+
					"<span>回复"+"</span>"+"<span>"+data.data.answerName+"</span>"+
					" <a onclick='showReply("+data.answerId+","+data.commentId+")'	 style='float: right;' >回复"+"</a>"+"</div>"+
					"<div class='common-text layui-row' >"+data.data.replyContent+"</div>"+"</div>"+"</div>"+"</li>");
		}
	});
}

function toLogin(){
	location.href = "/tologin";
}
