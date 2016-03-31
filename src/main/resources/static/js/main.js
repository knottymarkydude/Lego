
/* 
 * search the index
 */
$("#search-form").submit(function (event) {
    //alert("Handler for .submit() called.");
    event.preventDefault();
});

$(document).ready(function () {
    $("#form-submit").click(function () {
        $("#search-form").submit();
    });
});