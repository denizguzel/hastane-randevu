// Datepicker
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

// Swiper
new Swiper('#swiper-main', {
  pagination: '.swiper-pagination',
  paginationClickable: true
});

var surveySwiper = new Swiper('#swiper-survey', {
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
  opts.defaultText = opts.defaultText || 'default text';
  opts.displayTime = opts.displayTime || 3000;
  opts.target = opts.target || 'body';

  return function (text) {
    $('<div/>').addClass('toast').prependTo($(opts.target)).text(text || opts.defaultText).queue(function (next) {
      $(this).css({
        'opacity': 1
      });
      var topOffset = 50;
      $('.toast').each(function () {
        var $this = $(this);
        var height = $this.outerHeight();
        var offset = 15;
        $this.css('top', topOffset + 'px');

        topOffset += height + offset;
      });
      next();
    }).delay(opts.displayTime).queue(function (next) {
      var $this = $(this);
      var width = $this.outerWidth() + 20;
      $this.css({
        'right': '-' + width + 'px',
        'opacity': 0
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

  if (!$("#swiper-survey .swiper-slide").length) {
    Cookies.set("surveysDone", "yes");
  }
});

$("#swiper-survey .swiper-slide").each(function () {
  if (Cookies.get('surveyPk' + $(this).attr("id"))) {
    $(this).remove();
  }
  if (!$("#swiper-survey .swiper-slide").length) {
    Cookies.set("surveysDone", "yes");
  }
});

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

function selectPicker(data) {
  if (data.status === "success")
    $('.selectpicker').selectpicker("render");
}

function selectPickerToast(data) {
  if (data.status === "success") {
    $('.selectpicker').selectpicker("render");
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

// Empty error/info messages when modal closed
$(".modal").on('hidden.bs.modal', function () {
  $(this).find(".error,.info").text("");
});

// Tooltip
$('[data-toggle="tooltip"]').tooltip();

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
