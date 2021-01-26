
$(document).ready(function () {
    $('#guardar').click(function (event) {
        console.log("guardar botón");
        //traer el valor del input y guardarlo en la variable
        var documentoVar = $('#documento').val();
        var nombresVar = $('#nombres').val();
        var apellidosVar = $('#apellidos').val();
        var telefonoVar = $('#telefono').val();
        var correoVar = $('#correo').val();
        var direccionVar = $('#direccion').val();
        var departamentoVar = $('#departamento').val();
        var municipioVar = $('#municipio').val();

        $.post(
                "ClienteServlet",
                {
                    //enviar  //recibir
                    documento: documentoVar,
                    nombres: nombresVar,
                    apellidos: apellidosVar,
                    telefono: telefonoVar,
                    correo: correoVar,
                    direccion: direccionVar,
                    departamento: departamentoVar,
                    municipio: municipioVar,
                    boton: 'guardar'
                },
                function (responseText) {
                    $('#tabla').html(responseText);
                }
        );
    });
     $('#actualizar').click(function (event) {
        console.log("actualizar botón");
        //traer el valor del input y guardarlo en la variable
        var documentoVar = $('#documento').val();
        var nombresVar = $('#nombres').val();
        var apellidosVar = $('#apellidos').val();
        var telefonoVar = $('#telefono').val();
        var correoVar = $('#correo').val();
        var direccionVar = $('#direccion').val();
        var departamentoVar = $('#departamento').val();
        var municipioVar = $('#municipio').val();

        $.post(
                "ClienteServlet",
                {
                    //enviar  //recibir
                    documento: documentoVar,
                    nombres: nombresVar,
                    apellidos: apellidosVar,
                    telefono: telefonoVar,
                    correo: correoVar,
                    direccion: direccionVar,
                    departamento: departamentoVar,
                    municipio: municipioVar,
                    boton: 'actualizar'
                },
                function (responseText) {
                    $('#tabla').html(responseText);
                }
        );
    });
    $('#eliminar').click(function (event) {
        console.log("eliminar botón");
        //traer el valor del input y guardarlo en la variable
        var documentoVar = $('#documento').val();
        var nombresVar = $('#nombres').val();
        var apellidosVar = $('#apellidos').val();
        var telefonoVar = $('#telefono').val();
        var correoVar = $('#correo').val();
        var direccionVar = $('#direccion').val();
        var departamentoVar = $('#departamento').val();
        var municipioVar = $('#municipio').val();

        $.post(
                "ClienteServlet",
                {
                    //enviar  //recibir
                    documento: documentoVar,
                    nombres: nombresVar,
                    apellidos: apellidosVar,
                    telefono: telefonoVar,
                    correo: correoVar,
                    direccion: direccionVar,
                    departamento: departamentoVar,
                    municipio: municipioVar,
                    boton: 'eliminar'
                },
                function (responseText) {
                    $('#tabla').html(responseText);
                }
        );
    });
    $('#mostrar').click(function (event) {
        console.log("Mostrar boton");

        var documentoVar = $('#documento').val();

        var submitVar = $("#mostrar").val();

        $.post('ClienteServlet', {
            boton: submitVar,
            documento: documentoVar,

        }, function (responseText) {
            $('#tabla').html(responseText);

        });

    });

    $('#mostrarTODO').click(function (event) {
        console.log("Mostrar TODO boton");

        $.post('ClienteServlet', {
            boton: 'mostrarTODO'


        }, function (responseText) {
            $('#tabla').html(responseText);

        });

    });

});

    
