
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>The most excellent button board</title>

  <!-- Bootstrap core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap theme -->
  <link href="/css/bootstrap-theme.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/css/theme.css" rel="stylesheet">

  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
  <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
  <!--script src="../../assets/js/ie-emulation-modes-warning.js"></script -->

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <script src="/js/jquery-2.1.3.min.js"></script>
  <![endif]-->
</head>

<body role="document">

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Button-o-rama</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>

      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

<div class="container theme-showcase" role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="jumbotext">
      <h1>The most excellent Button Board</h1>
      <p>Mange knapper. Noen funker, noen funker ikke. Noen ser ut som de funker mens de egentlig ikke funker, mens noen virker som de ikke funker mens de faktisk funker. Hva tror du? </p>

    </div>
     </div>

  <div class="row">
    <div class="col-xs-12">
      <div class="panel panel-default">
        <div class="panel-body">
          <button type="button" class="btn btn-large btn-primary" data-bind="click:sayHello">Skriv "Hello tester!" til consolet</button>
        </div>
      </div>

      <div class="panel panel-default">
        <div class="panel-body">
          <button type="button" class="btn btn-large btn-primary" data-bind="click:btn2_hentKonsulenter">Hent en liste med konsulentnavn fra server og vis de fram</button>

          <h3 data-bind="if: btn2_konsulenter().length > 0">Konsulenter</h3>

            <ul data-bind="foreach:btn2_konsulenter">
              <li><span data-bind="text:navn"></span> - <span data-bind="text:stilling"></span> - <span data-bind="text:epost"></span></li>

            </ul>

        </div>
      </div>

      <div class="panel panel-default">
        <div class="panel-body">
          <p>
            <button type="button" class="btn btn-large btn-primary" data-bind="click:btn3_getText">Hent litt tekst fra server</button>
          </p>
          <p data-bind="text: btn3_response"></p>

        </div>
      </div>

      <div class="panel panel-default">
        <div class="panel-body">
          <p>
          <form action="/image" target="_blank">
            <input type="submit" class="btn btn-large btn-primary" value="Vis et bilde fra server (fors&oslash;k i Chrome og IE)">
          </form>
          </p>
        </div>
      </div>


      <div class="panel panel-default">
        <div class="panel-body">
          <p>
            <button type="button" class="btn btn-large btn-primary" data-bind="click:btn5_getError">Hent data fra komplisert, utestet kode</button>
          </p>
          <p data-bind="text: btn5_response"></p>

        </div>
      </div>

    </div>
  </div>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/knockout-3.3.0.js"></script>
<script src="/app/Konsulent.js"></script>
<script src="/app/Prosjekt.js"></script>
<script src="/app/ButtonBoardApp.js"></script>
</body>
</html>
