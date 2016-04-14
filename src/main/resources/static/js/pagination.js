//----------------------------------------------------------- Pagination ----------------------------
// 

$('#page-selection').bootpag({
    total: 10,
    page: 1,
    maxVisible: 5,
    leaps: true,
    firstLastUse: true,
    first: '←',
    last: '→',
    wrapClass: 'pagination',
    activeClass: 'active',
    disabledClass: 'disabled',
    nextClass: 'next',
    prevClass: 'prev',
    lastClass: 'last',
    firstClass: 'first'
}).on("page", function(event, num){
    $("#content").html("Page " + num); // or some ajax content loading...
}); 




