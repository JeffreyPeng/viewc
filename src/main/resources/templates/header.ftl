<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/style.css" rel="stylesheet">
        <link rel="shortcut icon" href="/favicon.png" />
        <link rel="bookmark" href="/favicon.png" type="image/x-icon"　/>
        <title>${title}</title>
    </head>
    <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home">ViewC</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="${isHome!}"><a href="home">主页</a></li>
                    <li class="${isManage!}"><a href="manage">管理</a></li>
                    <li class="${isHeartBeat!}"><a href="heartBeat">心跳</a></li>
                    <li class="${isIndex!}"><a href="index">关于</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
