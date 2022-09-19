function traerInformacionCliente() {
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            pintarRespuestaCliente(respuesta.items)
        }
    });
}
function pintarRespuestaCliente(items) {
    $("#resultadoCliente").empty();
    let myTable = "<table border='1'>";
    myTable += "<caption> CLIENT </caption>";
    myTable += "<tr><th>CODE</th> <th> NAME</th> <th> EMAIL</th> <th> AGE</th> ";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += "<td> <button onclick='borrarElementoCliente(" + items[i].id + ")'> Borrar </button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoCliente").append(myTable);
}

function guardarInformacionCliente() {
    let myData = {
        id: $("#idCliente").val(),
        name: $("#nameCliente").val(),
        email: $("#emailCliente").val(),
        age: $("#ageCliente").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "POST",
        data: myData,
        datatype: "JSON",
        success: function (respuestaCliente) {
            $("#resultadoCliente").empty();
            $("#idCliente").val("");
            $("#nameCliente").val("");
            $("#emailCliente").val("");
            $("#ageCliente").val("");
            traerInformacionCliente();
            alert("se ha guardado el dato de cliente")

        }
    });
}
function editarInformacionCliente() {
    let myData = {
        id: $("#idCliente").val(),
        name: $("#nameCliente").val(),
        email: $("#emailCliente").val(),
        age: $("#ageCliente").val(),
    };
    console.log(myData);
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "PUT",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuestaCliente) {
            $("#resultadoCliente").empty();
            $("#idCliente").val("");
            $("#nameCliente").val("");
            $("#emailCliente").val("");
            $("#ageCliente").val("");
            traerInformacionCliente();
            alert("se ha Actualizado el dato del cliente")

        }
    });
}
function borrarElementoCliente(idElemento) {
    let myData = {
        id: idElemento
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "DELETE",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuestaCliente) {
            $("#resultadoCliente").empty();
            traerInformacionCliente();
            alert("Se ha eliminado el dato del cliente")
        }
    });
}