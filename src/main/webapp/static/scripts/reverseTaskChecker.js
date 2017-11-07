$("input[name = 'taskChecker']").click(function () {
    let taskId = $(this).attr("data-taskId");
    $.ajax({
        url:"/reverseTaskChecker",
        method:"post",
        contentType:"text/plain",
        data:taskId
    });
});