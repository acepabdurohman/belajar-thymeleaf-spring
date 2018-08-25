$(document).ready(function(){
    getProducts();
});

function getProducts(){
    $.ajax({
        type: "GET",
        url: "http://localhost:1111/products",
        success: function(response){
            var resLeng = response.length
            console.log(resLeng);

            response.forEach(function(data){
                console.log(data.name);
            })
        },
        error: function(xhr, status, error){
            var statusCode = xhr.status;
            console.log("Status code : " + statusCode);
        }
    })
}