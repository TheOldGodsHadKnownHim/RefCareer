<html>
  <head>  
  
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="/SpringTutorial50/webapp/static/js/app.js" /></script>
      <script src="gameService.js" /></script>
      <script src="/webapp/static/js/controller/gameController.js" /></script>
      
    <title>AngularJS $http Example</title>  
    <style>
      .home.ng-valid {
          background-color: lightgreen;
      }
      .home.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .home.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="GameController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Game Submittal Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.game.matchId" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="home">Home Team</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.game.home" id="home" class="home form-control input-sm" placeholder="Enter home team" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.home.$error.required">This is a required field</span>
                                      <span ng-show="myForm.home.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.home.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                       
 

                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Home Teams </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Home Team</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.games">
                              <td><span ng-bind="u.matchId"></span></td>
                              <td><span ng-bind="u.home"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       

  </body>
</html>