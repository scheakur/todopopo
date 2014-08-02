(function() {

  function main() {
    var now = new Date();
    window.todoForm.duedate.value = formatDate(now);
    window.todoForm.offset.value = now.getTimezoneOffset();
  }

  function formatDate(date) {
    return [date.getFullYear(), pad0(date.getMonth() + 1), pad0(date.getDate())].join("-");
  }

  function pad0(n) {
    return ('00' + n).slice(-2);
  }

  document.addEventListener('DOMContentLoaded', main);

})();
