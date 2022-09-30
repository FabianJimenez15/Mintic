function InsertarInformacionCategory() {
    $("#resultadoCategory").empty();
    let myData = {
        name: $("#nameCategory").val(),
        description: $("#descriptionCategory").val(),
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Category/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            alert("Insercion exitosa");
            console.log();
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}

function ConsultarInformacionCategory() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaCategory(respuesta);
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}

function pintarRespuestaCategory(items) {
    $("#resultadoCategory").empty();
    let myTable = "<table border='1'>";
    myTable += "<caption> SKATE </caption>";
    myTable += "<tr><th>CODE</th> <th> NAME</th></th>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        //myTable += "<td> <button onclick='borrarElementoCategory(" + items[i].id + ")'> Borrar </button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoCategory").append(myTable);
}