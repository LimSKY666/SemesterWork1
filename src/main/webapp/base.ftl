<!DOCTYPE html>

<html lang="en">
<head>
    <title>SIMENS VINIL SHOP</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@400;700&display=swap" rel="stylesheet">
    <link rel="icon" type="image/svg" href="assets/icon.svg">
    <link rel="stylesheet" type="text/css" href="/styles/homepage.css">
    <script src="registration.js"></script>
    <style>
        body {
            background: #171515 url(assets/background.jpg); /* Цвет фона и путь к файлу */
            color: #FFFFFF; /* Цвет текста */
        }
        header {
            background: #171515 url(assets/background.jpg); /* Цвет фона и путь к файлу */
            color: #FFFFFF; /* Цвет текста */
        }
    </style>
</head>
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-expand-sm">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item mr-auto">
            <a class="nav-link text-light" href="/homepage">Главная</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="#">Скидки</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="/faqpage">О нас</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="#">Отзывы</a>
        </li>
    </ul>
    <#if username?has_content>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="/prof" class="nav-link text-light "><strong>${username}</strong></a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="/basketpage" class="nav-link text-light">🛒Корзина</a>
            </li>
        </ul>
    <#else>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="/login" class="nav-link text-light "><strong>Войти</strong></a>
            </li>
        </ul>
    </#if>
</nav>
</header>
</body>
</html>