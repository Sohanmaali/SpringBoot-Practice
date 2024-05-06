// (function () {
//   "use strict";
//   const forms = document.querySelectorAll(".requires-validation");
//   Array.from(forms).forEach(function (form) {
//     form.addEventListener(
//       "submit",
//       function (event) {
//         if (!form.checkValidity()) {
//           event.preventDefault();
//           event.stopPropagation();
//         }

//         form.classList.add("was-validated");
//       },
//       false
//     );
//   });
// })();

const toggleSidebar = () => {
  console.log("clickd");
  if ($(".sidebar").is("visible")) {
    $(".sidebar").css("display", "none");
    $("content").css("margin-left", "0%");
  } else {
    $(".sidebar").css("display", "block");
    $("content").css("margin-left", "20%");
  }
};
