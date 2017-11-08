$(document).ready(function () {
    let now = new Date();
    let rows = $("#tasksTable tr");

    console.log("Date now:" + now);

    for (let row of rows) {
        let dateExec = new Date();
        let checker = false;
        $(row).children("td").each(function (index, elem) {
            if ($(elem).attr("field") == "dateExec") {
                dateExec = new Date($(elem).text());
            }
            if ($(elem).children("input").attr("checked")) {
                checker = true;
            }
        });
        if (now.getYear() == dateExec.getYear() && now.getMonth() == dateExec.getMonth()
            && now.getDay() == dateExec.getDay()
            && checker == false) {
            $(row).addClass("bg-color-actual");
        }
        if ((now.getYear() > dateExec.getYear() || now.getMonth() > dateExec.getMonth()
                || now.getDay() > dateExec.getDay())
            && checker == false) {
            $(row).addClass("bg-color-danger");
        }
        if (checker == true)
            $(row).addClass("bg-color-success");
    }
});