/**
 * 
 */
'use strict';

angular.module('myApp').controller('RegistroConvController', ['$scope', 'RegistroConvService', function($scope, RegistroConvService) {
    var variableGlobalJs = this;
		
		
    variableGlobalJs.userDto={idUsuario:null,idConvocatoria:null,idEquipo:null,estado:null,codRespuesta:null,msgRespuesta:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function registroConvocatoria(userDto) {
        RegistroConvService.registroConvocatorias(userDto)
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
    		
    		registroConvocatoria(variableGlobalJs.userDto);
    	}
    }
    
  
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);