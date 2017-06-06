// Datepicker
$(".datepicker").datetimepicker({
  locale: "tr",
  format: "DD-MM-YYYY",
  icons: {
    time: "fa fa-timer",
    date: "fa fa-calendar",
    up: "fa fa-arrow-up",
    down: "fa fa-arrow-down",
    previous: "fa fa-arrow-left",
    next: "fa fa-arrow-right",
    today: "fa fa-calendar",
    clear: "fa fa-trash-o",
    close: "fa fa-close"
  },
  tooltips: {
    today: "Bugünü Seç",
    clear: "Temizle",
    close: "Kapat",
    selectMonth: "Ay Seç",
    prevMonth: "Önceki Ay",
    nextMonth: "Sonraki Ay",
    selectYear: "Yıl Seç",
    prevYear: "Önceki Yıl",
    nextYear: "Sonraki Yıl",
    selectDecade: "Onyıl Seç",
    prevDecade: "Önceki Onyıl",
    nextDecade: "Sonraki Onyıl",
    prevCentury: "Önceki Yüzyıl",
    nextCentury: "Sonraki Yüzyıl"
  }
});

$("#appointmentDateStart").datetimepicker({
  minDate: moment().add(1, "d"),
  daysOfWeekDisabled: [0, 6],
  locale: "tr",
  format: "DD-MM-YYYY",
  icons: {
    time: "fa fa-timer",
    date: "fa fa-calendar",
    up: "fa fa-arrow-up",
    down: "fa fa-arrow-down",
    previous: "fa fa-arrow-left",
    next: "fa fa-arrow-right",
    today: "fa fa-calendar",
    clear: "fa fa-trash-o",
    close: "fa fa-close"
  },
  tooltips: {
    today: "Bugünü Seç",
    clear: "Temizle",
    close: "Kapat",
    selectMonth: "Ay Seç",
    prevMonth: "Önceki Ay",
    nextMonth: "Sonraki Ay",
    selectYear: "Yıl Seç",
    prevYear: "Önceki Yıl",
    nextYear: "Sonraki Yıl",
    selectDecade: "Onyıl Seç",
    prevDecade: "Önceki Onyıl",
    nextDecade: "Sonraki Onyıl",
    prevCentury: "Önceki Yüzyıl",
    nextCentury: "Sonraki Yüzyıl"
  }
});

$("#appointmentDateEnd").datetimepicker({
  useCurrent: false,
  daysOfWeekDisabled: [0, 6],
  locale: "tr",
  format: "DD-MM-YYYY",
  icons: {
    time: "fa fa-timer",
    date: "fa fa-calendar",
    up: "fa fa-arrow-up",
    down: "fa fa-arrow-down",
    previous: "fa fa-arrow-left",
    next: "fa fa-arrow-right",
    today: "fa fa-calendar",
    clear: "fa fa-trash-o",
    close: "fa fa-close"
  },
  tooltips: {
    today: "Bugünü Seç",
    clear: "Temizle",
    close: "Kapat",
    selectMonth: "Ay Seç",
    prevMonth: "Önceki Ay",
    nextMonth: "Sonraki Ay",
    selectYear: "Yıl Seç",
    prevYear: "Önceki Yıl",
    nextYear: "Sonraki Yıl",
    selectDecade: "Onyıl Seç",
    prevDecade: "Önceki Onyıl",
    nextDecade: "Sonraki Onyıl",
    prevCentury: "Önceki Yüzyıl",
    nextCentury: "Sonraki Yüzyıl"
  }
});

$("#appointmentDateStart").on("dp.change", function (e) {
  $("#appointmentDateEnd").data("DateTimePicker").minDate(e.date);
});
$("#appointmentDateEnd").on("dp.change", function (e) {
  $("#appointmentDateStart").data("DateTimePicker").maxDate(e.date);
});

// Swiper
new Swiper("#swiper-main", {
  pagination: ".swiper-pagination",
  paginationClickable: true,
  autoplay: 3000,
  autoplayDisableOnInteraction: false
});

new Swiper("#swiper-survey", {
  autoplay: 3000,
  autoplayDisableOnInteraction: false,
  observer: true
});

$(".swiper-container").hover(function () {
  this.swiper.stopAutoplay();
}, function () {
  this.swiper.startAutoplay();
});

// Toast Notification
function ToastBuilder(options) {
  // options are optional
  var opts = options || {};

  // setup some defaults
  opts.defaultText = opts.defaultText || "default text";
  opts.displayTime = opts.displayTime || 3000;
  opts.target = opts.target || "body";

  return function (text) {
    $("<div/>").addClass("toast").prependTo($(opts.target)).text(text || opts.defaultText).queue(function (next) {
      $(this).css({
        "opacity": 1
      });
      var topOffset = 50;
      $(".toast").each(function () {
        var $this = $(this);
        var height = $this.outerHeight();
        var offset = 15;
        $this.css("top", topOffset + "px");

        topOffset += height + offset;
      });
      next();
    }).delay(opts.displayTime).queue(function (next) {
      var $this = $(this);
      var width = $this.outerWidth() + 20;
      $this.css({
        "right": "-" + width + "px",
        "opacity": 0
      });
      next();
    }).delay(600).queue(function (next) {
      $(this).remove();
      next();
    });
  };
}
var showtoast = new ToastBuilder();

// Cookie check for survey
$("#swiper-survey").find(".btn").click(function () {
  var surveyPk = $(this).closest(".swiper-slide").attr("id");
  Cookies.set("surveysDone", "no", {
    expires: 7,
    path: "/"
  });
  Cookies.set("surveyPk" + surveyPk, surveyPk, {
    expires: 7,
    path: "/"
  });
});

$("#swiper-survey .swiper-slide").each(function () {
  if (Cookies.get("surveyPk" + $(this).attr("id"))) {
    $(this).remove();
  }
  if (!$("#swiper-survey .swiper-slide").length) {
    Cookies.set("surveysDone", "yes");
  }
});

// Empty error/info messages when modal closed
$(".modal").on("hidden.bs.modal", function () {
  $(this).find(".error,.info").text("");
  $(this).find(".form-group").attr("data-message", "");
});

// Tooltip
$("[data-toggle='tooltip'], [data-tooltip='tooltip']").tooltip();

// Custom
function toast(data) {
  if (data.status === "success") {
    var systemMessageElement = $(".global-message li");
    if (systemMessageElement.length) {
      var message = systemMessageElement.text();
      showtoast(message);
      if (systemMessageElement.hasClass("error")) {
        $(".toast").addClass("error");
      }
      else if (systemMessageElement.hasClass("info")) {
        $(".toast").addClass("info");
      }
      systemMessageElement.text("");
    }
    else {
      showtoast("Bilgileri Kontrol Ediniz");
    }
  }
}

function selectPickerToast(data) {
  if (data.status === "success") {
    $(".selectpicker").selectpicker("render");
    var systemMessageElement = $(".global-message li");
    if (systemMessageElement.length) {
      var message = systemMessageElement.text();
      showtoast(message);
      if (systemMessageElement.hasClass("error")) {
        $(".toast").addClass("error");
      }
      else if (systemMessageElement.hasClass("info")) {
        $(".toast").addClass("info");
      }
      systemMessageElement.text("");
    }
    else {
      showtoast("Bilgileri Kontrol Ediniz");
    }
  }
}

function ajaxCall(data) {
  if (data.status === "success") {
    var ajaxElement = document.getElementById(data.source.id);
    var errorElement = $(ajaxElement).parent().find("span.error");
    var errorContent = errorElement.text();

    if ($(ajaxElement).parent().attr("data-message") !== undefined) {
      $(ajaxElement).parent().attr("data-message", errorContent);
    }
  }
}

function tableData(data) {
  if (data.status === "success") {
    var ajaxElement = document.getElementById(data.source.id);
    var columnData = [];
    data.source.disabled = true;
    $("[data-toggle='tooltip']").tooltip();
    $(".btn-popover").popover({
      html: true,
      trigger: "focus",
      placement: "bottom",
      content: function () {
        return $(".popover-content").html();
      },
      title: function () {
        return $(".popover-title").html();
      }
    });
    $(ajaxElement).closest(".table-row").find("td:not(:last-child,:first-child)").each(function () {
      columnData.push($.trim($(this).text()));
    });
    $(".popover-hospital, #appointment-modal .detail-hospital").text(columnData[1]);
    $(".popover-policlinic, #appointment-modal .detail-policlinic").text(columnData[2]);
    $(".popover-place, #appointment-modal .detail-place").text(columnData[3]);
    $(".popover-doctor, #appointment-modal .detail-doctor").text(columnData[0]);

    $(".btn-popover").click(function (e) {
      e.preventDefault();
      var clock = $(this).find("span:first-child").text();
      var date = $(this).find("span:last-child").text();
      date = moment(date, "DD-MM-YYYY").format("DD-MM-YYYY");

      $(".popover-date, #appointment-modal .detail-date").text(date + " " + clock);
    });
  }
}

function changeActiveTab(data) {
  if (data.status === "success") {
    $(".selectpicker").selectpicker("render");
    var systemMessageElement = $(".global-message li");
    if (systemMessageElement.length) {
      var message = systemMessageElement.text();
      showtoast(message);
      if (systemMessageElement.hasClass("error")) {
        $(".toast").addClass("error");
      }
      else if (systemMessageElement.hasClass("info")) {
        $(".toast").addClass("info");
      }
      systemMessageElement.text("");
      $("#login-tabs a:first").tab("show");
    }
    else {
      showtoast("Bilgileri Kontrol Ediniz");
    }
  }
}

function popoverCall() {
  $("[data-toggle='popover']").popover();
}

function appointment(data) {
  if (data.status === "success") {
    $(".selectpicker").selectpicker("render");

    $("#appointmentDateStart").datetimepicker({
      minDate: moment().add(1, "d"),
      daysOfWeekDisabled: [0, 6],
      locale: "tr",
      format: "DD-MM-YYYY",
      icons: {
        time: "fa fa-timer",
        date: "fa fa-calendar",
        up: "fa fa-arrow-up",
        down: "fa fa-arrow-down",
        previous: "fa fa-arrow-left",
        next: "fa fa-arrow-right",
        today: "fa fa-calendar",
        clear: "fa fa-trash-o",
        close: "fa fa-close"
      },
      tooltips: {
        today: "Bugünü Seç",
        clear: "Temizle",
        close: "Kapat",
        selectMonth: "Ay Seç",
        prevMonth: "Önceki Ay",
        nextMonth: "Sonraki Ay",
        selectYear: "Yıl Seç",
        prevYear: "Önceki Yıl",
        nextYear: "Sonraki Yıl",
        selectDecade: "Onyıl Seç",
        prevDecade: "Önceki Onyıl",
        nextDecade: "Sonraki Onyıl",
        prevCentury: "Önceki Yüzyıl",
        nextCentury: "Sonraki Yüzyıl"
      }
    });

    $("#appointmentDateEnd").datetimepicker({
      useCurrent: false,
      daysOfWeekDisabled: [0, 6],
      locale: "tr",
      format: "DD-MM-YYYY",
      icons: {
        time: "fa fa-timer",
        date: "fa fa-calendar",
        up: "fa fa-arrow-up",
        down: "fa fa-arrow-down",
        previous: "fa fa-arrow-left",
        next: "fa fa-arrow-right",
        today: "fa fa-calendar",
        clear: "fa fa-trash-o",
        close: "fa fa-close"
      },
      tooltips: {
        today: "Bugünü Seç",
        clear: "Temizle",
        close: "Kapat",
        selectMonth: "Ay Seç",
        prevMonth: "Önceki Ay",
        nextMonth: "Sonraki Ay",
        selectYear: "Yıl Seç",
        prevYear: "Önceki Yıl",
        nextYear: "Sonraki Yıl",
        selectDecade: "Onyıl Seç",
        prevDecade: "Önceki Onyıl",
        nextDecade: "Sonraki Onyıl",
        prevCentury: "Önceki Yüzyıl",
        nextCentury: "Sonraki Yüzyıl"
      }
    });

    $("#appointmentDateStart").on("dp.change", function (e) {
      $("#appointmentDateEnd").data("DateTimePicker").minDate(e.date);
    });
    $("#appointmentDateEnd").on("dp.change", function (e) {
      $("#appointmentDateStart").data("DateTimePicker").maxDate(e.date);
    });
  }
}

function nameSplit() {
  $(".comment").each(function () {
    var name = "";
    var text = $(this).find(".name").text().split(" ");
    for (var i = 0; i < text.length; i++)
      name += text[i].substr(0, 1);

    $(this).find(".avatar").text(name);
  });
}

window.onload = function () {
  var systemMessageElement = $(".global-message li");
  if (systemMessageElement.length) {
    var message = systemMessageElement.text();
    showtoast(message);
    if (systemMessageElement.hasClass("error")) {
      $(".toast").addClass("error");
    }
    else if (systemMessageElement.hasClass("info")) {
      $(".toast").addClass("info");
    }
    systemMessageElement.text("");
  }

  // Dashboard google map render
  $closestAppointment = $(".closest-appointment");
  $maps = $(".map");
  var hospitalName = $closestAppointment.text();
  $maps.each(function (index, element) {
    var mapOptions = {
      zoom: 15,
      center: new google.maps.LatLng(38.963745, 35.243322),
      scrollwheel: false,
      navigationControl: false,
      mapTypeControl: false,
      scaleControl: false,
      streetViewControl: false
    };
    var map;
    var geocoder;
    var marker;

    geocoder = new google.maps.Geocoder();
    geocoder.geocode({"address": hospitalName}, function (results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        mapOptions.center = results[0].geometry.location;
        map = new google.maps.Map(element, mapOptions);
        marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
        });
      }
    });
  });
};

$(".sidebar-toggler").click(function () {
  $("nav.sidebar").addClass("active");
  $("body").css("overflow", "hidden");
});

$("nav.sidebar .close").click(function () {
  $("nav.sidebar").removeClass("active");
  $("body").css("overflow", "hidden");
});

$(".navbar-toggler").click(function () {
  $("header .navbar .bottom").addClass("active");
  $("body").css("overflow", "hidden");
});

$("header .navbar .bottom .close").click(function () {
  $("header .navbar .bottom").removeClass("active");
  $("body").css("overflow", "hidden");
});

$("#edit-comment").on("show.bs.modal", function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal
  var comment = button.data("comment");
  var modal = $(this);
  modal.find(".modal-body textarea").val(comment);
});

$("#edit-comment, #make-comment").on("show.bs.modal", function () {
  var modal = $(this);
  var max = 250;
  var len = modal.find("textarea.counter").val().length;
  $(".character-count").find(".count").text(max - len + "/250");
});

$("textarea.counter").keyup(function () {
  var max = 250;
  var len = $(this).val().length;
  $(".character-count").find(".count").text(max - len + "/250");
});
