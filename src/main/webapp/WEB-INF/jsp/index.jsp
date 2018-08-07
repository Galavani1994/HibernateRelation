<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <!-- Bootstrap CSS -->
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">--%>

    <link rel="stylesheet" href="/css/css/bootstrap.css"/>
    <link rel="stylesheet" href="/css/css/bootstrap-rtl.css"/>
    <link rel="stylesheet" href="/css/css/bootstrap-rtl-theme.css"/>

    <!-- Additional CSS -->

    <link rel="stylesheet" href="/css/styles.css"/>

    <!--title-->
    <title>صفحه اصلی</title>
</head>
<body>

<form action="/save" method="post">
    <h1>Question:</h1><br/>
    <input type="text" name="qid">
    <input type="text" name="qname">

    <input type="submit" value="persist">
</form>
<hr>
<form>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>QuestionName</th>
            <th>Answer Field</th>
        </tr>
        </thead>
        <c:forEach var="list" items="${lists}">

            <form action="/answerpage">
                <tbody>
                <tr>
                    <td><input type="text" name="qid" value="${list.id}"></td>
                    <td><input type="text" name="qname" value="${list.qname}"></td>
                    <td><input type="submit" value="answer"></td>
                </tr>
                </tbody>
            </form>

        </c:forEach>
    </table>
</form>
<hr>
<form>
    <table border="1" style="width: 100%">
        <th>
        <td>ID</td>
        <td>Question</td>
        <td>Answer</td>
        <td>PostedBy</td>

        </th>
        <c:forEach var="list" items="${listans}">

            <form action="/answerpage">
                <tr>
                    <td><input type="text" name="question" value="${list.id}"></td>
                    <td><input type="text" name="question" value="${list.question.qname}"></td>
                    <td><input type="text" name="ansname" value="${list.answername}"></td>
                    <td><input type="text" name="postedBy" value="${list.postedBy}"></td>
                </tr>
            </form>

        </c:forEach>
    </table>
</form>
</body>
</html>