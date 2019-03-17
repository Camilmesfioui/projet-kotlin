<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <title>Liste des articles</title>
    <link rel="stylesheet" type="text/css" href="/assets/style.css">
</head>
<body>

<h1>Liste des articles</h1>
<#list articles as article>
    <p><a href="/articles/${article.id}">${article.title}</a></p>
</#list>

</body>
</html>