let createCardForm = document.getElementById("createCardForm");
createCardForm.addEventListener("submit", (event) => {
  event.preventDefault();

  let title = document.getElementById("title").value;
  let description = document.getElementById("description").value;
  let section = document.getElementById("section").value;

  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    title: title.value,
    description: description.value,
    section: section.value,
  });

  var requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch("localhost:8080/api/cards", requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.log("error", error));
});
