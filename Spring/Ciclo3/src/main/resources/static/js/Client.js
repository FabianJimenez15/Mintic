function InsertarInformacionClient(){
   $("#resultadoCliente").empty();
   let myData={ 
       email:$("#emailCliente").val(),
       password:$("#passwordCliente").val(),
       name:$("#nameCliente").val(),
       age:$("#ageCliente").val()
       
       
   };
    let dataToSend =JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Client/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
         success: function (respuesta) {
            alert("Insercion exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    });
}
function ConsultarInformacionClient(){
    $.ajax({
    url: "http://localhost:8080/api/Client/all",
         type : "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaClients(respuesta.items);
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
        });
}
function pintarRespuestaClients(items) {
    $("#resultadoCliente").empty();
    let myTable =  "<table border='1'>";
     myTable += "<caption> CLIENT <caption>";
     myTable += "<tr> <th>ID </th> <th> EMAIL </th>  <th>PASSWORD </th>  <th>NAME </th> <th>AGE </th> <th>MESSAGE</th> <th>RESERVATION </th>  </TF>";
     for (i=0; i < items.length; i++){
          myTable+= "<tr>";
          myTable += "<td>" + items[i].id + "</td>";
          myTable += "<td>" + items[i].email + "</td>";
          myTable += "<td>" + items[i].password + "</td>";
          myTable += "<td>" + items[i].name + "</td>";
          myTable += "<td>" + items[i].age + "</td>";
          myTable += "<td>" + items[i].message + "</td>";
          myTable += "<td>" + items[i].reservation + "</td>";
          
     }
     myTable += "</table>";
     $("#resultado").append(myTable);
}