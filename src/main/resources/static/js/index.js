$(document).ready(function() {
	grabar();
});

function validate(input) {
	if (input.value.length > 100) {
		input.setCustomValidity('El nombre del pedido no debe superar los 100 caracteres.');
	} else {
		// input is valid -- reset the error message
		input.setCustomValidity('');
	}
}
	
function grabar(){
	var form = $('#form-ajax-pedido');
	$('#form-ajax-pedido').submit(function(e) {
		e.preventDefault();
		saveData();
	})
}

function saveData() {
	  var nombre = $("#nombre").val();  
	  var monto = $("#monto").val();
	  var descuento = $("#descuento").val();
	  var data = {"nombre":nombre,"monto":monto,"descuento":descuento};
	  data = JSON.stringify(data);
	  $.ajax({
			url: $('#form-ajax-pedido').attr('action'),
			method: 'post',
			contentType: 'application/json',
			datatype: "json",
			data: data,
			beforeSend: function(){
            
			},
			success:function(data){
				if (data.success){
					alert("Guardado con exito!");
				}
				else{
					alert("Hubo un problema al guardar: "+data.errorMessage);
				}
			},
			complete: function(data){
            //alert("se completo");
	        },
			error: function(data){
				alert("Error actualizando el pedido.");
				if (data.xmlHttpResponse != undefined){
					console.error(data.xmlHttpResponse);	
				}
				else{
					console.error(data.statusText);
				}
			}
	  });	  
}

