$(document).ready(function () {
    let now = new Date();
    let rows = $("#tasksTable tr");

    console.log("Date now:" + now);

    for (let row of rows) {
        let dateExec = new Date();
        let checker = false;
        $(row).removeClass("bg-color-actual bg-color-danger bg-color-success");
        $(row).children("td").each(function (index, elem) {
            if ($(elem).attr("field") === "dateExec") {
                dateExec = new Date($(elem).text());
            }
            if ($(elem).children("input").attr("checked")) {
                checker = true;
            }
        });
        if (now.getUTCDate() === dateExec.getUTCDate()
            && checker == false) {
            $(row).addClass("bg-color-actual");
            console.log(row, dateExec);
        }
        if (now > dateExec && checker == false) {
            $(row).addClass("bg-color-danger");
            console.log(dateExec);
        }
        if (checker == true) {
            $(row).addClass("bg-color-success");
        }
    }
});