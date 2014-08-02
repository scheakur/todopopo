(function() {

  function main() {
    var now = new Date();
    window.todoForm.duedate.value = formatDate(now);
    window.todoForm.offset.value = now.getTimezoneOffset();

    var todoList = document.querySelector('.todo-list');
    todoList.addEventListener('change', done);
  }

  function formatDate(date) {
    return [date.getFullYear(), pad0(date.getMonth() + 1), pad0(date.getDate())].join("-");
  }

  function pad0(n) {
    return ('00' + n).slice(-2);
  }

  function done(event) {
    var request = new XMLHttpRequest();
    request.addEventListener('load', function (event) {
      console.log(event);
      // TODO Refresh todo list
    });

    var id = event.target.value;
    request.open('DELETE', '/' + id, false);
    request.send(null);
  }

  document.addEventListener('DOMContentLoaded', main);

})();
