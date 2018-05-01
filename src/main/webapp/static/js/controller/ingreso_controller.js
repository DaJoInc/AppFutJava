/**
 * 
 */
'use strict';

angular.module('myApp').controller('IngresoController', ['$scope', 'IngresoService', function($scope, IngresoService) {
   
	
	
	
	var variableGlobalJs = this;
    

    variableGlobalJs.userDto={nombreUsuario:null,contrasena:null,codUsuario:null,codRespuesta:null,msgRespuesta:null,idUsuario:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function ingresoUsuario(userDto) {
        IngresoService.ingresoUsuarios(userDto)
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
    		
    		ingresoUsuario(variableGlobalJs.userDto);
    	}
    }
    
  
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);