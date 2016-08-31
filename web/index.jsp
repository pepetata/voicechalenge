<%-- 
    Document   : index
    Created on : Aug 24, 2016, 9:16:18 AM
    Author     : Flavio Ferreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-language" content="en" />
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta http-equiv="last-modified" content="2016-08-19@00:00:00 Z" />
        <meta http-equiv="X-Served-By" content="PRD-DCX-WEBCD2" />
        <link href="http://www.honeywell.com/" rel="canonical" />
        <meta property="og:url" content="http://www.honeywell.com/" />

        <script src="js/main.js"></script>
        <script src="js/jquery-3.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="image/favicon.ico">

        <title>Desafio Vocollect Voice</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script>
            contesterList();
            setInterval(function () {
                contesterList();
            }, 10000);
        </script>
    </head>
    <body >
        <div class="header">
            <div class="row">
                <div class="col-md-2">
                    <img id="logo" src="image/logo.png">
                </div>
                <div class="col-md-8">
                    <h1 id="titulo">Desafio Vocollect Voice</h1>
                </div>
                <div class="col-md-2">
                    <img id="voco" src="image/voco.jpg">
                </div>
            </div>
        </div>
        <div class="body" background="image/foto1.jpg">
            <!--<h3 id="lista"> Lista dos Competidores</h3>-->
            <div id="contesterListRows">
            </div>
        </div>
        <div class="footer"></div>
    </body>
</html>
