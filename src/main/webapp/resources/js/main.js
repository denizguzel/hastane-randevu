var userId = $("#userId").text();
var restUrl = "http://localhost:8080/api/patient/" + userId;
var cityUrl = "http://localhost:8080/api/city/cityname";


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

function selectPicker(data) {
  if (data.status === 'success') $('.selectpicker').selectpicker("render");
}

$(".datepicker").datetimepicker({
  useCurrent: false,
  locale: "tr",
  format: 'DD-MM-YYYY',
  showTodayButton: true,
  showClear: true,
  icons: {
    time: 'fa fa-timer',
    date: 'fa fa-calendar',
    up: 'fa fa-arrow-up',
    down: 'fa fa-arrow-down',
    previous: 'fa fa-arrow-left',
    next: 'fa fa-arrow-right',
    today: 'fa fa-calendar',
    clear: 'fa fa-trash-o',
    close: 'fa fa-close'
  },
  tooltips: {
    today: 'Bugünü Seç',
    clear: 'Temizle',
    close: 'Kapat',
    selectMonth: 'Ay Seç',
    prevMonth: 'Önceki Ay',
    nextMonth: 'Sonraki Ay',
    selectYear: 'Yıl Seç',
    prevYear: 'Önceki Yıl',
    nextYear: 'Sonraki Yıl',
    selectDecade: 'Onyıl Seç',
    prevDecade: 'Önceki Onyıl',
    nextDecade: 'Sonraki Onyıl',
    prevCentury: 'Önceki Yüzyıl',
    nextCentury: 'Sonraki Yüzyıl'
  }
});