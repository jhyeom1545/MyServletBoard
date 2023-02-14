function click() {
	console.log('clicked');
}

$(document).ready(function() {
	// 버튼 클릭 이벤트 리스너 등록
	$("#likeButton").click(function() {
		$.ajax({
			async: true,
			url: "http://localhost:8080/board/like",
			type: "POST",
			dataType: "json",
			success: function(data) {
				console.log(data)
			},
			error: function(e) {
				console.log(e)
				console.log("실패");
			}
		})
	})
})
