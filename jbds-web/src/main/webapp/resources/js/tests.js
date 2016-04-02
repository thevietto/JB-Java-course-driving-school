/**
 * Created by aleksandrpliskin on 02.04.16.
 */
function getTests() {
    $.ajax({
        url:"teacher/ds_tests",
        type:"GET",
        dataType: "html",
        success: function(data) {
            $("#js-ds_tests").html(data);
        }
    })
}