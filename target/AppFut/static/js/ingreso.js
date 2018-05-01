/**
	 * Esta función guarda el nombre y apellidos del usuario en la base de datos
	 */
	function guardar()
	{
		// Guardamos el nombre y apellido en la base de datos del navegador
		localStorage.setItem("nombre", document.getElementById("nombre").value);
		
	
		mostrarDatos();
		
	
	}
 
	/**
	 * Esta función elimina el apellido de la base de datos
	 */

 
	/**
	 * Esta función elimina toda la base de datos
	 */
	function eliminar()
	{
		// Eliminamos toda la base de datos del navegador
		localStorage.clear();
 
		mostrarDatos();
	}
 
	/**
	 * Esta función muestra los datos guardados en la base de datos
	 */
	function mostrarDatos()
	{
		// Leemos los valores de las variables del navegador y las ponemos
		// en una variable para posteriormente mostrarlo en el navegador
		var resultado=localStorage.getItem("nombre");
		document.getElementById("resultado").innerHTML=resultado;
		
		var resultado1=+localStorage.getItem("nombre");
		
		document.getElementById("apellidos").value=resultado1;

		

	}
 
	window.onload=function()
	{
		// Cada vez que se inicia el navegador, mostramos los datos de
		// la base de datos.
		mostrarDatos();
 
		// Cuando cargamos la pagina, si las variables tienen valor, lo ponemos
		// en el formulario
		if(localStorage.getItem("nombre")!=null)
			document.getElementById("nombre").value=localStorage.getItem("nombre");
		
		
		
	}