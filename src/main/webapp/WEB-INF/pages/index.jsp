<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>ToDo List</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
</head>
<body>
<style>
    input[type=checkbox]:checked + label.strikethrough{
        text-decoration: line-through;
    }
</style>

<h1>ToDo List</h1>



<div id="app">
    {{ message }}
</div>
<script src="/res/main.js"></script>

</body>
</html>