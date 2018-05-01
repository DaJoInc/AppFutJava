/**
 * 
 */
'use strict';

angular.module('myApp').controller('RegistroEqController', ['$scope', 'RegistroEqService', function($scope, RegistroEqService) {
    var variableGlobalJs = this;

    variableGlobalJs.userDto={idUsuario:null,idEquipo:null,nombreEquipo:null,estadoEquipo:null,idDtEquipo:null,codRespuesta:null,msgRespuesta:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function registroEquipo(userDto) {
        RegistroEqService.registroEquipos(userDto)
            .then(
                function (respuestaServicio) {
                    variableGlobalJs.userDto = respuestaServicio;
                },
                function(errResponse){
                console.log('log while fetching Profile');
                }
            );
        
    }
    
    function fetchAllUsers(){
    	IngresoService.fetchAllUsers()
            .then(
            function(d) {
            	variableGlobalJs.userDto = d;
              
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
    
    
    function submit(){
    	if(variableGlobalJs.userDto!=null){
    		
    		registroEquipo(variableGlobalJs.userDto);
    	}
    }
    
  
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);