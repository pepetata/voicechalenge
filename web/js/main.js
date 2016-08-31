function winnerList() {
    $.ajax({url: "winnerList",
        success: function (result) {
            $("#contesterListRows").html(result);
        }});
}
;
function contesterList() {
    $.ajax({url: "contesterList",
        success: function (result) {
            $("#contesterListRows").html(result);
        }});
}
;
function saveName() {
//    console.log($("#flag").val());
    if ($("#flag").val() != "Y") return;
    if ($("#iname").val() == "") return;
//    console.log('chamando');
    $.ajax({
        url: "saveName",
        data: {name: $('#iname').val(), company: $('#icompany').val(), phone: $('#iphone').val()},
        success: function (result) {
            if (result.indexOf('yes') >= 0) {
//                console.log('yesssss');
                $("#iname").removeClass("inputReady");
                $("#icompany").removeClass("inputReady");
                $("#iphone").removeClass("inputReady");
                $("#iname").val("");
                $("#icompany").val("");
                $("#iphone").val("");
                $("#flag").val("N");
            }
        }});
}
;
function readyToSaveName(event) {
    event.preventDefault();
    // add class to input
    $("#iname").addClass("inputReady");
    $("#icompany").addClass("inputReady");
    $("#iphone").addClass("inputReady");
    $("#flag").val("Y");
}
;
