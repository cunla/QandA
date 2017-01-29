(function () {
  angular.module('starter').controller('AddQuestion', ['$scope', '$ionicLoading', '$state', 'api', AddQuestion]);
  function AddQuestion($scope, $ionicLoading, $state, api) {
    $scope.postNewQuestion = postNewQuestion;
    $scope.question = {};

    function postNewQuestion() {
      $ionicLoading.show();
      api.postQuestion($scope.question.author, $scope.question.title, $scope.question.body)
        .then(function (res) {
          $scope.question = {};
          $state.go('latest');
        })
        .finally(function () {
          $ionicLoading.hide();
        });
    }
  }

})();
