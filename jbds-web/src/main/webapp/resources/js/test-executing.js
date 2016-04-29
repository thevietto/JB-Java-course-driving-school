function checkTest(taskId){

    var answers = $("#js-test-execution").find('input');
    var questions = $("#js-test-execution").find('.js-question');

    var result = "";
    var blank = [];

    for (var i = 0 ; i < questions.length ; i++){
        var answerVariants = $('#'+questions[i].id).find('input');
        var isFill = false;
        for (var j = 0 ; j < answerVariants.length ; j++){
            if (answerVariants[j].checked){
                result += answerVariants[j].value + " ";
                isFill = true;
                break;
            }
        }
        if (isFill){
            isFill = false;
        } else {
            blank.push(i+1);
        }
    }

    if (blank.length > 0){
        $('#js-test-error').text('Вы не ответили на вопрос ' + blank);
    } else if (blank.length == 0) {
        $('#js-test-error').text('');
        loadTest(taskId, result);
    }
}

function loadTest(taskId, result){
    $.ajax({
        url: taskId,
        type: "POST",
        data: {
            result: result
        },
        success: function () {
            console.log("success request")
        }
    })
}