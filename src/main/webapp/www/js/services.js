(function () {
  'use strict';
  angular.module('starter', ['ionic']);
  angular.module('starter').factory('api', ['$http', api]);
  function api($http) {
    var baseUrl = "/boiler/";
    return {
      latest: latest,
      question: question,
      postQuestion: postQuestion,
      postAnswer: postAnswer
    };

    function latest() {
      return $http.get(baseUrl + "questions");
    }

    function question(questionId) {
      return $http.get(baseUrl + "questions/" + questionId);
    }

    function postQuestion(author, title, body) {
      var questionDict = {
        authorName: author,
        title: title,
        body: body
      };
      var json = JSON.stringify(questionDict);
      return $http.post(baseUrl + "questions", json);
    }

    function postAnswer(questionId, author, body) {
      var answerDict = {
        authorName: author,
        body: body
      };
      var json = JSON.stringify(answerDict);
      return $http.post(baseUrl + "questions/" + questionId + "/answers", json);
    }
  }
})();
