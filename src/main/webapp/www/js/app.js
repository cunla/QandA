(function () {
  'use strict';
  angular.module('starter')
    .constant('$ionicLoadingConfig', {
      template: "<ion-spinner></ion-spinner>",
      hideOnStateChange: false
    })
    .constant('AUTH_EVENTS', {
      notAuthenticated: 'auth-not-authenticated',
      notAuthorized: 'auth-not-authorized'
    })
    .constant('USER_ROLES', {
      admin: 'admin_role',
      public: 'public_role'
    })
    .run(function ($http, $state, $ionicPlatform, $rootScope, $ionicPopup) {
      $ionicPlatform
        .ready(function () {
          // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
          // for form inputs)
          if (window.cordova && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            cordova.plugins.Keyboard.disableScroll(true);
          }
          if (window.StatusBar) {
            // org.apache.cordova.statusbar required
            StatusBar.styleDefault();
          }

          if (window.Connection) {
            if (navigator.connection.type == Connection.NONE) {
              $ionicPopup.alert({
                title: "Internet Disconnected",
                content: "Please check your internet connection"
              })
            }
          }
        })
        .then(function () {
          if ($rootScope.projectStage == 'production' || $rootScope.projectStage == 'devCroinc')
            navigator.splashscreen.hide();
        });


    })

    .config(function ($stateProvider, $urlRouterProvider, $httpProvider, $ionicConfigProvider) {
      $ionicConfigProvider.backButton.previousTitleText(false);
      $ionicConfigProvider.backButton.text("").icon('ion-chevron-left');
      ;
      $stateProvider
        .state('latest', {
          url: '/latest',
          templateUrl: 'templates/latest/latest.html',
          controller: 'Latest',
          cache: false
        })
        .state('add', {
          url: '/add',
          templateUrl: 'templates/addquestion/add.html',
          controller: 'AddQuestion'
        })
        .state('question', {
          url: '/question/:questionId',
          templateUrl: 'templates/question/question.html',
          controller: 'Question'
        });
      $urlRouterProvider.otherwise('/latest');
    })
})();


