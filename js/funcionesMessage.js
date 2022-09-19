function traerInformacionMessage() {
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            pintarRespuestaMessage(respuesta.items)
        }
    });
}
function pintarRespuestaMessage(items) {
    $("#resultadoMessage").empty();
    let myTable = "<table border='1'>";
    myTable += "<caption> MESSAGE </caption>";
    myTable += "<tr><th>CODE</th> <th> MESSAGE </th>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].messagetext + "</td>";
        myTable += "<td> <button onclick='borrarElementoMessage(" + items[i].id + ")'> Borrar </button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoMessage").append(myTable);
}

function guardarInformacionMessage() {
    let myData = {
        id: $("#idMessage").val(),
        messagetext: $("#messagetext").val(),
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "POST",
        data: myData,
        datatype: "JSON",
        success: function (respuestaMessage) {
            $("#resultadoMessage").empty();
            $("#idMessage").val("");
            $("#messagetext").val("");
            traerInformacionMessage();
            alert("se ha guardado el dato de Message")

        }
    });
}
function editarInformacionMessage() {
    let myData = {
        id: $("#idMessage").val(),
        messagetext: $("#messagetext").val(),
    };
    console.log(myData);
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "PUT",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuestaMessage) {
            $("#resultadoMessage").empty();
            $("#idMessage").val("");
            $("#messagetext").val("");
            traerInformacionMessage();
            alert("se ha Actualizado de Message")

        }
    });
}
function borrarElementoMessage(idElemento) {
    let myData = {
        id: idElemento
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "https://g487a6996ba1685-bdmintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
        type: "DELETE",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuestaMessage) {
            $("#resultadoMessage").empty();
            traerInformacionMessage();
            alert("Se ha eliminado de Message")
        }
    });
}