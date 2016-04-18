<html>
<head>
</head>
<body>
<h1>Question</h1>
<#if question?has_content>
<ul>
    <h2>${question.text}</h2><br><br>
    <img src="${question.image}" alt="">

    <ul>
        <#list question.answerVariants as answerVariant>
            <li>
                <h3>${answerVariant.text}
                    <#if answerVariant.id == question.rightAnswer.answerVariant.id>
                        ( Правильный )
                    </#if>
                </h3>
            </li>

        </#list>
    </ul>
</ul>
</#if>
</body>
</html>
