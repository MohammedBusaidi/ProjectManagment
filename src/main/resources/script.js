const host = window.location.host;
let apiBoardID = 1;
let url = "http://" + "localhost:8080" + "/api/boards/" + apiBoardID + "/cards";

// Get All Cards
function getCards() {
  const deleteCardDropbox = document.getElementById("deleteCard");
  deleteCardDropbox.innerHTML = `<option value="" disabled selected>Select an option</option>`;

  const updateCardDropbox = document.getElementById("updateCard");
  updateCardDropbox.innerHTML = `<option value="" disabled selected>Select an option</option>`;

  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch(`http://${host}/api/boards/1/cards`, requestOptions)
    .then((response) => response.json())
    .then((parsedResponse) => {
      parsedResponse.data.cards.forEach((card) => {
        deleteCardDropbox.innerHTML += `<option>${card.cardId}</option>`;
        updateCardDropbox.innerHTML += `<option>${card.cardId}</option>`;

        let sectionDropDiv;
        let sectionDiv;

        let section = card.section;

        if (section === "TO_DO") {
          sectionDiv = document.getElementById("sectionToDo");
          sectionDropDiv = document.getElementById("sectionToDoDrop");
        } else if (section === "IN_PROGRESS") {
          sectionDiv = document.getElementById("sectionInProgress");
          sectionDropDiv = document.getElementById("sectionInProgressDrop");
        } else {
          sectionDiv = document.getElementById("sectionDone");
          sectionDropDiv = document.getElementById("sectionDoneDrop");
        }

        let cardDiv = document.createElement("div");
        cardDiv.className = "card";

        let idCrad = document.createElement("h3");
        idCrad.id = "cardID-" + card.cardId;

        let headingCard = document.createElement("h3");
        headingCard.id = "cardTitle-" + card.cardId;
        headingCard.textContent = card.title;

        let descriptionCrad = document.createElement("p");
        descriptionCrad.id = "cardDescription-" + card.cardId;
        descriptionCrad.textContent = card.description;

        cardDiv.appendChild(idCrad);
        cardDiv.appendChild(headingCard);
        cardDiv.appendChild(descriptionCrad);

        sectionDiv.appendChild(cardDiv);

        sectionDropDiv.appendChild(sectionDiv);
      });
    })
    .catch((error) => console.log("error", error));
}
//=========================================================================================//
function addCard() {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  let cardTitle = document.getElementById("title").value;
  let cardDescription = document.getElementById("description").value;
  let cardSection = document.getElementById("section").value;

  var raw = JSON.stringify({
    title: cardTitle,
    description: cardDescription,
    section: cardSection,
  });

  var requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch(url, requestOptions)
    .then((response) => response.text())
    .then((result) => location.reload())
    .catch((error) => console.log("error", error));
}
//=========================================================================================//
function deleteCards() {
  var requestOptions = {
    method: "DELETE",
    redirect: "follow",
  };
  var dropdown = document.getElementById("deleteCard");
  var selectedValue = dropdown.value;

  if (selectedValue === "") {
    alert("choose a Card to delete");
  } else {
    fetch(`${url}/${selectedValue}`, requestOptions)
      .then((response) => response.text())
      .then((result) => {
        console.log(result);
        location.reload();
      })
      .catch((error) => console.log("error", error));
  }
}
//=========================================================================================//
function updateCards() {
  var dropdown = document.getElementById("updateCard");
  var selectedValue = dropdown.value;

  if (!selectedValue) {
    alert("Select An option first to Update");
  } else {
    var titleValue = document.getElementById("updateTitle");
    var descriptionValue = document.getElementById("updateDescription");
    var sectionValue = document.getElementById("updateSection");

    if (titleValue.value === "") {
      let titleId = "title" + dropdown.value;
      let title = document.getElementById(titleId).textContent;
      titleValue.value = title;
    }

    if (descriptionValue.value === "") {
      let descriptionId = "description" + dropdown.value;
      let description = document.getElementById(descriptionId).textContent;
      descriptionValue.value = description;
    }

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
      title: titleValue.value,
      description: descriptionValue.value,
      section: sectionValue.value,
    });

    var requestOptions = {
      method: "PUT",
      headers: myHeaders,
      body: raw,
      redirect: "follow",
    };

    fetch(`${url}/${selectedValue}`, requestOptions)
      .then((response) => response.json())
      .then((result) => {
        console.log(result);
        location.reload();
      })
      .catch((error) => console.log("error", error));
  }
}
//=========================================================================================//
window.onload = getCards;
