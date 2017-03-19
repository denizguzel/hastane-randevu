var userId = $("#userId").text();
var restUrl = "http://localhost:8080/api/patient/" + userId;


$("#all-data").click(function () {

  jQuery.ajax({
    type: "GET",
    url: restUrl,
    dataType: "json",
    success: function (data) {
      var all = "";
      $.each(data, function (index, value) {
        all += '<li><span class="text-success">' + index + ': </span>' + value + '</li>';
      });
      $('#allData').append('<ul>' + all + '</ul>');
    }
  });

});


$("#filtered-data").click(function () {

  jQuery.ajax({
    type: "GET",
    url: restUrl,
    dataType: "json",
    success: function (data) {
      var filter = "";
      $.each(data, function () {
        filter = '<li><span class="text-success">PK: </span>' + data.pk + '</li>' +
          '<li><span class="text-success">İsim: </span>' + data.firstName + '</li>';
      });
      $('#filteredData').append('<ul>' + filter + '</ul>');
    }
  });

});