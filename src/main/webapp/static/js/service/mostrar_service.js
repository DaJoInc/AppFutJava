/**
 * 
 */
'use strict';

angular.module('myApp').factory('MostrarService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8089/AppFut/in/';//end point.
//referencia todos los servicios en una variable
    var factory = {
    	
            fetchAllUsers: fetchAllUsers
    };

    return factory;


    
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
                
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


}]);
